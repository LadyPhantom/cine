<%--
  Created by IntelliJ IDEA.
  User: CDI
  Date: 14/11/2018
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/">Index</a><br><br>

<ul>
    <li>Titre: ${film.titre} </li>

    <li>
        <a href="/affiche?id=${film.id}">
            <img src=\"/affiche?id=${film.id}" height="50%" >
        </a>
    </li>

    <li>Note: ${film.note}</li>

</ul>
<br>
<br>
<a href="/historique">
    Allez à l'historique
</a>

</body>
</html>
