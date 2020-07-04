package com.example.administrator.traveldiary.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
public class PersonData {


    /**
     * code : 200
     * result : 获取成功
     * data : [{"id":"1","cell_phone":"123","password":"123","nick_name":"weven","pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg","sex":"1","introduce":"一个没有感情的观众","date":"2019年10月25日22:37:01"}]
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
         * cell_phone : 123
         * password : 123
         * nick_name : weven
         * pic : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg
         * sex : 1
         * introduce : 一个没有感情的观众
         * date : 2019年10月25日22:37:01
         */

        private String p_id;
        private String cell_phone;
        private String password;
        private String nick_name;
        private String pic;
        private String sex;
        private String introduce;
        private String date;

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
