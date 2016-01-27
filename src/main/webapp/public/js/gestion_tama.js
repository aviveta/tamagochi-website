jQuery(document).ready(function($){

		var domain = window.location.host;


		$('.bouton-gerer').on('click',function(e) {
			e.preventDefault();

			var url ="http://"+domain+"/tama-game/gestionTamagochis?";
			var index = 0;
			url += "name="+ $('#tama-gere').attr('name') + "&a=" + $(this).parent().find('input').first().val(); 
			

			$.ajax({
				url: url
			}).done(function(data){
				alert(data);
				//traitement des data
				var tab = data.split(";");
				//on recupere les infos pour chaque case du tableau
				var id = tab[0]; //id

				//on remplace pour chaque attribut
				$('#poids').text(tab[1]);
				$('#proprete').text(tab[2]);
				$('#joie').text(tab[3])
			})

			})
		});
