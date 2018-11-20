function testMe(){
    var arr = [];
    arr[2] = "Hello";
    arr[1] = 5;
    //arr[0] = function(){alert("woah");};
    //arr[0]();

    //maps
    var obj = {};
    obj.var1 = 6;
    obj.var2 = arr;
    obj.func1 = function(){console.log(this.var1);}; 

    var obj2 = {};
    obj2.var1 = 5;
    obj2.var2 = 10;

    var jsonString = JSON.stringify(arr);
    console.log(jsonString);

    var obj3 = JSON.parse(jsonString);
    console.log();
    
}

function updateBet(){
    var bet = document.getElementById('betInput').value;
    document.getElementById('bet').innerHTML = bet;
    var el = document.createElement("p");
    el.innerText = "hi";
    document.querySelectorAll("body")[0].append(el);
}