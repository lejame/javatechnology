package ord.example.tdtu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class UploadServlet extends HttpServlet {

    private static final String Upload_Directory = "uploads" ;
    private static final List<String> SUPPORTED_EXTENSIONS = Arrays.asList("txt","docs", "docx", "img", "pdf", "rar", "zip");

    protected void doPost(HttpServletRequest request , HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String uploadPath = getServletContext().getRealPath("") + File.separator + Upload_Directory ;
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileExtension = getFileExtension(fileName);
        if(!SUPPORTED_EXTENSIONS.contains(fileExtension)){
            response.getWriter().println("Unsupported file extension");
            return;
        }
        File existingFile = new File(uploadPath + File.separator + fileName);
        boolean fileExist = existingFile.exists();
        boolean overrideIfExists = "on".equals(request.getParameter("override"));
        filePart.write(uploadPath + File.separator + fileName);
        if (fileExist && !overrideIfExists) {
            response.getWriter().println("File already exists");
            return;
        }
        if (fileExist && overrideIfExists) {
            response.getWriter().println("File has been overridden");
        } else {
            response.getWriter().println("File has been uploaded\n");
        }
        String downloadLink = request.getContextPath() + File.separator + Upload_Directory + File.separator + fileName ;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<a href='" + downloadLink + "'>Click here to visit the file</a>");
        out.println("</body></html>");
    }
    private String getFileExtension(String fileName){
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }
}
