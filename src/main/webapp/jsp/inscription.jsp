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
            <div class="col-md-2">
            </div>
            <div class="col-md-3" id="bouton_inscription">
                <h2 class="form-signin-heading">Pour s'inscrire</h2><br />
		<form action="/tama-game/gestionInscription">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Cliquez ici</button>
		<input type="hidden" name="a" value="inscrire" />
		</form>
            </div>
            <img class="col-md-2" id="kiraitchi" src="img/vintage.png" />
            <div class="col-md-3" id="bouton_connection">
                <h2 class="form-signin-heading">Pour se connecter</h2><br />
		<form action="/tama-game/gestionInscription">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Cliquez ici</button>
		<input type="hidden" name="a" value="connecter" />
		</form>
            </div>
            <div class="col-md-2">
            </div>

            <!-- end row -->

     </jsp:attribute>
 
</t:layout>

