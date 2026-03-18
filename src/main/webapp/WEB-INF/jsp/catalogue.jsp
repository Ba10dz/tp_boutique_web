<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><link rel="stylesheet" href="css/style.css"></head>
<body>
<h1>Catalogue <small>(Bienvenue ${user})</small></h1>
<nav><a href="panier">Voir le Panier</a> | <a href="logout">Déconnexion</a></nav>
<table border="1">
    <tr><th>Ref</th><th>Nom</th><th>Catégorie</th><th>Prix</th><th>Action</th></tr>
    <c:forEach var="a" items="${articles}">
        <tr>
            <td>${a.ref}</td><td>${a.nom}</td><td>${a.categorie}</td><td>${a.prix} €</td>
            <td><form action="panier" method="post"><input type="hidden" name="ref" value="${a.ref}"><button>Ajouter</button></form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>