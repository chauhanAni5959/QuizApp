package com.projectankit.quizapp.modelClass;

public class HomeModel {
//    creating variable for title and description
    String title , des;

    public HomeModel() {

    }

    public HomeModel(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
