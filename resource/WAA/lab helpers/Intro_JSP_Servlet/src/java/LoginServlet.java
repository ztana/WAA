import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakesh Shrestha
 */
//@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
  
        
        if (session.getAttribute("user") ==null) {
            session.setAttribute("user", new User());
            session.setAttribute("tries", 0);
        }
        
        User user = (User) session.getAttribute("user");
        
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        user.setUserId(userId);
        user.setPassword(password);
        
        request.setAttribute("errors", new HashMap<>());
        if(userId.isEmpty()){
            ((Map)request.getAttribute("errors")).put("requiredName", "Name cannot be empty.");
        }
        
        if(password.isEmpty()){
            ((Map)request.getAttribute("errors")).put("requiredPassword", "Password cannot be empty.");
        }
        
        if(userId.isEmpty() || password.isEmpty()){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        
        if(user.authenticate()){
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }else{
            ((Map)request.getAttribute("errors")).put("authError", "UserId/Password invalid.");
            int tries = (int)session.getAttribute("tries");
            session.setAttribute("tries", ++tries);
            if((int)session.getAttribute("tries") == 3){
                session.setAttribute("tries", 0);
                request.getRequestDispatcher("sorry.jsp").forward(request, response);
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
