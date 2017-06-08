<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="./res/css/stylePanier.css" />
        <title>panier</title>        
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="container">
                    <c:url var="url01" value="FrontControlleur?section=menu-main" />
                    <c:import url="${url01}" />
                    <h1>Votre panier</h1>
                    <c:if test="${empty panier}">
                        <p>Votre panier est vide</p>
                    </c:if>
                    <c:if test="${not empty panier}">
                        <table class="table table-striped">
                            <thread>
                                <tr>
                                    <th>ISBN</th>
                                    <th>Titre</th>
                                    <th>Date d'édition</th>
                                    <th>Stock</th>                    
                                    <th>Qté commandée</th>
                                    <th>Reduction</th>
                                    <th>Prix HT</th>
                                    <th>Prix HT Unitaire</th>                                   

                                    <th>Modifier Panier</th>
                                </tr>
                            </thread>
                            <tbody>
                                <c:forEach items="${panier}" var="l">
                                    <tr>
                                        <td>${l.livre.isbn}</td>
                                        <td>${l.livre.ouvNom}</td>
                                        <td>${l.livre.livDateEdition}</td>
                                        <td>${l.livre.livStock}</td>                                        
                                        <td>${l.qte}</td>

                                        <td>
                                            <fmt:formatNumber value="${l.proReduction}" minFractionDigits="2" maxFractionDigits="2" minIntegerDigits="1" /> €
                                        </td>                                        
                                        <td>
                                            <fmt:formatNumber value="${l.livPrix}" minFractionDigits="2" maxFractionDigits="2" minIntegerDigits="1" /> €
                                        </td>
                                        <td>                           
                                            <fmt:formatNumber value="${l.livre.livPrix}" minFractionDigits="2" maxFractionDigits="2" minIntegerDigits="1" /> €
                                        </td>    


                                        <td>
                                            <c:url var="url10" value="FrontControlleur?section=operation-panier&origine=detail-panier&action=add&ref=${l.livre.isbn}" /> 
                                            <a href="${url10}"> +1 </a>
                                            <c:url var="url10" value="FrontControlleur?section=operation-panier&origine=detail-panier&action=delete&ref=${l.livre.isbn}" /> 
                                            | <a href="${url10}"> -1 </a>
                                            <c:url var="url10" value="FrontControlleur?section=operation-panier&origine=detail-panier&action=clear&ref=${l.livre.isbn}" /> 
                                            | <a href="${url10}"> x </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="14">total HT</td>
                                    <td><fmt:formatNumber value="${totalHT}" minFractionDigits="2" maxFractionDigits="2" minIntegerDigits="1" /> €
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </c:if>                  
                    <a href=FrontControler?section=afficher-nouveauClient><input id="Valider_Commande" type="submit" value="Valider_Commande" name="Valider_Commande" /></a>           
                </div>
            </div>
        </nav>
    </body>
</html>
