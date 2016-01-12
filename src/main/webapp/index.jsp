<%@page import="java.util.Collection"%>
<%@page import="model.Joueur"%>
<%@page import="model.FacadeJoueurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="content">
        <div class="jumbotron">
            <h1>Bienvenue !</h1>
        </div>


        <script>
         window.onload = function(){

             var i =0;
             var imgs = ['dofus1.png','Himouto.jpg','kiraitchi1.png','Tamagotchi_blue1.png'];

             var genImg = function(){
                 if (i > 2) {
                     i =0;
                 } else {
                     i++
                 }
                 $("#imgs").html("<img class=\"imgdemo\" src=public\/+"img/"+imgs[i]+"\" />").css("opacity",0).animate({opacity:1},800);
             };
             var timer = setInterval(function(){ genImg(); }, 2000);
             genImg();
             
         };
        </script>

        <div id="imgs"></div>

        <div class="col-md-2">
        </div>
        </div>
        <!-- end row -->

        <hr/>
        <!-- row -->
        <div class="row" id="home-presentation">
            <div class="col-lg-4"> <img src="public/img/dofus.png" class="img-circle">
                <h2>Un oeuf aléatoire</h2>
                <p>Commencez par choisir un oeuf que vous devrez élever</p>
            </div>
            <div class="col-lg-4"> <img src="public/img/himouto.jpg" class="img-circle">

                <h2>Évolution</h2>
                <p>Ils évolueront en fonction de la façon dont vous les élever.
                    <br/> Attention à ne pas les laisser sans surveillance trop longtemps !</p>
            </div>
            <div class="col-lg-4"> <img src="public/img/tamagotchi.jpg" class="img-circle">

                <h2>Jouez avec vos amis</h2>
                <p>Jouez avec vos téléphones sur un seul écran, comme si vous aviez une Wii !</p>
            </div>
        </div>
        <!-- end row -->

     </jsp:attribute>
    
</t:layout>
