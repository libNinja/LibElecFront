<%-- 
    Document   : espacePersonnel
    Created on : 16 mai 2017, 15:18:24
    Author     : cdi213
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Espace Personnel</title>
    </head>
    <body>
        <c:url var="headerCommun" value="FrontControleur?section=menu-main" />
        <c:import url="${headerCommun}" />
        <div class="container" >
        <h1>Bienvenue ${client.cliNom}</h1>
        
        <div id="historiqueCommandes">
            <p>Commande en cours</p>
            <p>Historique des achats</p>
            <p>Informations Personnelles</p>
        </div>
        </div>
        
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
