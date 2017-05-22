 package controleur;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gestion.GestionDestinataire;
import gestion.GestionClient;
import accesBDD.ClientDAO;
import beans.Client;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "FrontControleur", urlPatterns = {"/FrontControleur"})
public class FrontControleur extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String page = "/WEB-INF/home.jsp";
        String section = request.getParameter("section");
        
        
        if ("menu-main".equalsIgnoreCase(section)) {
            page = "/WEB-INF/menu/menu-main.jsp";
        }
        
        if("afficher-panier".equalsIgnoreCase(section)){
           page = "/WEB-INF/panier.jsp";
        }
        
         if("afficher-destinataire".equalsIgnoreCase(section)){
           page = "/WEB-INF/destinataire.jsp";
        }
         
        if("authentification".equalsIgnoreCase(section)){
          page = "/WEB-INF/authentification.jsp";
        }
         
         
        if("destinataire-insertion".equalsIgnoreCase(section)){
             String destinataireNom = request.getParameter("desNom");
             String destinatairePrenom = request.getParameter("desPrenom");
             String destinataireEmail = request.getParameter("desEmail");
             String destinataireTel = request.getParameter("desTel");
             
             String adresseAdrNumVoie = request.getParameter("adrNumVoie");
             String adresseNomVoie = request.getParameter("adrNomVoie");
             String adresseNomVoieSuite = request.getParameter("adrNomVoieSuite");
             String adresseCp = request.getParameter("adrCp");
             String adresseVille = request.getParameter("adrVille");
             String adressePays = request.getParameter("adrPays");
             
             try{
             GestionDestinataire gd = new GestionDestinataire();
             
             gd.insertDes(destinataireNom,destinatairePrenom,destinataireEmail,destinataireTel);
             gd.insertDesAdr(adresseAdrNumVoie,adresseNomVoie,adresseNomVoieSuite,adresseCp,adresseVille,adressePays);
             
            
             } catch (IllegalArgumentException | SQLException ex) {
                
             }
            
             if("compte-enregistre".equalsIgnoreCase(section)){
             
             int cliStatut = 1;
             String cliChampLibre = "";
             int cliGenre = 1;
                 
             String cliNom = request.getParameter("nom");
             String cliPrenom = request.getParameter("prenom");
             String cliEmail = request.getParameter("email");
             String cliMdp = request.getParameter("password");
             String cliTelF = request.getParameter("telF");
             String cliTelM = request.getParameter("telM");
             Date cliDateAdhesion = new Date(2017);
             //String cliDateAdhesion = new Date().toString();
             
             Client nvCli = new Client(cliGenre, cliNom, cliPrenom, cliEmail, cliMdp, cliDateAdhesion, cliTelF, cliTelM, cliStatut, cliChampLibre);
             
             try{
                 
             GestionClient gc = new GestionClient();
             
             gc.insertCliInfo (nvCli);
           
             
             } catch (IllegalArgumentException ex) {
            
           
             }
           //page = response.encodeURL(page);
          //  response.sendRedirect(page);
          //  return ;
    }
        }
    
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> page : "+page);
        page = response.encodeURL(page);
        getServletContext().getRequestDispatcher(page).include(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /*
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    }

