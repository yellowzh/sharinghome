package com.lnsf.bean;

public class Comment {
    private Integer tid;

    private Integer topicId;

    private String comContent;

    private String username;

    private String tphoto;

    private String tpower;

    private Integer falgs;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTphoto() {
        return tphoto;
    }

    public void setTphoto(String tphoto) {
        this.tphoto = tphoto == null ? null : tphoto.trim();
    }

    public String getTpower() {
        return tpower;
    }

    public void setTpower(String tpower) {
        this.tpower = tpower == null ? null : tpower.trim();
    }

    public Integer getFalgs() {
        return falgs;
    }

    public void setFalgs(Integer falgs) {
        this.falgs = falgs;
    }
}