package com.lnsf.bean;

public class Homeshow {
    private Integer id;//主键

    private String imgsrc;//房间图片

    private String title;//标题

    private Integer count;//预览量

    private Integer focus;//收藏量

    private Integer view;

    private Double prices;

    private String address;

    private Integer falgs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc == null ? null : imgsrc.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getFalgs() {
        return falgs;
    }

    public void setFalgs(Integer falgs) {
        this.falgs = falgs;
    }

    @Override
    public String toString() {
        return "Homeshow{" +
                "id=" + id +
                ", imgsrc='" + imgsrc + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", focus=" + focus +
                ", view=" + view +
                ", prices=" + prices +
                ", address='" + address + '\'' +
                ", falgs=" + falgs +
                '}';
    }
    public Homeshow(){}

    public Homeshow(Integer id, String imgsrc, String title, Integer count, Integer focus, Integer view, Double prices, String address, Integer falgs) {
        this.id = id;
        this.imgsrc = imgsrc;
        this.title = title;
        this.count = count;
        this.focus = focus;
        this.view = view;
        this.prices = prices;
        this.address = address;
        this.falgs = falgs;
    }
}