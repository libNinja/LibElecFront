<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Nouveau Membre</title>
    </head>
    
    <body id="arriere">
        <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />
        
        <div id="membre" >
            <p>Veuillez renseigner les informations</p>
            
            <form action="FrontController?section=enregisterNouveauMembre" method="POST">
                <div id="chaineInscriptionVide">
                    <p>${chaineInscriptionInvalide}</p>
                    
                </div>
                
                <fieldset id="fieldset">
                    <legend>Nouveau Membre</legend>
                <div class="membreInfos">
                    <p>infos personnelles</p>
                    <label for="genre">Genre</label>
                    <input type="radio" name="genre" value="Mr">Mr</input>
                    <input type="radio" name="genre" value="Mme">Mme</input><span class="lblInfos">${genre}</span>
                </div>
                <div class="membreInfos">
                    <label for="nom">Nom </label><input type="text" name="nom"/><span class="lblInfos">${nom}</span>
                </div>
                        
                <div class="membreInfos">
                    <label for="prenom">Prenom</label><input type="text" name="prenom" /><span class="lblInfos">${prenom}</span>
                </div>
                      <!--  
                <div class="membreInfos">
                    <label for="dateNaissance">Date de Naissance</label><input type="date" name="dateNaissance" /><span class="lblInfos">${dateNaissance}</span>
                </div>
                      -->
                <div class="membreInfos">
                    <label for="email">Email</label><input type="email" name="email" /><span class="lblInfos">${email}</span>
                </div>
                        
                <div class="membreInfos">
                    <label for="password">Mot de passe</label><input type="text" name="password" /><span class="lblInfos">${password}</span>
                </div>
                
                 <div class="membreInfos">
                    <label for="confirmPassword">Confirmation Mot de passe</label><input type="text" name="ConfirmPassword" /><span class="lblInfos">${confirmPassword}</span>
                </div>
                        
                <div class="membreInfos">
                    <label for="telF">Telephone fixe</label><input type="text" name="telF" /><span class="lblInfos">${telF}</span>
                </div>
                        
                <div class="membreInfos">
                    <label for="telM">Telephone mobile</label><input type="text" name="telM" /><span class="lblInfos">${telM}</span>
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
                <div id="submitInscription">
                    <input type="submit" name="submit" value="Enregister"/>
                </div>
            </form>
        </fieldset>
    </body>
        
    <section id="boxes">
        <div class="container">
            <div class="box">
            </div>
                                
        </div>
    </section>
                        
    <footer>
        <p>Avec LibElec, trouvez votre oeuvre préférée</p>
    </footer>
</html>