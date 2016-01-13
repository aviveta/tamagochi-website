<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>


    <t:layout>
        <jsp:attribute name="content">
        <ul>
        <c:forEach items="${joueurs}" var="i">
        <li><c:out value="${i}"/></li>
        </c:forEach>
<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach>
        </ul>
        </jsp:attribute>

</t:layout>

