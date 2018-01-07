<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>

<head>
    <style type="text/css">
        .layui-form-item .layui-form-checkbox {
            margin-top: 10px !important;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>plugins/layui/css/layui.css" media="all"/>
</head>
<body>

<blockquote class="layui-elem-quote layui-text">
    鉴于小伙伴的普遍反馈，先温馨提醒两个常见“问题”：1. <a href="/doc/base/faq.html#form" target="_blank">为什么select/checkbox/radio没显示？</a> 2. <a
        href="/doc/modules/form.html#render" target="_blank">动态添加的表单元素如何更新？</a>
</blockquote>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">采用md5+salt加密</div>
    </div>
    <!--   <div class="layui-form-item">
        <label class="layui-form-label">选择框</label>
        <div class="layui-input-block">
          <select name="role" lay-verify="required" id="role">
          </select>
        </div>
      </div> -->
    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block" id="role" style="width:500px">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否禁用</label>
        <div class="layui-input-block">
            <input type="checkbox" name="switch" lay-skin="switch">
        </div>
    </div>
    <!--  <div class="layui-form-item">
       <label class="layui-form-label">单选框</label>
       <div class="layui-input-block">
         <input type="radio" name="sex" value="男" title="男">
         <input type="radio" name="sex" value="女" title="女" checked>
       </div>
     </div> -->
    <!-- <div class="layui-form-item layui-form-text">
      <label class="layui-form-label">文本域</label>
      <div class="layui-input-block">
        <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
      </div>
    </div> -->
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="addUser">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script type="text/javascript" src="<%=basePath%>plugins/layui/layui.all.js"></script>

<script type="text/javascript" src="<%=basePath%>plugins/layui/lay/modules/jquery.js"></script>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>page/user/js/userEdit.js"></script>
<script>
    //Demo
    layui.config({
        base: '<%=basePath%>build/js/',
        version: 'false'
    }).use(['form'], function () {
        var $ = layui.jquery,
            form = layui.form;
        /*   var html="";
              html+='<input type="checkbox" name="role" title="后端开发人员ss" value="5">';
              console.log(html);
              $("#role").append(html);
         */
        url = '<%=basePath%>';
        init(url);
        //监听提交
        form.on('submit(addUser)', function (data) {
            var roleIds = new Array();
            $("input[name='role']").each(function (i, d) {
                if (d.checked) {
                    roleIds.push(d.value);
                }
            });
            form.render('checkbox');
            if (roleIds.length == 0) {
                layer.msg("请选择至少一个角色", {icon: 2});
                return false;
            }
            layer.msg(JSON.stringify(data.field));
            console.log(data.field);
            return false;
        });
    });
</script>
</body>
</html>