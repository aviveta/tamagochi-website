<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
  <jsp:attribute name="content">

<div class="jumbotron">
  <h1>Mes tamagochis</h1>
</div>

<div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <%--<img src="..." alt="...">--%>
      <div class="caption">
        <h3>Kiraichi</h3>
        <%--<p>...</p>--%>
        <p>
	<form method="post" action="/tama-game/gestionTamagochis">
	  <button class="btn btn-primary" type="submit">Gérer ce tamagochi</button>
	  <input type="hidden" name="a" value="gererTama" />
	  <%--<a href="#" class="btn btn-default" role="button">Choisir</a>--%>
	  <button class="btn btn-primary" type="submit">Choisir</button>
	  <input type="hidden" name="a" value="choisirTama" />
	</form>
	</p>
      </div>
    </div>
  </div>
</div>

  </jsp:attribute>
</t:layout>
