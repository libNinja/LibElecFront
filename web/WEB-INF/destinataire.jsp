 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Adresse de livraison </title>
    </head>
    <h1>Definir les coordonnees de livraison</h1>
       
    <body>
        <p> Veuillez saisir les coordonnees de livraison</p>  
        <form action='FrontControleur?section=destinataire-insertion' method='POST' accept-charset="UTF-8">
        
            <div class="desInfo">
                <p>Données personnelles</p> 
            </div>
            <div class="desInfo">
                <label> Nom </label>
                <input type='text' name='desNom' />    
            </div>
            <div class="desInfo">
                <label> Prenom </label>
                <input type='text' name='desPrenom'>  
             </div>
             <div class="desInfo">
                <label> Email </label>
                <input type='email' name='desEmail'><br /> 
             </div>
             <div class="desInfo">
                <label> Telephone </label>
                <input type='text' name='desTel'><br /> <br /> 
             </div>
            
            <div class="adrLivraison">
                <p>Adresse de livraison</p> 
            </div>
             <div class="adrLivraison">
                <label> Numero</label>
                <input type='text' name='adrNumVoie'>
            </div>
            <div class="adrLivraison">
                <label> Type et Nom de la voie</label>
                <input type='text' name='adrNomVoie'>
            </div>
            <div class="adrLivraison">
                <label> complement d'adresse</label>
                <input type='text' name='adrNomVoieSuite'>
            </div> 
            <div class="adrLivraison">
                <label> Code postal</label>
                <input type='text' name='adrCp'>
            </div> 
            <div class="adrLivraison">
                <label> Ville</label>
                <input type='text' name='adrVille'>
            </div> 
            <div class="adrLivraison">
                <label> Pays</label>
                <input type='text' name='adrPays'>
            </div>  
        
            <div>
                <input type='hidden' name='section' value='destinataire-insertion'>
                <input type='submit' name='Envoyer' value='Valider' >
            </div>
            
        </form>
    </body>
</html>
