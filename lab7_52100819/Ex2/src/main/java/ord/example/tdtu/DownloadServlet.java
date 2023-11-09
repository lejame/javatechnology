package ord.example.tdtu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        String file = request.getParameter("file");
        if(file == null){
            response.getWriter().println("File not found");
            return;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + file);
        String filePath = getServletContext().getRealPath("/WEB-INF/resource2/" + file);
        java.io.File fileObj = new java.io.File(filePath);
        if (fileObj.exists()) {
            try (java.io.FileInputStream fis = new java.io.FileInputStream(fileObj)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                    String speedParam = request.getParameter("speed");
                    if (speedParam != null) {
                        int speed = Integer.parseInt(speedParam);
                        try {
                            Thread.sleep((bytesRead * 1000) / speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            response.getWriter().println("File not found");
        }
    }
}
