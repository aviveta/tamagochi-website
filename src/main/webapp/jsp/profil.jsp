<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>


    <t:layout>
        <jsp:attribute name="content">
            <div class="jumbotron">
                <h1>Profil de ${username}</h1>
            </div>

<div class="row" id="liste-infos">
        <div class="panel panel-primary">
  	  <div class="panel-heading">
    	    <h3 class="panel-title">Informations personnelles</h3>
  	  </div>

	  <!-- List group -->
	  <ul class="list-group">
	    <li class="list-group-item">Photo de profil
	      <img src="#" alt="" />
	      <button class="btn btn-default modifier badge" type="submit">Modifier</button>
    	    <li class="list-group-item">Nom : ${usersurname}
            <form id="modification-formulaire" method="POST" action="/tama-game/profil">
            <input type="text" class="form-control" id="InputName1" placeholder="Nouveau Nom" required="" autofocus="" name ="new_nom">
            <input type = "hidden" name = "a" value = "modif-nom1"/>
	      <button type="submit" id="modif-nom1" class="btn btn-default modifier badge" type="submit">Modifier</button>
        </form>
	    </li>
    	    <li class="list-group-item">Prénom : ${username}
            <form id="modification-formulaire" method="POST" action="/tama-game/profil">
            <input type="text" class="form-control" id="InputName2" placeholder="Nouveau Prénom" required="" autofocus="" name ="new_prenom">
            <input type = "hidden" name = "a" value = "modif-nom2"/>
          <button type="submit" id="modif-nom2" class="btn btn-default modifier badge" type="submit">Modifier</button>
        </form>
	    </li>
    	    <li class="list-group-item">Adresse Email : ${mail}
            <form id="modification-formulaire" method="POST" action="/tama-game/profil">
            <input type="email" class="form-control" id="InputMail" placeholder="Nouvel Email" required="" autofocus="" name ="new_mail">
            <input type = "hidden" name = "a" value = "modif-mail"/>
          <button type="submit" id="modif-mail" class="btn btn-default modifier badge" type="submit">Modifier</button>
        </form>
	    </li>
    	    <li class="list-group-item">Mot de passe : A faire
            <form id="modification-formulaire" method="POST" action="/tama-game/profil">
            <input type="password" class="form-control" id="InputMdp" placeholder="Nouveau mot de passe" required="" autofocus="" name ="new_nom">
            <input type = "hidden" name = "a" value = "modif-mdp"/>
          <button type="submit" id="modif-mdp" class="btn btn-default modifier badge" type="submit">Modifier</button>
        </form>
	    </li>
  	  </ul>

	</div>
</div>



        </jsp:attribute>

</t:layout>
