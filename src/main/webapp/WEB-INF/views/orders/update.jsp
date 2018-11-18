<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./../template/header.jsp" %>
<c:if test="${edited == 'n'}">
    <p>Błąd podczas edycji. Czy wpisałeś wszystko poprawnie?</p>
</c:if>

<form action="/orders/update" method="post">
    <table>
        <tr>
            <td colspan="2">Edytuj dane zlecenia:</td>
        </tr>
        <tr>
            <td>Data akceptacji zlecenia:</td>
            <td align="right"><input type="date" name="acceptDate" value="${order.getAcceptDate()}"></td>
        </tr>
        <tr>
            <td>Data planowanego rozpoczęcia:</td>
            <td align="right"><input type="date" name="plannedDate" value="${order.getPlannedDate()}"></td>
        </tr>
        <tr>
            <td>Data rozpoczęcia zlecenia:</td>
            <td align="right"><input type="date" name="startDate" value="${order.getStartDate()}"></td>
        </tr>
        <tr>
            <td>Pracownik wykonujący:</td>
            <td align="right"><select name="employee_id">
                <c:forEach items="${employees}" var="employee">
                    <option value="${employee.getEmployee_id()}"
                    <c:if test="${employee.getEmployee_id() == order.getEmployee().getEmployee_id()}"> selected </c:if>
                    >${employee.getName()} ${employee.getSurname()}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Opis problemu:</td>
            <td align="right"><textarea name="problemDesc" cols="25" rows="5">${order.getProblemDesc()}</textarea></td>
        </tr>
        <tr>
            <td>Opis naprawy:</td>
            <td align="right"><textarea name="repairDesc" cols="25" rows="5">${order.getRepairDesc()}</textarea></td>
        </tr>
        <tr>
            <td>Status naprawy:</td>
            <td align="right"><select name="status">
                <option value="1" <c:if test="${order.getStatus() == '1'}"> selected </c:if>>Przyjęty</option>
                <option value="2" <c:if test="${order.getStatus() == '2'}"> selected </c:if>>Zatwierdzony</option>
                <option value="3" <c:if test="${order.getStatus() == '3'}"> selected </c:if>>W naprawie</option>
                <option value="4" <c:if test="${order.getStatus() == '4'}"> selected </c:if>>Gotowy do odbioru</option>
                <option value="5" <c:if test="${order.getStatus() == '5'}"> selected </c:if>>Rezygnacja</option>
            </select></td>
        </tr>
        <tr>
            <td>Naprawiany samochód:</td>
            <td align="right"><select name="vehicle_id">
                <c:forEach items="${vehicles}" var="vehicle">
                    <option value="${vehicle.getVehicle_id()}"
                    <c:if test="${vehicle.getVehicle_id() == order.getVehicle().getVehicle_id()}"> selected </c:if>
                    >${vehicle.getMark()} ${vehicle.getModel()} ${vehicle.getRegistNumber()}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Całkowity koszt klienta:</td>
            <td align="right"><input type="number" name="clientCost" value="${order.getClientCost()}"></td>
        </tr>
        <tr>
            <td>Koszt części:</td>
            <td align="right"><input type="number" name="partCost" value="${order.getPartCost()}"></td>
        </tr>
        <tr>
            <td>Koszt roboczogodzin:</td>
            <td align="right"><input type="number" name="hoursCost" value="${order.getHoursCost()}"></td>
        </tr>
        <tr>
            <td><a href="/orders/delete?order_id=${order.getOrder_id()}">Usuń to zlecenie</a></td>
            <td align="right"><input type="hidden" name="order_id" value="${order.getOrder_id()}"/>
                <input type="submit" value="Zatwierdź"></td>
        </tr>
    </table>
</form>

<%@include file="./../template/footer.jsp" %>
