package com.lnsf.bean;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private String username;

    private String realName;

    private String userTel;

    private String userEmil;

    private String password;

    private String userPower;

    private String userStatus;

    private Date userLogintime;

    private Date userLoginouttime;

    private Integer userNum;

    private String userBackup1;

    private String userBackup2;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserEmil() {
        return userEmil;
    }

    public void setUserEmil(String userEmil) {
        this.userEmil = userEmil == null ? null : userEmil.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower == null ? null : userPower.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public Date getUserLogintime() {
        return userLogintime;
    }

    public void setUserLogintime(Date userLogintime) {
        this.userLogintime = userLogintime;
    }

    public Date getUserLoginouttime() {
        return userLoginouttime;
    }

    public void setUserLoginouttime(Date userLoginouttime) {
        this.userLoginouttime = userLoginouttime;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public String getUserBackup1() {
        return userBackup1;
    }

    public void setUserBackup1(String userBackup1) {
        this.userBackup1 = userBackup1 == null ? null : userBackup1.trim();
    }

    public String getUserBackup2() {
        return userBackup2;
    }

    public void setUserBackup2(String userBackup2) {
        this.userBackup2 = userBackup2 == null ? null : userBackup2.trim();
    }
}