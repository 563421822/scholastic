<%@ page import="java.time.LocalDateTime" %>
<%@ page import="demos.LoginUserVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/commonCSS.css">
    <script type="text/javascript" src="js/registerScript.js"></script>
</head>
<body>
<%
    LoginUserVo u = (LoginUserVo) session.getAttribute("loginKey");
    if (u == null || !"teacher".equals(u.getRole())) {
%>
<form method="get" action="RegisterServlet" onsubmit="return checkAll()">
    <table border="0">
        <thead>
        <th colspan="3">新用户注册表单</th>
        </thead>
            <%
    }else {
%>
        <form method="get" action="RegisterServlet" onsubmit="return checkAll()">
            <table border="0">
                <thead>
                <th colspan="3">添加学生页面</th>
                </thead>
                <%
                    }
                %>
                <tbody>
                <tr>
                    <td>用户名：</td>
                    <td><input onblur="checkName()" type="text" placeholder="请输入用户名" id="name" minlength="2"
                               maxlength="5"
                               name="name"></td>
                    <td id="warnName"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input onblur="checkPwd()" type="password" placeholder="请输入密码" id="password" maxlength="6"
                               name="password"></td>
                    <td id="warnPwd"></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input onblur="checkRePwd()" type="password" placeholder="请输入密码" id="rePassword"></td>
                    <td id="warnRePwd"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>🚹
                        <input type="radio" checked="checked" value="male" name="gender"/>
                        &nbsp;&nbsp;🚺
                        <input type="radio" value="female" name="gender"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>出生城市：</td>
                    <td><select name="city">
                        <optgroup label="---请选择---">
                            <option value="Beijing">北京</option>
                            <option value="Shanghai">上海</option>
                            <option value="Guangzhou">广州</option>
                            <option value="Shenzhen">深圳</option>
                        </optgroup>
                    </select></td>
                    <td></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td><input onblur="checkEmail()" type="text" placeholder="请输入邮箱" id="email" name="email"/></td>
                    <td id="warnEmail"></td>
                </tr>
                <tr>
                    <td>爱好：</td>
                    <td><input type="checkbox" value=" dine" name="hobby"/>
                        吃饭
                        <input type="checkbox" value="sleep" name="hobby"/>
                        睡觉
                        <input type="checkbox" value="playPhone" name="hobby"/>
                        玩手机
                        <input type="checkbox" value="typeCodes" name="hobby"/>
                        敲代码
                        <input type="checkbox" value="playGames" name="hobby"/>
                        玩游戏
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>注册身份：</td>
                    <td><input type="radio" checked="checked" name="role"/>学生&nbsp;<input type="radio" name="role"
                                                                                          disabled="disabled"/>老师
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>请阅读以下协议：</td>
                    <td><textarea rows="10" cols="">
							协议，网络协议的简称，网络协议是通信计算机双方必须共同遵从的一组约定。如怎么样建立连接、怎么样互相识别等。只有遵守这个约定，计算机之间才能相互通信交流。它的三要素是：语法、语义、时序。
							为了使数据在网络上从源到达目的，网络通信的参与方必须遵循相同的规则，这套规则称为协议（protocol），它最终体现为在网络上传输的数据包的格式。
							协议往往分成几个层次进行定义，分层定义是为了使某一层协议的改变不影响其他层次的协议。
						</textarea>
                        <input type="checkbox" id="agree" onclick="checkAgree()"/>
                        同意
                    </td>
                    <td id="warnAgree"></td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交" disabled="disabled" id="commit"/>
                        <input type="reset" value="重置"/></td>
                    <td></td>
                </tr>
                </tfoot>
            </table>
        </form>
</body>
</html>