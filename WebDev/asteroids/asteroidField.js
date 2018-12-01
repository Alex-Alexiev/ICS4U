function AsteroidField(num, size, speed){
    this.asteroidArray = [];
    for (let i = 0; i < num; i++){
        this.asteroidArray.push(new Asteroid(size, speed));
    }
}

AsteroidField.prototype.update = function(shotArray, ship){
    this.checkCollisions(shotArray, ship);
    this.clean();
    this.draw();
}

AsteroidField.prototype.checkCollisions = function(shotArray, ship){
    for (let i = 0; i < this.asteroidArray.length; i++){
        this.asteroidArray[i].checkCollisions(shotArray, ship);
    }
}

AsteroidField.prototype.draw = function (){
    for (let i = 0; i < this.asteroidArray.length; i++){
        this.asteroidArray[i].draw();
        this.asteroidArray[i].move();
    }
}

AsteroidField.prototype.clean = function(){
    for(let i = 0; i < this.asteroidArray.length; i++){
        if (!this.asteroidArray[i].show) this.asteroidArray.splice(i, 1);
    }
}