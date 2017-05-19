<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>catalogue</title>
    </head>
    <body>
        <c:url var="url01" value="FrontControleur?section=menu-main" />
        <c:import url="${url01}" />
        <h1>catalogue</h1>
        <table border="1">
            <thread>
                <tr>
                    <th>isbn</th>
                    <th>EdiId</th>
                    <th>TvaId</th>
                    <th>ProId</th>
                    <th>OuvNom</th>
                    <th>LivEdition</th>
                    <th>LivDateEdition</th>
                    <th>LivResume</th>
                    <th>LivStock</th>
                    <th>LivImage</th>
                    <th>LivSousTitre</th>
                    <th>LivStatut</th>
                    <th>LivChampLivre</th>
                    <th>LivPrix</th>
                    <th>action</th>
                </tr>
            </thread>
            <tbody>
                <c:forEach items="${livres}" var="l">
                    <tr>
                        <td>${l.isbn}</td>
                        <td>${l.ediId}</td>
                        <td>${l.tvaId}</td>
                        <td>${l.proId}</td>
                        <td>${l.ouvNom}</td>
                        <td>${l.livEdition}</td>
                        <td>${l.livDateEdition}</td>
                        <td>${l.livResume}</td>
                        <td>${l.livStock}</td>
                        <td>${l.livImage}</td>
                        <td>${l.livSousTitre}</td>
                        <td>${l.livStatut}</td>
                        <td>${l.livChampLibre}</td>
                        <td>
                            <fmt:formatNumber value="${l.livPrix}" minFractionDigits="2" maxFractionDigits="2" minIntegerDigits="1" /> €
                        </td>
                        <td>
                            <c:url var="url10" value="FrontControleur?section=operation-panier&origine=catalogue&action=add&ref=${l.isbn}" /> 
                            <a href="${url10}">aj.panier</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
