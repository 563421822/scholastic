package demos;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 120;
        int height = 40;
        int codeCount = 4;
        int lineCount = 10;
        ValidateCode code = new ValidateCode(width, height, codeCount, lineCount);
        String codeString = code.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("checkCode", codeString);
        code.write(response.getOutputStream());
        BufferedImage image = code.getBuffImg();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}