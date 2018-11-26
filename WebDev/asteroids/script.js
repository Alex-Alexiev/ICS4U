var ship;
var shots;
var asteroids;

function setup() {
    frameRate(60);
    createCanvas(400, 400);
    ship = new Ship(0,0, 0.3, 0.07, 5, 0.02);
    shots = new Shots(3, 5);
    asteroids = new AsteroidField(5, 50, 1);
}

function draw() {
    background(0);
    fill(255);
    stroke(255);
    ship.update();
    shots.show();
    asteroids.show();
}

function keyTyped(){
    if (key === ' '){
        shots.add(ship.position.x, ship.position.y, ship.direction.getAngle());
    }
}

