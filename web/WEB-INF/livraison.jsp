 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Livraison</title>
    </head>
        <c:url var="url01" value="FrontController?section=menu-main" />
        <c:import url="${url01}" />
        <h1>Livraison</h1>
       
    <body>
        
        <form action='FrontControler?section=livraison-enregistre' method='POST' accept-charset="UTF-8">
        
           
            <div class="adrLivraison">
                <p>Adresse de livraison</p> 
            </div>
             <div class="adrLivraison">
                <label> Numero</label> <input type='text' name='adrNumVoie'>
            </div>
            <div class="adrLivraison">
                <label> Type et Nom de la voie</label> <input type='text' name='adrNomVoie'>
            </div>
            <div class="adrLivraison">
                <label> complement d'adresse</label> <input type='text' name='adrNomVoieSuite'>
            </div> 
            <div class="adrLivraison">
                <label> Code postal</label> <input type='text' name='adrCp'>
            </div> 
            <div class="adrLivraison">
                <label> Ville</label> <input type='text' name='adrVille'>
            </div> 
            <div class="adrLivraison">
                <label> Pays</label> <input type='text' name='adrPays'>
            </div>  
        
             <div class="desInfo">
                <p>Destinataire de la livraison</p> 
            </div>
            <div class="desInfo">
                <label> Nom </label> <input type='text' name='desNom' />    
            </div>
            <div class="desInfo">
                <label> Prenom </label> <input type='text' name='desPrenom'>  
             </div>
             <div class="desInfo">
                <label> Email </label> <input type='email' name='desEmail'><br /> 
             </div>
             <div class="desInfo">
                <label> Telephone </label> <input type='text' name='desTel'><br /> <br /> 
             </div>
            
            <%--
            <div>
                <input type='hidden' name='section' value='livraison-enregistre'>
                <input type='submit' name='Envoyer' value='Valider' >
            </div>
            --%>
        </form>
        
        <a href="FrontControler?section=afficher-nouveauClient"> <input type="submit" name="submit" value="precedent" /></a>
        <a href="FrontControler?section=afficher-recap"> <input type="submit" name="recap" value="Valider" /></a>
    </body>
</html>