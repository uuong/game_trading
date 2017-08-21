package com.sky.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer buyId;

    private Integer sellerId;

    private Integer goodsId;

    private Date time;

    private Integer amount;

    public Order(Integer orderId, Integer buyId, Integer sellerId, Integer goodsId, Date time, Integer amount) {
        this.orderId = orderId;
        this.buyId = buyId;
        this.sellerId = sellerId;
        this.goodsId = goodsId;
        this.time = time;
        this.amount = amount;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}