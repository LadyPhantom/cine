<%--
  Created by IntelliJ IDEA.
  User: CDI
  Date: 14/11/2018
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Historique</title>
</head>
<body>
<a href="/">Index</a><br><br>
<%----------------------------------------%>
<ul>
    <c:if test="${!vuEmpty}">
        <c:forEach items="${films}" var="film">
            <li>
                <a href="/detail?id=${film.id}">
                        ${film.titre}
                </a>
            </li>
        </c:forEach>
    </c:if>
</ul>
<%----------------------------------------%>
</body>
</html>
