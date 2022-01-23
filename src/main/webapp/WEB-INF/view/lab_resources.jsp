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

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">
                <table>
                    <thead>
                    <tr class="table100-head">
                        <th class="column1">Lab Number</th>
                        <th class="column2">Lab Name</th>
                        <th class="column3">Total Systems</th>
                        <th class="column1">Processor</th>
                        <th class="column2">RAM</th>
                        <th class="column3">Available Softwares</th>
                    </tr>
                    </thead>
                    <c:forEach items="${labDetails}" var="LabDetail">
                        <tr>
                            <td class="column1">${LabDetail.lab_Number}</td>
                            <td class="column2">${LabDetail.lab_Name}</td>
                            <td class="column3">${LabDetail.number_Of_Systems}</td>
                            <td class="column1">${LabDetail.processor}</td>
                            <td class="column2">${LabDetail.ram}</td>
                            <td class="column3">${LabDetail.softwares}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>