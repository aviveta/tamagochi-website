
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
        <a class="btn btn-alert" id="move" href="#">Avancer</a>
        <a class="btn btn-alert" id="transparent" href="#">Transparent</a>
     </jsp:attribute>

</t:layout>
