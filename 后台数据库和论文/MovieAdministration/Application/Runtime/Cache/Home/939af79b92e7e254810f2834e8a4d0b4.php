<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <base href="/dashboard/www/Thinkphp3.2/MovieAdministration/Public/">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    
    <script src="js/jquery.js"></script>
</head>
<body class="fix-header fix-sidebar card-no-border">

<<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
    </div>
    <div class="head-l">&nbsp<a class="button button-little bg-red" href="<?php echo U('Login/index');?>"><span class="icon-power-off"></span> 退出登录</a> </div>
    <div class="record margin-big-right fadein-top">欢迎回来，管理员</div>
    <div class="record margin-big-right fadein-top"><label id="showtime"/></div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>基本设置</h2>
    <ul style="display:block">
        <li><a href="<?php echo U('Home/index');?>" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
        <li><a href="<?php echo U('Index/index');?>" target="right"><span class="icon-caret-right"></span>最新影评</a></li>
        <li><a href="<?php echo U('ChangePwd/index');?>" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    </ul>
</div>
<script type="text/javascript">
    date();
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });

    //获取当天日期
    function date()
    {
        var date=new Date();
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        var day = date.getDate();
        var hour = date.getHours();
        var min = date.getMinutes();
        document.getElementById("showtime").innerHTML="本次登录时间是:"+year+"年"+month+"月"+day+"日 "+hour+":"+min;
    }
</script>
<ul class="bread">
    <li><a href="<?php echo U('PersonData/index');?>" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</php></span>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="<?php echo U('PersonData/index');?>" name="right" width="100%" height="100%">
        
    </iframe>
</div>


    <script src="js/page/person.js"></script>

</body>
</html>