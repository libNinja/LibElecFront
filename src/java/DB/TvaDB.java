
package DB;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import objets.Tva;


public class TvaDB extends DB<Tva> {

    @Override
    public boolean insert(Tva obj) {
        
        String query = "insert into tva (tvaTaux) values (?)";
        
        PreparedStatement pstmt;
                
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setFloat(1, obj.getTvaTaux());
            pstmt.executeUpdate ();
            pstmt.close();
        return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean update(Tva obj) {
        
        String query = "update tva set tvaId = ? where tvaTaux = ?";
        
        PreparedStatement pstmt;
            
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setFloat(1, obj.getTvaId());
            pstmt.setFloat(2, obj.getTvaTaux());
            pstmt.executeUpdate ();
            pstmt.close();
        return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;  
        }
    }
    
    public Tva find (long tvaId) {
        
        String query = "SELECT * FROM Tva WHERE tvaId = ?";
        
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setLong(1, tvaId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            
            Tva obj = new Tva (rs.getLong("tvaId"),rs.getFloat("tvaTaux"));
            rs.close();
            pstmt.close();
            return obj;
            
            } catch(SQLException ex) {
            ex.printStackTrace();
            }
            return null;  
            }
    
    public Vector <Tva> affichage (){
        
        String query = "select * from Tva";
        
        try{
            
            System.out.println("chargement des donnees tva");
            
            Statement stmt = Connexion.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Vector <Tva> tvaList = new Vector ();
            while(rs.next()){
                Tva obj = new Tva (rs.getLong("tvaId"),rs.getFloat("tvaTaux"));
                tvaList.add(obj);
                //System.out.println(obj.getTvaTaux());
                
            }
            rs.close();
            stmt.close();
            return tvaList;
            
        } catch (SQLException ex){
            return null;
        }
    }
} 
    
    //TODO telecharger sublime text
