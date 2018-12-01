function Shots(radius, speed){
    this.radius = radius;
    this.speed = speed;
    this.shotArray = new Array();    
}

Shots.prototype.add = function(position, velocity, direction){
    this.shotArray.push(new Shot(position, velocity, direction, this.speed));
}

Shots.prototype.update= function(){
    this.clean();
    //this.draw();
}

Shots.prototype.draw = function(){
    for(let i = 0; i < this.shotArray.length; i++){
        this.shotArray[i].draw();
    }
}

Shots.prototype.clean = function(){
    for(let i = 0; i < this.shotArray.length; i++){
        if (!this.shotArray[i].show) this.shotArray.splice(i, 1);
    }
}
