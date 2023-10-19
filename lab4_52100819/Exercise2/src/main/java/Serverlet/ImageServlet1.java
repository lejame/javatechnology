package Serverlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/ImageServlet1")
public class ImageServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("image/jpeg");
        String imagePath = getServletContext().getRealPath("src/main/webapp/WEB-INF/Resource/image1.jpg");
        resp.getOutputStream().write(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(imagePath)));
    }
}
