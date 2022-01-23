<%@ page import="com.hellospringdemo.model.Datewise_details" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
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


    <script>document.getElementsByTagName("html")[0].className += " js";</script>
    <link rel="stylesheet" href="<c:url value = "/resources/css/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/bootstrap.min.css"/>">
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
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
    <a href="home" onclick="signOut();">Sign out</a>

    <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>

    <title>Lab Schedule</title>

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
                <li><a href="/lab_resources">Lab Resources</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">Select Lab<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="6017">6017</a></li>
                        <li><a href="6018">6018</a></li>
                        <li><a href="6019">6019</a></li>
                    </ul>
                </li>
                <li><a href="/BookLab">Book Lab</a></li>
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
    <br><br>
    <h1 class="text-xl">IPC 6019 Lab Schedule  (<c:out value="${Schedule_6017[0].date}"></c:out>) </h1>
</header>



<div class="cd-schedule cd-schedule--loading margin-top-lg margin-bottom-lg js-cd-schedule">
    <div class="cd-schedule__timeline">
        <ul>
            <li><span>08:00</span></li>
            <li><span>08:30</span></li>
            <li><span>09:00</span></li>
            <li><span>09:30</span></li>
            <li><span>10:00</span></li>
            <li><span>10:30</span></li>
            <li><span>11:00</span></li>
            <li><span>11:30</span></li>
            <li><span>12:00</span></li>
            <li><span>12:30</span></li>
            <li><span>13:00</span></li>
            <li><span>13:30</span></li>
            <li><span>14:00</span></li>
            <li><span>14:30</span></li>
            <li><span>15:00</span></li>
            <li><span>15:30</span></li>
            <li><span>16:00</span></li>
            <li><span>16:30</span></li>
            <li><span>17:00</span></li>
            <li><span>17:30</span></li>
            <li><span>18:00</span></li>
            <li><span>18:30</span></li>
            <li><span>19:00</span></li>
            <li><span>19:30</span></li>
            <li><span>20:00</span></li>
            <li><span>20:30</span></li>
            <li><span>21:00</span></li>
            <li><span>21:30</span></li>
            <li><span>22:00</span></li>
            <li><span>22:30</span></li>
            <li><span>23:00</span></li>
            <li><span>23:30</span></li>
            <li><span>00:00</span></li>
        </ul>
    </div> <!-- .cd-schedule__timeline -->
    <c:set var="count" value="0" scope="page" />
    <div class="cd-schedule__events">
        <ul>
            <li class="cd-schedule__group">
                <div class="cd-schedule__top-info"><span>Booking Time Table (Select Other Date) &nbsp; &nbsp; &nbsp;</span>
                    <form:form method="post" class="form-inline"  action="6019_schedule" modelAttribute="date6019">
                        <form:input type="date" class="form-control mr-sm-2" path="date"></form:input>
                        <input type="submit" class="btn btn-success" value="Go" />
                    </form:form>

                </div>
                <ul>
                    <c:forEach items="${Schedule_6019}" var="schedule">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <li class="cd-schedule__event">
                            <a data-start=${schedule.start_time} data-end=${schedule.end_time} data-content="${schedule.end_time}" data-event="event-<c:out value="${count%4}"></c:out>">
                                <em class="cd-schedule__name">${schedule.subject}</em>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </ul>
    </div>


    <div class="cd-schedule-modal">
        <header class="cd-schedule-modal__header">
            <div class="cd-schedule-modal__content">
                <span class="cd-schedule-modal__date"></span>
                <h3 class="cd-schedule-modal__name"></h3>
            </div>

            <div class="cd-schedule-modal__header-bg"></div>
        </header>

        <div class="cd-schedule-modal__body">
            <div class="cd-schedule-modal__event-info"></div>
            <div class="cd-schedule-modal__body-bg"></div>
        </div>

        <a href="#0" class="cd-schedule-modal__close text-replace">Close</a>
    </div>

    <div class="cd-schedule__cover-layer"></div>
</div> <!-- .cd-schedule -->

<script src="<c:url value = "/resources/js/util.js"/>"></script> <!-- util functions included in the CodyHouse framework -->
<script src="<c:url value = "/resources/js/main.js"/>"></script>

<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</body>
</html>
