function main(){
$('.skillset').hide();
$('.skillset').fadeIn(1000);
$('.projects').hide();
$('.projects-button').on('click', function(){
  $(this).toggleClass('active');
  $(this).text('Projects Viewed');
  $(this).next().slideToggle(400);
});
}
$(document).ready(main);