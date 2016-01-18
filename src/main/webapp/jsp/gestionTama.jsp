<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
  <jsp:attribute name="content">

 <!-- page-container contient tout le contenu relatif a la page courante -->
    <div id="page-container">
      <div class="jumbotron">
        <h1>Gérer votre tamagotchi !</h1>
      </div>

      <div id="gauche" class="btn-group-vertical" role="group" aria-label="...">
        <div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Nettoyer</button>
	</div>

  	<div class="btn-group" role="group">
    	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Nourrir
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
      	    <li><a href="#">Nourriture1</a></li>
      	    <li><a href="#">Nourriture2</a></li>
    	  </ul>
        </div>

	<div class="btn-group" role="group">
    	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Appliquer un objet
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
      	    <li><a href="#">Objet1</a></li>
      	    <li><a href="#">Objet2</a></li>
    	  </ul>
        </div>
      </div>

      <div id="centre">
	<img id="tama-gere" src="/public/img/kiraitchi.png">
      </div>

      <div id="droite" class="btn-group" role="group" aria-label="...">
	<div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Promener</button>
	</div>

	<div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Distraire</button>
	</div>

	<div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Faire du sport</button>
	</div>
      </div>

    </div>
    <!--end page-container -->


  </jsp:attribute>
</t:layout>
