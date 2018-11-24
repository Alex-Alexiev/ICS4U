var shotArray = new Array();

function Shots(radius, speed){
    this.radius = radius;
    this.speed = speed;
}

Shots.prototype.add = function(x,y,angle){
    shotArray.push(new Shot(x,y,this.speed, angle));
}

Shots.prototype.show = function(){
    for(let i = 0; i < shotArray.length; i++){
        shotArray[i].draw();
    }
}

