jQuery(document).ready(function($){
		$('.thumbnail').on('click',function(e) {
			e.preventDefault();
			var urlLocation = $(this).attr('href');
			urlLocation += '&name=' + $(this).find('img').first().attr('name');

			location.href = urlLocation;
			})
		});
