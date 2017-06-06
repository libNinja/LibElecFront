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
<<<<<<< HEAD:src/java/controller/FrontController.java
import beans.Client;
import model.ClientDAO;
=======

>>>>>>> 79d2e82ad8e6db51015292f7ea3c1ad51e7f887a:src/java/controller/FrontControleur.java
/**
 *
 * @author cdi213
 */
<<<<<<< HEAD:src/java/controller/FrontController.java
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
=======
@WebServlet(name = "FrontControleur", urlPatterns = {"/FrontControleur"})
public class FrontControleur extends HttpServlet {
>>>>>>> 79d2e82ad8e6db51015292f7ea3c1ad51e7f887a:src/java/controller/FrontControleur.java
    
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
        request.setCharacterEncoding("UTF-8");
        
        String page = "/WEB-INF/includes/home.jsp";
        String section = request.getParameter("section");

        String title = "";
        request.setAttribute("title", title);
        
<<<<<<< HEAD:src/java/controller/FrontController.java
        
        Client client = new Client();
        client.setCliId(1);
        ClientDAO c = new ClientDAO(client);
        request.setAttribute("client", c);
        boolean log = false;
        
=======
    
>>>>>>> 79d2e82ad8e6db51015292f7ea3c1ad51e7f887a:src/java/controller/FrontControleur.java
        
        
        if("home".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/home.jsp";
            
        }
        
         if ("menu-main".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/headerCommun.jsp";
        }
        
<<<<<<< HEAD:src/java/controller/FrontController.java
        if("espacePersonnel".equalsIgnoreCase(section)) {
            if(log) {
                page = "/WEB-INF/espaceClient/espacePersonnel.jsp";
            }
            else {
                page ="/WEB-INF/espaceClient/pageConnexion.jsp";
               
            }
        }
=======
        
>>>>>>> 79d2e82ad8e6db51015292f7ea3c1ad51e7f887a:src/java/controller/FrontControleur.java
//            response.sendRedirect(page);
        //return ;
            
            
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
