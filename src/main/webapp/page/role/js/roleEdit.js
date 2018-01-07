var $ = layer.jquery;
form = layer.form;

function addRole(url) {
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: url + "resource/initResource",
        success: function (result) {
            var html = '';
            $.each(result.data, function (index, value) {
                var data = result.data[index];
                html += '<input type="checkbox" name="role" title="' + data.description + '" value="' + data.id + '" >';

            });
            $("#role").append(html);
            layui.form.render('checkbox');
        },
        error: function (error) {
            console.log(error);
        }
    });
}