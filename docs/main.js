$(document).ready(function () {
  $('.projects').hide();
  $('.btn').on('click', function(){
    $(this).next().slideToggle(400);
     console.log("extra next");
  });
});