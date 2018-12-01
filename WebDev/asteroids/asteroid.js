function Asteroid(radius, speed){
    this.radius = radius;
    this.position = new Vector(Math.random()*width, Math.random()*height);
    this.velocity = new Vector(1,0);
    this.velocity.rotate(Math.random()*2*PI);
    this.velocity.scalarMultiply(speed);
    this.show = true;
}

Asteroid.prototype.draw = function(){
    fill(0);
    drawEllipse(this.position, this.radius);
}

Asteroid.prototype.checkCollisions = function(shotArray, ship){
    for (let i = 0; i < shotArray.length; i++){
        let shot = shotArray[i];
        if (Vector.add(shot.position.getScalarMultiply(-1), this.position).getMagnitude() < this.radius/2+shot.radius/2){
            this.show = false;
            shot.show = false;
        }
    }
    if (Vector.add(ship.position.getScalarMultiply(-1), this.position).getMagnitude() < this.radius/2){
        gameOver();
    }
}

Asteroid.prototype.move = function() {
    this.position = checkBoundaries(this.position);
    this.position.add(this.velocity);
}

