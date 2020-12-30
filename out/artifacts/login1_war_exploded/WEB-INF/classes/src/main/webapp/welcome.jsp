<%--
  Created by IntelliJ IDEA.
  User: bianlifeng
  Date: 2019-07-04
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<h1>欢迎光临！</h1>

<c:choose>
    <c:when test = "${empty sessionScope.sessionUser}">
        滚！
    </c:when>
    <c:otherwise>
        ${sessionScope.sessionUser}
    </c:otherwise>
</c:choose>

</body>
</html>
