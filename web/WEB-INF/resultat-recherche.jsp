<%-- 
    Document   : resultat-recherche
    Created on : 16 mai 2017, 14:57:28
    Author     : cdi205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Résultat</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Reference</th>
                    <th>nom</th>
                    <th>prix HT</th>
                    <th>action</th>
                </tr>
            </thead>
            <c:forEach items="${catalogue}" var="cata">
                <tbody>
                    <c:forEach items="${cata.value}" var="c">
                        <tr>
                            <c:url var="url250" value="FrontControleur?section=details-livre&ref=${c.isbn}&origine=recherche" /> 

                            <td><a href="${url250}">${c.isbn}</a></td>
                            <td><a href="${url250}">${c.ouvNom}</a></td>
                            <td>
                                <fmt:formatNumber value="${c.livPrix}" minFractionDigits="0" maxFractionDigits="2" minIntegerDigits="1" /> €
                            </td>
                            <td>

                                <a href="#">aj. panier</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:forEach var="i" begin="1" end="${cata.key}" >
                <c:url var="urlpage" value="FrontControleur?${url}&page=${i}" />
                <a href="${urlpage}">${i}</a>
            </c:forEach>
        </c:forEach>
    </body>
</html>
