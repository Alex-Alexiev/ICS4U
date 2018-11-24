function Shot(x,y,speed, motionAngle){
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.motionAngle = motionAngle;
    this.distanceTraveled = 0;
    this.radius = 5;
}

Shot.prototype.draw = function(){
    fill(255);
    ellipse(this.x, this.y, this.radius, this.radius);
    this.move();
}

Shot.prototype.move = function() {
    this.y += this.speed*cos(this.motionAngle);
    this.x += this.speed*sin(this.motionAngle);
}