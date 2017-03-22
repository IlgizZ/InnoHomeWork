<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Contact-Us| Allah-Express</title>
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
    <jsp:include page="../components/header.jsp"/>
        <div class="container">
            <h2>Add Category</h2>
            <form class="form-signin" action="<c:url value="/admin/addcategory"/>" method="post">
                <label for="inputEmail" class="sr-only">Category name</label>
                <input name="name" type="text" id="inputEmail" class="form-control" placeholder="Category name" required autofocus>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
            </form>
            <h2>Add Item</h2>
            <form class="form-signin" action="<c:url value="/admin/additem"/>" method="post">
                <input name="name" type="text" id="1" class="form-control" placeholder="Item name" required autofocus>
                <input name="price" type="text" id="2" class="form-control" placeholder="Price" required>
                <input name="description" type="text" id="3" class="form-control" placeholder="Description" required>
                <input name="category" type="text" id="4" class="form-control" placeholder="Category name" required>
                <input name="count" type="text" id="5" class="form-control" placeholder="Count" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
            </form>
        </div>
    <jsp:include page="../components/footer.jsp"/>
    </body>
</html>
