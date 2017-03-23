var numSquares = 6;
var colors = [];
var pickedColor;
var squares = document.querySelectorAll(".square");
var colorDisplay = document.getElementById ("colorDisplay");
var messageDisplay = document.querySelector("#message");
var h1 = document.querySelector ("h1");
var resetButton = document.querySelector("#reset");
var modeButtons = document.querySelectorAll(".mode");
init();

function init(){
    setupModeButtons();
    setupSquares();
    reset();
}
function setupModeButtons(){
	for (var i = 0; i < modeButtons.length; i++) {
	    modeButtons[i].addEventListener("click", function() {
	    modeButtons[0].classList.remove("selected");
	    modeButtons[1].classList.remove("selected");
	    this.classList.add("selected");	
	    //ternary operation 
	    this.textContent === "Easy" ? numSquares = 3: numSquares = 6;
	    reset ();
	    });
    }
}
function setupSquares(){
    for (var i = 0; i < squares.length; i++) {
	//add click listeners to squares
	squares[i].addEventListener("click", function () {
		//grab color of clicked 
        var clickedColor = this.style.background;
		//compare color to pickedColor
		if(clickedColor === pickedColor) {
			messageDisplay.textContent = "Correct!"
			resetButton.textContent = "Play Again?"
			changeColors(clickedColor);
			h1.style.background = clickedColor;
		} else {
			this.style.background = "black";
			messageDisplay.textContent = "Try Again";
		}

	});
    }
}
function reset() {
	colors = generateRandomColors(numSquares);
	//pick a new random collor form array
	pickedColor = pickColor();
	//change colorDisplay to match picked Color
	colorDisplay.textContent = pickedColor;
	resetButton.textContent = "New Colors";
	messageDisplay.textContent = "";
	//change the colors of squares
	for (var i = 0; i < squares.length; i++) {
		if (colors[i]) {
		squares[i].style.display = "block";
		squares[i].style.background = colors[i];
	    } else {
		squares[i].style.display = "none";
	    }
	}    
	h1.style.background = "steelblue";
}

resetButton.addEventListener("click", function(){
    reset();
})


function changeColors(color) {
     //loop through all squares
     for (var i = 0; i < squares.length; i++) {
     //change each color to match given color	
     	squares[i].style.background = color;
     }
}

function pickColor () {
	var random = Math.floor(Math.random() * colors.length);
	return colors [random];
}
function generateRandomColors (num){
    var arr = [];
    for (var i = 0 ; i < num ; i++){
        arr.push(randomColor())
    }
    return arr;
}

function randomColor(){
    var red = Math.floor(Math.random() * 256);
    var green = Math.floor(Math.random() * 256);
    var blue = Math.floor(Math.random() * 256);
    return "rgb(" + red + ", " + green + ", " + blue + ")";
}

