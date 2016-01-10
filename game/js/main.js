/******************* TAMAGAME ********************/

var game = new Phaser.Game(900,400,Phaser.AUTO,'game');

var TamaGame = function() {
    this.tamagochis = null; 
    this.players = null;
    this.roads = null;
    
    this.generatorTime = Phaser.Timer.SECOND*0.30;
}

/* Constants */
TamaGame.GAME_X = 800;
TamaGame.GAME_Y = 400;
TamaGame.MAX_PLAYERS = 4;
TamaGame.VELOCITY = 700;


TamaGame.Player = function(game,id,infos) {
    this.game = game;
    var offset = 30;
    var posX = (TamaGame.GAME_X/TamaGame.MAX_PLAYERS)*(id-1);
    Phaser.Sprite.call(this, game, posX , TamaGame.GAME_Y/2 , infos.img);

    /* player information */
    this.id = id; 
    this.name = infos.name || "player";
    this.score = 0;
    
    game.physics.enable(this,Phaser.Physics.ARCADE);
    
    /* game variables */
    this.enableBody = true;
    this.body.immovable = true;
    this.scale.setTo(0.5,0.5);
    
    this.moving = false;
    this.isTransparent = false;
    this.overlap = false;
    
    /* road creation */
    
    var roadWidth = TamaGame.GAME_X/TamaGame.MAX_PLAYERS;
    this.road = game.add.tileSprite(posX,0,roadWidth,TamaGame.GAME_Y,'road'+id);        
    this.road.player = this;
    this.road.obstacles = [];
    


    game.add.existing(this);
}


TamaGame.Player.prototype = Object.create(Phaser.Sprite.prototype);
TamaGame.Player.prototype.constructor = TamaGame.Player;

TamaGame.Player.prototype.move = function() {
        //do one step on the road
        this.road.tilePosition.y += 5;
        //set velocity aux obstacles, et si road move pas, on la met a 0
        this.road.obstacles.forEach(function(item){
            item.body.velocity.y = TamaGame.VELOCITY;
        },this);
    
        this.moving = true;
}

TamaGame.prototype = {
    
    preload : function() {
        for(var i = 0; i < TamaGame.MAX_PLAYERS ; i++) {
            game.load.image('road'+(i+1),'img/road'+(i+1)+'.png');
        }
        game.load.image('obstacle','img/himouto.jpg');
        game.load.image('p1','img/lovelin.png');
        game.load.image('p2','img/lovelin.png');
        game.load.image('p3','img/lovelin.png');
        game.load.image('p4','img/lovelin.png');
    },



    create : function() {
        game.physics.startSystem(Phaser.Physics.ARCADE);

        // game groups
        var roads = game.add.group();
        this.obstacles = game.add.group();
        this.players = game.add.group();
        
        /* 
         *   P1  P2  P3  P4
         *  |___|___|___|___|
         */
        
        // 4 roads, 4 players
        for(var nb = 0; nb < TamaGame.MAX_PLAYERS ; nb ++) {
            var player = new TamaGame.Player(game,nb+1,{
                img : "p"+(nb+1),
                name : "p"+(nb+1),
            }); 
            this.players.add(player);
        }
        var offset = 30;
        this.players.forEach(function(p){
            roads.add(p.road); 
            var style = { font: "42px Arial", fill: "#ff0044" };
            var middleRoad = (TamaGame.GAME_X/TamaGame.MAX_PLAYERS)/2;
            p.score = game.add.text(p.x + middleRoad, 50, "0", style);
        });
        
        //creation des obstacles pour chaque road
        this.obstacleGenerator = game.time.events.loop(this.generatorTime,this.generateObstacles,this);
        this.obstacleGenerator.timer.start(); 
    },
            
    generateObstacles : function() {
        var _this = this;
        //for each player, we check if we can make an obstacle
        this.players.forEach(function(p){
            if (p.moving && p.road.obstacles.length < 4) {
                var obs = p.road.obstacles;
                var thereIsPlace = true;
                
                for(var i in obs) {
                    ob = obs[i];
                    if (ob.y <= TamaGame.GAME_Y/3) {
                        thereIsPlace = false;
                        break;
                    }
                }
                var random = parseInt(Math.random()*3) % 2 == 0; 
                if (thereIsPlace && random) {
                    // this.player1.road.createObstacle();
                    _this.createObstacle(p);
                }
            }
        });
    },

    update : function() {
        this.players.forEach(function(p) {
            p.isTransparent = false;
            p.overlap = false;
            p.moving = false;
        });
        
        this.obstacles.forEach(function(item){
            item.body.velocity.y = 0;
        },this);

        game.physics.arcade.overlap(this.players,this.obstacles,function(p,o){
            p.overlap = true;
        });

        /* INPUT HANDLERS */
        if (game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR)){
            this.players.children[0].isTransparent = true;
            //timer pendant lequel le joueur est invulnerable?
        }
        
        if (game.input.keyboard.isDown(Phaser.Keyboard.UP)) {
            var player = this.players.children[0];
            var a = player.body.touching.up;
            
            if ( !a && !player.overlap || (player.overlap && player.isTransparent) ) {
                player.move();
                player.score.text = parseInt(player.score.text)+2;
            }
        }
        //player2
        if (game.input.keyboard.isDown(Phaser.Keyboard.S)){
            this.players.children[1].isTransparent = true;
            //timer pendant lequel le joueur est invulnerable?
        }
        
        if (game.input.keyboard.isDown(Phaser.Keyboard.Z)) {
            var player = this.players.children[1];
            var a = player.body.touching.up;
            
            if ( !a && !player.overlap || (player.overlap && player.isTransparent) ) {
                player.move();
                player.score.text = parseInt(player.score.text)+2;
            }
        }

        /* END INPUT HANDLER */

        //destruction des objets en dehors de la zone
        this.obstacles.forEach(function(ob){
            if (!ob.alive) {
                var index = ob.player.road.obstacles.indexOf(ob);
                ob.player.road.obstacles.splice(index,1);
                ob.destroy();
            } 
        },this);
    },

    createObstacle : function(player) {
        var x = player.x;
        var ob = game.add.sprite(x,0,'obstacle');
        ob.scale.y = 0.6;
        this.obstacles.add(ob);
        game.physics.enable(this.obstacles,Phaser.Physics.ARCADE);
        ob.body.bounce.setTo(0);
        ob.checkWorldBounds = true;
        ob.outOfBoundsKill = true;
        ob.player = player;
        player.road.obstacles.push(ob);
    },
    
    render : function() {
         game.debug.body(this.players);
    }
};


game.state.add('Game',TamaGame,true);

