/******************* TAMAGAME ********************/

var game = new Phaser.Game(900,400,Phaser.AUTO,'game');

var TamaGame = function() {
    this.tamagochis = null; 
    this.players = null;
    this.roads = null;
    
    this.obstaclesVelocity = 700;
    this.generatorTime = Phaser.Timer.SECOND*0.30;
}

/* Constants */
TamaGame.GAME_X = 800;
TamaGame.GAME_Y = 400;
TamaGame.MAX_PLAYERS = 4;

    
//  http://www.html5gamedevs.com/topic/1598-sprite-inheritance/


TamaGame.Player = function(game,id,infos) {
    this.game = game;
    var offset = 30;
    var posX = (TamaGame.GAME_X/TamaGame.MAX_PLAYERS)*(id-1);
    Phaser.Sprite.call(this, game, posX , TamaGame.GAME_Y/2 , infos.img);
    
    this.id = id; //id is the number of the tamagochi
    this.name = infos.name || "player";
    this.score = 0;
    
    game.physics.enable(this,Phaser.Physics.ARCADE);
    
    this.enableBody = true;
    this.body.immovable = true;
    this.isTransparent = false;
    this.scale.setTo(0.5,0.5);
    var roadWidth = TamaGame.GAME_X/TamaGame.MAX_PLAYERS;
    this.road = game.add.tileSprite(posX,0,roadWidth,TamaGame.GAME_Y,'road'+id);        
    this.road.obstacles = [];
    this.moving = false;
    this.isTransparent = false;
    this.overlap = false;

    game.add.existing(this);
}


TamaGame.Player.prototype = Object.create(Phaser.Sprite.prototype);
TamaGame.Player.prototype.constructor = TamaGame.Player;

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
            console.log("coquin3")
        for(var nb = 0; nb < TamaGame.MAX_PLAYERS ; nb ++) {
            var player = new TamaGame.Player(game,nb+1,{
                img : "p"+(nb+1),
                name : "p"+(nb+1),
            }); 
            this.players.add(player);
            console.log("coquin3")
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

        
        //activer la transparence si spacebar
        if (game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR)){
            this.players.children[0].isTransparent = true;
            //timer pendant lequel le joueur est invulnerable?
        }
        
        if (game.input.keyboard.isDown(Phaser.Keyboard.UP)) {
            var player = this.players.children[0];
            var a = player.body.touching.up;
            
            if ( !a && !player.overlap || (player.overlap && player.isTransparent) ) {
                //road move down
                // player1.road.step();
                //step -> creation d'obstacles, animation de descente
                // this.player1.road.animate();
                player.road.tilePosition.y += 5;
                //set velocity aux obstacles, et si road move pas, on la met a 0
                player.road.obstacles.forEach(function(item){
                    item.body.velocity.y = this.obstaclesVelocity;
                },this);
                //score
                player.score.text = parseInt(this.players.children[0].score.text)+2;
                player.moving = true;
            }
        }
        

        //destruction des objets en dehors de la zone
        this.obstacles.forEach(function(ob){
            if (!ob.alive) {
                ob.destroy();
            } 
        });
    },

    createObstacle : function(player) {
        /*random position*/
        var x = player.x;
        var ob = game.add.sprite(x,-50,'obstacle');
        ob.scale.y = 0.6;
        this.obstacles.add(ob);
        game.physics.enable(this.obstacles,Phaser.Physics.ARCADE);
        ob.body.bounce.setTo(0);
        ob.checkWorldBounds = true;
        ob.outOfBoundsKill = true;
    },
    
    render : function() {
         game.debug.body(this.players);
    }
};


game.state.add('Game',TamaGame,true);






