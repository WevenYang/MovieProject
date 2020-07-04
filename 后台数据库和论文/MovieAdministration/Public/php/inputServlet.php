<?php
checkIfTrue("weven", "1");

function checkIfTrue($aco, $pwd){
    $driverName = "localhost";
    $userName = "root";
    $passWord = "";
    $conn = mysql_connect($driverName, $userName, $passWord);
    mysql_query("set names utf8");
    mysql_select_db("film");
    $sql = "select phone from modult_comment WHERE name = '$pwd'";
    $link = mysql_query($sql, $conn);
    if(mysql_fetch_object($link)){
        echo "{\"status\": \"succeed\"}";

    }else{
        echo "{\"status\": \"false\"}";
    }
    mysql_close();
}