<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head onload="a()">
    <title>All Lab Requests</title>
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
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">
                <table>
                    <thead>
                    <tr class="table100-head">
                        <<th class="column1">Lab Index</th>
                        <th class="column2">Subject</th>
                        <th class="column3">Faculty</th>
                        <th class="column4">Purpose</th>
                        <th class="column5">Date</th>
                        <th class="column1">From</th>
                        <th class="column2">To</th>
                        <th class="column3">Lab Number</th>
                    </tr>
                    </thead>
                    <c:forEach items="${labrequests}" var="labrequests">
                        <tr>
                            <td class="column1">${labrequests.bookId}</td>
                            <td class="column2">${labrequests.subject}</td>
                            <td class="column3">${labrequests.faculty_Name}</td>
                            <td class="column4">${labrequests.purpose}</td>
                            <td class="column5">${labrequests.date}</td>
                            <td class="column1">${labrequests.start_Time}</td>
                            <td class="column2">${labrequests.end_Time}</td>
                            <td class="column3">${labrequests.labNumber}</td>
                        </tr>
                    </c:forEach>
                </table>
                <style>
                    .lite{
                        margin-left: 200px;
                        margin-right: 200px;
                    }
                </style>
                <div class="form-group">
                    <form:form method="post" action="approve_request" modelAttribute="approve">
                    <div class="lite">
                        <div>
                            <label>Enter Booking ID To Approve Lab</label>
                            <form:input class="form-control col-md-4" path="bookID"/>
                        </div>
                    </div>
                        <input type="submit" id="submitted" class="btn btn-success" value="Approve">
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script onload="a()">
    function a()
    {   var a = '${result}';
        if(a.length > 0 && a.localeCompare("Time Clash"))
        {   alert(a);
            console.log(a);
            window.location.href="/all_requests" }
        else
        {
            if(a.length > 0)
            window.location.href = "/all_requests"
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

</body>
</html>