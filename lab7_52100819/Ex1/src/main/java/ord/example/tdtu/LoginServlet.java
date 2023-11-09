package ord.example.tdtu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private HashMap<String, String> accounts;
    @Override
    public void init() throws ServletException {
        accounts = new HashMap<>();
        accounts.put("user1" , "admin1234");
        accounts.put("user2" , "admin1234");
        accounts.put("a" , "1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        if (accounts.containsKey(userName) && accounts.get(userName).equals(passWord)){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Login success");
            out.close();
        }

        else{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("login failed");
            out.close();
        }
    }
}
