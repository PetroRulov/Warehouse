package com.foxminded.warehouse.model.domain;

import java.math.BigDecimal;

/**
 * Created by prulov on 23.01.2017.
 */
public class Goods {

    private int id;
    private String name;
    private int groupID;
    private String providerCode;
    private int producerID;

    private String barcode;

    private float quantity;
    private int items;
    private String measureItem;
    private BigDecimal sellPrice;
    private BigDecimal purchPrice;

    public Goods() {}

    public Goods(int id, String name, int groupID, String providerCode, int producerID, float quantity,
                 String measureItem, BigDecimal sellPrice, BigDecimal purchPrice) {
        this.id = id;
        this.name = name;
        this.groupID = groupID;
        this.providerCode = providerCode;
        this.producerID = producerID;
        this.barcode = composeBarcode(producerID, providerCode, groupID, id);
        this.quantity = quantity;
        this.measureItem = measureItem;
        this.sellPrice = sellPrice;
        this.purchPrice = purchPrice;
    }

    public Goods(int id, String name, int groupID, String providerCode, int producerID, int items,
                 String measureItem, BigDecimal sellPrice, BigDecimal purchPrice) {
        this.id = id;
        this.name = name;
        this.groupID = groupID;
        this.providerCode = providerCode;
        this.producerID = producerID;
        this.barcode = composeBarcode(producerID, providerCode, groupID, id);
        this.items = items;
        this.measureItem = measureItem;
        this.sellPrice = sellPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.purchPrice = purchPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public String getMeasureItem() {
        return measureItem;
    }

    public void setMeasureItem(String measureItem) {
        this.measureItem = measureItem;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getPurchPrice() {
        return purchPrice;
    }

    public void setPurchPrice(BigDecimal purchPrice) {
        this.purchPrice = purchPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    public String composeBarcode(int producerID, String providerCode, int groupID, int id) {
        String prod = String.valueOf(producerID);
        String group = String.valueOf(groupID);
        String ident = String.valueOf(id);
        return prod + "-" + providerCode + "-" + group + "-" + ident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (getGroupID() != goods.getGroupID()) return false;
        if (getProducerID() != goods.getProducerID()) return false;
        if (!getName().equals(goods.getName())) return false;
        if (!getProviderCode().equals(goods.getProviderCode())) return false;
        if (!getMeasureItem().equals(goods.getMeasureItem())) return false;
        return getPurchPrice().equals(goods.getPurchPrice());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getGroupID();
        result = 31 * result + getProviderCode().hashCode();
        result = 31 * result + getProducerID();
        result = 31 * result + getMeasureItem().hashCode();
        result = 31 * result + getPurchPrice().hashCode();
        return result;
    }

    // - CONSOLE -
    @Override
    public String toString() {

        if ("items".equals(measureItem)) {
            return "#" + id + ", " + name + ", barcode=" + barcode + ", " + items + " " + measureItem +
                    ", sellPrice=" + sellPrice + " UAH, " +
                    "purchPrice=" + purchPrice + " UAH";
        } else {
            return "#" + id + ", " + name + ", barcode=" + barcode + ", " + quantity + " " + measureItem +
                    ", sellPrice=" + sellPrice + " UAH, " +
                    "purchPrice=" + purchPrice + " UAH";
        }
    }

    public String shortPrint() {
        if ("items".equals(measureItem)) {
            return name;
        } else {
            return name;
        }
    }





    // - S P E C I A L - methods for selecting (retrieving)
    public String selectedByProvider(){
        return this.getProviderCode();
    }

    public int selectedByGroup(){
        return this.getGroupID();
    }

    public String selectedByBarcode(){
        return this.getBarcode();
    }
}


