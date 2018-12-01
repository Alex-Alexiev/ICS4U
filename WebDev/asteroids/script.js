var ship;
var shots;
var asteroids;

function setup() {
    frameRate(60);
    var cnv = createCanvas(windowWidth, windowHeight);
    //cnv.style('display', 'block');
    ship = new Ship(0,0, 0.6, 0.09, 5, 0.018);
    shots = new Shots(3, 2);
    asteroids = new AsteroidField(10, 50, 1);
}

function draw() {
    background(0);
    fill(255);
    stroke(255);
    ship.update();
    shots.update();
    asteroids.update(shots.shotArray, ship);
}

function gameOver(){
    location.reload();
}

function keyTyped(){
    if (key === ' '){
        shots.add(ship.position, ship.velocity, ship.direction);
    }
}

