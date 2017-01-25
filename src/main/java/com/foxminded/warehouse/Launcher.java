package com.foxminded.warehouse;

import com.foxminded.warehouse.model.Warehouse;
import com.foxminded.warehouse.model.dao.DBLocal_Creator;
import com.foxminded.warehouse.model.domain.Goods;

import java.math.BigDecimal;

public class Launcher {

    public static void main(String[] args) {

        Goods added = new Goods(12, "Pipe steel 09g2s, d=210", 290, "25675432", 17,0.20f, "t", new BigDecimal(19200), new BigDecimal(13620));
        Goods lastEleven = new Goods(14, "Profile metal \"Polka\" f.50",280, "26113487", 5,24, "items", new BigDecimal(1267), new BigDecimal(962));
        Goods substracted = new Goods(20, "Profile metal \"Polka\" f.50",280, "26113487", 5,8, "items", new BigDecimal(1267), new BigDecimal(962));

        Warehouse stock = new Warehouse();
        stock.setiWDBCreator(new DBLocal_Creator());
        stock.consoleWarehouse();
        System.out.println();
//        stock.printProducersList();
//        stock.printProvidersList();
//        stock.printRemainInStockSelectedByProvider("26113487");
//        stock.printRemainInStockSelectedByGroup("280");
//        stock.printRemainInStockByBarcode("7-14876512-210-5");
//        stock.printCatalogue();
        stock.printReceiptsJournal();



//        stock.addNewGoods(added);
//        stock.consoleWarehouse();
//        stock.addNewGoods(added);
//        stock.consoleWarehouse();
//        stock.addNewGoods(lastEleven);
//        stock.consoleWarehouse();
//        stock.subtractGoods(substracted);
//        stock.consoleWarehouse();
//        stock.printCatalogue();



    }
}
