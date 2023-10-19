package ord.example.tdtu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String country = request.getParameter("country");
        String toeic = request.getParameter("toeic");
        String message = request.getParameter("message");
        String gender = request.getParameter("gender");
        String[] selectedValues = request.getParameterValues("favorite_ide[]");
        if(userName != null && !userName.isEmpty() && email != null && !email.isEmpty() && birthtime != null && !birthtime.isEmpty()
                && birthday != null && !birthday.isEmpty() && country != null && !country.isEmpty()
                && toeic != null && !toeic.isEmpty() && gender != null && !gender.isEmpty()
                && message != null && !message.isEmpty() && selectedValues != null && selectedValues.length > 0
        ) {
            Double toeicParam = Double.parseDouble(toeic);
            InforUser user1 = new InforUser(userName, email, birthday, birthtime, country, toeicParam, message,gender,selectedValues);

            request.setAttribute("info", user1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
            dispatcher.forward(request, response);

        }
        else{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<p>Ban Dien Thieu Thong tin,Xin vui long hay kiem tra lai</p>");
            out.println("</body></html>");
        }


    }
}
