package net.mumde.cs545;
 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
@WebServlet(name = "AjaxServlet", urlPatterns = {"*.ajax"})
public class AjaxServlet extends HttpServlet {
 
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
  {
        try {
            /* Two ways to determine whether to handle date or temperature
            * String s;
            * 1.Look at the servlet path (e.g., date.ajax return date, temp.ajax return temperature
            *   s = request.getServletPath();
            * 2. Use getParameter by setting parameters in xhr.open
            *   Can add name/value pairs to the url argument of xhr.open
            *   xhr.open("POST", url+"?"+params, …
            */
            
            Thread.sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    response.setContentType("text/plain");
    response.setHeader("Cache-Control", "no-cache");
    response.setStatus(HttpServletResponse.SC_OK);
     
    if(request.getParameter("param").equals("date"))
        response.getWriter().write(((new java.util.Date()).toString()));
    else {
         response.getWriter().write("94");
    }
  }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}