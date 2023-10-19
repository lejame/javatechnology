package Serverlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
//        if query string not found  or file name not exist then return <h1> File not found
        String queryString = request.getQueryString();
        if (queryString == null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1> Query string not found </h1>");
            out.flush();
            out.close();
            return;
        }
        String fileName = queryString.split("=")[1];
        System.out.println(fileName);
        System.out.println(getServletContext().getRealPath("/WEB-INF/" + fileName));
        if (!Path.of(getServletContext().getRealPath("/WEB-INF/" + fileName)).toFile().exists()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1> File not found </h1>");
            out.flush();
            out.close();
            return;
        }

//        force client download file
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        ServletOutputStream outputStream = response.getOutputStream();

        getServletContext().getResourceAsStream("/WEB-INF/" + fileName).transferTo(outputStream);

        outputStream.flush();
        outputStream.close();
    }
}
