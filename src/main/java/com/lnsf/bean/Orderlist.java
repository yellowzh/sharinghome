package com.lnsf.bean;

public class Orderlist {
    private Integer oid;

    private String utel;

    private String htel;

    private String username;

    private String husername;

    private Integer falgs;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel == null ? null : utel.trim();
    }

    public String getHtel() {
        return htel;
    }

    public void setHtel(String htel) {
        this.htel = htel == null ? null : htel.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getHusername() {
        return husername;
    }

    public void setHusername(String husername) {
        this.husername = husername == null ? null : husername.trim();
    }

    public Integer getFalgs() {
        return falgs;
    }

    public void setFalgs(Integer falgs) {
        this.falgs = falgs;
    }
}