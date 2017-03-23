/*
Score Keeping App

Recreate the html in the image screenshot and add your script
1. The Default score limit is 5
	The limit can be changed by the input field
2. Everytime player 1 or player 2 button is pressed score
	increments by 1 for player 1 or player 2.
3. When the score limit is reached the game is over
	Change the color to green for the winning player
4. Reset will set scores back to 0 for both players
	and will set the score limit back to the default

Use: event listeners, if/else statements, functions
*/

var winScore = 5; //initial limit
var p1Score = 0; //initial score for p1
var p2Score = 0; //initial score for p2
var gameOver = false;

var p1Button = document.getElementById("player1");
var p2Button = document.getElementById("player2");
var resetButton = document.getElementById("reset");

var p1Display = document.querySelector("#score1");
var p2Display = document.querySelector("#score2");

var numInput = document.querySelector("input"); //or #number
var limitDisplay = document.getElementById("playTo");
limitDisplay.textContent = winScore ;

p1Button.addEventListener("click", function(){
	//increase p1Score 

if (!gameOver){
	p1Score++;
	//if scoreP1 equals to winScore then end the game. 
	if(p1Score === winScore){
		gameOver = true;
		p1Display.classList.add("winner");
	}
	//display the score
	p1Display.textContent = p1Score;
}
});

p2Button.addEventListener("click", function(){
if (!gameOver){
	//increase p2Score 
	p2Score++;
	//if scoreP2 equals to winScore then end the game. 
	if(p2Score === winScore){
		gameOver = true;
		p2Display.classList.add("winner");
	}
	//display the score
	p2Display.textContent = p2Score;
}
});

var resetButton = document.querySelector("#reset");
resetButton.addEventListener("click", function(){
	reset();
});


function reset() {
	p1Score = 0;
	p1Display.textContent = 0;
	p2Score = 0;
	p2Display.textContent = 0;
	p1Display.classList.remove("winner");
	p2Display.classList.remove("winner");
	gameOver = false;
}

//changes how many games are needed to win the game
numInput.addEventListener("change", function(){
	winScore = Number(this.value); //because === and .value is initially a string, will never equal
	limitDisplay.textContent = this.value;
	reset();
});