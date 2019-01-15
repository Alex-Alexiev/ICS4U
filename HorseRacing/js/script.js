var START_BALANCE = 500;
var ANIMATION_TIME = 100;

var players = [];

var colours = [{
        name: "white",
        position: 0
    },
    {
        name: "pink",
        position: 0
    },
    {
        name: "red",
        position: 0
    },
    {
        name: "yellow",
        position: 0
    },
    {
        name: "purple",
        position: 0
    },
    {
        name: "green",
        position: 0
    },
    {
        name: "blue",
        position: 0
    }
];

var bets = [];

var winners = [];

$(function () {

    $("#startAnimation").hide();

    $("#startGame").button().on("click", function () {
        $("#startDiv").hide();
        startAnimation();
        $("#addPlayersDiv").show(ANIMATION_TIME);
    });

    userEntry = $("#newPlayerForm").dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: ANIMATION_TIME
        },
        hide: {
            effect: "blind",
            duration: ANIMATION_TIME
        },
        width: 400,
        height: 300,
        modal: true,
        buttons: {
            "Add Player": function () {
                addPlayer();
            },
            Cancel: function () {
                userEntry.dialog("close");
            }
        },
        close: function () {
            playerForm[0].reset();
        }

    });

    playerForm = userEntry.find("form").on("submit", function (event) {
        event.preventDefault();
        addPlayer();
    });

    $("#addPlayer").button().on("click", function () {
        userEntry.dialog("open");
    });

    $("#placeBets").button().on("click", function () {
        $("#addPlayersDiv").hide(ANIMATION_TIME);
        updateBetForm();
        $("#placeBetsDiv").show(ANIMATION_TIME);
    });

    $("#playerSelect").selectmenu();
    $("#colourSelect").selectmenu();
    $("#betAmount").spinner();
    $("#betType").selectmenu();

    $("#error").dialog({
        autoOpen: false,
        modal: true
    });

    $("#backToPlayer").button().on("click", function(){
        $("#placeBetsDiv").hide(ANIMATION_TIME);
        $("#addPlayersDiv").show(ANIMATION_TIME);
    });

    $("#submitBet").button().on("click", function () {
        makeBet();
    });

    $("#watchRace").button().on("click", function () {
        $("#placeBetsDiv").hide(ANIMATION_TIME);
        $("#watchRaceDiv").show(ANIMATION_TIME);
        race();
    });

    $("#results").dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: ANIMATION_TIME
        },
        hide: {
            effect: "blind",
            duration: ANIMATION_TIME
        },
        modal: true,
        close: function () {
            calculateResults();
            $("#watchRaceDiv").hide(ANIMATION_TIME);
            $("#addPlayersDiv").show(ANIMATION_TIME);
            updatePlayerTable();
        }
    });

});

/**
 * The starting animation for the game
 */
function startAnimation() {
    $("#startAnimation").show();
    let canvas = $("#animation")[0];
    let ctx = canvas.getContext('2d');
    canvas.width = colours.length * 30;
    canvas.height = window.innerHeight/2;
    let finished = 0;

    function iteration() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for (let i = 0; i < colours.length; i++) {
            if (colours[i].position < canvas.height) {
                colours[i].position += Math.floor(i + 1 + 0.075 * colours[i].position);
                if (colours[i].position >= canvas.height) {
                    finished++;
                }
            }
            ctx.fillStyle = colours[i].name;
            ctx.fillRect(i * 30, colours[i].position, 30, 30);
        }
        setTimeout(function () {
            if (finished < colours.length) {
                iteration();
            } else {
                $("#startAnimation").hide(ANIMATION_TIME);
            }
        }, 12);
    }
    iteration();
}

/**
 * adds a player to the player array with the name 
 * from the input and the default balance 
 */
function addPlayer() {
    players.push({
        name: $("#nameInput").val(),
        balance: START_BALANCE
    });
    userEntry.dialog("close");
    updatePlayerTable();
}

/**
 * Uses the latest information about the players and their
 * balance to update the HTML table showing those values
 */
