<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Le cinema de Tomcat</h2>

<a href="liste">liste</a>
<br>
<a href="liste?sort=note">liste notes croissantes</a>
<br>
<br>
<%--<a href="liste?sort=notedesc">liste notes décroissantes</a>--%>
<%--<br>--%>
<%--<a href="detail?id=2">détail n°2</a>--%>
<%--<br>--%>
<%--<a href="affiche?id=5">affiche n°5</a>--%>

<form method="get" action="recherche">

    <div>
        <label for="nom_film">Entrer le nom, ou une partie du nom, du film que vous rechercher:</label>
        <input type="text" name="nom_film" id="nom_film">
    </div>

    <input type="submit"/>
</form>

</body>
</html>
