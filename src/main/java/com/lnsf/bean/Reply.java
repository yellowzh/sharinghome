package com.lnsf.bean;

public class Reply {
    private Integer replyId;

    private Integer tid;

    private String username;

    private String content;

    private String rphoto;

    private Integer fagls;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRphoto() {
        return rphoto;
    }

    public void setRphoto(String rphoto) {
        this.rphoto = rphoto == null ? null : rphoto.trim();
    }

    public Integer getFagls() {
        return fagls;
    }

    public void setFagls(Integer fagls) {
        this.fagls = fagls;
    }
}