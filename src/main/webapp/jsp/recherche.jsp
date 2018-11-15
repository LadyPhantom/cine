<%--
  Created by IntelliJ IDEA.
  User: CDI
  Date: 14/11/2018
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Recherche</title>
</head>
<body>
<a href="/">
    Index
</a>
<br>
<br>
<%----------------------------------------%>
<ul>
    <p>Films correspondant à votre recherche:</p>
    <c:if test="${!aucunResultatObtenu}">
        <c:forEach items="${films}" var="film">
            <li>
                <a href="/detail?id=${film.id}">
                        ${film.titre}
                </a>
            </li>
        </c:forEach>
    </c:if>

    <li>Aucun film correspondant trouvé.</li>
</ul>
<%----------------------------------------%>
<br>
<br>
<a href="/historique">
    Allez à l'historique
</a>
</body>
</html>
