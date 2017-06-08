<%-- 
    Document   : recherche-avancee
    Created on : 18 mai 2017, 13:56:41
    Author     : cdi205
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div id="container">
            <c:url var="url02" value="FrontControleur" />
            <form action="${url02}" method="GET">          
                <div><label>Titre :</label><input type="text" name="titre"></div><br />
                <div><label>ISBN :</label><input type="text" name="isbn"></div><br />
                <div><label>Auteur :</label><input type="text" name="auteur"></div><br />
                <input type="hidden" name ="section" value = "recherche-avancee" />
                <input type="submit" name="rechercheAvancee" value="Rechercher">
            </form>
        </div>
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