package com.golsen.week7.model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class ProgrammeGroup {

    private List<Programmes> datas;
    private Advertisements focusImages;

    public Advertisements getFocusImages() {
        return focusImages;
    }

    public void setFocusImages(Advertisements focusImages) {
        this.focusImages = focusImages;
    }

    public List<Programmes> getDatas() {
        return datas;
    }

    public void setDatas(List<Programmes> datas) {
        this.datas = datas;
    }
}