function updatePlayerTable() {
    $("#playerTable").empty();
    $("#playerTable").append("<th>Name</th><th>Balance</th>")
    for (let i = 0; i < players.length; i++) {
        $("#playerTable").append("<tr>" +
            "<td>" + players[i].name + "</td>" +
            "<td>" + players[i].balance + "</td>");
    }
}

/**
 * Will add all the options to the select menus
 * of the betting form to account for any 
 * added players 
 */
function updateBetForm() {
    $("#bettingForm")[0].reset();
    $("#playerSelect").empty();
    $("#playerSelect").append($("<option selected disabled hidden></option>").html("--select an option--"));
    $.each(players, function (i, p) {
        let name = players[i].name;
        $("#playerSelect").append($("<option></option>").html(name));
    });
    $("#colourSelect").empty();
    $("#colourSelect").append($("<option selected disabled hidden></option>").html("--select an option--"));
    $.each(colours, function (i, p) {
        let name = colours[i].name;
        $("#colourSelect").append($("<option></option>").html(name));
    });
    $('select').each(function () {
        $(this).find('option:first').prop('selected', 'selected');
    });
}

/**
 * Adds one item to the bets array with 
 * information from the betting form 
 */
function makeBet() {
    let name = $("#playerSelect").val();
    let amount = parseInt($("#betAmount").val());
    let type = $("#betType").val();
    let colour = $("#colourSelect").val();
    let valid = false;
    if (name != null && type != null && colour != null) {
        for (let i = 0; i < players.length; i++) {
            if (name == players[i].name) {
                if (amount < players[i].balance && amount > 0) {
                    valid = true;
                }
                break;
            }
        }
    }
    if (!valid) {
        $("#error").dialog("open");
        updateBetForm();
    }
    bets.push({
        name: name,
        colour: colour,
        amount: amount,
        type: type
    });
    for (let i = 0; i < players.length; i++) {
        if (players[i].name == $("#playerSelect").val()) {
            players[i].balance -= parseInt($("#betAmount").val());
        }
    }
    updateBetForm();
}

/**
 * shows a graphical race using the canvas and 
 * when the race is finished a dialog is opened 
 * to show the winners
 */
function race() {
    reset();
    $("#winnerText").empty()
    let canvas = $("#race")[0];
    let ctx = canvas.getContext('2d');
    canvas.width = window.innerWidth;
    canvas.height = colours.length * 30;
    let finished = 0;

    function iteration() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for (let i = 0; i < colours.length; i++) {
            if (colours[i].position < canvas.width) {
                let step = Math.floor(Math.random() * 20) + 1;
                colours[i].position += step;
                if (colours[i].position >= canvas.width) {
                    winners.push(colours[i]);
                    finished++;
                }
            }
            ctx.fillStyle = colours[i].name;
            ctx.fillRect(colours[i].position, i * 30, 30, 30);
        }
        setTimeout(function () {
            if (winners.length < colours.length) {
                iteration();
            } else {
                $("#results").empty();
                for (let i = 0; i < 3; i++) {
                    $("#results").append("<p>" + (i + 1) + ": " + winners[i].name);
                }
                $("#results").dialog("open");
            }
        }, 50);
    }
    iteration();
}

/**
 * based on the winners array, and the bets array, 
 * the balances of all the players will be 
 * updated
 */
function calculateResults() {
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < bets.length; j++) {
            if (bets[j].colour == winners[i].name) {
                let winnings = 0;
                if (bets[j].type == "Win") {
                    winnings = bets[j].amount * 2;
                } else if (bets[j].type == "Place") {
                    winnings = bets[j].amount * 1.5;
                } else {
                    winnings = bets[j].amount * 1.25
                }
                for (let k = 0; k < players.length; k++) {
                    if (players[k].name == bets[j].name) {
                        players[k].balance += winnings;
                        break;
                    }
                }
                break;
            }
        }
    }
    reset();
}

function reset() {
    bets = [];
    winners = [];
    for (let i = 0; i < colours.length; i++) {
        colours[i].position = 0;
    }
}