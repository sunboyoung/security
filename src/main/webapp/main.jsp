<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="<%=basePath%>plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>plugins/font-awesome/css/font-awesome.min.css" media="all">
    <style>
        .info-box {
            height: 85px;
            background-color: white;
            background-color: #ecf0f5;
        }

        .info-box .info-box-icon {
            border-top-left-radius: 2px;
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 2px;
            display: block;
            float: left;
            height: 85px;
            width: 85px;
            text-align: center;
            font-size: 45px;
            line-height: 85px;
            background: rgba(0, 0, 0, 0.2);
        }

        .info-box .info-box-content {
            padding: 5px 10px;
            margin-left: 85px;
        }

        .info-box .info-box-content .info-box-text {
            display: block;
            font-size: 14px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            text-transform: uppercase;
        }

        .info-box .info-box-content .info-box-number {
            display: block;
            font-weight: bold;
            font-size: 18px;
        }

        .major {
            font-weight: 10px;
            color: #01AAED;
        }

        .main {
            margin-top: 25px;
        }

        .main .layui-row {
            margin: 10px 0;
        }
    </style>
</head>

<body>
<div class="layui-fluid main">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#00c0ef !important;color:white;"><i
                        class="fa fa-ambulance" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">CPU Traffic</span>
                    <span class="info-box-number">90%</span>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#dd4b39 !important;color:white;"><i
                        class="fa fa-google-plus" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">Likes</span>
                    <span class="info-box-number">25,412</span>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#00a65a !important;color:white;"><i
                        class="fa fa-shopping-bag" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">Sales</span>
                    <span class="info-box-number">654</span>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#f39c12 !important;color:white;"><i
                        class="fa fa-users" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">New Members</span>
                    <span class="info-box-number">85</span>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md12">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">说明</h3>
                        <ul>
                            <li>
                                本项目采用ssm+shiro搭建
                            </li>
                            <li>github地址：
                                <a href="https://github.com/sunboyoung/violenceMS" target="_blank">https://github.com/sunboyoung/violenceMS</a>(源码地址)
                            </li>
                        </ul>
                    </div>
                </li>
                <!-- <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">9月8日(v1.0.5)</h3>
                        <p>
                            <h3>#tab</h3>
                            <ul>
                                <li>添加tab.close(id)方法</li>
                                <li>添加tab.getId()方法</li>
                            </ul>
                            <h3>#onelevel</h3>
                            <ul>
                                <li>添加renderAfter(elem)回调函数 所属options参数</li>
                                <li>
                                    <pre class="layui-code">
onelevel.set{
renderAfter: function(elem) {
    //elem 当前容器
    elem.find('li').eq(0).click(); //模拟点击第一个
}
}</pre>
                                </li>
                            </ul>
                        </p>
                    </div>
                </li> -->

            </ul>
        </div>
    </div>
</div>
<script src="<%=basePath%>plugins/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('jquery', function () {
        var $ = layui.jquery;
        $('#test').on('click', function () {
            parent.message.show({
                skin: 'cyan'
            });
        });
    });
</script>
</body>

</html>