<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>

<c:if test="${add == 'y'}">
    <p>Dodano nowy samochód! Wprowadź kolejny.</p>
</c:if>
<c:if test="${add == 'n'}">
    <p>Błąd podczas zapisu. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/vehicles/create" method="post">
    <table>

        <tr>
            <td>Marka:</td>
            <td align="right"><input type="text" name="mark" placeholder="podaj markę"></td>
        </tr>
        <tr>
            <td>Model:</td>
            <td align="right"><input type="text" name="model" placeholder="podaj model"></td>
        </tr>
        <tr>
            <td>Rok produkcji:</td>
            <td align="right"><input type="number" name="yearOfProduction" placeholder="podaj rok produkcji"></td>
        </tr>
        <tr>
            <td>Numer rejestracyjny:</td>
            <td align="right"><input type="text" name="registNumber" placeholder="podaj numer rej."></td>
        </tr>
        <tr>
            <td>Następny przegląd:</td>
            <td align="right"><input type="date" name="nextReview"></td>
        </tr>
        <tr>
            <td>Właściciel:</td>
            <td align="right">
                <select name="client_id">
                    <c:forEach items="${clients}" var="client">
                        <option value="${client.getClient_id()}">${client.getName()} ${client.getSurname()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<br>
<p><a href="/vehicles/list">Powrót do listy samochodów</a></p>

<%@include file="./../template/footer.jsp" %>
