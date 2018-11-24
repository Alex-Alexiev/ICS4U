function setup(){
    frameRate(20);
    createCanvas(400,400);
}

function draw(){
    background(0);
    fill(255);
    stroke(255);
    var y = height/2-mouseY;
    var x = mouseX - width/2;
    var angle = atan(y/x);
    console.log(x + ":" + y + ":" + (180/PI)*angle);
    push();
    translate(width/2, height/2);
    rotate(-angle);
    line(0,0,100,0);
    pop();   
}