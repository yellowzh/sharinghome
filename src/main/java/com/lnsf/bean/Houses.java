package com.lnsf.bean;

public class Houses {
    private Integer housesId;

    private Integer businessId;

    private String housesPhoto;

    private String housesTitle;

    private Integer housesCount;

    private Integer housesFocus;

    private Integer housesView;

    private Integer housesPrices;

    private String housesAddress;

    private String housesFalgs;

    private String housesBackup;

    public Integer getHousesId() {
        return housesId;
    }

    public void setHousesId(Integer housesId) {
        this.housesId = housesId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getHousesPhoto() {
        return housesPhoto;
    }

    public void setHousesPhoto(String housesPhoto) {
        this.housesPhoto = housesPhoto == null ? null : housesPhoto.trim();
    }

    public String getHousesTitle() {
        return housesTitle;
    }

    public void setHousesTitle(String housesTitle) {
        this.housesTitle = housesTitle == null ? null : housesTitle.trim();
    }

    public Integer getHousesCount() {
        return housesCount;
    }

    public void setHousesCount(Integer housesCount) {
        this.housesCount = housesCount;
    }

    public Integer getHousesFocus() {
        return housesFocus;
    }

    public void setHousesFocus(Integer housesFocus) {
        this.housesFocus = housesFocus;
    }

    public Integer getHousesView() {
        return housesView;
    }

    public void setHousesView(Integer housesView) {
        this.housesView = housesView;
    }

    public Integer getHousesPrices() {
        return housesPrices;
    }

    public void setHousesPrices(Integer housesPrices) {
        this.housesPrices = housesPrices;
    }

    public String getHousesAddress() {
        return housesAddress;
    }

    public void setHousesAddress(String housesAddress) {
        this.housesAddress = housesAddress == null ? null : housesAddress.trim();
    }

    public String getHousesFalgs() {
        return housesFalgs;
    }

    public void setHousesFalgs(String housesFalgs) {
        this.housesFalgs = housesFalgs == null ? null : housesFalgs.trim();
    }

    public String getHousesBackup() {
        return housesBackup;
    }

    public void setHousesBackup(String housesBackup) {
        this.housesBackup = housesBackup == null ? null : housesBackup.trim();
    }
}