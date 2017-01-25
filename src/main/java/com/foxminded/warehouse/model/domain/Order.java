package com.foxminded.warehouse.model.domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private String date = dateFormat(new Date(System.currentTimeMillis()));
    private List<OrderItem> listOrderItems;
    private BigDecimal orderValue;

    public Order(int id, String date, List<OrderItem> list){
        this.id = id;
        this.date = date;
        this.listOrderItems = list;
        orderValue = calculateOrderValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderItem> getListOrderItems() {
        return listOrderItems;
    }

    public void setListOrderItems(List<OrderItem> listOrderItems) {
        this.listOrderItems = listOrderItems;
    }

    public BigDecimal getOrderValue() {
        return orderValue;
    }

    private BigDecimal calculateOrderValue() {
        BigDecimal orderValue = BigDecimal.ZERO;
        for (OrderItem orderItem : listOrderItems) {
            orderValue = orderValue.add(orderItem.getValue());
        }
        return orderValue.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private String dateFormat(Date d){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }

    public void printOrder() {
        int counter = 1;
        System.out.println("Order # " + id + "          Date: " + date);
        System.out.println("-----------------------------------------------------------------");
        for (OrderItem orderItem : listOrderItems) {
            System.out.println(counter + ". " + orderItem.toString());
            counter++;
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("TOTAL value of Receipt - " + orderValue + " UAH.");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }


}

