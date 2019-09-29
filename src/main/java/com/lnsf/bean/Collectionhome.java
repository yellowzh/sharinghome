package com.lnsf.bean;

import java.util.Date;

public class Collectionhome {
    private Integer collectionid;

    private Integer homeid;

    private Integer uid;

    private Date collectionTime;

    private Integer falgs;

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Integer collectionid) {
        this.collectionid = collectionid;
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Integer getFalgs() {
        return falgs;
    }

    public void setFalgs(Integer falgs) {
        this.falgs = falgs;
    }
}