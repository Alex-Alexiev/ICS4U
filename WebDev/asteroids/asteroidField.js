function AsteroidField(num, size, speed){
    this.asteroidArray = [];
    for (let i = 0; i < num; i++){
        this.asteroidArray.push(new Asteroid(size, speed));
    }
}

AsteroidField.prototype.show = function(){
    for (let i = 0; i < this.asteroidArray.length; i++){
        this.asteroidArray[i].draw();
    }
}