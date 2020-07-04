<?php
namespace Home\Controller;
use Think\Controller;
class IndexController extends Controller {
    public function index(){
     //   $this->show('<style type="text/css">*{ padding: 0; margin: 0; } div{ padding: 4px 48px;} body{ background: #fff; font-family: "微软雅黑"; color: #333;font-size:24px} h1{ font-size: 100px; font-weight: normal; margin-bottom: 12px; } p{ line-height: 1.8em; font-size: 36px } a,a:hover{color:blue;}</style><div style="padding: 24px 48px;"> <h1>:)</h1><p>欢迎使用 <b>ThinkPHP</b>！</p><br/>版本 V{$Think.version}</div><script type="text/javascript" src="http://ad.topthink.com/Public/static/client.js"></script><thinkad id="ad_55e75dfae343f5a1"></thinkad><script type="text/javascript" src="http://tajs.qq.com/stats?sId=9347272" charset="UTF-8"></script>','utf-8');
        $this -> display("index");
    }

    /**
     * 登陆接口
     */
    public function login()
    {
//        $condition['cell_phone'] = I('get.cellPhone');
//        $condition['password'] = I('get.password');
        $phone = I('get.cellphone');
        $pwd = I('get.password');
        $user = M("people_info")->where(["cell_phone" => $phone, "password" => $pwd])->select();
        if ($user) {
            $arr = array(
                "code" => 200,
                "result" => "登陆成功",
                "data" => $user,
                "success" => true
            );
        } else {
            $arr = array(
                "code" => 404,
                "result" => "登陆失败，找不到该账号",
                "data" => "",
                "success" => false
            );
        }
        echo json_encode($arr);
    }

    public function register(){
        $acc = I('get.account');
        $psd  = I('get.password');
        $nick = I('get.nick');
        //查询是否有该用户注册过
        $data = M('people_info') -> where(['cell_phone'=>$acc, 'password'=>$psd]) -> find();
        if ($data){
            $arr = array(
                "code" => 404,
                "data" => "",
                "result" => "已存在该用户",
                "success" => false
            );
        }else{
            $con['cell_phone'] = $acc;
            $con['password'] = $psd;
            $con['nick_name'] = $nick;
            M('people_info') -> add($con);
            $user_id = M("people_info") -> where(['cell_phone'=>$acc]) -> getField("id");
            if ($user_id){
                $arr = array(
                    "code" => 200,
                    "data" => $user_id,
                    "result" => "注册成功",
                    "success" => true
                );
            }else{
                $arr = array(
                    "code" => 403,
                    "data" => "",
                    "result" => "注册失败",
                    "success" => false
                );
            }

        }
        echo json_encode($arr);
    }

    public function getMovieInfos(){
        $userId = I("get.id");
        if (M("people_info") -> where("p_id=%d", $userId) -> select()){

            $arrayList = M("movie_info")
                ->alias('t')
                ->join("left join people_info as o on t.author_id = o.p_id")
                -> order("t.id desc")
                -> select();
            if ($arrayList){
                $arr = array(
                    "code" => 200,
                    "data" => $arrayList,
                    "success" => true
                );
            }else {
                $arr = array(
                    "code" => 402,
                    "data" => "加载失败",
                    "success" => false
                );
            }
        }else {
            $arr = array(
                "code" => 404,
                "data" => "加载失败，id获取不成功",
                "success" => false
            );
        }
        echo json_encode($arr);
    }

    public function getPersonInfo(){
        $id = I('get.id');
        $user_info = M("people_info")->where(["p_id" => $id])->select();
        if ($user_info) {
            $arr = array(
                "code" => 200,
                "result" => "获取成功",
                "data" => $user_info,
                "success" => true
            );
        } else {
            $arr = array(
                "code" => 404,
                "result" => "获取失败，找不到该账号",
                "data" => "",
                "success" => false
            );
        }
        echo json_encode($arr);
    }

    public function getPeopleComments(){
        $con["info_id"]= I('get.comment_id');
//        $con[""] = I("get".id);
        $list = M("movie_comment")
            ->alias('t')
            -> join('left join people_info as o on t.author_id = o.p_id')
            -> where($con)
            -> select();
        if ($list){
            $arr = array(
                "code" => 200,
                "result" => "获取成功",
                "data" => $list,
                "success" => true
            );
        }else{
            $arr = array(
                "code" => 403,
                "result" => "获取失败",
                "data" => $list,
                "success" => false
            );
        }
        echo json_encode($arr);
    }

    public function submitMovieComments(){
        header("Content-Type:text/html; charset=utf-8");
        $con["author_id"] = I("get.id");
        $con["info_id"] = I("get.info_id");
        $con["comment"] = I("get.comment");
        $con["date"] = date();
        $list = M("movie_comment") -> add($con);
        if ($list){
            $arr = array(
                "code" => 200,
                "result" => "提交成功",
                "data" => "",
                "success" => true
            );
        }else{
            $arr = array(
                "code" => 404,
                "result" => "提交失败",
                "data" => "",
                "success" => false
            );
        }
        echo json_encode($arr);
    }

    public function submitMovieShare(){
        header("Content-Type:text/html; charset=utf-8");
        $con["author_id"]= I('get.id');
        $con["author_name"]=I('get.name');
        $con["title"]=I('get.title');
        $con["content"]=I("get.content");
        $con["img"]=I("get.pic");
        $con["time"]=date("Y-m-d H:i:s");
        $user_info = M("movie_info")->add($con);
        if ($user_info) {
            $arr = array(
                "code" => 200,
                "result" => "提交成功",
                "data" => "",
                "success" => true
            );
        } else {
            $arr = array(
                "code" => 404,
                "result" => "提交失败",
                "data" => "",
                "success" => false
            );
        }
        echo json_encode($arr);
    }

    public function uploadFile(){
        $upload = new \Think\Upload();// 实例化上传类
        $upload->maxSize = 3145728 ;// 设置附件上传大小
        $upload->exts = array('jpg', 'gif', 'png', 'jpeg');// 设置附件上传类型
        $upload->rootPath = './Uploads/'; // 设置附件上传根目录
        $upload->savePath = ''; // 设置附件上传（子）目录
        // 上传文件
        $info = $upload->upload();
        if(!$info) {// 上传错误提示错误信息
            $this->error($upload->getError());
        }else{// 上传成功 获取上传文件信息
            foreach($info as $file){
                echo $file['savepath'].$file['savename'];
            }

        }
    }
}