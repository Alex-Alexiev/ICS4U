function Asteroid(size, speed){
    this.size = size;
    this.x = Math.floor(Math.random()*width);
    this.y = Math.floor(Math.random()*height);
    this.speed = speed;
    this.direction = Math.random()*2*PI;
}

Asteroid.prototype.draw = function(){
    fill(0);
    stroke(255);
    ellipse(this.x,this.y, this.size, this.size);
    this.update();
}

Asteroid.prototype.update = function() {
    this.checkBoundaries();
    let dx = -this.speed*sin(this.direction);
    let dy = this.speed*cos(this.direction);
    this.y += dy;
    this.x += dx;
}

Asteroid.prototype.checkBoundaries = function(){
    if (this.x > width) this.x = 0;
    else if (this.x < 0) this.x = width;
    if (this.y > height) this.y = 0;
    else if (this.y < 0) this.y = height;
}

