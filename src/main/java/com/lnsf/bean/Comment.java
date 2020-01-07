package com.lnsf.bean;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer orderId;

    private Integer userId;

    private String commentType;

    private String commentContent;

    private String commentPhoto;

    private String commentPower;

    private Integer replyId;

    private String commentFalgs;

    private Date createTime;

    private String commentBackup;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType == null ? null : commentType.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(String commentPhoto) {
        this.commentPhoto = commentPhoto == null ? null : commentPhoto.trim();
    }

    public String getCommentPower() {
        return commentPower;
    }

    public void setCommentPower(String commentPower) {
        this.commentPower = commentPower == null ? null : commentPower.trim();
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getCommentFalgs() {
        return commentFalgs;
    }

    public void setCommentFalgs(String commentFalgs) {
        this.commentFalgs = commentFalgs == null ? null : commentFalgs.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCommentBackup() {
        return commentBackup;
    }

    public void setCommentBackup(String commentBackup) {
        this.commentBackup = commentBackup == null ? null : commentBackup.trim();
    }
}