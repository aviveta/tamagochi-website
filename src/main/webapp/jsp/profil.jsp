<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>


    <t:layout>
        <jsp:attribute name="content">
            <div class="jumbotron">
                <h1>Profil de ${username}</h1>
            </div>


  <div class="row" id="param-profil">
  <ul class="liste">
    <li class="list-group-item">
      Prénom
      <span class="badge" ><font size="4">${username}</font> </span>
      <button class="btn btn-success" type="submit"><font size="4"><span  aria-hidden="true"></span></font>Modifier</button>
     </li>
    <li class="list-group-item">
  <span class="badge" ><font size="4">${mail}</font> </span>
      Email
      <button class="btn btn-success" type="submit"><font size="4"><span  aria-hidden="true"> </span> </font> Modifier</button>
    </li>

  </ul> 
</div>
        </jsp:attribute>

</t:layout>
