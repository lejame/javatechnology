package ord.example.tdtu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException , IOException {
        String queryString = request.getQueryString();
        if(queryString != null){
            String page = getParameterValue(queryString,"page");
            if (page != null) {
                String destination = "";

                if (page.equals("about")) {
                    destination = "about.jsp";
                } else if (page.equals("contact")) {
                    destination = "contact.jsp";
                } else if (page.equals("help")) {
                    destination = "help.jsp";
                }

                if (!destination.isEmpty()) {
                    request.getRequestDispatcher(destination).forward(request, response);
                    return;
                }
            }
            response.setContentType("text/html");
            response.getWriter().println("<h1>Welcome to our website!</h1>");
        }

    }
    private String getParameterValue(String queryString, String parameterName) {
        String[] parameters = queryString.split("&");
        for(String parameter : parameters){
            String[] keyValue = parameter.split("=");
            if(keyValue.length == 2 && keyValue[0].equals(parameterName)){
                return keyValue[1];
            }
        }
        return null;
    }
}
