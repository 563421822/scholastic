package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModifyPwdServlet")
public class ModifyPwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        LoginUserVo modify = (LoginUserVo) request.getSession().getAttribute("loginKey");
        String newPwd = request.getParameter("newPwd");
        CommonDAO dao = new CommonDAO();
        int result = dao.modifyPwd(modify.getName(), newPwd);
        if (result > 0) {
            response.getWriter().write("修改密码成功!");
            request.getSession().removeAttribute("key");
            Cookie c1 = new Cookie("name", null);
            Cookie c2 = new Cookie("password", null);
            c1.setMaxAge(0);
            c2.setMaxAge(0);
            response.addCookie(c1);
            response.addCookie(c2);
            System.out.println("获得session的上下文对象:" + request.getServletContext());
            response.setHeader("refresh", "3;login.jsp");
        } else {
            response.getWriter().write("修改密码失败!");
            response.setHeader("refresh", "3;modifyPwd.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}