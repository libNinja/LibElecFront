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
        <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />
        
        <h1>Connexion</h1>
        
        <section id="panLogger">
            <p class="clientInconnu">${clientInconnu}</p>
            <p class="clientInconnu">${emailVide}</p>
        <div id="loger">
            <form action="FrontController" method="POST">
                <input type="email" name="email" placeHolder="Entrez votre Email..." />
                <input type="password" name="password" placeHolder="Mot de passe"/>
                <input type="checkbox" name="checkbox" value="Mémoriser mes identifiants" />
                <input type="submit" name="submit" value="se Connecter"/>
            </form>
        </div>
    
        <div>
            <p>Pas encore inscrit ? </p>
            <p>
            <c:url var="pageInscription" value="FrontController?section=pageInscription" />
            <a href="${pageInscription}">Inscrivez-vous ici !</a></p>
            </div>
    </section>

        
    </body>
</html>
