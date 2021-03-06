<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>

  <jsp:attribute name="content">

<div class="jumbotron">
  <h1>Mes tamagochis</h1>
</div>

<div>
  <form method="post" action="/tama-game/gestionTamagochis">
	  <button class="btn btn-primary" type="submit">Ajouter un nouveau tamagochi</button>
	  <input type="hidden" name="a" value="newTama" />
  </form>
</div>
<br />

<div class="row">

  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
	<div class="panel-heading">
    <h3 class="panel-title">Tamagochi courant</h3>
</div>

      <img class="img-gestion" src="/tama-game/public/img/gestion/<c:out value="${tamaCourant.nom}"/>.png" />
      <div class="caption">
        <h3><c:out value="${tamaCourant.nom}"/></h3>

        <p>
	<form method="post" action="/tama-game/gestionTamagochis?id=<c:out value="${tamaCourant.id}"/>">
	  <button class="btn btn-primary btn-gestion" type="submit">Gérez ce tamagochi</button>
	  <input type="hidden" name="a" value="gererTama" />
	</form>
	</p>

      </div>

    </div>
  </div>

</div>


<div class="row">


<c:forEach items="${tamagochis}" var="i">

  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img class="img-gestion" src="/tama-game/public/img/gestion/<c:out value="${i.nom}"/>.png" />
      <div class="caption">
        <h3><c:out value="${i.nom}"/></h3>

        <p>

	<a href="/tama-game/gestionTamagochis?a=gererTama&id=<c:out value="${i.id}"/>">
	<button class="btn btn-primary btn-gestion" type="submit">Gérer ce tamagochi</button>
	</a>
	<a href="/tama-game/gestionTamagochis?a=choisirTamaCourant&id=<c:out value="${i.id}"/>">
	<button class="btn btn-primary btn-gestion" type="submit">Choisir</button>
	</a>
	</p>

      </div>

    </div>
  </div>

</c:forEach>

</div>

  </jsp:attribute>
</t:layout>
