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
    <p>
        email: ${loginSuccessful.email}<br>
        phone: ${loginSuccessful.phone}
    </p>
</body>
</html>
