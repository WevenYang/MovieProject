<?php
/**
 * Created by PhpStorm.
 * User: QQ594
 * Date: 2018/9/12
 * Time: 23:10
 */

namespace Home\Controller;
use Think\Controller;

class ChangePwdController extends Controller
{
        public function index(){
            $this -> display("index");
        }

        public function change(){
            $formerPwd = I("post.former");
            $newPwd = I("post.new");
            if (M("admin_info") -> where("password = %s", $formerPwd) -> select()){
                M('admin_info') -> where("password = %s", $formerPwd) -> setField('password', $newPwd);
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
                    "result" => "修改失败,请检查密码",
                    "success" => false
                );
            }
            echo json_encode($arr);
        }
}