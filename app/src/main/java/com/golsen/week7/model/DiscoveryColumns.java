package com.golsen.week7.model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class DiscoveryColumns {
    private String title;
    private List<Columns> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Columns> getList() {
        return list;
    }

    public void setList(List<Columns> list) {
        this.list = list;
    }
}
