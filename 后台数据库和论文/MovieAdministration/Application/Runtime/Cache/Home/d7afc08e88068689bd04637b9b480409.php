<?php if (!defined('THINK_PATH')) exit();?>
    <head>
        <base href="/dashboard/www/Thinkphp3.2/MovieAdministration/Public/">
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <form method="post" action="">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 用户管理</strong></div>
            <table class="table table-hover text-center">
                <tr>
                    <th width="120">ID</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>性别</th>
                    <th>注册时间</th>
                    <th width="25%">简介</th>
                </tr>
                <?php if(is_array($getInfo)): foreach($getInfo as $key=>$infos): ?><tr>
                        <td><?php echo ($infos["p_id"]); ?></td>
                        <td><?php echo ($infos["nick_name"]); ?></td>
                        <td><?php echo ($infos["cell_phone"]); ?></td>
                        <td><?php echo ($infos["sex"]); ?></td>
                        <td><?php echo ($infos["date"]); ?></td>
                        <td><?php echo ($infos["introduce"]); ?></td>
                   </tr><?php endforeach; endif; ?>
            </table>
        </div>
    </form>




    <script type="text/javascript">

        function del(id){
            if(confirm("您确定要删除吗?")){

            }
        }

        $("#checkall").click(function(){
            $("input[name='id[]']").each(function(){
                if (this.checked) {
                    this.checked = false;
                }
                else {
                    this.checked = true;
                }
            });
        })

        function DelSelect(){
            var Checkbox=false;
            $("input[name='id[]']").each(function(){
                if (this.checked==true) {
                    Checkbox=true;
                }
            });
            if (Checkbox){
                var t=confirm("您确认要删除选中的内容吗？");
                if (t==false) return false;
            }
            else{
                alert("请选择您要删除的内容!");
                return false;
            }
        }

    </script>