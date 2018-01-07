<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>

<head>
    <meta charset="UTF-8">
    <title>Table</title>
    <link rel="stylesheet" href="<%=basePath%>plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=basePath%>css/global.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/table.css"/>
</head>

<body>
<div class="admin-main">

    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="add">
            <i class="layui-icon">&#xe608;</i> 添加信息
        </a>
        <a href="#" class="layui-btn layui-btn-small" id="import">
            <i class="layui-icon">&#xe608;</i> 导入信息
        </a>
        <a href="#" class="layui-btn layui-btn-small">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i> 导出信息
        </a>
        <a href="#" class="layui-btn layui-btn-small" id="getSelected">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i> 获取全选信息
        </a>
        <a href="javascript:;" class="layui-btn layui-btn-small" id="search">
            <i class="layui-icon">&#xe615;</i> 搜索
        </a>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据列表</legend>
        <div class="layui-field-box layui-form">
            <table class="layui-table"
                   lay-data="{height:310, url:'<%=basePath%>user/getUserList', page:true, id:'initUser', even: 'true',size:'lg',method:'POST'}"
                   lay-filter="initUser">
                <thead>
                <tr>
                    <th lay-data="{field:'id', width:200, sort: true}">ID</th>
                    <th lay-data="{field:'userName', width:200, sort: true}">用户名称</th>
                    <th lay-data="{field:'role', width:200, sort: true}">角色名称</th>
                    <th lay-data="{field:'description', width:200, sort: true}">创建时间</th>
                    <th lay-data="{fixed: 'right', width:300, align:'center', toolbar: '#barDemo'}"></th>
                </tr>
                </thead>
            </table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>

        </div>
    </fieldset>


</div>

<script type="text/javascript" src="<%=basePath%>plugins/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>page/user/js/user.js"></script>

<script type="text/javascript">
    layui.config({
        base: '<%=basePath%>build/js/',
        version: 'false'
    }).use(['layer', 'form', 'table'], function () {
        var layer = layui.layer
            , form = layui.form
            , $ = layui.jquery
            , table = layui.table;
        url = '<%=basePath%>';
        $("#add").click(function () {
            initUser(url);
        })
    });
</script>

<script type="text/javascript">

</script>

</body>

</html>