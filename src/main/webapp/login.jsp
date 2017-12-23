<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Login - KitAdminCore</title>
    <script>
        if (window != window.top) top.location.href = self.location.href;
    </script>
    <link href="<%=basePath%>plugins/layui/css/layui.css" rel="stylesheet"/>
    <link href="<%=basePath%>plugins/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="<%=basePath%>build/css/login.css" rel="stylesheet"/>
    <link href="<%=basePath%>plugins/sideshow/css/normalize.css" rel="stylesheet"/>
    <link href="<%=basePath%>plugins/sideshow/css/demo.css" rel="stylesheet"/>
    <link href="<%=basePath%>plugins/sideshow/css/component.css" rel="stylesheet"/>
    <!--[if IE]>
    <script src="./plugins/sideshow/js/html5.js"></script>
    <![endif]-->
    <style>
        canvas {
            position: absolute;
            z-index: -1;
        }

        .kit-login-box header h1 {
            line-height: normal;
        }

        .kit-login-box header {
            height: auto;
        }

        .content {
            position: relative;
        }

        .codrops-demos {
            position: absolute;
            bottom: 0;
            left: 40%;
            z-index: 10;
        }

        .codrops-demos a {
            border: 2px solid rgba(242, 242, 242, 0.41);
            color: rgba(255, 255, 255, 0.51);
        }

        .kit-pull-right button,
        .kit-login-main .layui-form-item input {
            background-color: transparent;
            color: white;
        }

        .kit-login-main .layui-form-item input::-webkit-input-placeholder {
            color: white;
        }

        .kit-login-main .layui-form-item input:-moz-placeholder {
            color: white;
        }

        .kit-login-main .layui-form-item input::-moz-placeholder {
            color: white;
        }

        .kit-login-main .layui-form-item input:-ms-input-placeholder {
            color: white;
        }

        .kit-pull-right button:hover {
            border-color: #009688;
            color: #009688
        }
    </style>
</head>
<body class="kit-login-bg">
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="kit-login-box">
                <header>
                    <h1>Shiro LOGIN</h1>
                </header>
                <div class="kit-login-main">
                    <form action="<%=basePath%>user/login" class="layui-form" method="post">
                        <div class="layui-form-item">
                            <label class="kit-login-icon">
                                <i class="layui-icon">&#xe612;</i>
                            </label>
                            <input type="text" name="username" lay-verify="userName" autocomplete="off"
                                   placeholder="这里输入用户名." class="layui-input">
                        </div>
                        <div class="layui-form-item">
                            <label class="kit-login-icon">
                                <i class="layui-icon">&#xe642;</i>
                            </label>
                            <input type="password" name="password" lay-verify="password" autocomplete="off"
                                   placeholder="这里输入密码." class="layui-input">
                        </div>
                        <div class="layui-form-item">
                            <div class="kit-pull-right">
                                <button class="layui-btn layui-btn-primary" lay-submit lay-filter="login">
                                    <i class="fa fa-sign-in" aria-hidden="true"></i> 登录
                                </button>
                            </div>
                            <div class="kit-clear"></div>
                        </div>
                    </form>
                </div>
                <footer>
                    <p>KIT ADMIN © <a href="http://blog.zhengjinfan.cn" style="color:white; font-size:18px;"
                                      target="_blank">www.zhengjinfan.cn</a></p>
                </footer>
            </div>
        </div>
    </div>
</div>
<!-- /container -->


<script src="<%=basePath%>plugins/layui/layui.js"></script>
<script src="<%=basePath%>plugins/sideshow/js/TweenLite.min.js"></script>
<script src="<%=basePath%>plugins/sideshow/js/EasePack.min.js"></script>
<script src="<%=basePath%>plugins/sideshow/js/rAF.js"></script>
<script src="<%=basePath%>plugins/sideshow/js/demo-1.js"></script>


<script>
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form;
        //自定义验证规则
        form.verify({
            userName: function (value) {
                if (value == "" || value.length == 0) {
                    return '请输入登录名称';
                }
            }
            , password: [/(.+){3,12}$/, '密码必须3到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });


    });
</script>

</body>


</html>