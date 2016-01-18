<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="content">

<div class="alert alert-warning" role="alert">
  <b>WARNING!</b> Erreur de saisie de l'email ou du mot de passe.
</div>

<form method="post" action="/tama-game/gestionUtilisateur">
  <button class="btn btn-warning" type="submit">Retour</button>
  <input type="hidden" name="a" value="warning" />
</form>

     </jsp:attribute>
 
</t:layout>

