/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs.cs545.lab04;

import app.Quiz;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author levi
 */
public class Lab04PresController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("quiz", new Quiz());
        request.setAttribute("errorVisibility", "hidden");
        request.setAttribute("hintVisibility", "hidden");
        RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
        dispatcher.forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* if asked for a hint then set a hint message but do not
         * process the answer
         */
         String buttonPressed = request.getParameter("btnNext");
         if (buttonPressed.equals("Hint")){
             giveHint(request, response);
         }
         else {
             processAnswer(request, response);
         }
        

    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }

    private void giveHint(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
                request.setAttribute("hintMessage", "Pay the professor $10.");
                request.setAttribute("errorVisibility", "hidden");
                request.setAttribute("hintVisibility", "visible");
                RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
                dispatcher.forward(request, response);
    }

    private void processAnswer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /* now need to get an input from the user and process it */
        String answer = request.getParameter("txtAnswer");
        System.out.println("Answer is: " + answer);

        Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");


        boolean error = true;
        /* i.e., if answer is correct then increment the question index and score */
        if ((answer != null) && quiz.isCorrect(answer)) {
            error = false;
            quiz.scoreAnswer();
        }

        request.setAttribute("hintVisibility", "hidden");
        /* NEED TO see if are at end of quiz and go to finish page if so? */
        if (quiz.getNumQuestions() == quiz.getCurrentQuestionIndex()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("quizOver.jsp");
            dispatcher.forward(request, response);
        } else {
            /* display drror page if answer not correct */
            if (error && (answer != null)) {
                
                request.setAttribute("errorVisibility", "visible");
                RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorVisibility", "hidden");
                RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}
