
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountServices;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        
        //if the user presses the log out button, it will log out the user
        String log_out = request.getParameter("logoutbutton");
        if(log_out != null && log_out.equals("logout")) {
            session.invalidate(); 
            request.setAttribute("logoutMessage", "You have successfully logged out!");
            //back to the login jsp
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return; 
        }
        
        User user = (User) session.getAttribute("user");
        
        //if the is not null (user is logged in) it redirects to HomeServlet
        if(user != null) {
            response.sendRedirect("home");
            return;
        //if the user is not logged in (user == null), it shows the login jsp
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String user_name = request.getParameter("username");
        String password = request.getParameter("password");
        
        //if the user puts a wrong username/password, it will still store them to auto-fill the fields with 
        //what the user previously entered
        User invalidUser = new User(user_name, password);
        request.setAttribute("user", invalidUser);
        
        //if any field is null
        if(user_name == null || user_name == "" || password == null || password == "") {
            request.setAttribute("invalidLogin", "Invaid username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        //checks if the username and password is correct
        } else {
            AccountServices userEntered = new AccountServices();
            User user = new User();
            user = userEntered.login(user_name, password);

            //incorrect username/password, login method returns null
            if(user == null) {
                request.setAttribute("invalidLogin", "Invaid username or password");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            //correct username and password, redirect to HomeServlet
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("home");
                return;
            }
        }

    }

}
