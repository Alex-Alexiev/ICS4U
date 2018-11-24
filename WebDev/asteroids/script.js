var ship;
var shots;

function setup() {
    frameRate(60);
    createCanvas(400, 400);
    ship = new Ship(width/2, height/2, 0.3, 0.1, 5, 0.05);
    shots = new Shots(3, 5);
}

function draw() {
    background(0);
    fill(255);
    stroke(255);
    ship.update();
    shots.show();
}

function keyTyped(){
    if (key === ' '){
        shots.add(ship.x, ship.y, ship.directionAngle);
    }
}
