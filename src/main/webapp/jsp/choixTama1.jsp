
<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>

<jsp:attribute name="head_content">
<script src="/tama-game/public/js/choix_tama.js"></script>
</jsp:attribute>
  <jsp:attribute name="content">

<div class="jumbotron">
  <h1>Choisissez un tamagochi !</h1>
</div>

<div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/ange.png" name="ange" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/blonde.png" name="blonde" />

      </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/kiraichi.png" name="kiraichi" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/lovelin.png" name="lovelin" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/nadeshiko.png" name="nadeshiko" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/neko.png" name="neko" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/panda.png" name="panda" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/tamago.png" name="tamago" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/umaru.png" name="umaru" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=ajoutTama" class="thumbnail">
      <img src="/tama-game/public/img/gestion/vintage.png" name="vintage" />
      
    </a>
  </div>

</div>


  </jsp:attribute>
</t:layout>

