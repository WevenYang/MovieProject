package com.example.administrator.traveldiary.bean;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class Comment {
    int id;
    String essay_title, essay_content, essay_image, author_level, author_image, author_name, num_like;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_like() {
        return num_like;
    }

    public void setNum_like(String num_like) {
        this.num_like = num_like;
    }

    public String getEssay_title() {
        return essay_title;
    }

    public void setEssay_title(String essay_title) {
        this.essay_title = essay_title;
    }

    public String getEssay_content() {
        return essay_content;
    }

    public void setEssay_content(String essay_content) {
        this.essay_content = essay_content;
    }

    public String getEssay_image() {
        return essay_image;
    }

    public void setEssay_image(String essay_image) {
        this.essay_image = essay_image;
    }

    public String getAuthor_level() {
        return author_level;
    }

    public void setAuthor_level(String author_level) {
        this.author_level = author_level;
    }

    public String getAuthor_image() {
        return author_image;
    }

    public void setAuthor_image(String author_image) {
        this.author_image = author_image;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
