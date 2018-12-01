function checkBoundaries(position){
    var ret = new Vector(position.x, position.y);
    if (position.x > width/2) ret.x = -width/2;
    else if (position.x < -width/2) ret.x = width/2;
    if (position.y > height/2) ret.y = -height/2;
    else if (position.y < -height/2) ret.y = height/2;
    return ret;
}

function drawEllipse(position, size){
    stroke(255);
    push();
    translate(width/2, height/2);
    rotate(PI);
    ellipse(-position.x, position.y, size, size);
    pop();
}