function AsteroidField(num, size, speed){
    this.asteroidArray = [];
    for (let i = 0; i < num; i++){
        this.asteroidArray.push(new Asteroid(size, speed));
    }
}

AsteroidField.prototype.update = function(shotArray){
    this.checkCollisions(shotArray);
    this.draw();
}

AsteroidField.prototype.checkCollisions = function(shotArray){
    for (let i = 0; i < this.asteroidArray.length; i++){
        this.asteroidArray[i].checkCollisions(shotArray);
    }
}

AsteroidField.prototype.draw = function (){
    for (let i = 0; i < this.asteroidArray.length; i++){
        this.asteroidArray[i].draw();
    }
}