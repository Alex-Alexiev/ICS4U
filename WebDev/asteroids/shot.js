function Shot(position,velocity,direction, speed){
    this.position = new Vector(position.x, position.y);
    //this.position = new Vector(0,0);
    this.velocity = new Vector(1,0);
    this.velocity.scalarMultiply(speed);
    this.velocity.rotate(direction.getAngle());
    this.velocity.add(Vector.projection(this.velocity, direction));
    this.distanceTraveled = 0;
    this.radius = 5;
    this.maxDistance = 500;
    this.show = true;
}

Shot.prototype.draw = function(){
    fill(255);
    drawEllipse(this.position, this.radius);
}

Shot.prototype.move = function() {
    this.distanceTraveled += this.velocity.getMagnitude();
    if (this.distanceTraveled < this.maxDistance){
        this.position.add(this.velocity);
    } else {
        this.show = false;
    }
    this.position.add(this.velocity);
}