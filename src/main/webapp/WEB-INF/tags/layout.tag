<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="username"  %>
<%@attribute name="content" fragment="true" %>
<%@attribute name="head_content" fragment="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="/tama-game/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/tama-game/public/css/style.css" rel="stylesheet">
    <jsp:invoke fragment="head_content"/>

    <title>${title}</title>
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
          <a class="navbar-brand" href="/tama-game/">Home</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <c:if test="${empty username}">
              <li class="active"><a href="/tama-game/inscription">Inscription / Se connecter <span class="sr-only">(current)</span></a></li>
            </c:if>
            <c:if test="${not empty username}">
              <li><a href="/tama-game/game">Jouer</a></li>
              <li><a href="/tama-game/boutique">Boutique</a></li>
            </c:if>
          </ul>
          <c:if test="${not empty username}">
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> ${username} <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="/tama-game/gestionTamagochis/">Gérer</a></li>
                  <li><a href="/tama-game/logout">Deconnexion</a></li>
                </ul>
              </li>
            </ul>
          </c:if>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <!-- page-container contient tout le contenu relatif a la page courante -->
    <div id="page-container">
          <jsp:invoke fragment="content"/>
    </div>
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
