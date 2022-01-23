<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Lab Resources</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <%--    <link rel="icon" type="image/png" href="<c:url value ="/resources/img/favicon.ico"/>--%>
    <!--===============================================================================================-->
    <meta name="google-signin-scope" content="${sessionScope.get("email")}">
    <meta name="google-signin-client_id" content="936168659828-kuvp1cbk0mjiuskm0j42arfi42k3mlud.apps.googleusercontent.com">

    <script>
        function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
                console.log('User signed out.');
            });
        }

        function onLoad() {
            gapi.load('auth2', function() {
                gapi.auth2.init();
            });
        }
    </script>
    <a href="/home" onclick="signOut();">Sign out</a>

    <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>


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
    <!--===============================================================================================-->
</head>
<body>
<div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">IPC Lab Booking System</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/all_requests">All Booking Requests</a></li>
                <li><a href="/AddLabResources">Add Lab  Resources</a></li>
                <li><a onclick="signOut()" href="/">Sign Out</a></li></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" id="welcome"></a></li>
                <script>document.getElementById("welcome").innerText = sessionStorage.getItem("name")</script>
            </ul>
        </div>
    </nav>
</div>
    <header  class="cd-main-header text-center flex flex-column flex-center">
        <h1 class="text-xl"><br><br><br>Approval Failed !</h1>
        <h3 class="text-xl-center"><br><br><br>Lab timings are clashing, view schedule to choose appropriate time</h3>
    </header>
</div>
</body>
</html>
