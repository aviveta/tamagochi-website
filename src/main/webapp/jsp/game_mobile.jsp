
<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="js_content">
        <script src="/tama-game/public/game/js/input.js"></script>
    </jsp:attribute>

    
    <jsp:attribute name="content">
    <div id="tr-group">
        <a class="" id="button-transparent" href="#">Transparent</a>
    </div>
    <div id="buttons-group">
        <a class="" id="button-a" href="#">A</a>
        <a class="" id="button-b" href="#">B</a>
    </div>
    </jsp:attribute>

</t:layout>
