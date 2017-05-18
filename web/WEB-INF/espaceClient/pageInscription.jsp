<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Nouveau Membre</title>
    </head>
        
    <body>
        <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />
            
        <div id="membre" >
            <p>Veuillez renseigner les informations</p>
            <form action="FrontController?section=enregisterNouveauMembre" method="POST">
                <div id="membreInfos">
                    <p>Données personnelles</p>
                    <label for="genre">Genre</label>
                    <input type="radio" name="genre">Mr</input>
                    <input type="radio" name="genre">Mme</input>
                        
                    <label for="nom">Nom</label><input type="text" name="nom" />
                    <label for="prenom">Prenom</label><input type="text" name="prenom" />
                    <label for="email">Email</label><input type="email" name="email" />
                    <label for="password">Mot de passe</label><input type="text" name="password" />
                    <label for="telF">Telephone fixe</label><input type="text" name="telF" />
                    <label for="telM">Telephone mobile</label><input type="text" name="telM" />
                </div>   
                    
                <div id="membreAdresse">
                    <p>Champ Adresse</p>
                    <label for="numVoie">Numero voie</label><input type="text" name="numVoie" />
                    <label for="nomVoie">Nom voie</label><input type="text" name="nomVoie" />
                    <label for="nomVoieSuite">Nom voie suite</label><input type="text" name="nomVoieSuite" />
                    <label for="codePostal">Code postal</label><input type="text" name="codePostal" />
                    <label for="ville">Ville</label><input type="text" name="ville" />
                    <label for="pays">Pays</label><input type="text" name="pays" />
                </div>
                <div>
                    <input type="submit" name="submit" />
                </div>
                
            </form>
    </body>
</html>