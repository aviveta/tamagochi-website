<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:attribute name="content">
      <div class="jumbotron">
        <h1>Bienvenue !</h1>
      </div>

      <!-- row -->
      <div class="row" id="inscription-container">
        <div class="col-md-3">
        </div>
        <div class="col-md-7">
          <form class="form-signin" id="formulaire-login" method="POST" action="/tama-game/gestionUtilisateur">
            <h2 class="form-signin-heading">Se connecter</h2>
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email" required="" autofocus="" name="email" value="<c:out value="${souvenirEmail}"/>" />
            <label for="inputPassword" class="sr-only">Mot de passe</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Mot de passe" required="" name="mdp" value="<c:out value="${souvenirMdp}"/>" />
            <div class="checkbox">
              <label for="memoire">
                <input type="checkbox" name="memoire" value="remember-me" />Se souvenir de moi
              </label>
            </div>
	    <input type="hidden" name="a" value="connection"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer !</button>
          </form>
          <img id="kiraitchi" src="/tama-game/public/img/kiraitchi.png"/>
        </div>

        <div class="col-md-2">
        </div>
      </div>
      <!-- end row -->

     </jsp:attribute>
 
</t:layout>
