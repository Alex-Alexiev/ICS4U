var balance = 500;
var bet;

var playerCards = [];
var dealerCards = [];

var playerScore = 0;
var dealerScore = 0;

class CardOperations { 
    
    static getCard() {
        var cards = [
            "2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "10c", "jc", "qc", "kc", "ac",
            "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s", "js", "qs", "ks", "as",
            "2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "10h", "jh", "qh", "kh", "ah",
            "2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "10d", "jd", "qd", "kd", "ad",
        ]
        return cards[parseInt(Math.random()*52, 10)]; 
    }

    static getString(card){
        var value = CardOperations.getValue(card.substring(0, 1))[0];
        var suit = CardOperations.getSuit(card.substring(1))[0];
        return "("+value + " of " +suit+")";
    }

    static getSuit(suit){
        if (suit == 'c') return ["Clubs", "black"];
        if (suit == 'h') return ["Hearts", "red"];
        if (suit == 's') return ["Spades", "black"];
        if (suit == 'd') return ["Diamonds", "red"];
    }

    static getValue(value){
        if (value == 'a') return ["Ace", 1];
        if (value == 'j') return ["Jack", 10];
        if (value == 'k') return ["King", 10];
        if (value == 'q') return ["Queen", 10];
        return [value, parseInt(value, 10)];
    }

    static getCardValue(card){
        return CardOperations.getValue(card.substring(0,1))[1];
    }
     
}

function init(){
    document.getElementById("intro").innerHTML += "$"+balance;
}

function placeBet(){
    bet = document.getElementById("betInput").value;
}

function start(){
    playerCards[0] = CardOperations.getCard();
    dealerCards[0] = CardOperations.getCard();    
    calculateScores();
    showCards();
}

function calculateScores(){
    playerScore = 0;
    for (var i = 0; i < playerCards.length; i++){
        playerScore += CardOperations.getCardValue(playerCards[i]);
    }
    dealerScore = 0;
    for (var i = 0; i < dealerCards.length; i++){
        dealerScore += CardOperations.getCardValue(dealerCards[i]);
    }
}

function showCards(){
    document.getElementById("playerCards").innerHTML = "Your cards: ";
    for (var i = 0; i < playerCards.length; i++){
        document.getElementById("playerCards").innerHTML += CardOperations.getString(playerCards[i]);
    }
    document.getElementById("dealerCards").innerHTML = "Dealer cards: ";
    for (var i = 0; i < dealerCards.length; i++){
        document.getElementById("dealerCards").innerHTML += CardOperations.getString(dealerCards[i]);
    }
}

function hit(){
    playerCards[playerCards.length] = CardOperations.getCard();
    calculateScores();
    showCards();
    calculateFate();
}

function calculateFate(){
    if (playerScore > 21) {
        lose();
    } else if (playerScore == 21){
        win();
    }
}

function lose(){
    balance -= bet;
    location.assign("final.html");
    document.getElementById("result").innerHTML = "LMAO you lost...$"+bet+" your new balance is $"+balance;
    window.location.href = "final.html";
}

function win(){
    balance += bet;
}

function stand(){

}
