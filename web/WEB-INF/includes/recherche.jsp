<%-- 
    Document   : recherche
    Created on : 16 mai 2017, 11:38:54
    Author     : cdi205
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<form action="FrontControleur" method="GET">
    <input type="text" name="recherche">
    <input type="submit" name="valider" value="Ok">
</form>
<c:url var ="url1" value="FrontControleur?section=recherche-avancee" />
<a href ="${url1}">Recherche avancée</a>
<hr />
