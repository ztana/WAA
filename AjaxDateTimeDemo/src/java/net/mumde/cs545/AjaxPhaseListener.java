package net.mumde.cs545;


import javax.faces.event.PhaseListener;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;
import java.io.*;
 
public class AjaxPhaseListener implements PhaseListener
{
 
    public PhaseId getPhaseId()
    {    // Want to be called in the restore view phase
        return PhaseId.RESTORE_VIEW; // in afterPhase()
    }
 
    public void beforePhase(PhaseEvent phaseEvent)
    { // not interested
    }
 
    public void afterPhase(PhaseEvent phaseEvent)
    { // After the RESTORE VIEW phase
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
 
        String s = request.getServletPath();
        if (s.contains("dateAndTime.faces"))
        {
            response.setContentType("text/plain");
            response.setHeader("Cache-Control", "no-cache");
            response.setStatus(HttpServletResponse.SC_OK);
            try
            {
                if(request.getParameter("param").equals("date"))
                    response.getWriter().write("Current Temperature: " + ((new java.util.Date()).toString()));
                else {
                    response.getWriter().write("Current Temperature: " + "94");
                }
               // response.getWriter().write("AjaxPhaseListener: " + ((new java.util.Date()).toString()));
            }
            catch (Exception ex)
            {
                System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
            }
 
            phaseEvent.getFacesContext().responseComplete();
        }
    }
}