<?php
/**
 * Created by PhpStorm.
 * User: QQ594
 * Date: 2018/8/28
 * Time: 0:08
 */

namespace Home\Controller;
use Think\Controller;

class HomeController extends Controller
{
    public function index(){
        $this -> assign("getInfo", $this->getPeopleInfo());
        $this -> display("index");
    }

    public function getPeopleInfo(){
        header('content-type:application/json;charset=utf8');
//        $condition["id"] = I('get.PersonId');
        $data = M("people_info") -> order("p_id desc") -> select();
        return $data;
    }
}