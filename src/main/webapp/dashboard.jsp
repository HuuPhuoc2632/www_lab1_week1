<%--
  Created by IntelliJ IDEA.
  User: hpgam
  Date: 9/15/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <ul>
       <c:forEach var="account" items="${listUser}">
           <li>Name: ${account.full_name}</li>
           <ul>
               <li>Role Name:</li>
               <c:forEach var="gc" items="${listGA}">

                   <c:if test="${gc.account_id == account.account_id}">
                       ${gc.role_id.role_name}
                       <br/>
                   </c:if>
               </c:forEach>
           </ul>
           <br/>
       </c:forEach>
   </ul>

</body>
</html>
