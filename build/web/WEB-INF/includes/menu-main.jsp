<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<p>
    <c:url var="url01" value="FrontControleur" />
    <c:url var="url02" value="FrontControleur?section=affichage-catalogue" />
    <c:url var="url03" value="FrontControleur?section=affichage-panier" />
    <a href="${url01}">home</a> | <a href="${url02}">catalogue</a> | <a href="${url03}">panier (${infoPanier}) </a>
</p>
<hr />
