<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <script type="text/javascript" src="js/loginJs.js"></script>
    <link rel="stylesheet" href="css/commonCSS.css"/>
</head>
<body>
<%
    String name = "";
    String password = "";
    Cookie[] cs = request.getCookies();//请求中得到客户端中所有的Cookie
    if (cs != null) {
        for (Cookie c : cs) {
            if (c.getName().equals("name")) {
                name = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
            } else if (c.getName().equals("password")) {
                password = c.getValue();
            }
        }
    }
    Object error = request.getAttribute("error");
    if (error != null) {
%>
<script>alert("<%=request.getAttribute("error")%>");</script>
<%
    }
%>
<form method="get" action="LoginServlet">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="name" value="<%=name%>"/></td>
            <td></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" value="<%=password%>"/></td>
            <td></td>
        </tr>
        <tr>
        <tr>
            <td>登录身份:</td>
            <td><input type="radio" name="role" value="student" checked="checked"/>学生<input type="radio" name="role"
                                                                                            value="teacher"/>老师
            </td>
            <td></td>
        </tr>
        <td>验证码:</td>
        <td><input type="text" id="code" onblur="isCode()" name="code"/></td>
        <td><img src="CheckCodeServlet" id="ckCode"/><a href="javascript:void(0)" onclick="cannotSee()">看不清</a></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="rememberMe"/>记住我</td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="登录"><input type="reset" value="重置"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>