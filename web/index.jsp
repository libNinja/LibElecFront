<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="fc" value="FrontController" />

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LibElec | Bienvenue</title>
        <link rel="stylesheet" href="./resources/css/style.css" />
    </head>

    <body>

        <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />

        <section id="showcase">
            <div>

                <h3>Victor<strong> Hugo</strong></h3>
                <p>“On passe une moitié de sa vie à attendre ceux qu’on aimera et l’autre moitié à quitter ceux qu’on aime.”</p>
            </div>
        </section>

        <section id="newsletter">
            <div class="container">
                <h1>Rechercher un livre : </h1>
                <form action="FrontControleur" method="GET">
                    <input name="recherche" type="text" placeholder="Entrez votre recherche...">
                    <button name="valider" value="Ok" type="submit" class="button_1">Rechercher</button>
                    <c:url var ="url1" value="FrontControleur?section=recherche-avancee" />
                <a href ="${url1}">Recherche avancée</a>
                </form>
             </div>
             
        </section>

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





</body>
</html>


