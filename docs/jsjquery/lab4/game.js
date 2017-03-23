/* 
Guessing Game
Create your own index page.
*/

//1. create secretNumber

//2. ask user for guess

//3. check if guess is right

//4. check if guess is higher

//5. otherwise, check if lower
var secretNumber = 35;

var guessedNumber=  prompt("Guess a number between 1 to 100: ");

if(guessedNumber == secretNumber){
    console.log("Guess is right!");
} else if (guessedNumber > secretNumber){
    console.log("Guess is higher than the secret number.");
} else if (guessedNumber < secretNumber){
    console.log("Guess is lower than the secret number.");
}