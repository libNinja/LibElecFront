<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
    </head>
    <body>
        <c:url var="url01" value="FrontControleur?section=menu-main" />
        <c:import url="${url01}" />
        <h1>Authentification</h1>
            <p>Creer une compte</p>
            <br />
            
            
            <form action="FrontControleur?section=compte-enregistre" method="POST"> 
                <div class="membreInfos">
                    <p>Données personnelles</p>
                    <label for="genre">Genre</label>
                    <input type="radio" name="genre">Mr</input>
                    <input type="radio" name="genre">Mme</input>
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
                
                
                <%--
                <div class="membreAdresse">
                    <p>Champ Adresse</p>
                    <label for="numVoie">Numero voie</label><input type="text" name="numVoie" />
                </div>
                
                <div class="membreAdresse">
                    <label for="nomVoie">Nom voie</label><input type="text" name="nomVoie" />
                </div>
                
                <div class="membreAdresse">
                    <label for="nomVoieSuite">Nom voie suite</label><input type="text" name="nomVoieSuite" />
                </div>    
                
                <div class="membreAdresse">
                    <label for="codePostal">Code postal</label><input type="text" name="codePostal" />
                </div>    
                
                <div class="membreAdresse">
                    <label for="ville">Ville</label><input type="text" name="ville" />
                </div>    
                
                <div class="membreAdresse">
                    <label for="pays">Pays</label><input type="text" name="pays" />
                </div>
                --%>
                
                
                <input type='hidden' name='section' value='compte-enregistre'>
                <%--
                <a href="FrontControleur?section=compte-enregistre"><input type="submit" name="submit" value="continuer" /></a>
                 --%>
                
                 <input type="submit" name="submit" value="continuer" />
                 
                 
                </form> 
                
        <br />
        <a href="FrontControleur?section=afficher-destinataire"> Valider(aller a adresse de livraison)</a>
        
    </body>
</html>