<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Paiement</title>
    </head>
    <body>
        <c:url var="url01" value="FrontControleur?section=menu-main" />
        <c:import url="${url01}" />
        <h1>Paiement</h1>
            <br />
            
            
            <form action="FrontControleur?section=paiement-enregistre" method="POST"> 
                <div class="Montant">
                    <label for="montant">Montant : </label><input type="text" name="montant" />
                    <br/>
                    <br/>
                </div>
                
                <div class="InfoBancaire">
                    <label for="numeroCB">N° de carte bancaire : </label><input type="text" name="numeroCB" />
                    <br/>
                </div>
                    
                <div class="InfoBancaire">
                    <label for="dateExp">Date d'expiration : </label><input type="text" name="dateExp" />
                    <br/>
                    </div>
                
                <div class="InfoBancaire">
                    <label for="codeVerif">Code de verification : </label><input type="email" name="codeVerif" />
                    <br/>
                    </div>
                
                <div class="InfoBancaire">
                    <label for="nomTitulaire">Nom du titulaire : </label><input type="text" name="nomTitulaire" />
                    <br/>
                    </div>
                
                <br/>
                <input type='hidden' name='section' value='paiement-enregistre'>
                <input type="submit" name="Valider" value="Valider" />
                <input type="submit" name="Abandonner" value="Abandonner" />
                
                </form> 
    </body>
</html>