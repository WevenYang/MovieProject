<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>电影分享后台管理中心</title>
    <base href="/dashboard/www/Thinkphp3.2/MovieAdministration/Public/">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body class="fix-header fix-sidebar card-no-border">

<div class="header bg-main">
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
        <li><a href="<?php echo U('Lastest/index');?>" target="right"><span class="icon-caret-right"></span>最新影评</a></li>
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
    <iframe scrolling="auto" rameborder="0" name="right" width="100%" height="100%">
        
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>一些常用模块</small></div>
            </div>

            <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
                <li><a href="#" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>新增页面<br/>2300</a></li>
                <li><a href="#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>成交订单<br/>308</a></li>
                <li><a href="#" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br/>昨日访问<br/>80082</a></li>
                <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>在线用户<br/>3000</a></li>
            </ul>

            <div class="am-g">
                <div class="am-u-sm-12">
                    <table class="am-table am-table-bd am-table-striped admin-content-table">
                        <thead>
                        <tr>
                            <th>ID</th><th>用户名</th><th>最后成交任务</th><th>成交订单</th><th>管理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr><td>1</td><td>John Clark</td><td><a href="#">Business management</a></td> <td><span class="am-badge am-badge-success">+20</span></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#">1. 编辑</a></li>
                                        <li><a href="#">2. 下载</a></li>
                                        <li><a href="#">3. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr><td>2</td><td>风清扬</td><td><a href="#">公司LOGO设计</a> </td><td><span class="am-badge am-badge-danger">+2</span></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#">1. 编辑</a></li>
                                        <li><a href="#">2. 下载</a></li>
                                        <li><a href="#">3. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr><td>3</td><td>詹姆斯</td><td><a href="#">开发一款业务数据软件</a></td><td><span class="am-badge am-badge-warning">+10</span></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#">1. 编辑</a></li>
                                        <li><a href="#">2. 下载</a></li>
                                        <li><a href="#">3. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr><td>4</td><td>云适配</td><td><a href="#">适配所有网站</a></td><td><span class="am-badge am-badge-secondary">+50</span></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#">1. 编辑</a></li>
                                        <li><a href="#">2. 下载</a></li>
                                        <li><a href="#">3. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>5</td><td>呵呵呵</td>
                            <td><a href="#">基兰会获得BUFF</a></td>
                            <td><span class="am-badge">+22</span></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#">1. 编辑</a></li>
                                        <li><a href="#">2. 下载</a></li>
                                        <li><a href="#">3. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="am-g">
                <div class="am-u-md-6">
                    <div class="am-panel am-panel-default">
                        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-1'}">文件上传<span class="am-icon-chevron-down am-fr" ></span></div>
                        <div class="am-panel-bd am-collapse am-in" id="collapse-panel-1">
                            <ul class="am-list admin-content-file">
                                <li>
                                    <strong><span class="am-icon-upload"></span> Kong-cetian.Mp3</strong>
                                    <p>3.3 of 5MB - 5 mins - 1MB/Sec</p>
                                    <div class="am-progress am-progress-striped am-progress-sm am-active">
                                        <div class="am-progress-bar am-progress-bar-success" style="width: 82%">82%</div>
                                    </div>
                                </li>
                                <li>
                                    <strong><span class="am-icon-check"></span> 好人-cetian.Mp3</strong>
                                    <p>3.3 of 5MB - 5 mins - 3MB/Sec</p>
                                </li>
                                <li>
                                    <strong><span class="am-icon-check"></span> 其实都没有.Mp3</strong>
                                    <p>3.3 of 5MB - 5 mins - 3MB/Sec</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="am-panel am-panel-default">
                        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">浏览器统计<span class="am-icon-chevron-down am-fr" ></span></div>
                        <div id="collapse-panel-2" class="am-in">
                            <table class="am-table am-table-bd am-table-bdrs am-table-striped am-table-hover">
                                <tbody>
                                <tr>
                                    <th class="am-text-center">#</th>
                                    <th>浏览器</th>
                                    <th>访问量</th>
                                </tr>
                                <tr>
                                    <td class="am-text-center"><img src="assets/i/examples/admin-chrome.png" alt=""></td>
                                    <td>Google Chrome</td>
                                    <td>3,005</td>
                                </tr>
                                <tr>
                                    <td class="am-text-center"><img src="assets/i/examples/admin-firefox.png" alt=""></td>
                                    <td>Mozilla Firefox</td>
                                    <td>2,505</td>
                                </tr>
                                <tr>
                                    <td class="am-text-center"><img src="assets/i/examples/admin-ie.png" alt=""></td>
                                    <td>Internet Explorer</td>
                                    <td>1,405</td>
                                </tr>
                                <tr>
                                    <td class="am-text-center"><img src="assets/i/examples/admin-opera.png" alt=""></td>
                                    <td>Opera</td>
                                    <td>4,005</td>
                                </tr>
                                <tr>
                                    <td class="am-text-center"><img src="assets/i/examples/admin-safari.png" alt=""></td>
                                    <td>Safari</td>
                                    <td>505</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="am-u-md-6">
                    <div class="am-panel am-panel-default">
                        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-4'}">任务 task<span class="am-icon-chevron-down am-fr" ></span></div>
                        <div id="collapse-panel-4" class="am-panel-bd am-collapse am-in">
                            <ul class="am-list admin-content-task">
                                <li>
                                    <div class="admin-task-meta"> Posted on 25/1/2120 by John Clark</div>
                                    <div class="admin-task-bd">
                                        The starting place for exploring business management; helping new managers get started and experienced managers get better.
                                    </div>
                                    <div class="am-cf">
                                        <div class="am-btn-toolbar am-fl">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default"><span class="am-icon-check"></span></button>
                                                <button type="button" class="am-btn am-btn-default"><span class="am-icon-pencil"></span></button>
                                                <button type="button" class="am-btn am-btn-default"><span class="am-icon-times"></span></button>
                                            </div>
                                        </div>
                                        <div class="am-fr">
                                            <button type="button" class="am-btn am-btn-default am-btn-xs">删除</button>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="admin-task-meta"> Posted on 25/1/2120 by 呵呵呵</div>
                                    <div class="admin-task-bd">
                                        基兰和狗熊出现在不同阵营时。基兰会获得BUFF，“装甲熊憎恨者”。狗熊会获得BUFF，“时光老人憎恨者”。
                                    </div>
                                    <div class="am-cf">
                                        <div class="am-btn-toolbar am-fl">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default"><span class="am-icon-check"></span></button>
                                                <button type="button" class="am-btn am-btn-default"><span class="am-icon-pencil"></span></button>
                                                <button type="button" class="am-btn am-btn-default"><span class="am-icon-times"></span></button>
                                            </div>
                                        </div>
                                        <div class="am-fr">
                                            <button type="button" class="am-btn am-btn-default am-btn-xs">删除</button>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="am-panel am-panel-default">
                        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-3'}">最近留言<span class="am-icon-chevron-down am-fr" ></span></div>
                        <div class="am-panel-bd am-collapse am-in am-cf" id="collapse-panel-3">
                            <ul class="am-comments-list admin-content-comment">
                                <li class="am-comment">
                                    <a href="#"><img src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/96/h/96" alt="" class="am-comment-avatar" width="48" height="48"></a>
                                    <div class="am-comment-main">
                                        <header class="am-comment-hd">
                                            <div class="am-comment-meta"><a href="#" class="am-comment-author">某人</a> 评论于 <time>2014-7-12 15:30</time></div>
                                        </header>
                                        <div class="am-comment-bd"><p>遵循 “移动优先（Mobile First）”、“渐进增强（Progressive enhancement）”的理念，可先从移动设备开始开发网站，逐步在扩展的更大屏幕的设备上，专注于最重要的内容和交互，很好。</p>
                                        </div>
                                    </div>
                                </li>

                                <li class="am-comment">
                                    <a href="#"><img src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/96/h/96" alt="" class="am-comment-avatar" width="48" height="48"></a>
                                    <div class="am-comment-main">
                                        <header class="am-comment-hd">
                                            <div class="am-comment-meta"><a href="#" class="am-comment-author">某人</a> 评论于 <time>2014-7-12 15:30</time></div>
                                        </header>
                                        <div class="am-comment-bd"><p>有效减少为兼容旧浏览器的臃肿代码；基于 CSS3 的交互效果，平滑、高效。AMUI专注于现代浏览器（支持HTML5），不再为过时的浏览器耗费资源，为更有价值的用户提高更好的体验。</p>
                                        </div>
                                    </div>
                                </li>

                            </ul>
                            <ul class="am-pagination am-fr admin-content-pagination">
                                <li class="am-disabled"><a href="#">&laquo;</a></li>
                                <li class="am-active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </iframe>
</div>


</body>
</html>