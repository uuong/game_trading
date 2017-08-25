package com.sky.pojo;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable{
    private Integer goodsId;

    private Integer userId;

    private Integer areaId;

    private String name;

    private Integer number;

    private Integer price;

    private Byte state;

    private Date startTime;

    private Date endTime;

    public Goods(Integer goodsId, Integer userId, Integer areaId, String name, Integer number, Integer price, Byte state, Date startTime, Date endTime) {
        this.goodsId = goodsId;
        this.userId = userId;
        this.areaId = areaId;
        this.name = name;
        this.number = number;
        this.price = price;
        this.state = state;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Goods() {
        super();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", userId=" + userId +
                ", areaId=" + areaId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", state=" + state +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}