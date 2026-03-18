<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><link rel="stylesheet" href="css/style.css"></head>
<body>
<h1>Votre Panier</h1>
<nav><a href="catalogue">Retour Catalogue</a></nav>
<c:choose>
    <c:when test="${empty panier}">Votre panier est vide.</c:when>
    <c:otherwise>
        <table border="1">
            <tr><th>Article</th><th>Quantité</th><th>Sous-total</th><th>Action</th></tr>
            <c:set var="total" value="0"/>
            <c:forEach var="entry" items="${panier}">
                <tr>
                    <td>${entry.value.article.nom}</td><td>${entry.value.quantite}</td>
                    <td>${entry.value.sousTotal} €</td>
                    <td><form action="panier" method="post"><input type="hidden" name="action" value="supprimer"><input type="hidden" name="ref" value="${entry.key}"><button>Supprimer</button></form></td>
                </tr>
                <c:set var="total" value="${total + entry.value.sousTotal}"/>
            </c:forEach>
            <tr><td colspan="2"><strong>TOTAL</strong></td><td colspan="2"><strong>${total} €</strong></td></tr>
        </table>
        <form action="panier" method="post"><input type="hidden" name="action" value="vider"><button>Vider le panier</button></form>
    </c:otherwise>
</c:choose>
</body>
</html>