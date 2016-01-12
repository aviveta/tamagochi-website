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
            <div class="col-md-9">
                <form id="inscription-formulaire" method="POST" action="/tama-game/gestionUtilisateur">
                    <div class="form-group">
                        <label for="InputName1">Nom</label>
                        <input type="text" class="form-control" id="InputName1" placeholder="Nom" required="" autofocus="" name ="nom">
                    </div>
                    <div class="form-group">
                        <label for="InputName2">Prénom</label>
                        <input type="text" class="form-control" id="InputName2" placeholder="Prénom" required="" autofocus="" name ="prenom">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">Adresse Email</label>
                        <input type="email" class="form-control" id="InputEmail" placeholder="Email" required="" autofocus="" name ="email">
                    </div>
                    <div class="form-group">
                        <label for="InputPassword">Mot de passe</label>
                        <input type="password" class="form-control" id="InputPassword" placeholder="Mot de passe" required="" name ="mdp">
                    </div>
                    <input type = "hidden" name = "a" value = "inscription"/>
                    <button type="submit" id="envoyer" class="btn btn-lg btn-primary">Envoyer !</button>
                </form>
                <div id="salut" >
                    <img id="lovelin" src="/tama-game/public/img/lovelin.png"/>
                    <img id="bulle" src="/tama-game/public/img/bulle.png"/>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
        <!-- end row -->

     </jsp:attribute>
    
</t:layout>
