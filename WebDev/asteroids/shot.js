function Shot(x,y,speed, motionAngle){
    this.position = new Vector(x,y);
    this.velocity = new Vector(1,0);
    this.velocity.scalarMultiply(speed);
    this.velocity.rotate(motionAngle);
    this.distanceTraveled = 0;
    this.radius = 5;
    this.maxDistance = 10000;
    this.show = true;
}

Shot.prototype.draw = function(){
    if (this.show){
        fill(255);
        translate(width/2, height/2);
        rotate(PI);
        ellipse(-this.position.x, this.position.y, this.radius, this.radius);
        this.move();
    }
}

Shot.prototype.move = function() {
    if (this.position.magnitude < this.maxDistance){
        this.position.add(this.velocity);
    } else {
        this.show = false;
    }
}