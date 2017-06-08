<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Nouveau Client</title>
    </head>
    <body>
        <c:url var="url01" value="FrontController?section=menu-main" />
        <c:import url="${url01}" />
        <h1>Creer un compte</h1>
            <br />
            
            
            <form action="FrontControler?section=compte-enregistre" method="POST"> 
                
                
                <div class="membreInfos">
                    <label for="genre">Genre</label>
                    <input type="radio" name="genre" value="Mr">Mr</input>
                    <input type="radio" name="genre" value ="Mme">Mme</input>
                        </div>
                <div class="membreInfos">
                    <label for="nom">Nom</label><input type="text" name="nom" />
                    </div>
                    
                <div class="membreInfos">
                    <label for="prenom">Prenom</label><input type="text" name="prenom" />
                    </div>
                
                <div class="membreInfos">
                    <label for="email">Email</label><input type="email" name="email" />
                    </div>
                
                <div class="membreInfos">
                    <label for="password">Mot de passe</label><input type="text" name="password" />
                    </div>
                
                <div class="membreInfos">
                    <label for="telF">Telephone fixe</label><input type="text" name="telF" />
                    </div>
                
                <div class="membreInfos">
                    <label for="telM">Telephone mobile</label><input type="text" name="telM" />
                </div>   
                
                <div class="membreInfos">
                    <label for="numVoie">Numero voie</label><input type="text" name="numVoie" />
                </div>
                
                <div class="membreInfos">
                    <label for="nomVoie">Nom voie</label><input type="text" name="nomVoie" />
                </div>
                
                <div class="membreInfos">
                    <label for="nomVoieSuite">Nom voie suite</label><input type="text" name="nomVoieSuite" />
                </div>    
                
                <div class="membreInfos">
                    <label for="codePostal">Code postal</label><input type="text" name="codePostal" />
                </div>    
                
                <div class="membreInfos">
                    <label for="ville">Ville</label><input type="text" name="ville" />
                </div>    
                
                <div class="membreInfos">
                    <label for="pays">Pays</label><input type="text" name="pays" />
                </div>
              
                
                <input type='hidden' name='section' value='compte-enregistre'>
                <input type="submit" name="submit" value="creer un compte" />
                 
                </form> 
        <br />
        <a href="FrontControler?section=afficher-panier"> <input type="submit" name="submit" value="precedent" /></a>
         <%--
        <a href="FrontControler?section=afficher-livraison"> <input type="submit" name="submit" value="creer un compte" /></a>
        --%>
        
    </body>
</html>