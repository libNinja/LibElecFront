package controller;

import accessDB.AdresseDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import accessDB.ClientDAO;
import beans.Adresse;
import beans.Client;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "FrontControler", urlPatterns = {"/FrontControler"})
public class FrontControleur extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String page = "/WEB-INF/includes/home.jsp";
        String section = request.getParameter("section");

        if ("home".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/home.jsp";
        }

        if ("menu-main".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/headerCommun.jsp";
        }


        if ("afficher-nouveauClient".equalsIgnoreCase(section)) {
            page = "/WEB-INF/nouveauClient.jsp";
        }

        if ("afficher-livraison".equalsIgnoreCase(section)) {
            page = "/WEB-INF/livraison.jsp";
        }

        if ("afficher-paiement".equalsIgnoreCase(section)) {
            page = "/WEB-INF/paiement.jsp";
        }

        if ("afficher-recap".equalsIgnoreCase(section)) {
            page = "/WEB-INF/recapitulatif.jsp";
        }

        if ("compte-enregistre".equalsIgnoreCase(section)) {

            System.out.println("okok");
            LocalDate toDay = LocalDate.now();
            
            //Creation d'une HashMap pour recuperer les informations saisies par le client 
            HashMap<String, String> infosNouveau = new HashMap(15);

            infosNouveau.put("genre", request.getParameter("genre"));
            infosNouveau.put("nom", request.getParameter("nom"));
            infosNouveau.put("prenom", request.getParameter("prenom"));
            infosNouveau.put("email", request.getParameter("email"));
            infosNouveau.put("password", request.getParameter("password"));
            infosNouveau.put("telF", request.getParameter("telF"));
            infosNouveau.put("telM", request.getParameter("telM"));
            System.out.println(request.getParameter("genre"));
            
            /*
            infosNouveau.put("numVoie", request.getParameter("numVoie"));
            infosNouveau.put("nomVoie", request.getParameter("nomVoie"));
            infosNouveau.put("nomVoieSuite", request.getParameter("nomVoieSuite"));
            infosNouveau.put("codePostal", request.getParameter("codePostal"));
            infosNouveau.put("ville", request.getParameter("ville"));
            infosNouveau.put("pays", request.getParameter("pays"));
            System.out.println(request.getParameter("pays"));
            */
            
            Client nouveauMembre = new Client();
            switch (infosNouveau.get("genre")) {
                case "Mr":
                    nouveauMembre.setCliGenre(1);
                    break;
                case "Mme":
                    nouveauMembre.setCliGenre(2);
                    break;
            }
            nouveauMembre.setCliNom(infosNouveau.get("nom"));
            nouveauMembre.setCliPrenom(infosNouveau.get("prenom"));
            nouveauMembre.setCliDateAdhesion(toDay.toString());
            nouveauMembre.setCliEmail(infosNouveau.get("email"));
            nouveauMembre.setCliMdp(infosNouveau.get("password"));
            nouveauMembre.setCliTelF(infosNouveau.get("telF"));
            nouveauMembre.setCliTelM(infosNouveau.get("telM"));
            nouveauMembre.setCliStatut(1);

            ClientDAO clientDao = new ClientDAO(nouveauMembre);
            clientDao.insertCliInfo();
            
            /*
            Adresse adresseClient = new Adresse();
            adresseClient.setAdrNumVoie(Integer.valueOf(infosNouveau.get("numVoie")));
            adresseClient.setAdrNomVoie(infosNouveau.get("nomVoie"));
            adresseClient.setAdrNomVoieSuite(infosNouveau.get("nomVoieSuite"));
            adresseClient.setAdrCp(infosNouveau.get("codePostal"));
            adresseClient.setAdrVille(infosNouveau.get("ville"));
            adresseClient.setAdrPays(infosNouveau.get("pays"));
            adresseClient.setAdrStatut(1);
           
            AdresseDAO adresseDao = new AdresseDAO(adresseClient);
            adresseDao.insertAdrInfo();
            */
 
            page = "/WEB-INF/livraison.jsp";

            //page = response.encodeURL(page);
            //  response.sendRedirect(page);
            //  return ;
        }

        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> page : "+page);
        page = response.encodeURL(page);

        getServletContext()
                .getRequestDispatcher(page).include(request, response);
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
            Logger.getLogger(FrontControleur.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontControleur.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FrontControleur.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontControleur.class
                    .getName()).log(Level.SEVERE, null, ex);
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
