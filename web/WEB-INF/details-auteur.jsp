<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails de l'auteur</title>
    </head>
    <body>
        <c:url var="url01" value="FrontControleur?section=menu-main" />
        <c:import url="${url01}" />
        <div id="container">
            <h1>${auteur.autPrenom} ${auteur.autNom}</h1>
            <div>
                <h5>Nom :</h5> <p> ${auteur.autNom}</p>
                <h5>Prenom :</h5> <p>${auteur.autPrenom}</p>
                <h5>Date de Naissance :</h5> <p>${auteur.autDateNaissance}</p>
                <h5>Biographie :</h5> <p>${auteur.autBio}</p>
            </div>
            <form><input type="button" value="Retour" onClick="history.go(-1);
                return true;"></form>
        </div>
    </body>
</html>
