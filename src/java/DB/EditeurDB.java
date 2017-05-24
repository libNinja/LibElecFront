
package DB;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import objets.Editeur;

public class EditeurDB extends DB<Editeur> {

    public EditeurDB() {
    }

    
 
    @Override
    public boolean insert(Editeur obj) {
        String query = "insert into editeur (ediNom, ediTeleF, editEmail, ediStatut, ediChampLibre) values (?,?,?,?,?)";
                
        PreparedStatement pstmt;
                
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getEdiNom());
            pstmt.setString(2, obj.getEdiTeleF());
            pstmt.setString(3, obj.getEdiEmail());
            pstmt.setInt(4, obj.getEdiStatut());
            pstmt.setString(5, obj.getEdiChampLibre());
            
            pstmt.executeUpdate ();
            pstmt.close();
        return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Editeur obj) {
        
       // String query = "update tva set tvaId = ? where tvaTaux = ?";
        
        String query = "update editeur set ediTeleF = ?, editEmail = ?, ediStatut = ?, editChampLibre = ? where ediNom = ?";
        
        PreparedStatement pstmt;
            
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getEdiTeleF());
            pstmt.setString(2, obj.getEdiEmail());
            pstmt.setInt(3, obj.getEdiStatut());
            pstmt.setString(4, obj.getEdiChampLibre());
            pstmt.setString(5, obj.getEdiNom());
            pstmt.executeUpdate ();
            pstmt.close();
        return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;  
        }
    }
   
    public Editeur find(long ediId) {
        String query = "SELECT * FROM Editeur WHERE ediId = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setLong(1, ediId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Editeur obj = new Editeur(rs.getLong("ediId"), rs.getString("ediNom"), rs.getString("ediTeleF"), rs.getString("editEmail"), rs.getInt("ediStatut"), rs.getString("ediChampLibre"));
            return obj;
                    
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Vector <Editeur> affichage(){
        
        String query = "select * from Editeur";
        
        try{
            
            Statement stmt = Connexion.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Vector <Editeur> editeurList = new Vector ();
            while(rs.next()){
                Editeur obj = new Editeur (rs.getLong("ediId"),rs.getString("ediNom"),rs.getString("ediTeleF"),rs.getString("editEmail"),rs.getInt("ediStatut"),rs.getString("ediChampLibre"));
                editeurList.add(obj); 
            }
            rs.close();
            stmt.close();
            return editeurList;
            
        } catch (SQLException ex){
            return null;
        }
    }
    
}
