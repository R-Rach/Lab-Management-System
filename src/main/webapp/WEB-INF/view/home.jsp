<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>IPC Lab Management Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <%--    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>--%>
    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login_bootstrap.min.css"/>">


    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/fonts/login_font-awesome.min.css"/>">
    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/fonts/login_material-design-iconic-font.min.css"/>">
    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/login_animate.css"/>">
    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/login_hamburgers.min.css"/>">
    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login_animsition.min.css"/>">

    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login_select2.min.css"/>">

    <!--===============================================================================================-->
    <%--    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login_daterangepicker.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login_util.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login_main.css"/>">
    <!--===============================================================================================-->


    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/bootstrap.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/fonts/font-awesome.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/animate_lab_resources.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/select2_lr.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/perfect-scrollbar_lr.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/util.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value = "/resources/css/requestButton.css"/>">
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <meta name="google-signin-client_id" content="936168659828-kuvp1cbk0mjiuskm0j42arfi42k3mlud.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>

<div class="container-login100" style="background-image: url('<c:url value='/resources/img/back.webp'/>');">
    <%--<div class="container-login100" style="background-image: url('../webapp/resources/img/log.png');">--%>
    <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
        <form class="login100-form validate-form" method="post">
				<span class="login100-form-title p-b-50">
					Welcome to IPC Lab Management System
                    <br>
                    <br>
				</span>

            <style>
                .bitsimage{
                    margin-left: 40px;
                }
            </style>
            <div class = "bitsimage">
                <img src="<c:url value="/resources/img/log.png"/>" >
            </div>

            <div class="text-center p-t-57 p-b-20">
					<span class="text1">
						Login through BITS Email
					</span>
            </div>

            <div id="profileinfo"> </div>
            <div class="g-signin2" data-onsuccess="onSignIn" align="center"></div>
        </form>
    </div>
</div>
<script>
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        var name = "";
        name = profile.getName();

        // document.getElementById('profileinfo').innerHTML = profile.getName() + "<br>" + profile.getEmail() + "<br>" + "<img src = '" + profile.getImageUrl() + "'/>";
        var emailstr = "";
        emailstr = profile.getEmail();
        var n = emailstr.search("pilani.bits-pilani.ac.in");
        if(n==-1) // means it is not of the format user@pilani.bits-pilani.ac.in
        {   alert("Please use BITS Email!!")
            // document.getElementById('profileinfo').innerHTML = "You do not have pilani login. Kindly login using pilaniID";
            var res = signOut(); // sign out immediately if it's not pilani login
            window.location.href = "/"
        }

        var n2 = emailstr.search("f2015600");
        if(n2==-1)
        {
            window.location.href = "lab_resources";
            sessionStorage.setItem("name",name);
            sessionStorage.setItem("email",emailstr);// gets the email for eg: h20180132@pilani.bits-pilani.ac.in .
        }
        else
        {
            window.location.href = "all_requests";
            sessionStorage.setItem("name",name);
        }
    }
</script>

<script src="https://apis.google.com/js/platform.js?onload=onLoadCallback" async defer></script>

<script>
    window.onLoadCallback = function(){
        gapi.auth2.init({
            client_id: '936168659828-kuvp1cbk0mjiuskm0j42arfi42k3mlud.apps.googleusercontent.com'
        });
    }
    function signOut() {
        gapi.auth2.init({
            client_id: '936168659828-kuvp1cbk0mjiuskm0j42arfi42k3mlud.apps.googleusercontent.com'
        });

        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            sessionStorage.removeItem("name")
            window.location.href = "/"
        });
    }
</script>

<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>