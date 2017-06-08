<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Informations Personnelles</title>
    </head>
    <body>
        <c:url var="headerCommun" value="FrontControleurEspaceClient?section=menu-main" />
        <c:import url="${ headerCommun }" />
        
        <div class="infosClient">
            <p>Nom <c:out value="${ client.cliNom }" /></p>
        </div>
        
        <div class="infosClient">
            <p>Prenom <c:out value="${ client.cliPrenom }" /></p>
        </div>
        
        <div class="infosClient">
            <p>Email <c:out value="${ client.cliEmail }" /></p>
        </div>
        
        <div class="infosClient">
            <p>Mot de passe <c:out value="${ client.cliMdp }" /></p>
        </div>
        
        
    </body>
</html>
