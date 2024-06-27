<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2024
  Time: 05:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="/pages/navbar.jsp"%>

<div class="container col-md-4 col-md-offset-4 mt-4">
    <div class="panel panel-primary">
        <div class="panel-heading"> Application de Logement creer par Thomas Souah Jr.</div>
        <div class="panel-body">
            <c:if test="${auth == true}">
            </c:if>
            <p>
                Vous etes sur la page d'inscription
            </p>
        </div>

        <form action="ajout-utilisateur" method="post" class="form-group">
            <div class="form-group">
                <label for="first_name" class="col-sm-2 col-form-label col-form-label-lg text-info">Prenom</label>
                <input type="text" id="first_name" name="first_name" class="form-control" >
            </div>
            <div class="form-group">
                <label for="last_name" class="col-sm-2 col-form-label col-form-label-lg text-info">Nom</label>
                <input type="text" id="last_name" name="last_name" class="form-control" >
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 col-form-label col-form-label-lg text-info">email</label>
                <input type="email" id="email" name="email" class="form-control" >
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 col-form-label col-form-label-lg text-info">mot de passe</label>
                <input type="password" id="password" name="password" class="form-control" >
            </div>
            <div class="form-group">
                <label for="dateNaissance" class="col-sm-2 col-form-label col-form-label-lg text-info">Date Naissance</label>
                <input type="date" id="dateNaissance" name="dateNaissance" class="form-control" >
            </div>
                <fieldset>
                    <legend> Sexe</legend>
                    <div class="pt-3-5">
                        <input type="radio" id="sexe1" name="sexe" value="M">
                        <label for="sexe1" >Masculin</label>
                    </div>
                    <div>
                        <input type="radio" id="sexe2" name="sexe" value="F">
                        <label for="sexe2" >Feminin</label>
                    </div>

                </fieldset>

            <br>
            <div class="form-group">
                <label for="role" class="col-sm-2 col-form-label col-form-label-lg text-info">Role</label>
                <select name="role" id="role" class="form-control">
                    <option value="admin">Admin</option>
                    <option value="proprietaire">proprietaire</option>
                </select>
            </div>

            <div class="text-right">
                <input type="submit" value="creation" class="btn btn-primary">
            </div>

        </form>
    </div>
</div>
</body>
</html>
