<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="content">
        <input id="room-name"></input>
        <a class="btn btn-alert" id="join" href="/tama-game/game">Rejoindre</a>
        <a class="btn btn-alert" id="new" href="/tama-game/game">Creer</a>
     </jsp:attribute>

     <jsp:attribute name="js_content">
         <script src="/tama-game/public/game/js/choix.js"></script>
     </jsp:attribute>
</t:layout>
