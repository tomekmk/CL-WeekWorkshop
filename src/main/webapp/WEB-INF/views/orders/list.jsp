<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./../template/header.jsp" %>

<c:choose>
    <c:when test="${emptyTable == null}">
        <form action="/orders/delete" method="post">
            <table class="table">
                <tr>
                    <th>DATA ROZP.</th>
                    <th>PRACOWNIK</th>
                    <th>SAMOCHÓD</th>
                    <th>STATUS</th>
                    <th>KOSZT</th>
                    <th>USUŃ</th>
                    <th>EDYTUJ</th>
                </tr>

                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.getAcceptDate()}</td>
                        <td>${order.getEmployee().getName()} ${order.getEmployee().getSurname()}</td>
                        <td>${order.getVehicle().getMark()} ${order.getVehicle().getModel()}</td>
                        <td>
                            <c:if test="${order.getStatus() == '1'}">Przyjęty</c:if>
                            <c:if test="${order.getStatus() == '2'}">Zatwierdzony</c:if>
                            <c:if test="${order.getStatus() == '3'}">W naprawie</c:if>
                            <c:if test="${order.getStatus() == '4'}">Gotowy do odbioru</c:if>
                            <c:if test="${order.getStatus() == '5'}">Rezygnacja</c:if>
                        </td>
                        <td>${order.getClientCost()}</td>
                        <td><input type="checkbox" name="order_id" value="${order.getOrder_id()}"/></td>
                        <td><a href="/orders/update?order_id=${order.getOrder_id()}">EDYCJA</a></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="6" align="right"><input type="submit" value="usuń zaznaczone"></td>
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
    Usunięto ${countDel} zleceń.
</c:if>
<c:if test="${edited == 'y'}">
    Zlecenie zostało poprawnie zmodyfikowane.
</c:if>
<c:if test="${edited == 'n'}">
    Błąd, zlecenie nie zostało zmodyfikowane.
</c:if>

<p align="center"><a href="/orders/create">Dopisz zlecenie!</a></p>

<%@include file="./../template/footer.jsp" %>