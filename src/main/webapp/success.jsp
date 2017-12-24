<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title></title>
</head>
<body>
<shiro:hasAnyRoles name="admin">
    <shiro:principal/>拥有角色admin

    <a href="<%=basePath%>user/hello2">go</a>
</shiro:hasAnyRoles>
</body>
</html>