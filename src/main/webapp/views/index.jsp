<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> <%--다국어용--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%--    여기서 js 앞에 /를 안 쓰면 : 127.0.0.1/jsp/jsp01/ 이하로 js/index0421.js 를 찾음
                     /를 쓰면    : root부터 검색인데 관행적으로 root가 static --%>
    <script src="/js/index0421.js"></script>
<%--카카오맵api --%>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e8baa2c2fda88e720d607644c62ab5ae"></script>
<%--  chart01 --%>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
<%--chart 02--%>
    <script src="https://code.highcharts.com/highcharts-3d.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
<%--chart0302--%>
    <script src="https://code.highcharts.com/modules/cylinder.js"></script>
<%--chart0303--%>
<%--live chart--%>
    <script src="https://code.highcharts.com/modules/data.js"></script>

<%--    websocket--%>

    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>




    <style>

        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
            background-color: greenyellow;
            border :none;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 650px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
            <c:if test="${logincust != null}">
                <li><a href="/jsp">JSP</a></li>
                <li><a href="/ajax">AJAX</a></li>
                <li><a href="/map">MAP</a></li>
                <li><a href="/chart">CHART</a></li>
            </c:if>
                <li><a href="/cust">Cust</a></li>
                <li><a href="/item">Item</a></li>
                <c:if test="${logincust !=null}">
                    <li><a href="#">Contact</a></li>
                </c:if>
            </ul>
            <c:choose>
                <c:when test="${logincust==null}">
<%--                    ${} 는 모델에 담은 것뿐만 아니라 session에 담은 정보도 끄집어낼 수 있음 --%>
<%--                    로그인을 안 했으면 아래가 보이고                    --%>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/login"><span class="glyphicon glyphicon-off"></span> Login</a></li>
                        <li><a href="/register"><span class="glyphicon glyphicon-piggy-bank"></span> Register</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
<%--                    로그인을 했으면 아래가 보이고--%>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/logout"><span class="glyphicon glyphicon-off"></span>LOGOUT</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/item/allcart?id=${logincust.id}"><span class="glyphicon glyphicon-shopping-cart"></span> CART</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/custinfo?id=${logincust.id}">${logincust.id}</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <%--  Left Menu starts--%>
            <c:choose>
                <c:when test="${left == null}">
                    <jsp:include page="left.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="${left}.jsp"/>
                </c:otherwise>
            </c:choose>
        <%--  Left Menu ends--%>

        <%--  Main Center Starts--%>
            <c:choose>
                <c:when test="${center == null}">
                     <jsp:include page="center.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="${center}.jsp"/>
                </c:otherwise>
            </c:choose>
        <%--  Main Center Ends--%>

        <div class="col-sm-2 sidenav">
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
</body>
</html>

