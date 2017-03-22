<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | MY-Express</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/prettyPhoto.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/price-range.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/images/ico/favicon.ico"/>">
</head>
<!--/head-->

<body>
<jsp:include page="components/header.jsp"/>


<!--/#cart_items-->

<section id="do_action">
    <div class="container">

        <div class="row">
            <% String error = null;
                if ((error = request.getParameter("empty_basket")) != null) { %>
            <div class="alert alert-warning">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong>
                Basket was empty !
                <br>
                <a href="/shop/home" class="btn-primary">Back</a>
            </div>

            <%} else {%>

            <div class="col-sm-6 col-sm-offset-3">
                <div class="total_area">
                    <ul>
                        <li>Cart Sub Total <span>${SubTotal}$</span></li>
                        <li>Eco Tax <span>${EcoTax}%</span></li>
                        <li>Shipping Cost <span>Free</span></li>
                        <li>Total <span>${Total}$</span></li>
                    </ul>
                </div>
                <label>Some online pay service</label>
                <br>

                <form action="/orders/new" method="post" id="reg">
                    <label>${Total}$</label>
                    <input type="hidden" name="sum" value="${Total}"/>
                    <button type="submit" class="btn btn-default">Buy!</button>
                </form>

                <%--<input type="number" min="0" step="0.01" placeholder="Give me your money!!" name="money"--%>
                <%--value="${Total}$"/>--%>
            </div>
            <%}%>
        </div>
    </div>
</section>

<jsp:include page="components/footer.jsp"/>


</body>
</html>