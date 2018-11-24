function Ship(x, y, linearAcceleration, angularAcceleration, maxSpeed, friction){
    this.x = x;
    this.y = y;
    this.angularAcceleration = angularAcceleration;
    this.linearAcceleration = linearAcceleration;
    this.maxSpeed = maxSpeed;
    this.friction = friction;
    this.directionAngle = 0,
    this.motionAngle = 0;
    this.speed = 0;
}

Ship.prototype.update = function(){
    this.checkBoundaries();
    this.updatePos();
    this.accelerate();
    this.draw();
}

Ship.prototype.accelerate = function(){
    if (keyIsPressed) {
        if (keyCode === LEFT_ARROW) {
            //motionAngle-= angularAcceleration;
            this.directionAngle -= this.angularAcceleration;
        } else if (keyCode === RIGHT_ARROW) {
            //motionAngle+= angularAcceleration;
            this.directionAngle += this.angularAcceleration;
        }
        if (this.speed < this.maxSpeed) {
            if (keyCode === UP_ARROW) {
                this.speed += this.linearAcceleration;
                this.motionAngle = this.directionAngle;
            } else if (keyCode === DOWN_ARROW) {
                this.speed -= 1;
                this.motionAngle = this.directionAngle;
            }
        }
    }
}

Ship.prototype.checkBoundaries = function(){
    if (this.x > width) this.x = 0;
    else if (this.x < 0) this.x = width;
    if (this.y > height) this.y = 0;
    else if (this.y < 0) this.y = height;
}

Ship.prototype.updatePos = function(){
    if (this.speed > 0) {
        this.speed -= this.friction;
    }
    this.x += -this.speed * sin(this.motionAngle);
    this.y += this.speed * cos(this.motionAngle);
}

Ship.prototype.draw = function() {
    push();
    translate(this.x, this.y);
    rotate(this.directionAngle);
    triangle(0, 10, 10, -15, -10, -15);
    pop();
}
