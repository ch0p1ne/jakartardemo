<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2024
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="tab-content">
    <div class="container col-md-5 col-md-offset-3 mt-md-3">

        <form action="authentification" method="post">
            <!-- Email input -->
            <div data-mdb-input-init class="form-outline mb-4">
                <input type="email" id="form2Example1" name="email" class="form-control" />
                <label class="form-label" for="form2Example1">Email address</label>
            </div>

            <!-- Password input -->
            <div data-mdb-input-init class="form-outline mb-4">
                <input type="password" id="form2Example2" name="password" class="form-control" />
                <label class="form-label" for="form2Example2">Password</label>
            </div>

            <!-- 2 column grid layout for inline styling -->
            <div class="row mb-4">
                <div class="col d-flex justify-content-center">
                    <c:if test="${!empty sessionScope.error}">
                        <span>${error}</span>
                        ${error = ""}
                    </c:if>
                </div>
            </div>

            <!-- Submit button -->
            <input  type="submit" class="btn btn-primary btn-block mb-4">

            <!-- Register buttons -->
            <div class="text-center">
                <p>Not a member? <a href="inscription">inscription</a></p>
            </div>
        </form>
    </div>
</div>

</body>
</html>
