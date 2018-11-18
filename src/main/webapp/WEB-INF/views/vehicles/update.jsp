<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>
<c:if test="${edited == 'n'}">
    <p>Błąd podczas edycji. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/vehicles/update" method="post">
    <table>
        <tr>
            <td>Marka:</td>
            <td align="right"><input type="text" name="mark" value="${vehicle.getMark()}"></td>
        </tr>
        <tr>
            <td>Model:</td>
            <td align="right"><input type="text" name="model" value="${vehicle.getModel()}"></td>
        </tr>
        <tr>
            <td>Rok produkcji:</td>
            <td align="right"><input type="number" name="yearOfProduction" value="${vehicle.getYearOfProduction()}">
            </td>
        </tr>
        <tr>
            <td>Numer rejestracyjny:</td>
            <td align="right"><input type="text" name="registNumber" value="${vehicle.getRegistNumber()}"></td>
        </tr>
        <tr>
            <td>Następny przegląd:</td>
            <td align="right"><input type="date" name="nextReview" value="${vehicle.getNextReview()}"></td>
        </tr>
        <tr>
            <td>Właściciel:</td>
            <td align="right">
                <select name="client_id">
                    <c:forEach items="${clients}" var="client">
                        <option value="${client.getClient_id()}"
                                <c:if test="${client.getClient_id() == vehicle.getClient().getClient_id()}">selected</c:if>>
                                ${client.getName()} ${client.getSurname()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td><a href="/vehicles/delete?vehicle_id=${vehicle.getVehicle_id()}">Usuń ten samochód</a></td>
            <td align="right">
                <input type="hidden" name="vehicle_id" value="${vehicle.getVehicle_id()}"/>
                <input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<%@include file="./../template/footer.jsp" %>
