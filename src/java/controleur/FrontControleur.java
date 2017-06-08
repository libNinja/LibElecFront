/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestion.AuteurGes;
import gestion.LivreGes;
import gestion.ProGestion;
import gestion.ThemeGes;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Catalogue;
import objets.Livre;
import objets.Promotion;

/**
 *
 * @author cdi205
 */
@WebServlet(name = "FrontControleur", urlPatterns = {"/FrontControleur"})
public class FrontControleur extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String page = "/index.jsp";
        String section = request.getParameter("section");

        if (getServletContext().getAttribute("livre") == null) {
            try {
                getServletContext().setAttribute("livre", new LivreGes());
            } catch (NamingException ex) {
                System.out.println("1) >>>>>>>>>> erreur : " + ex.getMessage());
            }
        }
        LivreGes lg = (LivreGes) getServletContext().getAttribute("livre");
        
        if (getServletContext().getAttribute("auteur") == null) {
            try {
                getServletContext().setAttribute("auteur", new AuteurGes());
            } catch (NamingException ex) {
                System.out.println("1) >>>>>>>>>> erreur : " + ex.getMessage());
            }
        }
        AuteurGes ag = (AuteurGes) getServletContext().getAttribute("auteur");
        
        if (getServletContext().getAttribute("promotion") == null) {
            try {
                getServletContext().setAttribute("promotion", new ProGestion());
            } catch (NamingException ex) {
                System.out.println("1) >>>>>>>>>> erreur : " + ex.getMessage());
            }
        }
        ProGestion pg = (ProGestion) getServletContext().getAttribute("promotion");
        
        if (getServletContext().getAttribute("themes") == null) {
            try {
                getServletContext().setAttribute("themes", new ThemeGes());
            } catch (NamingException ex) {
                System.out.println("1) >>>>>>>>>> erreur : " + ex.getMessage());
            }
        }
        ThemeGes tg = (ThemeGes) getServletContext().getAttribute("themes");
        
        if ("recherche".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/recherche.jsp";
        }

        if ("menu-main".equalsIgnoreCase(section)) {
            page = "/WEB-INF/includes/menu-main.jsp";
        }

        if (request.getParameter("valider") != null) {
            try {
                if (request.getParameter("page") == null) {
                    request.setAttribute("catalogue", lg.findByMotCle(1,request.getParameter("recherche")));
                    request.setAttribute("url", "recherche="+request.getParameter("recherche")+"&valider=Ok");
                    page = "/WEB-INF/resultat-recherche.jsp";
                } else { 
                    request.setAttribute("catalogue", lg.findByMotCle(Integer.valueOf(request.getParameter("page")),request.getParameter("recherche")));
                    request.setAttribute("url", "recherche="+request.getParameter("recherche")+"&valider=Ok");
                    page = "/WEB-INF/resultat-recherche.jsp";
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("details-livre".equalsIgnoreCase(section)) {
            try {

                String ref = request.getParameter("ref");
                Livre l = lg.findByIsbn(ref);
                Promotion p = pg.findById(l.getProId());
                request.setAttribute("livre", l);
                request.setAttribute("auteurs", ag.findByIsbn(ref));
                request.setAttribute("p", p);
                System.out.println(p.getProId());
                page = "/WEB-INF/details-livre.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("themes".equalsIgnoreCase(section)) {
            try {
                request.setAttribute("themes", tg.findAllTheme());
                request.setAttribute("clefs", tg.getClefs());
                page = "/WEB-INF/themes.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("theme-livre-list".equalsIgnoreCase(section)) {
            try {

                String theme = request.getParameter("theme");
                if (request.getParameter("page") == null) {
                    request.setAttribute("catalogue", lg.findByTheme(1, theme));
                    request.setAttribute("url", "section=theme-livre-list&theme=" + theme);
                    page = "/WEB-INF/resultat-recherche.jsp";
                } else {
                    request.setAttribute("catalogue", lg.findByTheme(Integer.valueOf(request.getParameter("page")), theme));
                    request.setAttribute("url", "section=theme-livre-list&theme=" + theme);
                    page = "/WEB-INF/resultat-recherche.jsp";
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("details-auteur".equalsIgnoreCase(section)) {
            try {
                String auteur = request.getParameter("auteur");
                request.setAttribute("auteur", ag.findById(auteur));
                page = "/WEB-INF/details-auteur.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("recherche-avancee".equalsIgnoreCase(section)) {
            page = "/WEB-INF/recherche-avancee.jsp";
            if (request.getParameter("rechercheAvancee") != null) {
                try {
                    String titre = request.getParameter("titre");
                    String isbn = request.getParameter("isbn");
                    String auteur = request.getParameter("auteur");
                    if (request.getParameter("page") == null) {
                        request.setAttribute("catalogue", lg.rechercheAvancee(1, titre, isbn, auteur));
                        request.setAttribute("url", "titre="+titre+"&isbn="+isbn+"&auteur="+auteur+"&section=recherche-avancee&rechercheAvancee=Rechercher");
                    } else {
                        request.setAttribute("catalogue", lg.rechercheAvancee(Integer.valueOf(request.getParameter("page")), titre, isbn, auteur));
                        request.setAttribute("url", "titre="+titre+"&isbn="+isbn+"&auteur="+auteur+"&section=recherche-avancee&rechercheAvancee=Rechercher");
                    }
                    page = "/WEB-INF/resultat-recherche.jsp";
                } catch (SQLException ex) {
                    Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
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
