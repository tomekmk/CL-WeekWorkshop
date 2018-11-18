<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="WEB-INF/views/template/header.jsp"%>

<center>
<p><h1>W naszym warsztacie mamy:</h1></p>
    <p><h5>${clients} wkurwionych klientów!</h5></p>
    <p><h5>${employees} biednych pracowników!</h5></p>
    <p><h5>${vehicles} zepsutych samochodów!</h5></p>
    <p><h5>${orders} odniesionych porażek!</h5></p>

    <br>
    <p>
        //TODO:<br>
        powiadomienia email<br>
        rezerwacja klienta na wizyty serwisowe<br>
        przeglądanie wszystkich zleceń danego pracownika<br>
        przeglądanie aktualnych zleceń danego pracownika<br>
        zamienić EDYCJA na SZCZEGÓŁY<br>
        życzenia urodzinowe dla klientów<br>
        niepozwalać na dodawanie pustych komórek<br>
        koszt roboczogodziny w tabeli orders<br>
        wyszukiwanie klienta po nazwisku<br>
        przeglądanie pojazdów danego klienta<br>
        przeglądanie historii konkretnego pojazdu (data rozp. i opis)<br>
        ...do tego przejście do szczegółów zlecenia ze wszystkimi danymi<br>
        strona główna: aktualnie prowadzone naprawy<br>
        raporty
    </p>
</center>

<%@include file="WEB-INF/views/template/footer.jsp"%>