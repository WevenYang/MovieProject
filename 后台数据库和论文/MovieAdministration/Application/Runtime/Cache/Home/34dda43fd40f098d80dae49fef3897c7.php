<?php if (!defined('THINK_PATH')) exit();?>
    <head>
        <base href="/dashboard/www/Thinkphp3.2/MovieAdministration/Public/">
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <div class="panel admin-panel">
        <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
        <div class="body-content">
            <form id="form" method="post" class="form-x" action="">
                <div class="form-group">
                    <div class="label">
                        <label for="sitename">原始密码：</label>
                    </div>
                    <div class="field">
                        <input type="password" class="input w50" id="mpass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="sitename">新密码：</label>
                    </div>
                    <div class="field">
                        <input type="password" class="input w50" id="newpass" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="sitename">确认新密码：</label>
                    </div>
                    <div class="field">
                        <input type="password" class="input w50" id="renewpass" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <script src="js/jquery.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script language="JavaScript">
        $(function () {
            $("#form").validate({
                submitHandler: function (form) {
                    if(($("#mpass").val() == "") || ($("#newpass").val() == "") || ($("#renewpass").val() == "")){
                        return false;
                    }else if ($("#newpass").val() != $("#renewpass").val()){
                        layer.alert("两次密码输入不一样", { icon: 5 });
                    }else {
                        change();
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

            function change() {
                $.ajax({
                    type: 'POST',
                    url: '../Home/ChangePwd/change',
                    dataType : 'json',
                    data: {
                        former: $("#mpass").val(),
                        new: $("#newpass").val()
                    },
                    beforeSend: function () {
                        layIndex = layer.msg("修改中...", { icon: 16, shade: 0.01 });
                    },
                    complete: function () {
                        layer.close(layIndex);
                    },
                    success: function (res) {
                        if (res.success) {
                            layer.msg('修改成功', { icon: 6 });

                        } else {
                            layer.alert(res.result, { icon: 5 });
                        }
                    }
                })
            }
        })
    </script>