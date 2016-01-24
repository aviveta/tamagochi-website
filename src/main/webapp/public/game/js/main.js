/******************* TAMAGAME ********************/

var game = new Phaser.Game(900,400,Phaser.CANVAS,'tama-game');

var TamaGame = function() {
    this.tamagochis = null; 
    this.players = null;
    this.roads = null;
    this.ws = null;
    
    this.generatorTime = Phaser.Timer.SECOND*0.30;
}

/* Constants */
TamaGame.GAME_X = 800;
TamaGame.GAME_Y = 400;
TamaGame.MAX_PLAYERS = 4;
TamaGame.VELOCITY = 700;
TamaGame.TILE_OFFSET = 50;
TamaGame.IMG_FOLDER = 'public/game/img/';


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
    this.collide = false;
    this.orientation = 0;


    
    /* road creation */
    
    var roadWidth = TamaGame.GAME_X/TamaGame.MAX_PLAYERS;
    this.road = game.add.tileSprite(posX,0,roadWidth,TamaGame.GAME_Y,'road'+id);        
    this.road.player = this;
    this.road.obstacles = [];
    
    /* inputs */
    this.moveInput = false;
    this.transparencyInput = false;
    
    game.add.existing(this);
}


TamaGame.Player.prototype = Object.create(Phaser.Sprite.prototype);
TamaGame.Player.prototype.constructor = TamaGame.Player;


TamaGame.Player.prototype.move = function() {
    switch(this.orientation) {
        case 0:
                this.angle = -2;
                this.orientation = 1;
                break;
        case 1:
                this.angle = 0;
                this.orientation = 2;
                break;
        case 2:
                this.angle = 2;
                this.orientation = 0;
                break;
    }
    //do one step on the road
    this.road.tilePosition.y += TamaGame.TILE_OFFSET;
    //set velocity aux obstacles, et si road move pas, on la met a 0
    this.road.obstacles.forEach(function(item){
        item.body.velocity.y = TamaGame.VELOCITY;
    },this);

    this.moving = true;
}

TamaGame.Player.prototype.setTransparency = function() {
    if (!this.isTransparent) {
        this.isTransparent = true;
        this.game.time.events.add(Phaser.Timer.SECOND * 4, function(){
            this.isTransparent = false;
        } , this);
    }
}


TamaGame.prototype = {
    
    preload : function() {
        for(var i = 0; i < TamaGame.MAX_PLAYERS ; i++) {
            game.load.image('road'+(i+1),TamaGame.IMG_FOLDER+'road'+(i+1)+'.png');
        }
        game.load.image('obstacle',TamaGame.IMG_FOLDER+'himouto.jpg');
        game.load.image('p1',TamaGame.IMG_FOLDER+'p1.png');
        game.load.image('p2',TamaGame.IMG_FOLDER+'p2.png');
        game.load.image('p3',TamaGame.IMG_FOLDER'p3.png');
        game.load.image('p4',TamaGame.IMG_FOLDER+'p4.png');
    },



    create : function() {
        var _this = this;
        game.physics.startSystem(Phaser.Physics.ARCADE);
        game.stage.disableVisibilityChange  = true;

        //WS
        var domain = window.location.host;
        this.ws = new WebSocket("ws://"+domain+"/tama-game/example");
        // this.ws = new WebSocket("ws://localhost:8080/tama-game/example");
        var ws = this.ws;
        // this.room = "";
        // var room = this.room;
        this.ws.onopen = function()
        {
            var room = getParameterByName('room');
            var action = getParameterByName('a');
            ws.send(action+";"+room);
        };

        this.ws.onmessage = function (evt) 
        { 			     	
            var msg = evt.data;
            // alert("Message received:" +  msg);
            //do action in the game
            var msgs = msg.split(";");
            if (msgs[0] == "move") {
                _this.inputMove(parseInt(msgs[1]));
            }

            if (msgs[0] == "transparent") {
                _this.inputTransparency(parseInt(msgs[1]));
            }

            //si c'est une nouvelle connexion,
            //on recoit aussi info du tamagochi
            //on peut supposer avoir deja toutes les imgs du jeu dans public
            //et on charge la bonne
            //sprite . loadTexture
            
            //et le nom du joueur
            
            
            //il faut pouvoir a la fin du jeu, faire une requete http pour dire de save le score


            //ou avant de lancer le jeu, on attend tout le monde
        };

        this.ws.onclose = function()
        { 
            alert("Connection is closed..."); 
        };
        //WS END

        // game groups
        var roads = game.add.group();
        this.obstacles = game.add.group();
        this.players = game.add.group();
        this.hitboxes = game.add.group();
        
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
            p.score = game.add.text(p.x + middleRoad, 30, "0", style);

            //creation de la hitbox
            p.hitbox = game.add.sprite(p.x + offset, TamaGame.GAME_Y/2, null);
            game.physics.enable(p.hitbox,Phaser.Physics.ARCADE);
            p.hitbox.enableBody = true;
            p.hitbox.body.immovable = true;
            p.hitbox.body.setSize(200,20);
            p.hitbox.player = p;
            this.hitboxes.add(p.hitbox);
            
        },this);
        
        //creation des obstacles pour chaque road
        this.obstacleGenerator = game.time.events.loop(this.generatorTime,this.generateObstacles,this);
        this.obstacleGenerator.timer.start(); 
    },
            
    inputMove : function(indexPlayer) {
    this.players.children[indexPlayer-1].moveInput = true;
    },
inputTransparency : function(indexPlayer) {
    this.players.children[indexPlayer-1].transparencyInput = true;
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
        var _this = this;
        this.players.forEach(function(p) {
            p.overlap = false;
            p.moving = false;
            p.collide = false;

            if (!p.isTransparent) {
                //draw transparent effect
            }
        });
        
        this.obstacles.forEach(function(item){
            item.body.velocity.y = 0;
        },this);

        // game.physics.arcade.overlap(this.players,this.obstacles,function(p,o){
        //     p.overlap = true;
        //     p.obstacleCollide = o;
        // });

        // game.physics.arcade.collide(this.players,this.obstacles,function(p,o){
        //     p.obstacleCollide = o; 
        //     p.collide = true;
        // });

        //collide hitbox
            
            // game.physics.arcade.collide(p.hitbox, this.obstacles,function(pl,o){
            //     pl.obstacleCollide = o;
            //     pl.collide = true;
            // });
            
        game.physics.arcade.overlap(this.hitboxes, this.obstacles,function(h,o){
            h.player.obstacleCollide = o;
            h.player.overlap = true;
        });
        

        
        /* INPUT HANDLERS */
        this.players.forEach(function(p) {
            if (p.transparencyInput) {
                //destruction de l'objet
                if (p.collide || p.overlap) {
                    var index = p.obstacleCollide.player.road.obstacles.indexOf(p.obstacleCollide);
                    p.obstacleCollide.player.road.obstacles.splice(index,1);
                    p.obstacleCollide.destroy();
                }
                // p.setTransparency();
                p.transparencyInput = false;
            }
            if (p.moveInput) {
                var a = p.body.touching.up;
                if ( !a && !p.overlap || (p.overlap && p.isTransparent) ) {
                    p.move();
                    p.score.text = parseInt(p.score.text)+2;
                }
                p.moveInput = false;
            } 
        });
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
        game.debug.body(this.hitboxes);
    }
};


game.state.add('Game',TamaGame,true);


function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
