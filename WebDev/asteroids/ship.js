function Ship(x, y, linearAcceleration, angularAcceleration, maxSpeed, friction){
    this.angularAcceleration = angularAcceleration;
    this.linearAcceleration = linearAcceleration;
    this.maxSpeed = maxSpeed;
    this.friction = friction;
    this.velocity = new Vector(0,0);
    this.direction = new Vector(0,1);
    this.position = new Vector(x,y);
}

Ship.prototype.update = function(){
    this.accelerate();
    this.updatePos();
    this.checkBoundaries();
    this.draw();
}

Ship.prototype.accelerate = function(){
    if (keyIsPressed) {
        if (keyCode === LEFT_ARROW) {
            this.direction.rotate(this.angularAcceleration);
        } 
        if (keyCode === RIGHT_ARROW) {
            this.direction.rotate(-this.angularAcceleration);
        }
        if (this.velocity.getMagnitude() < this.maxSpeed) {
            if (keyCode === UP_ARROW) {
               this.velocity.add(this.direction.getScalarMultiply(this.linearAcceleration));
            } 
        }
    }
}

Ship.prototype.checkBoundaries = function(){
    if (this.position.x > width/2) this.position.x = -width/2;
    else if (this.position.x < -width/2) this.position.x = width/2;
    if (this.position.y > height/2) this.position.y = -height/2;
    else if (this.position.y < -height/2) this.position.y = height/2;
}

Ship.prototype.updatePos = function(){
    if (this.velocity.getMagnitude() > 0) {
        this.velocity.add(this.velocity.getScalarMultiply(-1).getScalarMultiply(this.friction));
    }
    this.position.add(this.velocity);
}

Ship.prototype.draw = function() {
    fill(0);
    stroke(255);
    push();
    translate(width/2, height/2);
    rotate(PI);
    translate(-this.position.x, this.position.y);
    stroke(255,0,0);
    line(0,0, -this.direction.getScalarMultiply(100).x, this.direction.getScalarMultiply(100).y);
    stroke(0,255,0);
    line(0,0, -this.velocity.getScalarMultiply(100).x, this.velocity.getScalarMultiply(100).y);
    rotate(PI/2-this.direction.getAngle());
    stroke(255);
    triangle(0, 10, 10, -15, -10, -15);
    pop();
}
