<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./../template/header.jsp" %>

<c:if test="${add == 'y'}">
    <p>Dodano nowe zlecenie! Wprowadź kolejne i rób hajs</p>
</c:if>
<c:if test="${add == 'n'}">
    <p>Błąd podczas zapisu. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/orders/create" method="post">
    <table>
        <tr>
            <td colspan="2">
                Wprowadź dane nowego zlecenia:
            </td>
        </tr>
        <tr>
            <td>Data akceptacji zlecenia:</td>
            <td align="right"><input type="date" name="acceptDate"></td>
        </tr>
        <tr>
            <td>Data planowanego rozpoczęcia:</td>
            <td align="right"><input type="date" name="plannedDate"></td>
        </tr>
        <tr>
            <td>Data rozpoczęcia zlecenia:</td>
            <td align="right"><input type="date" name="startDate"></td>
        </tr>
        <tr>
            <td>Pracownik wykonujący:</td>
            <td align="right">
                <select name="employee_id">
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.getEmployee_id()}">${employee.getName()} ${employee.getSurname()}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td>Opis problemu:</td>
            <td align="right"><textarea name="problemDesc" cols="25" rows="5" placeholder="wprowadź tutaj opis usterki"></textarea></td>
        </tr>
        <tr>
            <td>Opis naprawy:</td>
            <td align="right"><textarea name="repairDesc" cols="25" rows="5" placeholder="wprowadź tutaj opis naprawy"></textarea></td>
        </tr>
        <tr>
            <td>Status naprawy:</td>
            <td align="right">
                <select name="status">
                    <option value="1">Przyjęty</option>
                    <option value="2">Zatwierdzony</option>
                    <option value="3">W naprawie</option>
                    <option value="4">Gotowy do odbioru</option>
                    <option value="5">Rezygnacja</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Naprawiany samochód:</td>
            <td align="right">
                <select name="vehicle_id">
                    <c:forEach items="${vehicles}" var="vehicle">
                        <option value="${vehicle.getVehicle_id()}">${vehicle.getMark()} ${vehicle.getModel()} ${vehicle.getRegistNumber()}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td>Całkowity koszt klienta:</td>
            <td align="right"><input type="number" name="clientCost" placeholder="clientCost"></td>
        </tr>
        <tr>
            <td>Koszt części:</td>
            <td align="right"><input type="number" name="partCost" placeholder="partCost"></td>
        </tr>
        <tr>
            <td>Koszt roboczogodzin:</td>
            <td align="right"><input type="number" name="hoursCost" placeholder="hoursCost"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<br>
<p><a href="/orders/list">Powrót do listy zleceń</a></p>

<%@include file="./../template/footer.jsp" %>