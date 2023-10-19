package Serverlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServerlet extends HttpServlet {
    private HashMap<String, String> account;
    @Override
    public void init() throws ServletException {
        account = new HashMap<>();
        account.put("admin", "123");
        account.put("user", "123");
        account.put("user1", "123");
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        System.out.println(username);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (account.containsKey(username) && account.get(username).equals(password)) {
            out.println("login success");
            System.out.println("loi");
        } else {
            out.println("fail");
        }

        out.flush();
        out.close();
    }
}
