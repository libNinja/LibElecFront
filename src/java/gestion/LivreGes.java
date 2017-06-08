package gestion;

import DB.LivreDB;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import objets.Livre;

public class LivreGes {

    private LivreDB ld;

    public LivreGes() throws NamingException {
        this.ld = new LivreDB();
    }

    public HashMap<Integer, List<Livre>> findByMotCle(int page, String motCle) throws SQLException {
        motCle = motCle.trim();
        return ld.findByMotCle(page, motCle);
    }

    public Livre findByIsbn(String isbn) throws SQLException {
        isbn = isbn.trim();
        return ld.find(isbn);
    }

    public HashMap<Integer, List<Livre>> findByTheme(int page, String theme) throws SQLException {
        theme = theme.trim();
        return ld.findByTheme(page ,theme);
    }

    public HashMap<Integer, List<Livre>> rechercheAvancee(int page, String ouvNom, String isbn, String autNom) throws SQLException {
        String autPrenom;
        if (ouvNom == null) {
            ouvNom = "";
        }

        if (ouvNom == null) {
            isbn = "";
        }
        if (autNom == null) {
            autNom = "";
            autPrenom = "";
        }

        if (autNom.contains(" ")) {
            String[] nom = autNom.split(" ");
            autNom = "%"+nom[0]+"%";
            autPrenom = "%"+nom[1]+"%";
        } else {
                autNom = "%"+autNom+"%";
            autPrenom = "";
        }
        
        ouvNom = "%"+ouvNom+"%";
        isbn = "%"+isbn+"%";
        return ld.rechercheAvancee(page, ouvNom, isbn, autNom, autPrenom);
    }
}
