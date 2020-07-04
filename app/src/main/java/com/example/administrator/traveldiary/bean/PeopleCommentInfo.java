package com.example.administrator.traveldiary.bean;

import java.util.List;

public class PeopleCommentInfo {

    /**
     * code : 200
     * result : 获取成功
     * data : [{"id":"1","info_id":"1","author_id":"2","comment":"这是一条测试评论","c_date":"2019年11月8日23:55:44","p_id":"2","cell_phone":"","password":"123","nick_name":"Yang","pic":"","sex":"0","introduce":"","date":""},{"id":"2","info_id":"1","author_id":"1","comment":"这又是一条评论","c_date":"2019年11月10日22:34:40","p_id":"1","cell_phone":"123","password":"123","nick_name":"weven","pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg","sex":"1","introduce":"一个没有感情的观众","date":"2019年10月25日22:37:01"},{"id":"3","info_id":"1","author_id":"1","comment":"123","c_date":"","p_id":"1","cell_phone":"123","password":"123","nick_name":"weven","pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg","sex":"1","introduce":"一个没有感情的观众","date":"2019年10月25日22:37:01"}]
     * success : true
     */

    private int code;
    private String result;
    private boolean success;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * info_id : 1
         * author_id : 2
         * comment : 这是一条测试评论
         * c_date : 2019年11月8日23:55:44
         * p_id : 2
         * cell_phone :
         * password : 123
         * nick_name : Yang
         * pic :
         * sex : 0
         * introduce :
         * date :
         */

        private String id;
        private String info_id;
        private String author_id;
        private String comment;
        private String c_date;
        private String p_id;
        private String cell_phone;
        private String password;
        private String nick_name;
        private String pic;
        private String sex;
        private String introduce;
        private String date;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInfo_id() {
            return info_id;
        }

        public void setInfo_id(String info_id) {
            this.info_id = info_id;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getC_date() {
            return c_date;
        }

        public void setC_date(String c_date) {
            this.c_date = c_date;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }

        public String getCell_phone() {
            return cell_phone;
        }

        public void setCell_phone(String cell_phone) {
            this.cell_phone = cell_phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
