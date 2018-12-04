
function carousel(images) {
	var index = 0;
	
	function changeImage(index) {
		$('.carousel img').attr('src', 'images/' + images[index]);
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
	
	
}