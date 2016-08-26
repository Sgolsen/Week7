package com.golsen.week7.model;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class Radios {
    private String  rname;
    private String programName;
    private int radioPlayCount;
    private String radioCoverSmall;

    public String getRadioCoverSmall() {
        return radioCoverSmall;
    }

    public void setRadioCoverSmall(String radioCoverSmall) {
        this.radioCoverSmall = radioCoverSmall;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getRadioPlayCount() {
        return radioPlayCount;
    }

    public void setRadioPlayCount(int radioPlayCount) {
        this.radioPlayCount = radioPlayCount;
    }
}
