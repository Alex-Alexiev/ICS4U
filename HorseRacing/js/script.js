var START_BALANCE = 500;

var players = [{
        name: "benbet",
        balance: 500
    },
    {
        name: "clarkbet",
        balance: 500
    }
];

var horses = ["clark", "ben", "jon"];
var bets = [];

var winningHorse;

updateTable();

$(function () {

    updateTable();
    
    userEntry = $("#newPlayerForm").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true,
        buttons: {
            "Create Player": function () {
                addPlayer();
                updateTable();
                userEntry.dialog("close");
            },
            Cancel: function () {
                userEntry.dialog("close")
            }
        }
    });

    $("#addPlayer").button().on("click", function () {
        userEntry.dialog("open");
    });

    $("#placeBets").button().on("click", function () {
        $("#addPlayersDiv").hide(1000);
        $("#placeBetsDiv").show(1000);
    });

    $("#placeBets").button().on("click", function () {
        $("#addPlayersDiv").hide(1000);
        $("#placeBetsDiv").show(1000);
        updateBetForm();
    });

    $("#playerSelect").selectmenu();
    $("#horseSelect").selectmenu();
    $("#betAmount").spinner();

    $("#makeBet").button().on("click", makeBet)

    $("#watchRace").button().on("click", function () {
        $("#placeBetsDiv").hide(1000);
        $("#watchRaceDiv").show(1000);
        race();
    });

    $("#showResults").button().on("click", function () {
        calculateResults();
        $("#watchRaceDiv").hide(1000);
        $("#addPlayersDiv").show(1000);
        updateTable();
    });

    $("#playAgain").button().on("click", function () {
        $("#showResultsDiv").hide(1000);
        bets = [];
        $("#addPlayersDiv").show(1000);
    });

});

function addPlayer() {
    players.push({
        name: $("#nameInput").val(),
        balance: START_BALANCE
    });
}

function updateTable() {
    $("#playerTable").empty();
    $("#playerTable").append("<th>Name</th><th>Balance</th>")
    for (let i = 0; i < players.length; i++) {
        $("#playerTable").append("<tr>" +
            "<td>" + players[i].name + "</td>" +
            "<td>" + players[i].balance + "</td>");
    }
}

function updateBetForm() {
    $("#playerSelect").empty();
    $.each(players, function (i, p) {
        let name = players[i].name;
        $("#playerSelect").append($("<option></option>").val(name).html(name));
    });
    $("#horseSelect").empty();
    $.each(horses, function (i, p) {
        $("#horseSelect").append($("<option></option>").val(p).html(p));
    });
}

function makeBet() {
    bets.push({
        name: $("#playerSelect").val(),
        horse: $("#horseSelect").val(),
        amount: parseInt($("#betAmount").val())
    });
    for (let i = 0; i < players.length; i++) {
        if (players[i].name == $("#playerSelect").val()) {
            players[i].balance -= parseInt($("#betAmount").val());
        }
    }
}


function race() {
    winningHorse = horses[Math.floor(Math.random() * horses.length)];
    $("#winnerText").empty()
    $("#winnerText").append(document.createTextNode("The winner is " + winningHorse + "!"));
}

/*
function calculateResults() {
    var winningPlayers = [];
    var totalBets = 0;
    for (let i = 0; i < bets.length; i++) {
        totalBets += bets[i].amount;
        if (bets[i].horse == winningHorse) {
            winningPlayers.push(bets[i].name);
        }
    }
    if (winningPlayers.length > 0) {
        var winningsPerPlayer = totalBets / (winningPlayers.length);
        for (let i = 0; i < winningPlayers.length; i++) {
            for (let j = 0; j < players.length; j++) {
                if (players[j].name == winningPlayers[i]) {
                    players[j].balance += winningsPerPlayer;
                }
            }
        }
    }
}
*/

function calculateResults() {
    for (let i = 0; i < bets.length; i++) {
        if (bets[i].horse == winningHorse) {
            for (let j = 0; j < players.length; j++) {
                if (players[j].name == bets[i].name) {
                    players[j].balance += bets[i].amount * 2;
                }
            }
        }
    }
}