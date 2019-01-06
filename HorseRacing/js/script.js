$(function () {

    var START_BALANCE = 500;
    var players = [];

    function addPlayer() {
        players.push({ name: $("#nameInput").val(), balance: START_BALANCE });
    }

    userEntry = $("#newPlayerForm").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true,
        buttons: {
            "Create Player": function () { addPlayer(); updateTable(); userEntry.dialog("close"); },
            Cancel: function () { userEntry.dialog("close") }
        }
    });

    $("#addPlayer").button().on("click", function () {
        userEntry.dialog("open");
    });

    function updateTable() {
        $("#playerTable").empty();
        $("#playerTable").append("<th>Name</th><th>Balance</th>")
        for (let i = 0; i < players.length; i++) {
            $("#playerTable").append("<tr>" +
                "<td>" + players[i].name + "</td>" +
                "<td>" + players[i].balance + "</td>");
        }

        $("#placeBets").button().on("click", function () {
            $("#addPlayersDiv").hide(1000);
            $("#placeBetsDiv").show(1000);
        });

    }

    $("#placeBets").button().on("click", function () {
        $("#addPlayersDiv").hide(1000);
        $("#placeBetsDiv").show(1000);
        updateBetForm();
    });

    var horses = ["clark", "ben", "jon"];

    function updateBetForm(){
        $("#playerSelect").empty();
        $.each(players, function(i,p){
            let name = players[i].name;
            $("#playerSelect").append($("<option></option>").val(name).html(name));
        });
        $("#horseSelect").empty();
        $.each(horses, function(i, p){
            $("#horseSelect").append($("<option></option>").val(p).html(p));
        });
    }

    var bets = [];

    $("#playerSelect").selectmenu();
    $("#horseSelect").selectmenu();
    $("#betAmount").spinner();

    $("#makeBet").button().on("click", makeBet)

    function makeBet(){
        bets.push({name:$("#playerSelect").val(), horse:$("#horseSelect").val(), amount:$("#betAmount").val()});
    }

    $("#watchRace").button().on("click", function(){
        $("#placeBetsDiv").hide(1000);
        $("#watchRaceDiv").show(1000);
        race();
    });

    function race(){
        var winner = horses[Math.floor(Math.random()*horses.length)];
        $("#winnerText").append(document.createTextNode(winner+"!"))
    }

    $("#showResults").button().on("click", function(){
        $("#watchRaceDiv").hide(1000);
        $("#showResultsDiv").show(1000);
    });

    $("#playAgain").button().on("click", function(){
        $("#showResultsDiv").hide(1000);
        $("#addPlayersDiv").show(1000);
    });

});



