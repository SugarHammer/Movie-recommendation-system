<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>关于我们</title>
    <link rel="stylesheet" href="${ctx}/css/aboutus/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/aboutus/animate.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/aboutus/main.css"type="text/css">
    <div class="footer"></div>
    <script src="${ctx}/js/aboutus/jquery-3.2.0.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/aboutus/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/aboutus/main.js" type="text/javascript"></script>
</head>
<style type="text/css">
    body{
        padding-top: 50px;
        width:100%;
        background: url("static/pro/images/aboutus/bg.jpg");
        background-size: cover;
        background-attachment: fixed;
    }
</style>
<body>
<div class="nav navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">关于我们</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active" id="aboutUs"><a href="#">About Us</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 col-xs-12 main-container text-center">
            <h2>个性化电影推荐系统</h2>
            <div class="intr-logo">
                <img src="${ctx}/static/pro/images/aboutus/img.png" alt="introduction-logo" class="animated bounce">
            </div>
            <div style="font-size: 18px;text-align: justify;">
                <div style="margin-top: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在浩瀚的电影宇宙中，每一束光影都承载着故事与梦想。自2008年成立以来，我们的团队——光影探索者，一直致力于构建一个连接电影与灵魂的桥梁。我们是一群对电影充满无限热爱的探索者，相信每部影片都有其独特的魅力和价值。</div>

                <div style="margin-top: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;光影探索者，不仅仅是一个电影推荐平台，我们是您私人定制的观影顾问。利用先进的AI算法，结合每一位用户的观影历史和偏好，我们精准推荐那些能触动您心灵的佳作。无论是经典老片的深度挖掘，还是新锐导演的前沿作品，我们都能为您找到心头所好。</div>

                <div style="margin-top: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们深知，电影不仅是娱乐，更是文化与情感的传递。因此，我们不仅推荐电影，更分享电影背后的故事，解读电影中的艺术与人生。在这里，您将遇见那些未曾谋面的精彩，发现那些与您共鸣的瞬间。</div>

                <div style="margin-top: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加入我们，一起在光影的世界中探索、发现、感动。光影探索者，让电影成为连接你我，连接世界的美好纽带。</div>
            </div>
        </div>
    </div>
<%--    <div class="row">--%>
<%--        <div class="col-md-6 col-md-offset-3 text-center main-skills">--%>
<%--            <h2>个性化电影推荐系统</h2>--%>

<%--        </div>--%>
<%--    </div>--%>
</div></body>
</html>
