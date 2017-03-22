<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<header id="header">
    <div class="header_top">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> 88005553535</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> better.call@soal.brba</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav"> <!-- прописать ссылки если нужно -->
                            <li><a href="www.facebook.com"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="https://ru.linkedin.com/"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="https://plus.google.com/"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="header-middle">
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="/shop/home"><img src="<c:url value="/resources/images/home/logo.png"/>"/></a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <!-- через secutiry реализовать проверку авторизован ли пользователь -->
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/admin"><i class="fa fa-user-secret"></i> Admin</a></li>
                            </sec:authorize>
                            <li><a href="/shop/cart/"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                                <li><a href="/profile"><i class="fa fa-user"></i> Account</a></li>
                                <li><a href="<c:url value="/logout"/>"><i class="fa fa-lock"></i> Logout</a></li>
                            </sec:authorize>
                            <!-- показывать либо аккаунт либо ссылку на страницу входа -->
                            <sec:authorize access="isAnonymous()">
                                <li><a href="/login"><i class="fa fa-lock"></i> Login/Register</a></li>
                            </sec:authorize>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                </div>
                <div class="col-sm-3">
                    <div class="search_box pull-right">
                        <input disabled type="text" placeholder="In developing:)"/> <!-- пока не реализован -->
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>
