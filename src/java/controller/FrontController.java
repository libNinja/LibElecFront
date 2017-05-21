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
import java.util.ArrayList;
import java.util.HashMap;
import modelTablesDB.ClientDAO;
import model.VerificateurSaisie;

//TODO il faut activer la session des la rentree du mot de passe

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
    private VerificateurSaisie verificateurSaisie;
    
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
        
      //  String chaineInscriptionVide = "Un ou plusieurs champs vide Veuillez completer les champs manquants";
        String chaineInscriptionInvalide ="Un ou plusieurs champs invalides Veuillez completer les champs manquants";
        
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
                verificateurSaisie = new VerificateurSaisie(request.getParameter("email"));
                if(verificateurSaisie.checkClient()) {
                    if(request.getParameter("password").isEmpty()) {
                        request.setAttribute("mdpVide", mdpVide);
                        page ="/WEB-INF/espaceClient/pageConnexion.jsp";
                    }
                    else {
                        if(verificateurSaisie.checkMdp(request.getParameter("password"))) {
                            System.out.println("true");
                            request.setAttribute("client", verificateurSaisie.getClient());
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
        
        if("enregisterNouveauMembre".equalsIgnoreCase(section)) {
            ArrayList<String> listeSaisie = new ArrayList(15);
            HashMap<String, String> listeChaineInscription;
            
            String nom = request.getParameter("nom");
            listeSaisie.add(nom);
            
            String prenom = request.getParameter("prenom");
            listeSaisie.add(prenom);
            
            String dateNaissance = request.getParameter("dateNaissance");
            listeSaisie.add(dateNaissance);
            
            String email = request.getParameter("email");
            listeSaisie.add(email);
            
            String password = request.getParameter("password");
            listeSaisie.add(password);
            
            String telF = request.getParameter("telF");
            listeSaisie.add(telF);
            
            String telM = request.getParameter("telM");
            listeSaisie.add(telM);
            
            verificateurSaisie = new VerificateurSaisie();
                        
/*          if(verificateurSaisie.verifierChaineVide(listeSaisie)) {
                request.setAttribute("chaineInscriptionVide", chaineInscriptionVide);
                page = "/WEB-INF/espaceClient/pageInscription.jsp";
            }
            else 
            if{*/
            Client nouveauMembre = new Client();
            HashMap<String, String> infosNouveau = new HashMap(15);
                        
            infosNouveau.put("nom", request.getParameter("nom"));
            infosNouveau.put("prenom", request.getParameter("prenom"));
            infosNouveau.put("dateNaissance", request.getParameter("dateNaissance"));
            infosNouveau.put("email", request.getParameter("email"));
            infosNouveau.put("password", request.getParameter("password"));
            infosNouveau.put("telF", request.getParameter("telF"));
            infosNouveau.put("telM", request.getParameter("telM"));
            
            listeChaineInscription = verificateurSaisie.checkSaisieNouveauMembre(infosNouveau);
            
            listeChaineInscription.forEach( (k, v) -> {
                String tmp = (String) v;
                
                if(tmp.equals("vide")) {
                    request.setAttribute((String) k, " * vide");
                    request.setAttribute("chaineInscriptionInvalide", chaineInscriptionInvalide);
                }
                else if(tmp.equals("invalide")) {
                    request.setAttribute((String) k, " * invalide");
                    request.setAttribute("chaineInscriptionInvalide", chaineInscriptionInvalide);
                } 
                
                
                System.out.println("key :" + k + " => " + v );
            });
            
            
            page = "/WEB-INF/espaceClient/pageInscription.jsp";
            
        
        //}
//adresse
            
            
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
