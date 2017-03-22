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

<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="/shop/home">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="description"></td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td class="total">Total</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="Items" items="${CartItems}">
                    <tr>
                        <td class="cart_product">
                            <a href=""><img src="" alt=""></a>
                        </td>
                        <td class="cart_description">
                            <h4>
                                <a href="<c:url value="/shop/item/${Items.getItem().getId()}" />">${Items.getItem().getName()}</a>
                            </h4>

                                <%--<p>Web ID: ${Items.getItem().getId()}</p>--%>
                        </td>
                        <td class="cart_price">
                            <p>$${Items.getItem().getPrice()}</p>
                        </td>
                        <td class="cart_quantity">
                            <div class="cart_quantity_button">
                                <input id="${Items.getItem().getId()}" class="cart_quantity_input" type="number"
                                       name="quantity" value="${Items.getCount()}"
                                       min="0" autocomplete="off" size="2"
                                       onclick="reloadQuantity(${Items.getItem().getId()})">
                            </div>
                        </td>


                        <td class="cart_total">
                            <p class="cart_total_price" id=""></p>
                        </td>
                        <td class="cart_delete">
                            <a class="cart_quantity_delete" onclick="removeItem(${Items.getItem().getId()})">
                                <i class="fa fa-times"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<!--/#cart_items-->

<section id="do_action">
    <div class="container">
        <div class="heading">
            <h3>What would you like to do next?</h3>

            <p>Choose if you have a discount code or reward points you want to use or would like to estimate your
                delivery cost.</p>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="chose_area">
                    <ul class="user_info">
                        <li class="single_field">
                            <label>Country:</label>
                            <select>
                                <option>Russia</option>
                                <option>United States</option>
                                <option>Bangladesh</option>
                                <option>UK</option>
                                <option>India</option>
                                <option>Pakistan</option>
                                <option>Ucrane</option>
                                <option>Canada</option>
                                <option>Dubai</option>
                            </select>
                        </li>
                        <li class="single_field zip-field">
                            <label>Email:</label>
                            <input type="text" value="">
                        </li>
                        <li class="single_field zip-field">
                            <label>Zip Code:</label>
                            <input type="text" value="">
                        </li>
                    </ul>
                    <a class="btn btn-default check_out" href="/orders/new">Continue</a>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="total_area">
                    <ul>
                        <li>Cart Sub Total <span>${SubTotal}$</span></li>
                        <li>Eco Tax <span>${EcoTax}%</span></li>
                        <li>Shipping Cost <span>Free</span></li>
                        <li>Total <span>${Total}$</span></li>
                    </ul>
                    <%--<a class="btn btn-default update" href="" onclick="reload()">Update</a>--%>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="components/footer.jsp"/>

<script>
    function removeItem(id) {
        var content = id;

        $.ajax({
            url: '/shop/cart/remove_item',
            type: 'POST',
            data: {"id": content},

            success: function () {
                window.location.reload(true);
            },

            error: function (e) {
                alert('error' + e);
            }
        });

    }
    ;

    function reloadQuantity(id) {
        var count = document.getElementById(id).value;
        var itemId = id;
        $.ajax({
            url: '/shop/cart/update_item_count',
            type: 'POST',
            data: {"id": itemId, "count": count},

            success: function () {
                window.location.reload(true);
            },

            error: function (e) {
                alert('error' + e);
            }
        });
    }
</script>

</body>
</html>