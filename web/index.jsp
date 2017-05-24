<%-- 
    Document   : index
    Created on : 16 mai 2017, 13:09:44
    Author     : cdi205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="url01" value="FrontControleur?section=menu-main" />
<c:url var="url02" value="FrontControleur?section=recherche" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="${url01}" />
        <c:import url="${url02}" />
    </body>
</html>