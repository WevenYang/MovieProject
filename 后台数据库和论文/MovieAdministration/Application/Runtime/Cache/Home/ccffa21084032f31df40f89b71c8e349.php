<?php if (!defined('THINK_PATH')) exit();?>
    <head>
        <base href="/dashboard/www/Thinkphp3.2/MovieAdministration/Public/">
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 最新列表</strong></div>
        <div class="padding border-bottom">
            <button type="button" class="button border-yellow" ><span class="icon-plus-square-o"></span> 全部阅过</button>
        </div>
        <div id="load">
            <table class="table table-hover text-center">
                <tr>
                    <th width="120">ID</th>
                    <th>标题</th>
                    <th>文章内容</th>
                    <th>作者</th>
                    <th>发表时间</th>
                    <th>操作</th>
                </tr>
                <?php if(is_array($getLastest)): foreach($getLastest as $key=>$items): ?><tr>
                        <td><?php echo ($items["id"]); ?></td>
                        <td><?php echo ($items["title"]); ?></td>
                        <td><?php echo ($items["content"]); ?></td>
                        <td><?php echo ($items["author_id"]); ?></td>
                        <td><?php echo ($items["time"]); ?></td>
                        <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
                    </tr><?php endforeach; endif; ?>
            </table>
        </div>
    </div>
    <div class="panel admin-panel margin-top" id="add">
        <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 回复内容</strong></div>
        <div class="body-content">
            <form method="post" class="form-x" action="">
                <div class="form-group">
                    <div class="label">
                        <label>描述：</label>
                    </div>
                    <div class="field">
                        <textarea type="text" class="input" name="note" style="height:450px;" value=""></textarea>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit" onclick="submit(1,1)"> 回复作者</button>
                    </div>
                </div>
            </form>
        </div>
    </div>



    <script language="JavaScript">
        function del(id,mid){
            window.location.href='#add';
        }

        function pass(id, mid){
            if(confirm("您确定允许通过吗？"))
            {
                var table = document.getElementsByClassName("table")
                s="";
                for(var i = 0; i<table.rows.length ; i++){
                    var onerow = table.rows[i];
                    for(var j = 0,l2 = onerow.cells.length; j< l2;j++){
                        s += onerow.cells[j].innerText;
                    }
                    s+="n"
                }
                alert("fuck");
            }
        }

        function submit(id, mid) {

        }
    </script>