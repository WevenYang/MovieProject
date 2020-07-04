$(function () {
    $("#form").validate({
        submitHandler: function (form) {
            if(($("#name").val() == "") || ($("#password").val() == "")){
                return false;
            }else {
                login();
            }

        },
        onfocusout: function (element) {
            $(element).valid();
        },
        errorPlacement: function (error, element) {
            layer.tips(error[0].innerText, element, {
                tipsMore: true
            });
        }
    });

    function login() {
        $.ajax({
            type: 'GET',
            url: '../Home/Login/submitLoginInfo',
            data: {
                name: $("#name").val(),
                password: $("#password").val()
            },
            dataType : "json",
            beforeSend: function () {
                layIndex = layer.msg("登录中...", { icon: 16, shade: 0.01 });
            },
            complete: function () {
                layer.close(layIndex);
            },
            success: function (res) {
                if (res.success) {
                    layer.msg('登录成功', { icon: 6 });
                    window.location.href = "../Home/Index";

                } else {
                    layer.alert(res.result, { icon: 5 });
                }
            }
        })
    }
})