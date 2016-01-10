<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Macaque</title>


    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <nav class="navbar">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Home</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active"><a href="inscription.html">Inscription / Se connecter <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Jouer</a></li>
            <li><a href="boutique.html">Boutique</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">photo <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="gestion.html">Gérer</a></li>
                <li><a href="#">Deconnexion</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>

    <!-- page-container contient tout le contenu relatif a la page courante -->
    <div id="page-container">
      <div class="jumbotron">
        <h1>Bienvenue !</h1>
      </div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script>
	//<![CDATA[

	window.onload = function(){

          var i =0;
	   var imgs = ['dofus1.png','Himouto.jpg','kiraitchi1.png','Tamagotchi_blue1.png'];

	   var genImg = function(){
             if (i > 2) {
              i =0;
             } else {
              i++
             }
	      $("#imgs").html("<img class=\"imgdemo\" src=\"img/"+imgs[i]+"\" />").css("opacity",0).animate({opacity:1},800);
	   };
	   var timer = setInterval(function(){ genImg(); }, 2000);
	   genImg();
				
	};
	//]]>
	</script>

	<div id="imgs"></div>
	
	<div class="col-md-2">
        </div>
      </div>
      <!-- end row -->

      <hr/>
      <!-- row -->
      <div class="row" id="home-presentation">
        <div class="col-lg-4"> <img src="img/dofus.png" class="img-circle">
          <h2>Un oeuf aléatoire</h2>
          <p>Commencez par choisir un oeuf que vous devrez élever</p>
        </div>
        <div class="col-lg-4"> <img src="img/himouto.jpg" class="img-circle">

          <h2>Évolution</h2>
          <p>Ils évolueront en fonction de la façon dont vous les élever.
            <br/> Attention à ne pas les laisser sans surveillance trop longtemps !</p>
        </div>
        <div class="col-lg-4"> <img src="img/tamagotchi.jpg" class="img-circle">

          <h2>Jouez avec vos amis</h2>
          <p>Jouez avec vos téléphones sur un seul écran, comme si vous aviez une Wii !</p>
        </div>
      </div>
      <!-- end row -->
      </div>
      <!--end page-container -->

    <!-- footer -->
    <hr/>
    <footer>
      <p class="pull-right"><a href="#aviveta">Aviveta Team</a></p>
      <p>Projet d'intergiciel 2015-2016</p>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>

</html>
