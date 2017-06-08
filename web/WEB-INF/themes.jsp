<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./resources/css/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="headerCommun" value="FrontController?section=menu-main" />
        <c:import url="${headerCommun}" />
        <c:forEach items="${clefs}" var="c">
            <h1>${c}</h1>
            <c:forEach items="${themes.get(c)}" var="t">
                <ul>
                    <c:url var="url01" value="FrontControleur?section=theme-livre-list&theme=${t.theNom}" />
                    <li><a href ="${url01}">${t}</a></li>
                </ul>
            </c:forEach>
        </c:forEach>
        <section id="boxes">
            <div class="container">
                <div class="box">
                </div>

            </div>
        </section>

        <footer>
            <p>Avec LibElec, trouvez votre oeuvre préférée</p>
        </footer>
    </body>
</html>
