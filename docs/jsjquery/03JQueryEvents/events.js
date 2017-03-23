$(document).ready(function () {
    $('button').click(function(){
        $(this).css('background-color', 'pink');
        alert($(this).text());
    });
    
//    $('input').keypress(function(){
//        console.log("key has been pressed");
//    });
    
    $('h1').on('click', function(){
        $(this).css('color', 'purple');
    });
    $('input').on('keypress', function(event){
       console.log(event.type + ": " + event.which); 
    });
});