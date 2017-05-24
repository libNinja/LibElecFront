package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import objets.Adresse;
import objets.Client;

public class AdresseDB implements DAOInterface{
    private Adresse adresse;
    private String query = "";
    private PreparedStatement pstmt;
    private Connection connexion;
    private Statement stmt;
    
    
    public AdresseDB(Adresse adresse) {
        this.adresse = adresse;
    }
    
    @Override
    public void insert() {
        try {
            query = "INSERT INTO Adresse "
                    + "(desId,cliId,cli_cliId,adrNumVoie,adrNomVoie,adrNomVoieSuite,adrCp,adrVille,adrPays,adrStatut) "
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            pstmt = connexion.prepareStatement(query);
            
//            private long adrId;
//            private long desId;
//            private long cliId;
//            private long cli_cliId;
//            private int adrNumVoie;
//            private String adrNomVoie;
//            private String adrNomVoieSuite;
//            private String adrCp;
//            private String adrVille;
//            private String adrPays;
//            private int adrStatut;
            
            
            pstmt.setLong(1, adresse.getDesId());
            pstmt.setLong(2, adresse.getCliId());
            pstmt.setLong(3, adresse.getCli_cliId());
            pstmt.setInt(4, adresse.getAdrNumVoie());
            pstmt.setString(5, adresse.getAdrNomVoie());
            pstmt.setString(6, adresse.getAdrNomVoieSuite());
            pstmt.setString(7, adresse.getAdrCp());
            pstmt.setString(8, adresse.getAdrVille());
            pstmt.setString(9, adresse.getAdrPays());
            pstmt.setInt(10, adresse.getAdrStatut());
            
            pstmt.executeUpdate();
            
        } catch(SQLException ex) {
            System.out.println("sql exception of insertion: " + ex.getMessage());
        }
    }
    
    // TODO Il ne faut oublier le update AdresseDB (attente pour voir sa mise en place)
    @Override
    public void update(long id, String attribut, String nouveauAttribut) {
        query = "";
        try {
            
            try {
                
                switch(attribut) {
                    case "adrNumVoie":
                        int numVoie = Integer.parseInt(nouveauAttribut);
                        query = "UPDATE Adresse "
                                + "SET " + attribut +  " = '" + numVoie +"' "
                                + "WHERE cliId = '" + id + "';";
                        break;
                    case "adrStatut":
                        long sta = Long.parseLong(nouveauAttribut);
                        query = "UPDATE Adresse "
                                + "SET " + attribut +  " = '" + sta +"' "
                                + "WHERE cliId = '" + id + "';";
                        break;
                    default:
                        query = "UPDATE Adresse "
                                + "SET " + attribut +  " = '" + nouveauAttribut +"' "
                                + "WHERE cliId = '" + id + "';";
                        break;
                }
                
                System.out.println("code postal: " + nouveauAttribut);
                
                pstmt = Connexion.connexion.prepareStatement(query);
                pstmt.executeUpdate();
                
            }catch(NumberFormatException ex) {
                ex.getMessage();
            }
                       
        } catch(SQLException ex) {
            System.out.println("sql exception of update: " + ex.getMessage());
        }
    }
    
    public void updateAdresse(long idFacOuLiv, long id, String attribut, String nouveauAttribut) {
        query = "";
        try {
            
            try {
                
                switch(attribut) {
                    case "adrNumVoie":
                        int numVoie = Integer.parseInt(nouveauAttribut);
                        query = "UPDATE Adresse "
                                + "SET " + attribut +  " = '" + numVoie +"' "
                                + "WHERE adrId = '" + id + "' AND cli_cliId = '" + idFacOuLiv +"';";
                        break;
                    case "adrStatut":
                        long sta = Long.parseLong(nouveauAttribut);
                        query = "UPDATE Adresse "
                                + "SET " + attribut +  " = '" + sta +"' "
                                + "WHERE adrId = '" + id + "' AND cli_cliId = '" + idFacOuLiv +"';";
                        break;
                    default:
                        query = "UPDATE Adresse "
                                + "SET " + attribut +  " = '" + nouveauAttribut +"' "
                                + "WHERE adrId = '" + id + "' AND cli_cliId = '" + idFacOuLiv +"';";
                        break;
                }
                
                System.out.println("code postal: " + nouveauAttribut);
                
                pstmt = Connexion.connexion.prepareStatement(query);
                pstmt.executeUpdate();
                
            }catch(NumberFormatException ex) {
                ex.getMessage();
            }
                       
        } catch(SQLException ex) {
            System.out.println("sql exception of update: " + ex.getMessage());
        }
    }
    
    
    
    
    public Vector loadAdressesOfDB() {
        Vector listeAdresses = new Vector();
        ResultSet rs;
        
        try {
            query = "SELECT * FROM Adresse;";
            stmt = Connexion.connexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            
                   
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                
                Vector v = new Vector();
                
                
                adresse.setDesId(rs.getLong("desId"));
                adresse.setCliId(rs.getLong("cliId"));
                adresse.setCli_cliId(rs.getLong("cli_cliId"));
                adresse.setAdrNumVoie(rs.getInt("adrNumVoie"));
                adresse.setAdrNomVoie(rs.getString("adrNomVoie"));
                adresse.setAdrNomVoieSuite(rs.getString("adrNomVoieSuite"));
                adresse.setAdrCp(rs.getString("adrCp"));
                adresse.setAdrVille(rs.getString("adrVille"));
                adresse.setAdrPays(rs.getString("adrPays"));
                adresse.setAdrStatut(rs.getInt("adrStatut"));
                
                v.add(adresse.getAdrId());
                v.add(adresse.getDesId());
                v.add(adresse.getCliId());
                v.add(adresse.getCli_cliId());
                v.add(adresse.getAdrNumVoie());
                v.add(adresse.getAdrNomVoie());
                v.add(adresse.getAdrNomVoieSuite());
                v.add(adresse.getAdrCp());
                v.add(adresse.getAdrVille());
                v.add(adresse.getAdrPays());
                v.add(adresse.getAdrStatut());
                                
              
                
                listeAdresses.add(v);
            }
        }catch (SQLException ex) {
            System.out.println(" erreur chargement adresse" + ex.getMessage());
        }
        
        return listeAdresses;
    }
}
