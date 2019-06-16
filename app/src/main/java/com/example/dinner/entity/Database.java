package com.example.dinner.entity;


import java.util.ArrayList;
import java.util.List;

public class Database {
    public static String tableName;
    public static int sum=0;
    public static String content;
    public static List<OrderList> lists = new ArrayList<>();

    public static void orderLists(String name1,int price){
        sum+=price;
        OrderList orderList = new OrderList(name1,price,1);
        lists.add(orderList);
        /*if(lists.size()==0){
            OrderList orderList = new OrderList(name1,sum);
            lists.add(orderList);

        }else {
            for (OrderList l:lists) {
                if(l.caiName.equals(name1)){
                    l.caiCount++;
                }else {
                    OrderList orderList = new OrderList(name1,price);
                    lists.add(orderList);
                }
            }
        }*/


    }
}
