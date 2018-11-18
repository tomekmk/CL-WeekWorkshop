<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>

<c:if test="${add == 'y'}">
    <p>Dodano nowego pracownika!</p>
</c:if>
<c:if test="${add == 'n'}">
    <p>Błąd podczas zapisu. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/employees/create" method="post">
    <table>
        <tr>
            <td colspan="2">
                Wprowadź dane nowego pracownika:
            </td>
        </tr>
        <tr>
            <td>Imię:</td>
            <td align="right"><input type="text" name="name" placeholder="podaj imie"></td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td align="right"><input type="text" name="surname" placeholder="podaj nazwisko"></td>
        </tr>
        <tr>
            <td>Ulica, nr domu:</td>
            <td align="right"><input type="text" name="street" placeholder="podaj adres"></td>
        </tr>
        <tr>
            <td>Miasto:</td>
            <td align="right"><input type="text" name="city" placeholder="podaj miasto"></td>
        </tr>
        <tr>
            <td>Telefon:</td>
            <td align="right"><input type="text" name="telephone" placeholder="podaj telefon"></td>
        </tr>
        <tr>
            <td>Notatka:</td>
            <td align="right"><textarea name="note" cols="25" rows="5" placeholder="wprowadź notatkę dotyczącą pracownika"></textarea></td>
        </tr>
        <tr>
            <td>Stawka godzinowa:</td>
            <td align="right"><input type="number" name="hourCost"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<br>
<p><a href="/employees/list">Powrót do listy pracowników</a></p>

<%@include file="./../template/footer.jsp" %>
