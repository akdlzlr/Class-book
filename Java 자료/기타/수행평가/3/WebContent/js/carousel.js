
//function carousel(self,images) {
$.fn.carousel=function(images) {
	var self = this;
	var index = 0;
/////////////////////////////////////////////////////////////////////////////////////////
	var template = `<div class="carousel">
		<img>
		<a class="prev" href="#"><i class="fas fa-angle-left"></i></a>
		<a class="next" href="#"><i class="fas fa-angle-right"></i></a>
		<div class="indicator"></div></div>`;
	
	self.append(template);
/////////////////////////////////////////////////////////////////////////////////////////
	
	function changeImage(index) {
		$('.carousel img').fadeOut('slow',function (){
				$(this).attr('src', 'images/' + images[index]);
				$(this).fadeIn('slow');
				});
		$('.indicator-item').removeClass('active');
		$('.indicator-item').eq(index).addClass('active');
	}
	
	for(var ix in images){
		var indicator = $('<a href="#" class="indicator-item"></a>')
		$('.carousel>.indicator').append(indicator)	
	}
	
	$('.indicator-item').click(function(){
		index = $(this).index();
		changeImage(index);
		
	});
	
	$('.prev').click(function(){
		index = (index-1) < 0 ? images.length-1 : index-1;
		changeImage(index);
	});
	
	$('.next').click(function(){
		index = (index+1) % images.length;
		changeImage(index);
	});		
	
	setInterval(function(){
		index = (index+1) % images.length;
		changeImage(index);
	}, 3000);

	changeImage(index);	
	
	return this;
}




