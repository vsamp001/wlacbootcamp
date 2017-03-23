/*
Word Unscramble

Create a function that will take a string and an array of letters
The array will contain all of the same letters as the string but will be scrambled
Example:  "hello" and ["l","e","h","o","l"] 

The function will move the indices and sort it until it equals the string.
*/
function unscramble (scram, word){
    if (word.length != scram.length){
        return console.log("The string and array are not the same size");
    } else {
        console.log("Original " + scram);
        var splitWord = word.split('');
        var temp;
        for (var i = 0 ; i < scram.length ; i++){
            for (var j = 0 ; j < scram.length ; j++){
                if (splitWord[i] == scram[j]){
                    temp = scram[i];
                    scram[i] = scram[j];
                    scram[j] = temp;
                }
            }
        }   
        return console.log("Word " + word + "\nArray " + scram);
    }
}

unscramble(["l","e","h","o","l"], "hello");