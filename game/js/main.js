/* Phaser game */

/* create a tamagochi on the game */
var Tamagochi = function(img,w,hp) {
    this.velocity = [1,1];
    this.weight = w;
    this.img = img;
    this.hp = hp;
    this.transparency = false;
}

var Player = function(name,tama_descriptor) {
    
    this.tamagochi = new Tamagochi(tama_descriptor.img,tama_descriptor.w,tama_descriptor.hp); 
    this.score = 0;
}

var Obstacle = function(position,height) {
    
}

var Road = function() {
    
}


/* le jeu */

// creation des obstacles 

// gestion des inputs

// gestion du score
