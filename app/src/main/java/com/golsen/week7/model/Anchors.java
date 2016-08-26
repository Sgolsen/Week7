package com.golsen.week7.model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class Anchors {
    private int id;
    private String title;
    private List<Anchor> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Anchor> getList() {
        return list;
    }

    public void setList(List<Anchor> list) {
        this.list = list;
    }
}
