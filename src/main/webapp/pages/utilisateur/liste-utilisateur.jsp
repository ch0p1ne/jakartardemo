<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2024
  Time: 03:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des utilisateurs</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="/pages/navbar.jsp"%>

<div class="container col-md-6 col-md-offset-3 pt-2">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2> Liste des utilisateurs</h2>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>ROLE</th>
                    <th>email</th>
                    <th>ACTIF</th>
                    <th>PRENOM</th>
                    <th>NOM</th>
                    <th>SEXE</th>
                    <th>DATE DE NAISSANCE</th>
                </tr>
                <c:forEach items="${model.users}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.role}</td>
                        <td>${p.email}</td>
                        <td>${p.actif}</td>
                        <td>${p.firstName}</td>
                        <td>${p.lastName}</td>
                        <td>${p.sexe}</td>
                        <td>${p.dateNaissance}</td>
                        <td> <button class="btn btn-info"> <a href="profil?userId=${p.id}" >edit profil</a> </button> </td>
                        <td> <button class="btn btn-warning text-danger"> <a href="delete?userId=${p.id}" >delete profil</a> </button> </td>
                    </tr>
                </c:forEach>
            </table>
            <button class="btn btn-info text-danger"> <a href="inscription" >Add profil</a> </button>
        </div>
    </div>
</div>
</body>
</html>
