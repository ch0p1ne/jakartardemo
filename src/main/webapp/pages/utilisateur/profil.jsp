<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2024
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Profil</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="/pages/navbar.jsp"%>
<div class="page-content page-container" id="page-content">
    <div class="padding">
        <div class="row container d-flex justify-content-center">
            <div class="col-xl-6 col-md-12">
                <div class="card user-card-full">
                    <div class="row m-l-0 m-r-0">
                        <div class="col-sm-4 bg-c-lite-green user-profile">
                            <div class="card-block text-center text-white">
                                <div class="m-b-25">
                                    <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image">
                                </div>
                                <form action="update" method="post">
                                    <label for="firstname"> Prenom</label>
                                <input type="text" id="firstname" name="first_name" class="f-w-600" value="${user.firstName}">
                                    <br>
                                    <label for="lastname"> Nom</label>
                                <input type="text"  id="lastname" name="last_name" class="f-w-600" value="${user.lastName}">
                                    <c:if test="${!empty locataire}">
                                        <p>${locataire.emploie}</p>
                                    </c:if>

                                <i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="card-block">
                                <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Information</h6>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Email</p>
                                        <input type="email" name="email" class="text-muted f-w-400" value="
<%--                                           cas user--%>
                                            <c:if test="${!empty user}">${user.email}</c:if>
<%--                                           cas locataire--%>
                                            <c:if test="${!empty locataire}">${locataire.email}</c:if>
                                        ">
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Compte actif </p>
                                        <div class=" f-w-400 btn btn-success">
                                            <c:if test="${!empty user}">${user.actif}</c:if>
                                            <c:if test="${!empty locataire}">${locataire.actif}</c:if>
                                        </div>
                                    </div>
                                </div>
                                <label for="date">Date naissance</label>
                                <input type="date" name="dateNaissance" id="date" class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600" value="${user.dateNaissance}">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Sexe</p>
                                        <input type="text" name="sexe" class="text-muted f-w-400" value="${user.sexe}">
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Role</p>
                                        <select name="role" <c:if test="${user.role != 'admin'}"> disabled</c:if>  >
                                            <option value="proprietaire" <c:if test="${user.role == 'proprietaire'}">selected </c:if>>Proprietaire</option>
                                            <option value="locataire">Locataire</option>
                                            <option value="admin" <c:if test="${user.role == 'admin'}">selected </c:if> >Admin</option>
                                        </select>
                                    </div>

                                </div>
                                <br>
                                <div class="col-sm-6">
                                    <p class="m-b-10 f-w-600"> </p>
                                    <label for="password"> Mot de passe</label>
                                    <input type="text"  id="password" name="password" class="f-w-600" value="${user.password}">
                                </div>
                                <br>
                                <input type="submit" class="mt-md-3 btn btn-info" value="mettre a jour">
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
