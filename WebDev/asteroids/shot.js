function Shot(position,velocity,direction, speed){
    this.position = new Vector(position.x, position.y);
    //this.position = new Vector(0,0);
    this.velocity = new Vector(1,0);
    this.velocity.scalarMultiply(speed);
    this.velocity.rotate(direction.getAngle());
    this.velocity.add(Vector.projection(velocity, direction));
    this.distanceTraveled = 0;
    this.radius = 5;
    this.maxDistance = 500;
    this.show = true;
}

Shot.prototype.draw = function(){
    if (this.show){
        fill(255);
        push();
        translate(width/2, height/2);
        rotate(PI);
        ellipse(-this.position.x, this.position.y, this.radius, this.radius);
        pop();
        this.move();
    }
}

Shot.prototype.move = function() {
    // if (this.position.getMagnitude() < this.maxDistance){
    //     this.position.add(this.velocity);
    // } else {
    //     this.show = false;
    // }
    this.position.add(this.velocity);
}