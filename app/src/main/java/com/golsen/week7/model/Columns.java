package com.golsen.week7.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class Columns implements Serializable{
    private String title;
    private String coverPath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }
}
