
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(); 
       
        User user = (User) session.getAttribute("user");
        //if the user is not logged in (user == null), it redirects to LoginServlet
        if(user == null) {
            response.sendRedirect("login");
            return;
        //if user object exists (logged in), load the home jsp
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
