package controleurs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metiers.Catalogue;
import metiers.GestionPanier;
import obj.LignePanier;
import obj.Livre;

@WebServlet(name = "FrontControleur", urlPatterns = {"/FrontControleur"})
public class FrontControleur extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String page = "/WEB-INF/home.jsp";
        String section = request.getParameter("section");

        if (getServletContext().getAttribute("catalogue") == null) {
            try {
                getServletContext().setAttribute("catalogue", new Catalogue());
            } catch (NamingException ex) {
                System.out.println("1) >>>>>>>>>> erreur : " + ex.getMessage());
            }

        }
        Catalogue cl = (Catalogue) getServletContext().getAttribute("catalogue");

        if (session.getAttribute("gestionPanier") == null) {
            session.setAttribute("gestionPanier", new GestionPanier());
        }
        GestionPanier gp = (GestionPanier) session.getAttribute("gestionPanier");

        if ("menu-main".equalsIgnoreCase(section)) {
            int qte = gp.getQuantite();
            if (qte > 1) {
                request.setAttribute("infoPanier", qte + " articles");
            } else {
                request.setAttribute("infoPanier", qte + " article");
            }
            page = "/WEB-INF/includes/menu-main.jsp";
        }

        if ("affichage-catalogue".equalsIgnoreCase(section)) {
            try {
                List<Livre> livres = cl.findAllLivres();
                request.setAttribute("livres", livres);
                page = "/WEB-INF/catalogue.jsp";
            } catch (SQLException ex) {
                System.err.println("2) >>>>>>>>>> erreur:" + ex.getErrorCode() + "/" + ex.getMessage());

            }
        }
        
        if("affichage-panier".equalsIgnoreCase(section)){
           Collection<LignePanier> panier = gp.getPanier();
           request.setAttribute("panier", panier);
           request.setAttribute("totalHT", gp.getPrixTotal());
           page = "/WEB-INF/detail-panier.jsp";
        }

        if ("operation-panier".equalsIgnoreCase(section)) {
            String action = request.getParameter("action");

            if ("add".equalsIgnoreCase(action)) {
                String ref = request.getParameter("ref");
                try {
                    Livre l = cl.findLivreById(ref);
                    gp.add(l);
                } catch (IllegalArgumentException ex) {
                    System.err.printf(ref, ex.getMessage());

                } catch (SQLException ex) {
                    System.err.println("4) >>>>>>>>>> erreur:" + ex.getErrorCode() + "/" + ex.getMessage());

                }
            }
            
            if("delete".equalsIgnoreCase(action)){
                String ref = request.getParameter("ref");
                try {
                    Livre l = cl.findLivreById(ref);
                    gp.delete(l);
                    
                } catch (IllegalArgumentException ex){
                    System.err.printf(ref, ex.getMessage());
                    
                } catch (SQLException ex){
                    System.err.println("5) >>>>>>>>>> erreur:" + ex.getErrorCode() + "/" + ex.getMessage());
                }
                
            }
            
            if("clear".equalsIgnoreCase(action)){
                String ref = request.getParameter("ref");
                try {
                    Livre l = cl.findLivreById(ref);
                    gp.clear(l);
                } catch (IllegalArgumentException ex){
                    System.err.printf(ref, ex.getMessage());
                } catch (SQLException ex){
                    System.err.printf("6) >>>>>>>>>>> erreur:" + ex.getErrorCode() + "/" + ex.getMessage());
                }
                
            }
            String origine = request.getParameter("origine");
            if ("catalogue".equalsIgnoreCase(origine)) {
                page = "FrontControleur?section=affichage-catalogue";
            }

            if ("detail-panier".equalsIgnoreCase(origine)) {
                page = "FrontControleur?section=affichage-panier";
            }

            page = response.encodeURL(page);
            response.sendRedirect(page);
            return;
        }
        page = response.encodeURL(page);
        getServletContext().getRequestDispatcher(page).include(request, response);
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
