package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/ModifyInfo")
public class ModifyInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        LoginUserVo upd = new LoginUserVo();
        upd.setName(request.getParameter("name"));
        upd.setSex(request.getParameter("gender"));
        upd.setEmail(request.getParameter("email"));
        String[] hobby = request.getParameterValues("hobby");
        upd.setHobby(Arrays.toString(hobby));
        upd.setCity(request.getParameter("city"));
        CommonDAO stuDAO = new CommonDAO();
        stuDAO.modifyInfo(upd);
        request.setAttribute("succe", "修改成功!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}