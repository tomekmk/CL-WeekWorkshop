<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="doc_header.jsp" %>
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="/index">WARSZTAT SAMOCHODOWY</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <%--PRZYCISKI NA GÓRNEJ BELCE: DZWONEK KOPERTA LOGOWANIE--%>
    <!-- Navbar -->
    <%--<ul class="navbar-nav ml-auto ml-md-0">--%>
        <%--<li class="nav-item dropdown no-arrow mx-1">--%>
            <%--<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown"--%>
               <%--aria-haspopup="true" aria-expanded="false">--%>
                <%--<i class="fas fa-bell fa-fw"></i>--%>
                <%--<span class="badge badge-danger">9+</span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
            <%--</div>--%>
        <%--</li>--%>
        <%--<li class="nav-item dropdown no-arrow mx-1">--%>
            <%--<a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown"--%>
               <%--aria-haspopup="true" aria-expanded="false">--%>
                <%--<i class="fas fa-envelope fa-fw"></i>--%>
                <%--<span class="badge badge-danger">7</span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
            <%--</div>--%>
        <%--</li>--%>
        <%--<li class="nav-item dropdown no-arrow">--%>
            <%--<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"--%>
               <%--aria-haspopup="true" aria-expanded="false">--%>
                <%--<i class="fas fa-user-circle fa-fw"></i>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">--%>
                <%--<a class="dropdown-item" href="#">Settings</a>--%>
                <%--<a class="dropdown-item" href="#">Activity Log</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>--%>
            <%--</div>--%>
        <%--</li>--%>
    <%--</ul>--%>
    <%--KONIEC - PRZYCISKI NA GÓRNEJ BELCE: DZWONEK KOPERTA LOGOWANIE--%>

</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/index">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Strona główna</span>
            </a>
        </li>
        <li class="nav-item dropdown show">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="true">
                <i class="fas fa-fw fa-folder"></i>
                <span>Tabele</span>
            </a>
            <div class="dropdown-menu show" aria-labelledby="pagesDropdown">
                <h6 class="dropdown-header">Zarządzaj:</h6>
                <a class="dropdown-item" href="/clients/list">Klienci</a>
                <a class="dropdown-item" href="/vehicles/list">Pojazdy</a>
                <a class="dropdown-item" href="/employees/list">Pracownicy</a>
                <a class="dropdown-item" href="/orders/list">Zlecenia</a>
                <div class="dropdown-divider"></div>
                <%--<h6 class="dropdown-header">Other Pages:</h6>--%>
                <%--<a class="dropdown-item" href="404.html">404 Page</a>--%>
                <%--<a class="dropdown-item active" href="blank.html">Blank Page</a>--%>
            </div>
        </li>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="charts.html">--%>
                <%--<i class="fas fa-fw fa-chart-area"></i>--%>
                <%--<span>Charts</span></a>--%>
        <%--</li>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="tables.html">--%>
                <%--<i class="fas fa-fw fa-table"></i>--%>
                <%--<span>Tables</span></a>--%>
        <%--</li>--%>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="/index">STRONA GŁÓWNA</a>
                </li>
                <li class="breadcrumb-item active">${pageName}</li>
            </ol>