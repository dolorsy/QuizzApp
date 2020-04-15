package com.dolor.quizzapp;

import android.graphics.Bitmap;
import android.media.Image;

import java.net.URL;

public class QuizModel {
    private String imageURL;
    private String name,describ,level;
    private int questionsNumber;

    public QuizModel(String imageURL, String name, String describ, String level, int questionsNumber) {
        this.imageURL = imageURL;
        this.name = name;
        this.describ = describ;
        this.level = level;
        this.questionsNumber = questionsNumber;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImage(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getQuestionsNumber() {
        return questionsNumber;
    }

    public void setQuestionsNumber(int questionsNumber) {
        this.questionsNumber = questionsNumber;
    }
}
