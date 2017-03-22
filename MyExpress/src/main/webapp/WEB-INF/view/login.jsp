<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | MY-Express</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/prettyPhoto.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/price-range.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/images/ico/favicon.ico"/>">
</head>

<body>
<jsp:include page="components/header.jsp"/>

<section id="form">
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form">
                    <h2>Login to your account</h2>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Error!</strong> Invalid login or password:(
                        </div>
                    </c:if>
                    <form action="/login/process" method="post">
                        <label>Email: </label>
                        <input type="text" name="email" size="20" maxlength="50" type="text">
                        <label>Password: </label>
                        <input type="password" name="password" size="20" maxlength="50" type="password">
                        <button type="submit" class="btn btn-default">Login</button>
                    </form>
                    <br>

                    <%--<form action="<c:url value="/login/process"/>" method="post" id="log">--%>
                    <%--<label for="j_username">Email: </label>--%>
                    <%--<input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>--%>

                    <%--<label for="j_password">Password: </label>--%>
                    <%--<input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>--%>

                    <%--<button type="submit" class="btn btn-default">Login</button>--%>
                    <%--</form>--%>
                </div>
            </div>
            <div class="col-sm-1">
                <h2 class="or">OR</h2>
            </div>
            <div class="col-sm-4">
                <div class="signup-form">
                    <h2>New User Signup!</h2>

                    <%--<form action="<c:url value="/register"/>" method="post" id="reg">--%>
                    <%--<input type="text" placeholder="Name" name="name"/>--%>
                    <%--<input type="email" placeholder="Email Address" name="email"/>--%>
                    <%--<input type="password" placeholder="Password" name="password"/>--%>
                    <%--<button type="submit" class="btn btn-default">Signup</button>--%>
                    <%--</form>--%>
                    <% String error = null;
                        if ((error = request.getParameter("regError")) != null) { %>
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> %><%
                        if (error.equals(1)) {%>
                        Invalid registration !
                        <% } else if (error.equals(2)) {%>
                        Login is not allow to use
                        <%}%>
                    </div>

                    <%}%>
                    <sf:form action="/register" method="post" modelAttribute="user">

                        <sf:label path="name">Name: </sf:label> <sf:input path="name" placeholder="Name"/>
                        <sf:errors path="name"/>

                        <sf:label path="email">Login: </sf:label> <sf:input type="email" path="email"
                                                                            placeholder="Email Address"/>
                        <sf:errors path="email"/>
                        <sf:label path="password">Password: </sf:label> <sf:password path="password"
                                                                                     placeholder="Password"/>
                        <sf:errors
                                path="password"/>

                        <button type="submit" class="btn btn-default">Sign up</button>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="components/footer.jsp"/>

</body>
</html>