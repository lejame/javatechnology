// Ex1

package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Starting Logout Servlet!!!");
    }

    @Override
    public void destroy() {
        System.out.println("Deleting Servlet!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("userId");
            session.removeAttribute("username");
        }
        System.out.println(session.getAttribute("userId"));
        System.out.println(session.getAttribute("username"));
        // Redirect to the login page
        res.sendRedirect("/Lab05/");
    }
}
