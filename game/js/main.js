/******************* TAMAGAME ********************/

var game = new Phaser.Game(800,400,Phaser.AUTO,'game');

var TamaGame = function() {
    this.GAME_X = 400;
    this.GAME_Y = 800;
    this.tamagochis = null; 
    this.players = null;
    this.roads = null;
    this.obstaclesVelocity = 700;
    this.generatorTime = Phaser.Timer.SECOND*0.30;
}

    
   //  http://www.html5gamedevs.com/topic/1598-sprite-inheritance/ //

// var TamaGame.Tamagochi = function(game,img,w,hp) {
//     this.velocity = [1,1];
//     this.weight = w || 50;
//     this.hp = hp || 100;
//     this.img = img;
//     this.transparency = false;
// }

// var TamaGame.Player = function(game,infos) {
//     this.name = infos.name || "player";
//     this.score = 0;
    
//     this.tamagochi = new Tamagochi(infos.img); 
//     this.road = new Road();
// }

// var TamaGame.Road = function(number,game) {
//     this.number = number;
//     this.animated = false;
// }

TamaGame.prototype = {
    
    preload : function() {
        game.load.image('road1','img/road1.png');
        game.load.image('obstacle','img/himouto.jpg');
        game.load.image('p1','img/lovelin.png');
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
        this.player1 = this.game.add.sprite(10,250,'p1');
        this.players.add(this.player1);
        game.physics.enable(this.players,Phaser.Physics.ARCADE);
        
        this.player1.enableBody = true;
        this.player1.body.immovable = true;
        this.player1.isTransparent = false;
        this.player1.scale.setTo(0.5,0.5);

        //road
        this.player1.road = game.add.tileSprite(0,0,800,400,'road1');        
        roads.add(this.player1.road);
        
        this.player1.road.obstacles = this.obstacles;
        this.player1.moving = false;
        
        var style = { font: "64px Arial", fill: "#ff0044" };
        this.player1.score = game.add.text(300, 50, "0", style);
        
        //creation des obstacles pour chaque road
        this.obstacleGenerator = game.time.events.loop(this.generatorTime,this.generateObstacles,this);
        this.obstacleGenerator.timer.start(); 
    },
            
    generateObstacles : function() {
        if (this.player1.moving && this.player1.road.obstacles.children.length < 4) {
            var obs = this.player1.road.obstacles.children;
            var thereIsPlace = true;
            
            for(var i in obs) {
                ob = obs[i];
                if (ob.y <= this.GAME_Y/3) {
                    thereIsPlace = false;
                    break;
                }
            };
            var random = parseInt(Math.random()*3) % 2 == 0; 
            console.log(random);
            if (thereIsPlace && random) {
                // this.player1.road.createObstacle();
                this.createObstacle(this.players.children[0]);
            }
        }
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
            this.player1.isTransparent = true;
            //timer pendant lequel le joueur est invulnerable?
            console.log("ok")
        }
        
        if (game.input.keyboard.isDown(Phaser.Keyboard.UP)) {
            var a = this.player1.body.touching.up;
            if ( !a && !this.player1.overlap || (this.player1.overlap && this.player1.isTransparent) ) {
                //road move down
                // player1.road.step();
                //step -> creation d'obstacles, animation de descente
                // this.player1.road.animate();
                this.player1.road.tilePosition.y += 5;
                //set velocity aux obstacles, et si road move pas, on la met a 0
                this.player1.road.obstacles.forEach(function(item){
                    item.body.velocity.y = this.obstaclesVelocity;
                },this);
                //score
                this.player1.score.text = parseInt(this.player1.score.text)+2;
                this.player1.moving = true;
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
         // game.debug.body(this.player1);
    }
};


game.state.add('Game',TamaGame,true);






