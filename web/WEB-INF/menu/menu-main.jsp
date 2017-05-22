<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<p>
    <c:url var="url01" value="FrontControleur" />
    <c:url var="url03" value="FrontControleur?section=afficher-panier" />
    <a href="${url01}">home</a> | | <a href="${url03}">panier </a>
</p>
<hr />
