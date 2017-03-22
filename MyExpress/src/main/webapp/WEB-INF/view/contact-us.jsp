<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Contact-Us| MY-Express</title>
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

<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">
            <div class="col-sm-12">
                <h2 class="title text-center">Contact <strong>Us</strong></h2>
            </div>
            <% if (request.getParameter("mess") != null) { %>
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Success!</strong> Your message was sent!
            </div>

            <%} else if (request.getParameter("error") != null) {%>

            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong> Invalid login or password:(
            </div>
            <% }%>
        </div>
        <div class="row">
            <div class="col-sm-8"> <!-- прописать нужные -->
                <div class="contact-form">
                    <h2 class="title text-center">Get In Touch</h2>

                    <div class="status alert alert-success" style="display: none"></div>
                    <form id="main-contact-form" class="contact-form row" name="contact-form" method="post">
                        <div class="form-group col-md-6">
                            <input type="email" name="email" class="form-control" required="required"
                                   placeholder="Email">
                        </div>
                        <div class="form-group col-md-6">
                            <input type="password" name="password" class="form-control" required="required"
                                   placeholder="Password to your gmail">
                        </div>
                        <div class="form-group col-md-12">
                            <input type="text" name="subject" class="form-control" required="required"
                                   placeholder="Subject">
                        </div>
                        <div class="form-group col-md-12">
                            <textarea name="message" id="message" required="required" class="form-control" rows="8"
                                      placeholder="Your Message Here"></textarea>
                        </div>
                        <div class="form-group col-md-12">
                            <input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-4"> <!-- прописать нужные -->
                <div class="contact-info">
                    <h2 class="title text-center">Contact Info</h2>
                    <address>
                        <p>E-Shopper Inc.</p>

                        <p>935 W. Webster Ave New Streets Chicago, IL 60614, NY</p>

                        <p>New York USA</p>

                        <p>Mobile: 8-800-555-35-35</p>

                        <p>Email: ilgiz1996@mail.ru</p>
                    </address>
                    <%--<div class="social-networks">--%>
                    <%--<h2 class="title text-center">Social Networking</h2>--%>
                    <%--<ul>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-facebook"></i></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-twitter"></i></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-google-plus"></i></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-youtube"></i></a>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>

</body>
</html>