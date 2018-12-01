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

Vector.projection = function(a, b){
    theta = a.getAngle()-b.getAngle();
    mag = a.getMagnitude()*cos(theta);
    ret = b.getScalarMultiply(1/b.getMagnitude());
    ret.scalarMultiply(mag);
    return ret;
}

Vector.prototype.rotate = function(angle){
    let newAngle = this.getAngle()+angle;
    let magnitude =  this.getMagnitude();
    this.x = magnitude*cos(newAngle);
    this.y = magnitude*sin(newAngle);
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
