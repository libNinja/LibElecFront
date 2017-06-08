<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />
        <c:url var="url250" value="${livre.livImage}" />
        <h1>${livre.ouvNom}</h1>
        <h2>${livre.livSousTitre}</h2>
        <div>
            <img src ="${url250}" />
            <h5>Résumé :</h5> <p> ${livre.livResume}</p>
            <h5>Date d'édition :</h5> <p>${livre.livDateEdition}</p>
            <h5>Edition :</h5> <p>${livre.livEdition}</p>
            <h5>Auteur(s) :</h5> <p> <c:forEach items="${auteurs}" var="a">
                    <c:url var="url3" value="FrontControleur?section=details-auteur&auteur=${a.autId}" />
                    <a href = "${url3}">${a}</a>
                </c:forEach></p>

            <h5> Prix : </h5> <p>  ${livre.livPrix} <c:if test = "${p.proStatut == 1}" > En promotion ! -${p.proReduction}% soit ${livre.livPrix - livre.livPrix * (1 / p.proReduction) } </c:if></p>
        </div> 
        <form><input type="button" value="Retour" onClick="history.go(-1);
                return true;"></form>
        <section id="boxes">
            <div class="container">
                <div class="box">
                </div>

            </div>
        </section>

        <footer>
            <p>Avec LibElec, trouvez votre oeuvre préférée</p>
        </footer>
    </body>
</html>
