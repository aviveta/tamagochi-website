<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ConnecterMacaque</title>


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
          <a class="navbar-brand" href="index2.html">Home</a>
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

      <!-- row -->
      <div class="row" id="inscription-container">
        <div class="col-md-3">
        </div>
        <div class="col-md-7">
          <form class="form-signin" id="formulaire-login">
            <h2 class="form-signin-heading">Se connecter</h2>
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email" required="" autofocus="">
            <label for="inputPassword" class="sr-only">Mot de passe</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Mot de passe" required="">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me"> Se souvenir de moi
              </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer !</button>
          </form>
          <img id="kiraitchi" src="img/kiraitchi.png"/>
        </div>

        <div class="col-md-2">
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
