
<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="content">
<div class="jumbotron">
  <h1>Boutique</h1>
  </div>
  <center><img  id="boutique1" src="img/money.jpg" /></center>
<!-- row -->
<div class="row" id="liste-objets">
  <ul class="list-group">
    <li class="list-group-item">
      Objet   
      <span class="badge" ><font size="4">prix</font> </span>
      <button class="btn btn-success" type="submit"><font size="4"><span class="glyphicon glyphicon-euro" aria-hidden="true"></span></font>Acheter</button>
     </li>
    <li class="list-group-item">
  <span class="badge" ><font size="4">prix</font> </span>
      Autre objet
      <button class="btn btn-success" type="submit"><font size="4"><span class="glyphicon glyphicon-euro" aria-hidden="true"> </span> </font> Acheter</button>
    </li>

  </ul> 
</div>
</jsp:attribute>

</t:layout>
