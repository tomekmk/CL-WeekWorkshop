<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>
<c:if test="${edited == 'n'}">
    <p>Błąd podczas edycji. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/clients/update" method="post">
    <table>
        <tr>
            <td colspan="2">
                Edytuj dane klienta:
            </td>
        </tr>

        <tr>
            <td>Imię:</td>
            <td align="right"><input type="text" name="name" value="${client.getName()}"/></td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td align="right"><input type="text" name="surname" value="${client.getSurname()}"/></td>
        </tr>
        <tr>
            <td>Data urodzenia:</td>
            <td align="right"><input type="date" name="dateOfBirth" value="${client.getDateOfBirth()}"/></td>
        </tr>
        <tr>
            <td><a href="/clients/delete?client_id=${client.getClient_id()}">Usuń tego klienta</a></td>
            <td align="right"><input type="hidden" name="client_id" value="${client.getClient_id()}"/>
                <input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<br><p><a href="/clients/list">Powrót do listy klientów</a></p>

<%@include file="./../template/footer.jsp" %>