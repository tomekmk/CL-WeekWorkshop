<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./../template/header.jsp" %>

<c:choose>
    <c:when test="${emptyTable == null}">
        <form action="/clients/delete" method="post">
            <table class="table">
                <tr>
                    <th>IMIĘ</th>
                    <th>NAZWISKO</th>
                    <th>DATA URODZENIA</th>
                    <th>USUŃ</th>
                    <th>EDYTUJ</th>
                </tr>

                <c:forEach items="${clients}" var="client">
                    <tr>
                        <td>${client.getName()}</td>
                        <td>${client.getSurname()}</td>
                        <td>${client.getDateOfBirth()}</td>
                        <td><input type="checkbox" name="client_id" value="${client.getClient_id()}"/></td>
                        <td><a href="/clients/update?client_id=${client.getClient_id()}">EDYCJA</a></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="4" align="right"><input type="submit" value="usuń zaznaczone"></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </c:when>
    <c:otherwise>
        <p align="center">Brak wyników</p>
    </c:otherwise>
</c:choose>

<c:if test="${countDel != null}">
    Usunięto ${countDel} klientów.
</c:if>
<c:if test="${edited == 'y'}">
    Klient został poprawnie zmodyfikowany.
</c:if>
<c:if test="${edited == 'n'}">
    Błąd, klient nie został poprawnie zmodyfikowany.
</c:if>

<p align="center"><a href="/clients/create">Dopisz kogoś!</a></p>

<%@include file="./../template/footer.jsp" %>