<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
  <jsp:attribute name="content">

<div class="jumbotron">
  <h1>Choisissez votre premier tamagochi !</h1>
</div>

<div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/ange.png" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/blonde.png" name="nomTama" value="blonde" />

      </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/kiraichi.png" name="nomTama" value="kiraichi" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/lovelin.png" name="nomTama" value="lovelin" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/nadeshiko.png" name="nomTama" value="nadeshiko" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis" class="thumbnail">
      <img src="/tama-game/public/img/gestion/neko.png" name="nomTama" value="neko" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/panda.png" name="nomTama" value="panda" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis" class="thumbnail">
      <img src="/tama-game/public/img/gestion/tamago.png" name="nomTama" value="tamago" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/umaru.png" name="nomTama" value="umaru" />
      
    </a>
  </div>

  <div class="col-xs-6 col-md-3">
    <a href="/tama-game/gestionTamagochis?a=choisirTamaInit" class="thumbnail">
      <img src="/tama-game/public/img/gestion/vintage.png" name="nomTama" value="vintage" />
      
    </a>
  </div>

</div>


  </jsp:attribute>
</t:layout>

