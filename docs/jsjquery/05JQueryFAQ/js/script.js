$(document).ready(function(){
    /*
    You will need to write the following event(s):

    1. When a question is clicked, the answer needs to slide down to reveal itself. The arrow image needs to  be rotated to point down. Use the css class ‘rotate’.
    2. When a question is clicked and the answer is showing, the answer needs to slide up to hide itself. The arrow image needs to revert back to its original position.
    Bonus: Change your event so that only one question/answer can be opened at a time.
    */
    $('li.q').on('click', function(e){
        $(this).next().slideToggle('slow');
        $(this).children('img').toggleClass('rotate');
    });
    /*
       idea: if ($('li.q.open') ) { 
       remove id, close(slide toggle), rotate
       else
       $(this).next().slideToggle('slow');
       $(this).children('img').toggleClass('rotate');
       $(this).add(id = open);
    */
    
});

