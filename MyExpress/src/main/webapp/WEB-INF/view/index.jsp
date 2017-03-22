<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${name} |MY-Express</title>
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
<% String order = request.getParameter("order");
    if (order != null && (order).equals("success")) { %>
<div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong>
    Order bought, it will soon on your town!
    <br>
</div>

<%} %>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="left-sidebar">
                    <h2>Category</h2> <!-- категории -->
                    <div class="panel-group category-products" id="accordian">
                        <c:forEach var="Category" items="${categories}">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a
                                            href="/shop/category/${Category.getId()}">${Category.getName()}</a></h4>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="col-sm-9 padding-right">
                <div class="features_items">
                    <h2 class="title text-center">Features Items</h2> <!-- товары -->
                    <c:forEach var="Item" items="${list}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="<c:url value="/resources/images/home/no_photo.jpg"/>" alt=""/>

                                        <h2>$${Item.getPrice()}</h2>

                                        <p>${Item.getName()}</p>
                                        <a class="btn btn-default add-to-cart" onclick="doAjax(${Item.getId()})"><i
                                                class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <h2>$${Item.getPrice()}</h2>

                                            <p>${Item.getName()}</p>
                                            <a class="btn btn-default add-to-cart" onclick="doAjax(${Item.getId()})"><i
                                                    class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a href="<c:url value="/shop/item/${Item.getId()}" />"><i
                                                class="fa fa-external-link"></i>Go to the product page</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="recommended_items">
                    <h2 class="title text-center">new items</h2>
                    <c:forEach var="newItem" items="${newItems}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="<c:url value="/resources/images/home/no_photo.jpg"/>" alt=""/>

                                        <h2>$${newItem.getPrice()}</h2>

                                        <p>${newItem.getName()}</p>
                                        <a class="btn btn-default add-to-cart" onclick="doAjax(${newItem.getId()})"><i
                                                class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <h2>$${newItem.getPrice()}</h2>

                                            <p>${newItem.getName()}</p>
                                            <button class="btn btn-default add-to-cart"
                                                    onclick="doAjax(${newItem.getId()})"><i
                                                    class="fa fa-shopping-cart"></i>Add to cart
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a href="<c:url value="/shop/item/${newItem.getId()}" />"><i
                                                class="fa fa-external-link"></i>Go to the product page</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    function doAjax(id) {

        var content = id;
        alert(id);
        $.ajax({
            url: '/shop/addItem',
            type: 'POST',
            data: {"cont": id},

            success: function () {

            },

            error: function (e) {
                alert('error' + e);
            }
        });

    }
    ;
</script>

<jsp:include page="components/footer.jsp"/>

</body>
</html>