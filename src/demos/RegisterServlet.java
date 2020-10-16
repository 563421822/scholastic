package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object session = request.getSession().getAttribute("loginKey");
        LoginUserVo regStu = new LoginUserVo();
        request.setCharacterEncoding("UTF-8");
        regStu.setName(request.getParameter("name"));
        regStu.setPassword(request.getParameter("password"));
        regStu.setSex(request.getParameter("gender"));
        regStu.setEmail(request.getParameter("email"));
        String[] hobbys = request.getParameterValues("hobby");
        regStu.setHobby(Arrays.toString(hobbys));
        regStu.setCity(request.getParameter("city"));
        CommonDAO stuDao = new CommonDAO();
        int result = stuDao.register(regStu);
        response.setContentType("text/html;charset=utf-8");
        if (result > 0 && session != null && "teacher".equals(((LoginUserVo) session).getRole())) {
            response.getWriter().write("[老师登录]——注册成功,3秒后回到管理学生页面!");
            response.setHeader("refresh", "3;url=ManageStu");
        } else if (result == 0 && session != null && "teacher".equals(((LoginUserVo) session).getRole())) {
            response.getWriter().write("[老师登录]——注册失败!");
            response.setHeader("refresh", "3;url=ManageStu");
        } else if (result > 0) {
            response.getWriter().write("[未登录||其他登录]——注册成功!");
            response.setHeader("refresh", "3;url=login.jsp");
        } else {
            response.getWriter().write("[未登录||其他登录]——注册失败!");
            response.setHeader("refresh", "3;url=register.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}