package com.example.dinner.entity;

public class OrderList {
    public String caiName;
    public int caiCount;
    public int price;
    public OrderList(String caiName,int Price,int caiCount){
        this.caiCount = caiCount;
        this.caiName = caiName;
        this.price = Price;
    }
}
