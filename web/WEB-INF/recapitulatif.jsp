<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Recapitulatif</title>
    </head>
    <body>
        <c:url var="url01" value="FrontController?section=menu-main" />
        <c:import url="${url01}" />
        <h1>Recapitulatif</h1>
            <br />
            
                <div class="ClientInfos">
                    <h>ADRESSE DE FACTURATION</h>
                </div>    
                <div class="ClientInfos">
                    <p >${client.nom}</p>
                </div>
                <div class="ClientInfos">
                    <label >Justine Rose</label>
                </div>
                <div class="ClientInfos">
                    <label >16 rue Enim</label>
                </div>
                <div class="ClientInfos">
                    <label >69668 La Granja</label>
                </div>    
                <div class="ClientInfos">
                    <label >France</label>
                </div>    
                
                <div class="LivraisonAdresse">
                    <p>ADRESSE DE LIVRAISON</p>
                </div> 
                <div class="LivraisonAdresse">
                    <label> Jerome Wyatt</label> 
                </div>
                <div class="LivraisonAdresse">
                    <label> 50 impasse de la butte</label> 
                <div class="LivraisonAdresse">
                    <label> 75001 Paris</label> 
                </div>
                <div class="LivraisonAdresse">
                    <label> France</label>
                </div>
                    <div class="LivraisonAdresse">
                    <label> Tel :06.47.65.88.48</label> 
                </div>
                    <div class="LivraisonAdresse">
                    <label> Email : Integer@ipsumsodales.co.uk</label> 
                </div>
                
        <br />   
        <a href="FrontControler?section=afficher-livraison"> <input type="submit" name="submit" value="precedent" /></a>
        
        <a href="FrontControler?section=afficher-paiement"> <input type="submit" name="submit" value="confirmer" /></a>
        
        
    </body>
</html>