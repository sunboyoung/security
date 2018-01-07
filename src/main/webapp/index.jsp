<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<c:set var="proPath" value="${pageContext.request.contextPath}"/>
<c:set var="basePath" value="${basePath}"/>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Shiro</title>
    <link rel="stylesheet" href="${basePath}plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${basePath}plugins/font-awesome/css/font-awesome.min.css" media="all"/>
    <link rel="stylesheet" href="${basePath}build/css/app.css" media="all"/>
    <link rel="stylesheet" href="${basePath}build/css/themes/default.css" media="all" id="skin" kit-skin/>
</head>

<body class="kit-theme">
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">Shiro</div>
        <div class="layui-logo kit-logo-mobile">K</div>
        <ul class="layui-nav layui-layout-left kit-nav">
            <li class="layui-nav-item"><a href="javascript:;">控制台</a></li>
            <li class="layui-nav-item"><a href="javascript:;">商品管理</a></li>
            <li class="layui-nav-item"><a href="javascript:;" id="pay"><i class="fa fa-gratipay" aria-hidden="true"></i>
                捐赠我</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">邮件管理</a></dd>
                    <dd><a href="javascript:;">消息管理</a></dd>
                    <dd><a href="javascript:;">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <i class="layui-icon">&#xe63f;</i> 皮肤</a>
                </a>
                <dl class="layui-nav-child skin">
                    <dd><a href="javascript:;" data-skin="default" style="color:#393D49;"><i
                            class="layui-icon">&#xe658;</i> 默认</a></dd>
                    <dd><a href="javascript:;" data-skin="orange" style="color:#ff6700;"><i
                            class="layui-icon">&#xe658;</i> 橘子橙</a></dd>
                    <dd><a href="javascript:;" data-skin="green" style="color:#00a65a;"><i
                            class="layui-icon">&#xe658;</i> 原谅绿</a></dd>
                    <dd><a href="javascript:;" data-skin="pink" style="color:#FA6086;"><i
                            class="layui-icon">&#xe658;</i> 少女粉</a></dd>
                    <dd><a href="javascript:;" data-skin="blue.1" style="color:#00c0ef;"><i
                            class="layui-icon">&#xe658;</i> 天空蓝</a></dd>
                    <dd><a href="javascript:;" data-skin="red" style="color:#dd4b39;"><i class="layui-icon">&#xe658;</i>
                        枫叶红</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img"> zms
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" kit-target
                           data-options="{url:'basic.html',icon:'&#xe658;',title:'基本资料',id:'966'}"><span>基本资料</span></a>
                    </dd>
                    <dd><a href="javascript:;">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="login.html"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
            </ul>
        </div>
    </div>


    <div class="layui-body" id="container">
        <!--  <div class="layui-tab layui-tab-card kit-tab" lay-filter="kitTab">
               <ul class="layui-tab-title">
               <li class="layui-this" lay-id="-1" data-url="main.jsp">
               <i class="layui-icon">
               </i>主页</li>
              </ul>
             <div class="kit-tab-tool">操作&nbsp;
                 <i class="fa fa-caret-down"></i>
             </div>

              <div class="kit-tab-tool-body layui-anim layui-anim-upbit">
                  <ul>
                   <li class="kit-item" data-target="refresh">刷新当前选项卡</li>
                   <li class="kit-line"></li>
                   <li class="kit-item" data-target="closeCurrent">关闭当前选项卡</li>
                   <li class="kit-item" data-target="closeOther">关闭其他选项卡</li>
                   <li class="kit-line"></li>
                   <li class="kit-item" data-target="closeAll">关闭所有选项卡</li>
                  </ul>
              </div>

              <div class="layui-tab-content">
               <div class="layui-tab-item layui-show" lay-item-id="-1">
                 <iframe src="main.jsp" style="height: 20000px;"></iframe>
                </div>
              </div>

         </div> -->
    </div>


    <div class="layui-footer">
        <!-- 底部固定区域 -->
        2017 &copy;
        <a href="http://kit.zhengjinfan.cn/">kit.zhengjinfan.cn/</a> MIT license
    </div>
</div>


<script type="text/javascript">
    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cspan id='cnzz_stat_icon_1264021086'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264021086%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
</script>
<script src="${basePath}plugins/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">
    var message;
    layui.config({
        base: '<%=basePath%>build/js/',
        version: 'false'
    }).use(['app', 'message', 'navbar', 'tab', 'element'], function () {
        var app = layui.app,
            $ = layui.jquery,
            tab = layui.tab,
            navbar = layui.navbar,
            element = layui.element,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;

        <%--    $.post({
               type: "POST",//方法类型
               dataType: "text",//预期服务器返回的数据类型
               url: "<%=basePath%>menu/initMenu",
               success: function (result) {
                   console.log(result);
               },
               error : function(error) {
                  layer.msg(error);
               }
            }); --%>

        //主入口 渲染iframe 第一个主页
        tab.set({
            mainUrl: 'main.jsp',
            renderType: 'iframe',
            title: '主页',
            elem: '#container'
        }).render();
        //navbar加载左侧导航栏
        navbar.set({
            remote: {
                url: 'menu/initMenu',
                type: "POST",
                jsonp: false
            }
        }).render(function (data) {
            prefix = "<%=basePath%>";
            data.url = prefix + data.url;
            tab.tabAdd(data);
        });

        /* kitAdmin支付
         $('#pay').on('click', function() {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="/src/images/pay.png" />',
                area: ['500px', '250px'],
                shadeClose: true
            });
        });
         */
        $('dl.skin > dd').on('click', function () {
            var $that = $(this);
            var skin = $that.children('a').data('skin');
            switchSkin(skin);
        });

        var setSkin = function (value) {
                layui.data('kit_skin', {
                    key: 'skin',
                    value: value
                });
            },
            getSkinName = function () {
                return layui.data('kit_skin').skin;
            },
            switchSkin = function (value) {
                var _target = $('link[kit-skin]')[0];
                _target.href = _target.href.substring(0, _target.href.lastIndexOf('/') + 1) + value + _target.href.substring(_target.href.lastIndexOf('.'));
                setSkin(value);
            },
            initSkin = function () {
                var skin = getSkinName();
                switchSkin(skin === undefined ? 'default' : skin);
            }();
    });


</script>
</body>

</html>