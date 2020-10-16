<%@ page import="demos.LoginUserVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<%
    LoginUserVo u = (LoginUserVo) session.getAttribute("loginKey");
    if (u == null) {
        out.write("你还没有登录,3秒后跳转到登录页");
        response.setHeader("refresh", "3;url=login.jsp");
    } else if ("student".equals(u.getRole())) {
        Object mess = request.getAttribute("succe");
        if (mess != null) {
%>
<h3><%=request.getAttribute("succe")%>
</h3>
<%
    }
%>
<h1>学生后台首页</h1>
<h1><a href="modifyPwd.jsp" target="_blank">修改密码</a></h1>
<h1><a href="GetInfoByName?name=<%=((LoginUserVo) request.getSession().getAttribute("loginKey")).getName()%>"
       target="_blank">修改用户信息</a></h1>
<h2><a href="ExitServlet">注销</a></h2>
<%
} else if ("teacher".equals(u.getRole())) {
    Object mess = request.getAttribute("succe");
    if (mess != null) {
%>
<h3><%=request.getAttribute("succe")%>
</h3>
<%
    }
%>
<h1>老师后台首页</h1>
<h1><a href="modifyPwd.jsp" target="_blank">修改密码</a></h1>
<h1><a href="ManageStu" target="_blank">管理学生</a></h1>
<h2><a href="ExitServlet">注销</a></h2>
<%
    }
%>
</body>
</html>