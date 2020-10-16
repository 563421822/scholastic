package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ManageStu")
public class ManageStu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CommonDAO dao = new CommonDAO();
        ArrayList<LoginUserVo> stuList = dao.queryAllStu();
        request.setAttribute("key", stuList);
        if (request.getParameter("name") == null) {
            request.getRequestDispatcher("manageStu.jsp").forward(request, response);
        } else {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            int result = dao.delStuByNP(name, password);
            if (result == 0) {
                request.setAttribute("error", "密码错误!");
                request.getRequestDispatcher("manageStu.jsp").forward(request, response);
            } else {
                response.sendRedirect("ManageStu");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}