<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="content">
        kebab
        <script src="/tama-game/public/game/js/phaser.min.js"></script>
        <script src="/tama-game/public/game/js/main.js"></script>
     </jsp:attribute>
 
</t:layout>
