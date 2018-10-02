/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.GestionClientcommandeLocal;

/**
 *
 * @author gabrielleite
 */
@WebServlet(name = "CreationClient", urlPatterns = {"/CreationClient"})
public class CreationClient extends HttpServlet {

    @EJB
    private GestionClientcommandeLocal gestionClientcommande;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String login=request.getParameter("login");
        String passe=request.getParameter("passe");
        String nai=request.getParameter("nai");
        if((nom!=null)&& (prenom!=null)&& (login!=null)&&(passe!=null)&&(nai!=null)){
            
            Date da = Date.valueOf(nai);
            gestionClientcommande.creerClient(nom, prenom, da, login, passe);
            response.sendRedirect("Menu");
            
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreationClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreationClient at " + request.getContextPath() + "</h1>");
            out.println("<form>");
            out.println("Nom:<input type='text' name='nom' ><br/>");
            out.println("Prenom:<input type='text' name='prenom'><br/>");
            out.println("Identifiant:<input type='text' name='login'><br/>");
            out.println("Mot de passe:<input type='text' name='passe'><br/>");
            out.println("Date naissance:<input type='date' name='nai'><br/>");
            out.println("<input type='submit'><br/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
