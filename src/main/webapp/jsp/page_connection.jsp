<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

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

     </jsp:attribute>
 
</t:layout>
