<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./../template/header.jsp" %>
<c:if test="${edited == 'n'}">
    <p>Błąd podczas edycji. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/employees/update" method="post">
    <table>
        <tr>
            <td colspan="2">Edytuj dane pracownika:</td>
        <tr>
            <td>Imię:</td>
            <td align="right"><input type="text" name="name" value="${employee.getName()}"/></td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td align="right"><input type="text" name="surname" value="${employee.getSurname()}"/></td>
        <tr>
            <td>Ulica, nr domu:</td>
            <td align="right"><input type="text" name="street" value="${employee.getStreet()}"/></td>
        <tr>
            <td>Miasto</td>
            <td align="right"><input type="text" name="city" value="${employee.getCity()}"/></td>

        <tr>
            <td>Telefon:</td>
            <td align="right"><input type="text" name="telephone" value="${employee.getTelephone()}"/></td>
        <tr>
            <td>Notatka:</td>
            <td align="right">
                <textarea name="note" cols="25" rows="5">${employee.getNote()}</textarea>
            </td>
        <tr>
            <td>Stawka godzinowa:</td>
            <td align="right"><input type="number" name="hourCost" value="${employee.getHourCost()}"/></td>
        <tr>
            <td><a href="/employees/delete?employee_id=${employee.getEmployee_id()}">Usuń tego pracownika</a></td>
            <td align="right">
                <input type="hidden" name="employee_id" value="${employee.getEmployee_id()}"/>
                <input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<%@include file="./../template/footer.jsp" %>