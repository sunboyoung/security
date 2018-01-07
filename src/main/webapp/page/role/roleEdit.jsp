<%--
  Created by IntelliJ IDEA.
  User: 懋小方
  Date: 2018/1/6
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>角色添加</title>
</head>
<body>
<blockquote class="layui-elem-quote layui-text">
    鉴于小伙伴的普遍反馈，先温馨提醒两个常见“问题”：1. <a href="/doc/base/faq.html#form" target="_blank">为什么select/checkbox/radio没显示？</a> 2. <a
        href="/doc/modules/form.html#render" target="_blank">动态添加的表单元素如何更新？</a>
</blockquote>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input type="text" name="userName" required lay-verify="required" placeholder="请输入角色名称" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色描述</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入角色描述"
                   autocomplete="off" class="layui-input">
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
        addRole(url);
        //监听提交
        form.on('submit(addRole)', function (data) {
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
