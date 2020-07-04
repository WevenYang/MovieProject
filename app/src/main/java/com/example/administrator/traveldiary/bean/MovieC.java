package com.example.administrator.traveldiary.bean;

import java.util.List;

public class MovieC {


    /**
     * code : 200
     * data : [{"id":"1","author_id":"1","title":"","content":"","img":"","fav":"0","date":"2019年10月25日22:37:01","cell_phone":"123","password":"123","nick_name":"weven","pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg","sex":"1","introduce":"一个没有感情的观众"},{"id":"1","author_id":"1","title":"《招魂》为何会在恐怖片中大放异彩？","content":"《招魂》为何会在恐怖片中大放异彩？温氏恐怖占据了大头\r\n\r\n在欧美的恐怖片之中，血腥以及非常恐怖的营销范围是十分常见的。然而这样的恐怖片却令观众们感到审美疲劳。\r\n\r\n然而作为华人所导演的东方色彩电影现在这样的氛围之下，带来了不一样的感受。小编今天就来和大家一起探讨一下这个恐怖的电影吧。\r\n既然提到了招魂，那么就不得不提起这一位华人导演。我们的温导身为华人，便将东方的吓人方式进行了精彩的呈现。而在这期间又添加了来自于西方的恐怖手法，使得整个电影呈现出来的氛围十分的可怕与精彩。\r\n\r\n当人们看惯了血浆像是不要钱般的泼洒，电影的色调变得越发的昏暗，伴随着那种可怕的印象，使得观众们的第一印象就是在讲笑话的同时在挠你的痒痒肉一般。\r\n\r\n这样的机械式恐怖使得观众们在初期的惊奇过后，变得越来越麻木。而我们的温导则是在这样的氛围之下，将恐怖场景带动人们紧张刺激情绪的方式融入到了西式电影之中。","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1572065260655&di=b5fcfefe217084c5b390e14fa97a7085&imgtype=0&src=http%3A%2F%2Fgss0.baidu.com%2F9fo3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Db202cb3f96cad1c8d0eef4234a0e4b3f%2Fd1a20cf431adcbeff445a516afaf2edda3cc9fa9.jpg","fav":"0","date":"2019年10月25日22:37:01","cell_phone":"123","password":"123","nick_name":"weven","pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg","sex":"1","introduce":"一个没有感情的观众"}]
     * success : true
     */

    private int code;
    private boolean success;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
         * author_id : 1
         * title :
         * content :
         * img :
         * fav : 0
         * date : 2019年10月25日22:37:01
         * cell_phone : 123
         * password : 123
         * nick_name : weven
         * pic : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg
         * sex : 1
         * introduce : 一个没有感情的观众
         */

        private String id;
        private String author_id;
        private String title;
        private String content;
        private String img;
        private String fav;
        private String time;
        private String cell_phone;
        private String password;
        private String nick_name;
        private String pic;
        private String sex;
        private String introduce;
        private String m_pass;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getFav() {
            return fav;
        }

        public void setFav(String fav) {
            this.fav = fav;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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

        public String getM_pass() {
            return m_pass;
        }

        public void setM_pass(String m_pass) {
            this.m_pass = m_pass;
        }
    }
}
