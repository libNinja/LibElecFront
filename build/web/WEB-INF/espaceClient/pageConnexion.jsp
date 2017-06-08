<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibElec | Espace Client</title>
        <link rel="stylesheet" href="./resources/css/style.css" />
    </head>
    
    <body>
        <c:url var="headerCommun" value="FrontControleurEspaceClient?section=menu-main" />
        <c:import url="${headerCommun}" />
        
        
        <section id="panLogger">
            <h1>Connexion</h1>
            
                <div id="clientInconnu">
                    <p>${identifiantInconnu}</p>
                    <p>${emailVide}</p>
                    <p>${mdpVide}</p>
                   </div>
                    
                    
                    <form action="FrontControleurEspaceClient?section=verifierClient" method="POST">
                        <div class="infosConnection">
                            <input type="email" name="email" placeHolder="Entrez votre Email..." />
                        </div>
                        
                        <div class="infosConnection">
                        <input type="password" name="password" placeHolder="Mot de passe"/>
                        </div>
                        
                        <div class="infosConnection">
                            <input type="checkbox" name="checkbox"><label> Mémoriser mes identifiants</label></input>
                        </div>
                        
                        <div class="infosConnection">
                        <input type="submit" name="submit" value="se Connecter"/>
                        </div>
                    </form>
                
                
              
                    <p>Pas encore inscrit ? </p>
                    <p>
                        <c:url var="pageInscription" value="FrontControleurEspaceClient?section=pageInscription" />
                        <a href="${pageInscription}">Inscrivez-vous ici !</a></p>
                
            </section>
        
    
</body>
</html>
