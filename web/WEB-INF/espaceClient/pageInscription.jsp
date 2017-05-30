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
        <c:url var="headerCommun" value="FrontControleur?section=menu-main" />
        <c:import url="${headerCommun}" />
        
        <div id="membre" >
            <p>Veuillez renseigner les informations</p>
            
            <form action="FrontControleur?section=enregisterNouveauMembre" method="POST">
                <div id="chaineInscriptionVide">
                    <p>${chaineInscriptionInvalide}</p>
                    
                </div>
                
                <fieldset id="fieldset">
                    <legend>Nouveau Membre</legend>
                <div class="membreInfos">
                    <p>infos personnelles</p>
                    <label for="genre">Genre</label>
                    <input type="radio" name="genre" value="Mr">Mr</input>
                    <input type="radio" name="genre" value="Mme">Mme</input><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['genre']}" /></span>
                </div>
                <div class="membreInfos">
                    <label for="nom">Nom </label><input type="text" name="nom" value="<c:out value="${param.nom}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['nom']}" /></span>
                </div>
                        
                <div class="membreInfos">
                    <label for="prenom">Prenom</label><input type="text" name="prenom" value="<c:out value="${param.prenom}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['prenom']}" /></span>
                </div>
                      <!--  
                <div class="membreInfos">
                    <label for="dateNaissance">Date de Naissance</label><input type="date" name="dateNaissance" /><span class="lblErreur"></span>
                </div>
                      -->
                <div class="membreInfos">
                    <label for="email">Email</label><input type="email" name="email" value="<c:out value="${param.email}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['email']}" /></span>
                </div>
                        
                <div class="membreInfos">
                    <label for="password">Mot de passe</label><input type="text" name="password" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['password']}" /></span>
                </div>
                
                 <div class="membreInfos">
                    <label for="confirmPassword">Confirmation Mot de passe</label><input type="text" name="ConfirmPassword" /><span class="lblErreur"></span>
                </div>
                        
                <div class="membreInfos">
                    <label for="telF">Telephone fixe</label><input type="text" name="telF" value="<c:out value="${param.telF}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['telF']}" /></span>
                </div>
                        
                <div class="membreInfos">
                    <label for="telM">Telephone mobile</label><input type="text" name="telM" value="<c:out value="${param.telM}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['telM']}" /></span>
                </div>   
                
                <div class="membreAdresse">
                   
                    <label for="numVoie">Numero voie</label><input type="text" name="numVoie" value="<c:out value="${param.numVoie}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['numVoie']}" /></span>
                </div>
                    
                <div class="membreAdresse">
                    <label for="nomVoie">Nom voie</label><input type="text" name="nomVoie" value="<c:out value="${param.nomVoie}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['nomVoie']}" /></span>
                </div>
                    
                <div class="membreAdresse">
                    <label for="nomVoieSuite">Nom voie suite</label><input type="text" name="nomVoieSuite" value="<c:out value="${param.nomVoieSuite}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['nomVoieSuite']}" /></span>
                </div>    
                    
                <div class="membreAdresse">
                    <label for="codePostal">Code postal</label><input type="text" name="codePostal" value="<c:out value="${param.codePostal}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['codePostal']}" /></span>
                </div>    
                    
                <div class="membreAdresse">
                    <label for="ville">Ville</label><input type="text" name="ville" value="<c:out value="${param.ville}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['ville']}" /></span>
                </div>    
                    
                <div class="membreAdresse">
                    <label for="pays">Pays</label><input type="text" name="pays" value="<c:out value="${param.pays}" />" /><span class="lblErreur"><c:out value="${verificateurSaisie.listeErreurs['pays']}" /></span>
                </div>
                <div class="membreAdresse">
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
        <p>Avec LibElec, trouvez votre oeuvre préfèrée</p>
    </footer>
</html>