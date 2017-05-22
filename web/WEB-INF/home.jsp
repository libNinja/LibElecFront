<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>LIB ELEC</title>
    </head>
    <body>
        <h1>LibElec vous souhaite la bienvenue!</h1>
        <c:url var="url01" value="FrontControleur?section=menu-main" />
        <c:import url="${url01}" />
    </body>
</html>
