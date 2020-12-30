<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆界面</title>
</head>
<body>
<p style="color: #ff2256;font-weight: 900">${msg}</p>
<h2 align="center"><fornt color="red">用户登陆界面</fornt></h2>
<form action="login" method="post">
    <table align="center" border="1" >
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码；</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆" name="login"></td>
            <td><input type="reset" value="重置" name="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>