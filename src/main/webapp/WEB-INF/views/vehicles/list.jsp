<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>

<c:choose>
    <c:when test="${emptyTable == null}">
        <form action="/vehicles/delete" method="post">
            <table class="table">
                <tr>
                    <th>MARKA</th>
                    <th>MODEL</th>
                    <th>ROK PROD.</th>
                    <th>NR REJ.</th>
                    <th>PRZEGLĄD</th>
                    <th>KLIENT</th>
                    <th>USUŃ</th>
                    <th>EDYTUJ</th>
                </tr>

                <c:forEach items="${vehicles}" var="vehicle">

                    <tr>
                        <td>${vehicle.getMark()}</td>
                        <td>${vehicle.getModel()}</td>
                        <td>${vehicle.getYearOfProduction()}</td>
                        <td>${vehicle.getRegistNumber()}</td>
                        <td>${vehicle.getNextReview()}</td>
                        <td>${vehicle.getClient().getName()} ${vehicle.getClient().getSurname()}</td>
                        <td><input type="checkbox" name="vehicle_id" value="${vehicle.getVehicle_id()}"/></td>
                        <td><a href="/vehicles/update?vehicle_id=${vehicle.getVehicle_id()}">EDYTUJ</a></td>
                    </tr>

                </c:forEach>

                <tr>
                    <td colspan="7" align="right"><input type="submit" value="usuń zaznaczone"></td>
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
    Usunięto ${countDel} samochodów.
</c:if>
<c:if test="${edited == 'y'}">
    Samochód został poprawnie zmodyfikowany.
</c:if>
<c:if test="${edited == 'n'}">
    Błąd, samochód nie został zmodyfikowany.
</c:if>

<p align="center"><a href="/vehicles/create">Dopisz samochód!</a></p>

<%@include file="./../template/footer.jsp" %>