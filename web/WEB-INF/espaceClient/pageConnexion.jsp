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
        <c:url var="headerCommun" value="FrontControleur?section=menu-main" />
        <c:import url="${headerCommun}" />
        
        <h1>Connexion</h1>
        
        <div id="loger">
            <form action="FrontControleur" method="POST">
                <input type="email" name="email" placeHolder="Entrez votre Email..." />
                <input type="password" name="password" placeHolder="Mot de passe"/>
                <input type="checkbox" name="checkbox" value="Mémoriser mes identifiants" />
                <input type="submit" name="seConnecter" />
            </form>
        </div>
    
        <div>
            <p>Pas encore inscrit ? </p>
            <p>
            <c:url var="pageInscription" value="FrontControleur?section=pageInscription" />
            <a href="${pageInscription}">Inscrivez-vous ici !</a></p>



        
    </body>
</html>
