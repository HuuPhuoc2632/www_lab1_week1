<%--
  Created by IntelliJ IDEA.
  User: hpgam
  Date: 9/15/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h2>
       ${listUser}
   </h2>
   <ul>
       <c:forEach var="user" items="${listUser}">
           <li>${user.full_name}</li>
       </c:forEach>
   </ul>
</body>
</html>