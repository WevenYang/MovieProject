package com.example.administrator.traveldiary.bean;

/**
 * Created by NewHT on 2016/10/9.
 */
public class MovieDetail {
    String pic, title, goal;

    public MovieDetail(String pic, String title, String goal) {
        this.pic = pic;
        this.title = title;
        this.goal = goal;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "pic=" + pic +
                ", title='" + title + '\'' +
                ", goal='" + goal + '\'' +
                '}';
    }
}
