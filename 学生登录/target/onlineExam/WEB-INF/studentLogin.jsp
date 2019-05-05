<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD 	XHTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>学生登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="../css/common/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/pages/Login.css">
    <script type="text/javascript" src="../js/common/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/pages/Login.js"></script>
</head>

<body>
<img src="../images/爱学习.gif" width="100%" id="background" >
<div id="title">
    <div id="titleContext">
        <h1>在线考试系统</h1>
        <h2>EXERCISE.com</h2>
    </div>
</div>
<div id="total">
    <div id="middle">
        <form id="form1" action="${pageContext.request.contextPath }/student_login.action" method="post">
            <div id="userHead">
                <a href="#"><img src="../images/学生.png" width="80px" height="80px" /></a>
            </div>
            <div id="inputBox">
                <div id="username">
                    <img src="../images/username(1).png" width="10%" height="65%" />
                    <input type="text" placeholder="用户名" />
                </div>
                <div id="inputpsw">
                    <img src="../images/password.png" width="10%" height="65%" />
                    <input type="password" placeholder="密码" />
                </div>
            </div>
            <div id="loginBtn">
                <button type="submit" id="submit">登 录</button>
            </div>
            <div id="tiptext">
                <a href="##">忘记密码</a>
                <a href="##">忘记用户名</a>
                <a href="##">免费注册</a>
            </div>
        </form>
    </div>
</div>
<div id="bottom">
    <p>在线出题 | 在线考试 | 查看成绩 | 即时排名</p>
    <p>©2019 EXERCISE.com 版权所有</p>
</div>
</body>
</html>
