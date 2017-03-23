$(document).ready(function(){
    //Mark an item complete by clicking on the to-do item. 
    //Use the provided CSS class to give the text a strike-through.
    $('ul').on('click','li', function(){
        $(this).toggleClass("completed");
    });
    //2. When the trash icon is clicked, delete the to-do item from 
    //the list. Give the event a fadeOut effect. HINT: Make sure the 
    //animation finishes, before removing the list item.

    $("ul").on("click", "span", function(event) {
	    $(this).parent().fadeOut(500, function(){
	    	$(this).remove();
    	});
	    event.stopPropagation();
    });

    //When the user types into the text box and presses the enter key, 
    //add the text entered to the to-do list, then clear the text box. 
    //HINT: Use the event.which property to find out which key was pressed.  T
    //he code for the enter key is 13. 
    $("input[type='text'").keypress(function(event) {
        if (event.which === 13 ) {
            //alert('enter');
            //grabbing new todo text from input
	        var todoText = $(this).val();
	        $(this).val("");
	        //create a new li and add to ul
	        $("ul").append("<li><span><i class='fa fa-trash'></i></span> " + todoText + "</li>")
        }
    });
    
    //When clicked, the plus (+) sign needs to hide or display 
    //the input text box.  Use a fade effect. 
    $("i.fa.fa-plus").click(function() {
      //  alert("clicked");
	    $("input[type='text'").fadeToggle();
        });
});