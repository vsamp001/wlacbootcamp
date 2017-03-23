var todoArray = [];
function addTodo (){
    var newTodo = prompt("Enter new todo");
    //add to todos array
    todoArray.push(newTodo);
    console.log("Added Todo");
}
function deleteTodo () {
    //ask for index of todo to be deleted
    var index = prompt("Enter index of todo to delete");
    //delete that todo
    //splice ()
    todoArray.splice(index, 1);
    console.log("Deleted Todo");
}
function listTodo (){
    todoArray.forEach(function(todoArray, i){
        console.log( i + ": " + todoArray)
    });
    console.log("--------");
}

var result = prompt("\"new\" - Add A Todo\n\"list\" - List All Todos\n\"delete\" - Remove Specific Todo\n\"quit\" - Quit App");

    while(result !== "quit"){
  
        if (result == "new"){
            addTodo();
        } else if (result == "list"){
            listTodo();
        } else if (result == "delete"){
            deleteTodo();
        } else {
            alert("Enter a correct command.");
        }
         result = prompt("\"new\" - Add A Todo\n\"list\" - List All Todos\n\"delete\" - Remove Specific Todo\n\"quit\" - Quit App");
    }
  console.log("quitting");  