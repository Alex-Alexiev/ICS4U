function onOver(params) {
    //x is an array
    var x = document.querySelectorAll(".c1");
    
    for (let i = 0; i < x.length; i++) {
        x[i].classList.add("hoverClass");        
    }

}

function onOut(params) {
    //x is an array
    var x = document.querySelectorAll(".c1");
    
    for (let i = 0; i < x.length; i++) {
        x[i].classList.remove("hoverClass");        
    }

}