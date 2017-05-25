<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<header>
    <div class="container">
        <div id="branding">
            <h1><span class="highlight">LibElec</span> Votre librairie electronique</h1>
        </div>
                    
        <nav>
            <ul>
                <li class="current"><c:url var="acceuil" value="FrontControleur?section=home" /><a href="${acceuil}">Acceuil</a></li>
                <li><c:url var="catalogue" value="FrontControleur?section=catalogue" /><a href="${catalogue}">Catalogue</a></li>
                <li><c:url var="espacePersonnel" value="FrontControleur?section=espacePersonnel" /><a href="${espacePersonnel}">Espace Personnel</a></li>
            </ul>
        </nav>
    </div>
</header>
            