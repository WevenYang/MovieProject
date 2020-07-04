<?php
/**
 * Created by PhpStorm.
 * User: NewHT
 * Date: 2016/12/12
 * Time: 19:52
 */
    if (isset($_POST["submit"]) && $_POST == "登陆")
    {
        $user = $_POST["name"];
        $psw = $_POST["password"];
        if ($user == "" || $psw == ""){
            echo "<script>alert(\"请输入用户名和密码\");</script>";
        }else{
            mysqli_connect("localhost", "root", "");
            mysql_select_db("file");
            mysql_query("set names utf-8");
            $sql = "select * from superAdministrator where account = '$_POST[name]' and password = '$_POST[password]'";
            $result = mysql_query($sql);
            $num = mysql_num_rows($result);
            if ($num){
                $row = mysql_fetch_array($result);
                echo "<script>alert('登陆成功');history.go(-1);</script>";
            }else{
                echo "<script>alert('用户名不存在')</script>";
            }
        }
    }else{
        echo "<scritp>alert('提交未成功')</scritp>";
    }