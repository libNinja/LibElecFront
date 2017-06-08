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
        <c:url var="headerCommun" value="FrontControleurEspaceClient?section=menu-main" />
        <c:import url="${headerCommun}" />
        <div class="container" >
        <h1>Bienvenue ${client.cliNom}</h1>
        
        
        <div id="commandeEnCours">
            <c:url var="commandeEnCours" value="FrontControleurEspaceClient?section=commandeEnCours" /><a href="${ commandeEnCours }">Commande en cours</a>
        </div>
        
        <div id="historiqueAchats">
            <c:url var="historiqueDesAchats" value="FrontControleurEspaceClient?section=historiqueDesAchats" /><a href="${ historiqueDesAchats }">Historique des achats</a>
        </div>
        
        <div id="informationsPersonnelles">
            <c:url var="informationsPersonnelles" value="FrontControleurEspaceClient?section=informationsPersonnelles" /><a href="${ informationsPersonnelles }">Informations personnelles</a>
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
