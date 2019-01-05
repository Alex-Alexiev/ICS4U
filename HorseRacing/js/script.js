var players = [];

function placeBets(){
    document.getElementById("addPlayers").style.display = "none";
    document.getElementById("placeBets").style.display = "block";
}

function watchRace(){
    document.getElementById("placeBets").style.display = "none";
    document.getElementById("watchRace").style.display = "block";
}

function showResults(){
    document.getElementById("watchRace").style.display = "none";
    document.getElementById("showResults").style.display = "block";
}

