


$.fn.lightbox = function(opt){
	var self = this;	// 클로저형태
	opt = $.extend({
		images : [],
		boxname : 'lightbox-set'
	},opt);
	opt.images.forEach(item=>{
		var templ=`
		<a href="../images/${item}"
		 data-lightbox="${opt.boxname}" data-title="My caption">
		 	<img src="../images/${item}" width="100" class="img-thumbnail">
		 	</a>`;
		 $(self).append(templ);
	});
	
	return this;
}
