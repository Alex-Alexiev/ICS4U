var shotArray = new Array();

function Shots(radius, speed){
    this.radius = radius;
    this.speed = speed;
}

Shots.prototype.add = function(x,y,angle){
    shotArray.push(new Shot(x,y,this.speed, angle));
}

Shots.prototype.show = function(){
    this.clean();
    for(let i = 0; i < shotArray.length; i++){
        shotArray[i].draw();
    }
}

Shots.prototype.clean = function(){
    for(let i = 0; i < shotArray.length; i++){
        if (!shotArray[i].show) shotArray.splice(i, 1);
    }
}
