package com.foxminded.warehouse.model.domain;

import java.math.BigDecimal;

public class OrderItem {

    private Goods goods;
    private BigDecimal value;

    public OrderItem(Goods goods){
        this.goods = goods;
        if (goods.getQuantity() != 0.0f) {
            this.value = goods.getSellPrice().multiply(new BigDecimal(goods.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            this.value = goods.getSellPrice().multiply(new BigDecimal(goods.getItems())).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String toString() {
        if ("items".equals(goods.getMeasureItem())) {
            return goods.shortPrint() + " - " + goods.getItems() + " " + goods.getMeasureItem() + " - " + goods.getSellPrice() + ", UAH " + value;
        } else {
            return goods.shortPrint() + " - " + goods.getQuantity() + " " + goods.getMeasureItem() + " - " + goods.getSellPrice() + ", UAH " + value;
        }
    }
}

