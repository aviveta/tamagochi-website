<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
  <jsp:attribute name="content">

 <!-- page-container contient tout le contenu relatif a la page courante -->
    <div id="page-container">
      <div class="jumbotron">
        <h1>Gérer votre tamagochi !</h1>
      </div>

      <div id="gauche" class="btn-group-vertical" role="group" aria-label="...">
        <div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Nettoyer</button>
	  <input type="hidden" name="a" value="nettoyer" />
	</div>

	<div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Nourrir</button>
	  <input type="hidden" name="a" value="nourrir" />
	</div>

      </div>

      <div id="centre">
	<img id="tama-gere" src="/tama-game/public/img/gestion/<c:out value="${tamaCourant.nom}"/>.png" name="<c:out value="${tamaCourant.id}"/>" />
      </div>

      <div id="droite" class="btn-group" role="group" aria-label="...">
	<div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Distraire</button>
	  <input type="hidden" name="a" value="distraire" />
	</div>

	<div>
  	  <button type="button" class="bouton-gerer" class="btn btn-lg btn-default">Faire du sport</button>
	  <input type="hidden" name="a" value="sport" />
	</div>
      </div>

    </div>
    <!--end page-container -->


  </jsp:attribute>
</t:layout>
