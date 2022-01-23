<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <title>Fill Book Details</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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

    <!--===============================================================================================-->
    <%--    <link rel="icon" type="image/png" href="<c:url value ="/resources/img/favicon.ico"/>--%>
    <!--===============================================================================================-->


    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/bootstrap.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/fonts/font-awesome.min.css"/>">
    <!--===============================================================================================-->
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
                <li><a href="lab_resources">Lab Resources</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">Select Lab<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="6017">6017</a></li>
                        <li><a href="6018">6018</a></li>
                        <li><a href="6019">6019</a></li>
                    </ul>
                </li>
                <li><a href="BookLab">Book Lab</a></li>
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
    <h1 class="text-xl"><br><br><br>Fill Booking Details</h1>
</header>

<style>
    .lite{
        margin-left: 200px;
        margin-right: 200px;
    }
</style>

<div class="form-group">
<form:form method="post" action="book_request">
    <div class="lite">
        <div>
            <label>Lab Number </label>
            <form:input class="form-control col-md-4" path="labNumber"/>
        </div>
        <div>
            <label >Faculty Name </label><label>....</label><label id="suggest"></label>
            <form:input id="faculty" class="form-control col-md-4" path="faculty_Name" />
                <script>document.getElementById("suggest").innerText = " Suggestion ( " + sessionStorage.getItem("name") + " ) "</script>
        </div>
        <br>
        <div>
            <label >Email </label><label>....</label><label id="email"></label>
            <form:input class="form-control col-md-4" path="emailID" />
            <script>document.getElementById("email").innerText = " Suggestion ( " + sessionStorage.getItem("email") + " ) "</script>
        </div>
        <br>
        <div>
            <label>Subject/Department (Ex. Placement Unit) :</label>
            <form:input class="form-control col-md-4" path="subject" />
        </div>
        <br>
        <div>
        <label>Start Time :</label>
        <form:select class="form-control col-md-4" path="start_Time" items="${timings}"/>
        </div>
        <br>
        <div>
        <label>End Time :</label>
        <form:select class="form-control col-md-4" path="end_Time" items="${timings}"/>
        </div>
        <br>
        <div>
        <label>Purpose / Special Requirements (If Any)</label>
        <form:input class="form-control" path="purpose"/>
        </div>
        <br>
        <div>
            <label>Date</label>
            <form:input class="form-control" type="date" path="date"></form:input>
        </div>
        <br>
        <div>
        <input type="submit" class="btn btn-success" value="Book Lab" />
        </div>

    </div>
</form:form>
</div>
</body>
</html>