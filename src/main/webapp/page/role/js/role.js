var $ = layer.jquery;
form = layer.form;

function openRole(url) {
    layer.open({
        type: 2
        , offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        , id: 'layerDemo' //防止重复弹出
        , area: ['800px', '600px']
        , content: '' + url + 'page/role/roleEdit.jsp'
        , title: "角色添加"
        , btnAlign: 'c' //按钮居中
        , shade: 0 //不显示遮罩
        , yes: function () {
            layer.closeAll();
        }
    });
}