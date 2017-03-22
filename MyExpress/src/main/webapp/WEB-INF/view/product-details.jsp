<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Product | MY-Express</title>
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
                                            href="/category/${Category.getId()}">${Category.getName()}</a></h4>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <c:set var="Item" value="${Prod}"/>

            <script>
                function doAjax(id) {

                    var content = id;

                    $.ajax({
                        url: '/shop/addItem',
                        type: 'POST',
                        data: {"cont": content},

                        success: function () {
                        },

                        error: function (e) {
                            alert('error' + e);
                        }
                    });

                }
                ;
            </script>

            <div class="col-sm-9 padding-right">
                <div class="product-details"><!--product-details-->
                    <div class="col-sm-5">
                        <div class="view-product">
                            <img src="${Item.getPhoto()}" alt=""/>
                        </div>

                    </div>
                    <div class="col-sm-7">
                        <div class="product-information"><!--/product-information-->
                            <h2>${Item.getDescription()}</h2>

                            <p>Web ID: ${Item.getId()}</p>
								<span>
									<span>$${Item.getPrice()}</span>
									<label>Quantity:</label>
									<button onclick="doAjax(${Item.getId()})" type="button"
                                            class="btn btn-fefault cart">
                                        <i class="fa fa-shopping-cart"></i>
                                        Add to cart
                                    </button>
								</span>

                            <p><b>Count:</b> ${Item.getCount()}</p>

                            <p><b>Brand:</b> Allah-express</p>

                            <p><b>Description: ${Item.getDescription()}</b></p>
                        </div>
                        <!--/product-information-->
                    </div>
                </div>
                <!--/product-details-->

                <div class="recommended_items">
                    <h2 class="title text-center">new items</h2>
                    <c:forEach var="Items" items="${newItems}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="<c:url value="/resources/images/home/no_photo.jpg"/>" alt=""/>

                                        <h2>$${Items.getPrice()}</h2>

                                        <p>${Items.getName()}</p>
                                        <a href="/item/${Items.getId()}" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <h2>$${Items.getPrice()}</h2>

                                            <p>${Items.getName()}</p>
                                            <a href="" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a href="<c:url value="/item/${Items.getId()}" />"><i
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

<jsp:include page="components/footer.jsp"/>

</body>
</html>