<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="fc" value="FrontControleur" />

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LibElec | Bienvenue</title>
        <link rel="stylesheet" href="./resources/css/style.css" />
    </head>
    
    <body>
        
        <c:url var="headerCommun" value="FrontControleur?section=menu-main" />
        <c:import url="${headerCommun}" />
            
        <section id="showcase">
            <div>
                
                <h3>Victor<strong> Hugo</strong></h3>
                <p>“On passe une moitié de sa vie à attendre ceux qu’on aimera et l’autre moitié à quitter ceux qu’on aime.”</p>
            </div>
        </section>
                    
                    <section id="newsletter">
                        <div class="container">
                            <h1>Inscrivez-vous pour recevoir des promotions</h1>
                            <form>
                                <input type="email" placeholder="Entrez votre Email...">
                                <button type="submit" class="button_1">S'inscrire</button>
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
            
            
                        
                        
                        
   

