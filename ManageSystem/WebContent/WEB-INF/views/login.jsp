<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/14
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
	
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom TextBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${path}/resource/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}/resource/css/icon.css">
    <link rel="stylesheet" type="text/css" href="${path}/resource/css/demo.css">
    <script type="text/javascript" src="${path}/resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/resource/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${path}/resource/js/md5.js"></script>
    <script type="text/javascript" src="${path}/resource/js/login.js"></script>
    
</head>
<body>
<h1 style="color: #69a6ff;border-bottom: 3px solid #69a6ff;padding-bottom: 20px;font-size: 3em; margin: 0 0 24px 0">邮政分公司外勤管理系统</h1>
<!--<div style="margin:20px 0;"></div>-->
<div class="easyui-panel" title="登录" style="width:100%;max-width:400px;padding:30px 60px;margin: 0 auto">
    <div style="margin-bottom:10px">
        <input id="loginname" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input id="password" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
    </div>
    <div>
        <input onclick="return login('${path}')"  type="button" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:40%;font-size:14px;" value="登录"/>
        <a href="#" style="margin-top:15px ">忘记密码?</a>
    </div>
</div>
</body>
</html>
