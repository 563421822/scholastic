<%@ page import="java.util.ArrayList" %>
<%@ page import="demos.LoginUserVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    LoginUserVo role = (LoginUserVo) request.getSession().getAttribute("loginKey");
    if (role == null || !"teacher".equals(role.getRole())) {
        response.sendRedirect("index.jsp");
    }
%>
<head>
    <title>管理学生页面</title>
    <script type="text/javascript" src="js/manageJS.js"></script>
</head>
<body>
<table border="1">
    <tr>
        <td>姓名</td>
        <td>性别</td>
        <td>出生城市</td>
        <td>邮箱</td>
        <td>爱好</td>
        <td></td>
    </tr>
    <%
        if ((request.getAttribute("error")) != null) {
    %>
    <script>alert("<%=request.getAttribute("error")%>")</script>
    <%
        }
        ArrayList<LoginUserVo> stuList = (ArrayList<LoginUserVo>) request.getAttribute("key");
        for (LoginUserVo l : stuList) {
    %>
    <tr>
        <td><%=l.getName()%>
        </td>
        <td><%=l.getSex()%>
        </td>
        <td><%=l.getCity()%>
        </td>
        <td><%=l.getEmail()%>
        </td>
        <td><%=l.getHobby()%>
        </td>
        <td><input type="button" value="修改" onclick="modifyStu('<%=l.getName()%>')"/> <input type="button" value="删除"
                                                                                             onclick="delStu('<%=l.getName()%>')"/>
        </td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="6"><a href="register.jsp" target="_blank">添加学生信息</a></td>
    </tr>
</table>
</body>
</html>