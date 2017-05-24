<%-- 
    Document   : menu-main
    Created on : 17 mai 2017, 15:07:25
    Author     : cdi205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<p>
    <c:url var="url01" value="FrontControleur" />
    <c:url var="url02" value="FrontControleur?section=themes" />
    <a href="${url01}">Home</a> | <a href="${url02}">Catalogue</a>
</p>
<hr />
