<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
    Collection<Joueur> joueurs = (Collection) request.getAttribute("joueurs");
    for (Joueur joueur : joueurs ) { %>
    <%= joueur.getNom() %>
<% } %>
    
<%= getServletContext().getInitParameter("webmaster") %>
