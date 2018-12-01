function Asteroid(size, speed){
    this.size = size;
    this.position = new Vector(Math.random()*width-width/2, Math.random()*height - height/2);
    this.velocity = new Vector(1,0);
    this.velocity.rotate(Math.random()*2*PI);
    this.velocity.scalarMultiply(speed);
}

Asteroid.prototype.draw = function(){
    this.move();
    fill(0);
    stroke(255);
    ellipse(this.position.x,this.position.y, this.size, this.size);
}

Asteroid.prototype.checkCollisions = function(shotArray){
    for (let i = 0; i < shotArray.length; i++){
        console.log("hello");
    }
}

Asteroid.prototype.move = function() {
    this.checkBoundaries();
    this.position.add(this.velocity);
}

Asteroid.prototype.checkBoundaries = function(){
    if (this.position.x > width) this.position.x = 0;
    else if (this.position.x < 0) this.position.x = width;
    if (this.position.y > height) this.position.y = 0;
    else if (this.position.y < 0) this.position.y = height;
}

