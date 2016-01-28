<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:attribute name="content">
        <input id="room-name"></input>
        <input id="email-name" type="hidden" name="usermail" value="<c:out value="${mail}"/>"></input>
        <a class="btn btn-alert" id="join" href="/tama-game/game">Rejoindre</a>
        <a class="btn btn-alert" id="new" href="/tama-game/game">Creer</a>
     </jsp:attribute>

     <jsp:attribute name="js_content">
         <!-- <script src="/tama-game/public/game/js/choix.js"> -->
          <script>

          jQuery(document).ready(function($){
              
              $("#join").on('click',function(e){
                  e.preventDefault();
                  location.href = $(this).attr('href') + '?a=rejoindre&room='  + $('#room-name').val() + "&user_email="+$('#email-name').val() ;
              });
              
              $("#new").on('click',function(e){
                  e.preventDefault();
                  location.href = $(this).attr('href') + '?a=creationRoom&room='  + $('#room-name').val() ;
              });
          })

          
         </script>
     </jsp:attribute>
</t:layout>
