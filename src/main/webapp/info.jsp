<%--
  Created by IntelliJ IDEA.
  User: hpgam
  Date: 9/15/2023
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>
        ${loginSuccessful.full_name}
    </h2>
    <div class="wrapper">
        <div class="profile">
            <h1>Profile</h1>
            <div class="profile-row">
                <p>Account ID: ${loginSuccessful.account_id}</p>
            </div>
            <div class="profile-row">
                <p>Full Name: ${loginSuccessful.full_name}</p>
            </div>
            <div class="profile-row">
                <p>Password: ${loginSuccessful.password}</p>
            </div>
            <div class="profile-row">
                <p>Email: ${loginSuccessful.email}</p>
            </div>
            <div class="profile-row">
                <p>Phone: ${loginSuccessful.phone}</p>
            </div>
            <div class="profile-row">
                <p>Status: ${loginSuccessful.status}</p>
            </div>
<%--            <div class="profile-row">--%>
<%--                <p>Roles: </p>--%>
<%--                <ul>--%>
<%--                    <c:forEach items="${loginSuccessful.roles}" var="role">--%>
<%--                        <li>${role.roleName}</li>--%>
<%--                    </c:forEach>--%>
<%--                </ul>--%>
<%--            </div>--%>
        </div>
    </div>
</body>
</html>
</body>
</html>
