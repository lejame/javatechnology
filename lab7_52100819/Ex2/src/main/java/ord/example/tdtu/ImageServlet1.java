package ord.example.tdtu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/imageServlet1")
public class ImageServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {

        response.setContentType("image/jpeg");
        String imagePath = getServletContext().getRealPath("/WEB-INF/resource/image1.jpg");
        response.getOutputStream().write(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(imagePath)));

    }
}
