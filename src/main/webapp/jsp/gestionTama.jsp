<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>

<jsp:attribute name="head_content">
<script src="/tama-game/public/js/gestion_tama.js"></script>
</jsp:attribute>

  <jsp:attribute name="content">

 <!-- page-container contient tout le contenu relatif a la page courante -->
    <div id="page-container">
      <div class="jumbotron">
        <h1>Gérez votre tamagochi !</h1>
      </div>

      <div id="gauche" class="btn-group-vertical" role="group" aria-label="...">
        <form method="post" action="/tama-game/gestionTamagochis">
  	  <button type="button" class="btn btn-lg btn-default bouton-gerer">Nettoyer</button>
	  <input type="hidden" name="a" value="nettoyer" />
	</form>

	<form method="post" action="/tama-game/gestionTamagochis">
  	  <button type="button" class="btn btn-lg btn-default bouton-gerer">Nourrir</button>
	  <input type="hidden" name="a" value="nourrir" />
	</form>

	<form method="post" action="/tama-game/gestionTamagochis">
  	  <button type="button" class="btn btn-lg btn-default bouton-gerer">Distraire</button>
	  <input type="hidden" name="a" value="distraire" />
	</form>

	<form method="post" action="/tama-game/gestionTamagochis">
  	  <button type="button" class="btn btn-lg btn-default bouton-gerer">Faire du sport</button>
	  <input type="hidden" name="a" value="sport" />
	</form>

      </div>

      <div id="centre">
	<img id="tama-gere" src="/tama-game/public/img/gestion/<c:out value="${tamaCourant.nom}"/>.png" name="<c:out value="${tamaCourant.id}"/>" />
      </div>

      <div id="droite" class="btn-group" role="group" aria-label="...">

	<div class="panel panel-default">
  	  <div class="panel-heading">
    	    <h3 class="panel-title">Caractéristiques de <c:out value="${tamaCourant.nom}"/></h3>
  	  </div>
  	  <div class="panel-body">
    	  	<ul class="list-group">
  	  	  Poids : <li id="poids" class="list-group-item"><c:out value="${tamaCourant.poids}"/></li>
  	  	  Propreté : <li id="proprete" class="list-group-item"><c:out value="${tamaCourant.proprete}"/></li>
  	  	  Joie : <li id="joie" class="list-group-item"><c:out value="${tamaCourant.joie}"/></li>
		</ul>

  	  </div>
	</div>

      </div>

    </div>
    <!--end page-container -->


  </jsp:attribute>
</t:layout>
