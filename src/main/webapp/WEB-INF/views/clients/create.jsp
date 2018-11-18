<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./../template/header.jsp" %>

<c:if test="${add == 'y'}">
    <p>Dodano nowego klienta! Wprowadź kolejnego.</p>
</c:if>
<c:if test="${add == 'n'}">
    <p>Błąd podczas zapisu. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/clients/create" method="post">
    <table>
        <tr>
            <td colspan="2">
                Wprowadź dane nowego klienta:
            </td>
        </tr>
        <tr>
            <td>Imię:</td>
            <td align="right"><input type="text" name="name" placeholder="podaj imię"/></td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td align="right"><input type="text" name="surname" placeholder="podaj nazwisko"/></td>
        </tr>
        <tr>
            <td>Data urodzenia:</td>
            <td align="right"><input type="date" name="dateOfBirth""/></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<br><p><a href="/clients/list">Powrót do listy klientów</a></p>

<%@include file="./../template/footer.jsp" %>
