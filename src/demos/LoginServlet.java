package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        LoginUserVo luv = new LoginUserVo();
        luv.setName(request.getParameter("name"));
        luv.setPassword(request.getParameter("password"));
        luv.setRole(request.getParameter("role"));
        String rememberMe = request.getParameter("rememberMe");
        String code = request.getParameter("code");
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        if (checkCode.equalsIgnoreCase(code)) {
            CommonDAO dao = new CommonDAO();
            int result = dao.login(luv);
            System.out.println(result);
            if (result == 0) {
                request.setAttribute("error", "登录失败!");
                request.getRequestDispatcher("login.jsp").forward(request, response);//获得请求的调度并向前
            } else {
                if ("on".equals(rememberMe)) {
                    Cookie c1 = new Cookie("name", URLEncoder.encode(luv.getName(), StandardCharsets.UTF_8));//键值对,设置键名
                    Cookie c2 = new Cookie("password", luv.getPassword());
                    c1.setMaxAge(300);
                    c2.setMaxAge(300);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                request.getSession().setAttribute("loginKey", luv);
                System.out.println(request.getSession().getAttribute("loginKey"));
                request.getRequestDispatcher("index.jsp").forward(request, response);//转发,带数据
            }
        } else {
            response.getWriter().write("验证码有误!");
            response.setHeader("refresh", "1;url=login.jsp");
            PrintWriter out = response.getWriter();
            out.write("<!DOCTYPE html>");
            out.write("<html>");
            out.write("<head>");
            out.write("<meta charset='UTF - 8'>");
            out.write("<title>Title</title>");
            out.write("</head>");
            out.write("<body>");
            out.write("<h1>你好!Servlet!</h1>");
            out.write("</body>");
            out.write("</html>");
            String[] arr = new String[]{"abc", "efg", "王永亮", "张三"};
            for (String s : arr) {
                out.write("<h2>" + s + "</h2>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}