$.fn.hScroll = function(news) {
	var self = this;
	self.append('<p class="h-scroll-text"></p>');
	var ix = 0;
	function hscroll() {
		self.find('.h-scroll-text').css({
			position : 'relative',
			left : '100%'
		}).text(news[ix]).animate({
			left : '-100%'
		}, 5000, 'linear', hscroll);
		ix = (ix + 1) % news.length;

	}
	hscroll();
	return this;
}