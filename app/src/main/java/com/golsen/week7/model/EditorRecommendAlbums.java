package com.golsen.week7.model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class EditorRecommendAlbums {
    private String title;
    private List<AlbumsContent> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AlbumsContent> getList() {
        return list;
    }

    public void setList(List<AlbumsContent> list) {
        this.list = list;
    }
}
