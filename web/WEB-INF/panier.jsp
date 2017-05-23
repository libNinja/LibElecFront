<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | panier</title>
    </head>
    <body>
        <c:url var="url01" value="FrontControleur?section=menu-main" />
        <c:import url="${url01}" />
        <h1>Panier</h1>
        
            <table border ="1">
                <thead>
                    <tr>
                    <th>Reference</th>
                    <th>nom</th>                    
                    <th>quantite</th>
                    <th>prix HT </th>
                </thead>
            </table>
        <br />
        <a href="FrontControleur?section=afficher-nouveauClient"> <input type="submit" name="submit" value="Valider" /></a>
        
    </body>
</html>
