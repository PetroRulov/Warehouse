package com.foxminded.warehouse.model.domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Receipt {
    private int id;
    private String date = dateFormat(new Date(System.currentTimeMillis()));
    private List<ReceiptItem> listReceiptItems;
    private BigDecimal receiptValue;

    public Receipt(int id, String date, List<ReceiptItem> list){
        this.id = id;
        this.date = date;
        this.listReceiptItems = list;
        receiptValue = calculateReceiptValue();
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

    public List<ReceiptItem> getListReceiptItems() {
        return listReceiptItems;
    }

    public void setListReceiptItems(List<ReceiptItem> listReceiptItems) {
        this.listReceiptItems = listReceiptItems;
    }

    public BigDecimal getReceiptValue() {
        return receiptValue;
    }

    private BigDecimal calculateReceiptValue() {
        BigDecimal receiptValue = BigDecimal.ZERO;
        for (int i = 0; i < listReceiptItems.size(); i++) {
            receiptValue = receiptValue.add(listReceiptItems.get(i).getValue());
        }
        return receiptValue.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private String dateFormat(Date d){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }

    public void printReceipt() {
        int counter = 1;
        System.out.println("Receipt # " + id + "          Date: " + date);
        System.out.println("-----------------------------------------------------------------");
        for (ReceiptItem receiptItem : listReceiptItems) {
            System.out.println(counter + ". " + receiptItem.toString());
            counter++;
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("TOTAL value of Receipt - " + receiptValue + " UAH.");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }


}