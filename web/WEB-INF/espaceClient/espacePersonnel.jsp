<%-- 
    Document   : espacePersonnel
    Created on : 16 mai 2017, 15:18:24
    Author     : cdi213
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="./resources/css/style.css" />
        <title>LibElec | Espace Personnel</title>
    </head>
    <body>
         <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />
        
        <h1>Bienvenue M ${client.cliNom}</h1>
        
        
        
    </body>
</html>
