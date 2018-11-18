<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>

<c:choose>
    <c:when test="${emptyTable == null}">
        <form action="/employees/delete" method="post">
            <table class="table">
                <tr>
                    <th>IMIĘ</th>
                    <th>NAZWISKO</th>
                    <th>ULICA</th>
                    <th>MIASTO</th>
                    <th>TELEFON</th>
                    <th>STAWKA</th>
                    <th>USUŃ</th>
                    <th>EDYTUJ</th>
                </tr>

                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.getName()}</td>
                        <td>${employee.getSurname()}</td>
                        <td>${employee.getStreet()}</td>
                        <td>${employee.getCity()}</td>
                        <td>${employee.getTelephone()}</td>
                        <td>${employee.getHourCost()}</td>
                        <td><input type="checkbox" name="employee_id" value="${employee.getEmployee_id()}"/></td>
                        <td><a href="/employees/update?employee_id=${employee.getEmployee_id()}">EDYCJA</a></td>
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
    Usunięto ${countDel} pracowników.
</c:if>
<c:if test="${edited == 'y'}">
    Pracownik został poprawnie zmodyfikowany.
</c:if>
<c:if test="${edited == 'n'}">
    Błąd, pracownik nie został zmodyfikowany.
</c:if>

<p align="center"><a href="/employees/create">Dopisz pracownika!</a></p>

<%@include file="./../template/footer.jsp" %>