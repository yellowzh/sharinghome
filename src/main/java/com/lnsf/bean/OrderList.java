package com.lnsf.bean;

import java.util.Date;

public class OrderList {
    private Integer orderId;

    private Integer passengerId;

    private Integer businessId;

    private Integer housesId;

    private Integer housesNum;

    private Integer orderPrices;

    private String housesIn;

    private String orderPay;

    private Date createTime;

    private String orderFalgs;

    private String orderBackup;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getHousesId() {
        return housesId;
    }

    public void setHousesId(Integer housesId) {
        this.housesId = housesId;
    }

    public Integer getHousesNum() {
        return housesNum;
    }

    public void setHousesNum(Integer housesNum) {
        this.housesNum = housesNum;
    }

    public Integer getOrderPrices() {
        return orderPrices;
    }

    public void setOrderPrices(Integer orderPrices) {
        this.orderPrices = orderPrices;
    }

    public String getHousesIn() {
        return housesIn;
    }

    public void setHousesIn(String housesIn) {
        this.housesIn = housesIn == null ? null : housesIn.trim();
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay == null ? null : orderPay.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderFalgs() {
        return orderFalgs;
    }

    public void setOrderFalgs(String orderFalgs) {
        this.orderFalgs = orderFalgs == null ? null : orderFalgs.trim();
    }

    public String getOrderBackup() {
        return orderBackup;
    }

    public void setOrderBackup(String orderBackup) {
        this.orderBackup = orderBackup == null ? null : orderBackup.trim();
    }
}