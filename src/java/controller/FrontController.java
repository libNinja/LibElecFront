/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Client;
import modelTablesDB.ClientDAO;
import model.VerificateurClient;

//TODO il faut activer la session des la rentree du mot de passe

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
    private VerificateurClient verificateurClient;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        
        
        String page = "/WEB-INF/includes/home.jsp";
        String section = request.getParameter("section");
        
        String title = "";
        request.setAttribute("title", title);
        
        String identifiantInconnu = "Email ou Mot de passe inconnu ou inexistant !";
        
        String emailVide = "Veuillez completer le champ de l'émail";
        String mdpVide = "Veuillez completer le champ du mot de passe";
        
        
        
        boolean log = false;
        
        
        
        if("home".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/home.jsp";
            
        }
        
        if ("menu-main".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/headerCommun.jsp";
        }
        
        if("espacePersonnel".equalsIgnoreCase(section)) {
            if(log) {
                page = "/WEB-INF/espaceClient/espacePersonnel.jsp";
            }
            else {
                page ="/WEB-INF/espaceClient/pageConnexion.jsp";
            }
        }
        
        if("verifierClient".equalsIgnoreCase(section)) {
            if(request.getParameter("email").isEmpty()) {
                request.setAttribute("emailVide", emailVide);
                page ="/WEB-INF/espaceClient/pageConnexion.jsp";
            }
            else {
                verificateurClient = new VerificateurClient(request.getParameter("email"));
                if(verificateurClient.checkClient()) {
                    if(request.getParameter("password").isEmpty()) {
                        request.setAttribute("mdpVide", mdpVide);
                        page ="/WEB-INF/espaceClient/pageConnexion.jsp";
                    }
                    else {
                        if(verificateurClient.checkMdp(request.getParameter("password"))) {
                            System.out.println("true");
                            request.setAttribute("client", verificateurClient.getClient());
                            page = "/WEB-INF/espaceClient/espacePersonnel.jsp";
                        }
                        else {
                            request.setAttribute("identifiantInconnu", identifiantInconnu);
                            page ="/WEB-INF/espaceClient/pageConnexion.jsp";
                        }
                    }
                }
               
                request.setAttribute("identifiantInconnu", identifiantInconnu);
                page ="/WEB-INF/espaceClient/pageConnexion.jsp";
                
            }
            
        }
        
        if("pageInscription".equalsIgnoreCase(section)) {
            page ="/WEB-INF/espaceClient/pageInscription.jsp";
        }
        
        
        page = response.encodeURL(page);
        
        this.getServletContext().getRequestDispatcher(page).include(request, response);
        
        
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
