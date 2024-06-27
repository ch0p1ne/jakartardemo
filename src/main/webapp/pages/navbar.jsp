<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2024
  Time: 05:29
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<div class="navbar navbar-default">
<ul class="nav navbar-nav">
    <li><a href="accueil">Accueil</a></li>

    <c:if test="${!empty user && user.role == \"admin\"}">
        <li><a href="liste-utilisateur">Gestion Utilisateur</a> </li>
    </c:if>
    <c:if test="${!empty user && user.role == \"proprietaire\"}">
        <li><a href="liste-immeuble">immeuble</a> </li>
    </c:if>
    <li><a href="liste-location-unit">Uniter de location</a> </li>
    <c:if test="${!empty locataire && user.role == \"locataire\"}">
        <li><a href="liste-location-contrat">Contrat de location</a> </li>
    </c:if>
    <c:if test="${empty user}">
        <li><a href="connexion">Connexion</a></li>
        <li><a href="inscription">Inscription</a></li>
    </c:if>

    <c:if test="${!empty user}">
        <li class=" nav navbar-nav">
            <form action="deconnexion" method="POST">
                <input type="submit" name="deconnexion" value="Deconnexion">
            </form>
        </li>
    </c:if>

    <c:if test="${!empty user}">
        <li><a href="profil">Profil | ${user.firstName} ${user.lastName} | ${user.role}</a> </li>
    </c:if>
</ul>
</div>