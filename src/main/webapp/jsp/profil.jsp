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
	      <button class="btn btn-default modifier badge" type="submit">Modifier</button>
	    </li>
    	    <li class="list-group-item">Prénom : ${username}
	    <button class="btn btn-default modifier badge" type="submit">Modifier</button>
	    </li>
    	    <li class="list-group-item">Adresse Email : ${mail}
	      <button class="btn btn-default modifier badge" type="submit">Modifier</button>
	    </li>
    	    <li class="list-group-item">Mot de passe : A faire
	      <button class="btn btn-default modifier badge" type="submit">Modifier</button>
	    </li>
  	  </ul>

	</div>
</div>



        </jsp:attribute>

</t:layout>
