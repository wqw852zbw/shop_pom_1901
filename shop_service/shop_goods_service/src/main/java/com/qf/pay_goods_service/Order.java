package com.qf.pay_goods_service;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName:Order
 * @Author: Zhengbowen
 * @Description:
 * @Date: Created in 17:07 2020/7/5
 * @Modified
 * @VERSION 1.0
 */
@Data
public class Order implements Serializable {

    private String OrderId;

    private Integer orderStatus;

    private String oderName;

    public Order() {

    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOderName() {
        return oderName;
    }

    public void setOderName(String oderName) {
        this.oderName = oderName;
    }
}
