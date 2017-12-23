<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                    <img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img"> Van
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
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 基本元素</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target
                               data-options="{url:'test.html',icon:'&#xe6c6;',title:'表格',id:'1'}">
                                <i class="layui-icon">&#xe6c6;</i><span> 表格</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="form.html" data-icon="fa-user" data-title="表单" kit-target
                               data-id='2'><i class="fa fa-user" aria-hidden="true"></i><span> 表单</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="nav.html" data-icon="&#xe628;" data-title="导航栏" kit-target
                               data-id='3'><i class="layui-icon">&#xe628;</i><span> 导航栏</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="list4.html" data-icon="&#xe614;" data-title="列表四"
                               kit-target data-id='4'><i class="layui-icon">&#xe614;</i><span> 列表四</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target
                               data-options="{url:'https://www.baidu.com',icon:'&#xe658;',title:'百度一下',id:'5'}"><i
                                    class="layui-icon">&#xe658;</i><span> 百度一下</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 组件</span></a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'navbar.html',icon:'&#xe658;',title:'Navbar',id:'6'}"><i
                                class="layui-icon">&#xe658;</i><span> Navbar</span></a></dd>
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'tab.html',icon:'&#xe658;',title:'TAB',id:'7'}"><i class="layui-icon">&#xe658;</i><span> Tab</span></a>
                        </dd>
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'onelevel.html',icon:'&#xe658;',title:'OneLevel',id:'50'}"><i
                                class="layui-icon">&#xe658;</i><span> OneLevel</span></a></dd>
                        <dd><a href="javascript:;" kit-target
                               data-options="{url:'app.html',icon:'&#xe658;',title:'App',id:'8'}"><i class="layui-icon">&#xe658;</i><span> app.js主入口</span></a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"><i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63e;</i>
            请稍等...
        </div>
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
<script src="${basePath}plugins/layui/layui.js"></script>
<script>
    var message;
    layui.config({
        base: '<%=basePath%>build/js/',
        version: '1.0.1'
    }).use(['app', 'message', 'navbar', 'tab'], function () {
        var app = layui.app,
            $ = layui.jquery,
            tab = layui.tab,
            navbar = layui.navbar,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //navbar加载方式二，设置远程地址加载
        tab.set({
            renderType: 'iframe',
            mainUrl: 'main.jsp',
            openWait: false,
            elem: '#container',

            onSwitch: function (data) { //选项卡切换时触发
                //console.log(data.layId); //lay-id值
                //console.log(data.index); //得到当前Tab的所在下标
                //console.log(data.elem); //得到当前的Tab大容器
            },
            closeBefore: function (data) { //关闭选项卡之前触发
                // console.log(data);
                // console.log(data.icon); //显示的图标
                // console.log(data.id); //lay-id
                // console.log(data.title); //显示的标题
                // console.log(data.url); //跳转的地址
                return true; //返回true则关闭
            }
        }).render(
        );
        navbar.set({
            remote: {
                url: 'menu/initMenu',
                type: "POST",
                jsonp: false
            }
        }).render(function (data) {
            tab.tabAdd(data);
        });

        //主入口
        app.set({
            type: 'iframe'
        }).init();

        $('#pay').on('click', function () {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="/src/images/pay.png" />',
                area: ['500px', '250px'],
                shadeClose: true
            });
        });
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