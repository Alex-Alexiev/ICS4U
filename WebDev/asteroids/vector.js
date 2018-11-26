function Vector(x,y){
    this.x = x;
    this.y = y;
}

Vector.prototype.getAngle = function(){
    if (this.x < 0){
        return PI+atan(this.y/this.x);
    }
    return atan(this.y/this.x);
}

Vector.prototype.getMagnitude = function(){
    return Math.sqrt(this.x*this.x+this.y*this.y);
}

Vector.prototype.rotate = function(angle){
    let newAngle = this.getAngle()+angle;
    this.x = this.getMagnitude()*cos(newAngle);
    this.y = this.getMagnitude()*sin(newAngle);
}

Vector.prototype.scalarMultiply = function(k){
    this.x *= k;
    this.y *= k;
}

Vector.prototype.getScalarMultiply = function(k){
    return new Vector(this.x*k, this.y*k);
}

Vector.prototype.add = function(v){
    this.x += v.x;
    this.y += v.y;
}
