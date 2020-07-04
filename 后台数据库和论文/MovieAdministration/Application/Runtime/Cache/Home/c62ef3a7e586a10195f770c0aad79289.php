<?php if (!defined('THINK_PATH')) exit();?>
    <head>
        <base href="/dashboard/www/Thinkphp3.2/MovieAdministration/Public/">
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 最新列表</strong></div>
        <div class="padding border-bottom" style="display: none">
            <button type="button" class="button border-yellow" onclick="return check(1, true, 1)"><span class="icon-plus-square-o"></span> 全部阅过</button>
        </div>
        <div id="load">
            <table class="table table-hover text-center">
                <tr>
                    <th width="20">ID</th>
                    <th width="250">标题</th>
                    <th>文章内容</th>
                    <th width="120">作者</th>
                    <th width="120">发表时间</th>
                    <th width="300">操作</th>
                </tr>
                <?php if(is_array($getLastest)): foreach($getLastest as $key=>$items): ?><tr>
                        <td><?php echo ($items["id"]); ?></td>
                        <td><?php echo ($items["title"]); ?></td>
                        <td><?php echo ($items["content"]); ?></td>
                        <td><?php echo ($items["nick_name"]); ?></td>
                        <td><?php echo ($items["time"]); ?></td>
                        <td>
                            <div class="button-group">
                                <a class="button border-red" onclick="check(-1, false, '<?php echo ($items["id"]); ?>')"><span class="icon-trash-o"></span> 审核拒绝</a>
                            </div>
                            <div class="button-group">
                                <a class="button border-main" onclick="check(1, false, '<?php echo ($items["id"]); ?>')"><span class="icon-edit"></span> 审核通过</a>
                            </div>
                        </td>
                    </tr><?php endforeach; endif; ?>
            </table>
        </div>
    </div>



    <script src="js/jquery.js"></script>
    <script language="JavaScript">

        function check(status, all, id) {
            if (all) {
                if (confirm("您确定全部通过吗？")) {
//                    var table = document.getElementsByClassName("table")
//                    s="";
//                    for(var i = 0; i<table.rows.length ; i++){
//                        var onerow = table.rows[i];
//                        for(var j = 0,l2 = onerow.cells.length; j< l2;j++){
//                            s += onerow.cells[j].innerText;
//                        }
//                        s+="n"
//                    }
                }
            } else {
                if (status == 1) {
                    if (confirm("您确定允许通过吗？")) {
                        $.ajax({
                            type: 'GET',
                            url: '../Home/Lastest/changeStatus',
                            data: {
                                id: id,
                                status: status
                            },
                            success: function (data) {
                                window.location.reload();
                            }
                        })

                    }
                } else if (status = -1) {
                    if (confirm("您确定审核不通过该条分享吗？")) {
                        $.ajax({
                            type: 'GET',
                            url: '../Home/Lastest/changeStatus',
                            data: {
                                id: id,
                                status: status
                            },
                            success: function (data) {
                                window.location.reload();
                            }
                        })
                    }
                }
            }
        }


    </script>