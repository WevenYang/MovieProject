<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2016/12/14 0014
 * Time: 下午 3:39
 */
$link = mysql_connect("w.rdc.sae.sina.com.cn", "mljzlj4l42", "i11lm04y1h02z15h250z4ii2ymkx0xw42xx41ymm");
mysql_query("set names utf8");
mysql_select_db("app_594771590");
$sql = "select * from module_message";
$result = mysql_query($sql, $link);
echo "<table class=\"table table-hover text-center\">
    <tr>
      <th width=\"10%\">ID</th>
      <th width=\"20%\">头像</th>
      <th width=\"15%\">作者</th>
      <th width=\"20%\">留言内容</th>
      <th width=\"10%\">留言时间</th>
      <th width=\"15%\">操作</th>
    </tr>";
while ($row = mysql_fetch_array($result)){
    echo "<tr>
         <td>".$row["id"]."</td>
      <td><img src=\"./images/11.jpg\" alt=\"\" width=\"120\" height=\"50\" /></td>
      <td>".$row["author_name"]."</td>
      <td>".$row["author_message"]."</td>
      <td>".$row["time"]."</td>
      <td><div class=\"button-group\">
      <a class=\"button border-main\" onclick=\"return pass(1,1)\"><span class=\"icon-edit\"></span> 阅过</a>
      <a class=\"button border-red\" href=\"javascript:void(0)\" onclick=\"return del(1,1)\"><span class=\"icon-trash-o\"></span> 回复</a>
      </div></td>
    </tr>";
}
mysql_close();
"</table>";