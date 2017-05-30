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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import accessDB.ClientDAO;
import beans.Adresse;
import javax.naming.NamingException;
import model.*;

//TODO il faut activer la session des la rentree du mot de passe

@WebServlet(name = "FrontControleur", urlPatterns = {"/FrontControleur"})
public class FrontControleur extends HttpServlet {
    private VerificateurSaisie verificateurSaisie;
    private GestionClient gestionClient;
    
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
        
        String chaineInscriptionInvalide ="Un ou plusieurs champs invalides Veuillez completer les champs manquants";
        
        boolean nouveauComplet;
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
        
        
        //TODO il faut modifier les infos clients,
        //TODO il faut supprimer un compte client (changer attribut statut dans la base sans supprimer)
        
        if("enregisterNouveauMembre".equalsIgnoreCase(section)) {
            ArrayList<String> listeSaisie = new ArrayList(15);
            HashMap<String, String> listeChaineInscription;
            
            LocalDate toDay = LocalDate.now();
            
            //perapration des objets metiers
            verificateurSaisie = new VerificateurSaisie();
            Client nouveauMembre;
            Adresse adresseNouveauMembre;
            
            
            /**
             * choix d'une hashmap pour pouvoir reperer
             * et récupérer facilement une valeur correspondant à une clé
             */
            HashMap<String, String> infosNouveau = new HashMap(15);
            
            infosNouveau.put("genre", request.getParameter("genre"));
            infosNouveau.put("nom", request.getParameter("nom"));
            infosNouveau.put("prenom", request.getParameter("prenom"));
            infosNouveau.put("email", request.getParameter("email"));
            infosNouveau.put("password", request.getParameter("password"));
            infosNouveau.put("telF", request.getParameter("telF"));
            infosNouveau.put("telM", request.getParameter("telM"));
            infosNouveau.put("numVoie", request.getParameter("numVoie"));
            infosNouveau.put("nomVoie", request.getParameter("nomVoie"));
            infosNouveau.put("nomVoieSuite", request.getParameter("nomVoieSuite"));
            infosNouveau.put("codePostal", request.getParameter("codePostal"));
            infosNouveau.put("ville", request.getParameter("ville"));
            infosNouveau.put("pays", request.getParameter("pays"));
            /**
             * On envoie la hashmap en parametre au l'objet verificateurSaisie
             * cela retourne une autre hashmap correspondant à l'index saisie (ex: nom)
             * et sa valeur contenant 'le msg d'erreur' ou 'ok' si la saisie est correcte
             * Si l'inscription est invalide : la hashmap va permettre d'affecter les valeurs
             * et reperer les saisie concernees dans la jsp 'pageInscription'
             */
            
            
            
            verificateurSaisie.checkSaisieNouveauMembre(infosNouveau);
            
            
            
            
            /* drapeau permettant de savoir si la saisie de l'inscription est complete ou incorrecte */
            
            nouveauComplet = verificateurSaisie.getNouveauComplet();
            
            // TODO il faut controler si le nouveau membre existe deja dans la base
            
            if(nouveauComplet) {
                try {
                    gestionClient = new GestionClient();
                    nouveauMembre = gestionClient.creerNouveauMembre(infosNouveau);
                  
                    
                    request.setAttribute("client", nouveauMembre);
                    
                    
                    // il faut maintenant recuperer l'id de ce client depuis la base pour le lier a cette adresse
                    // Rajout à la base du nouveau client
                    
                    gestionClient.ajouterNouveauClient(nouveauMembre);
                    
                    long nouveauMembreId = gestionClient.getIdDB(nouveauMembre); // recuperation id client depuis la base 
                    adresseNouveauMembre = gestionClient.affecterAdresseAuNouveauMembre(nouveauMembreId, infosNouveau);
                    gestionClient.ajouterAdresseNouveauClient(adresseNouveauMembre);
                    
                    
                }catch(NamingException ex) {
                    System.err.println("naming exception : " + ex.getMessage());
                }
                
            }
            
            
            if(nouveauComplet) {
                page = "/WEB-INF/espaceClient/espacePersonnel.jsp";
            }
            else {
                // si le nouveau membre n'a pu etre creer, on affecte l'object au request pour afficher les msgs erreurs
                request.setAttribute("verificateurSaisie", verificateurSaisie);
                page = "/WEB-INF/espaceClient/pageInscription.jsp";
            }
            
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
