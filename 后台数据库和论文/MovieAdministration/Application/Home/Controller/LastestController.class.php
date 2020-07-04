<?php
/**
 * Created by PhpStorm.
 * User: QQ594
 * Date: 2019/10/24
 * Time: 23:32
 */

namespace Home\Controller;
use Think\Controller;

class LastestController extends Controller
{
    public function index(){
        $this -> assign("getLastest", $this->getLastest());
        $this -> display("index");
    }

    public function getLastest(){
        header('content-type:application/json;charset=utf8');
        $list = M("movie_info")
            ->alias("m")
            ->join("left join people_info as p on m.author_id = p.p_id")
            ->where("m_pass = %d", 0)
            -> order("id desc")
            -> select();
        return $list;
    }

    public function changeStatus(){
        $id = I("get.id");
        $status = I("get.status");
        $result = M("movie_info") -> where("id = %d", $id) -> setField("m_pass", $status);
        if ($result){
            $arr = array(
                "code" => 200,
                "data" => "",
                "result" => "修改成功",
                "success" => true
            );
        }else {
            $arr = array(
                "code" => 402,
                "data" => "",
                "result" => "修改失败",
                "success" => false
            );
        }
        echo json_encode($arr);
    }
}