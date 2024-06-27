<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2024
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste immeubles</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="/pages/navbar.jsp"%>

<div class="container col-md-6 col-md-offset-3 pt-2">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2> Liste des immeubles</h2>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Adresse</th>
                    <th>Description</th>
                    <th>nombre d'uniter location disponible</th>
                    <th>Nom du proprietaire</th>
                    <th>NOM</th>
                </tr>
                <c:forEach items="${model.users}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.role}</td>
                        <td>${p.email}</td>
                        <td>${p.actif}</td>
                        <td>${p.firstName}</td>
                        <td>${p.lastName}</td>
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
