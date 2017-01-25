package com.foxminded.warehouse.model.dao;

import com.foxminded.warehouse.model.domain.*;

import java.util.List;

public interface IWDBCreator {

    List<Goods> getWarehouse();
    List<Producer> getProducers();
    List<Provider> getProviders();
    //Catalogue getCatalogue();
    List<Group> getCatalogue();
    List<Receipt> getReceiptsJournal();

    // - O P E R A T I O N S -
    //INSERT Goods
    void insertNewGoods(Goods goods);
    //CHANGE (ALTER) Goods
    void subtractGoodsQuantity(Goods goods);
    void alterGoodsName(Goods goods, String newName);
    // DELETE Goods
    void deleteGoodsFromWarehouse(Goods goods);
}
