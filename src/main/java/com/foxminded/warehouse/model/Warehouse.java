package com.foxminded.warehouse.model;

import com.foxminded.warehouse.model.dao.IWDBCreator;
import com.foxminded.warehouse.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private IWDBCreator iWDBCreator;

    public void setiWDBCreator(IWDBCreator iWDBCreator) {
        this.iWDBCreator = iWDBCreator;
    }

    public List<Goods> getWarehouse() {
        return iWDBCreator.getWarehouse();
    }

    public List<Producer> getProducers() {
        return iWDBCreator.getProducers();
    }

    public List<Provider> getProviders() {
        return iWDBCreator.getProviders();
    }

    public List<Group> getCatalogue() {
        return iWDBCreator.getCatalogue();
    }

    public List<Receipt> getReceiptsJournal() {return iWDBCreator.getReceiptsJournal();}

    // - O P E R A T I O N S -

    // - INSERT - Goods
    public void addNewGoods(Goods goods){
        iWDBCreator.insertNewGoods(goods);
    }

    // - CHANGE (ALTER) - Goods
    public void subtractGoods(Goods goods) {
        iWDBCreator.subtractGoodsQuantity(goods);
    }

    public void changeGoodsName(Goods goods, String newName) {
        iWDBCreator.alterGoodsName(goods, newName);
    }

    // - DELETE - Goods
    public void deleteGoods(Goods goods) {
        iWDBCreator.deleteGoodsFromWarehouse(goods);
    }










    //   - R E A D,   R E T R I E V E -

    // - SELECTION -
    public List<Goods> selectedByProvider(String providerIdentCode) {
        List<Goods> selectedByProvider = new ArrayList<>();
        for (Goods goods : getWarehouse()) {
            if (providerIdentCode.equals(goods.selectedByProvider())) {
                selectedByProvider.add(goods);
            }
        }
        return selectedByProvider;
    }

    public List<Goods> selectedByGroup(String groupID) {
        List<Goods> selectedByGroup = new ArrayList<>();
        for (Goods goods : getWarehouse()) {
            if (Integer.parseInt(groupID) == goods.selectedByGroup()) {
                selectedByGroup.add(goods);
            }
        }
        return selectedByGroup;
    }

    public void consoleWarehouse() {
        int counter = 1;
        for (Goods goods : getWarehouse()) {
            System.out.println(counter + ". " + goods.toString());
            counter++;
        }
    }

    // - PRINTING -
    public void printRemainInStockByBarcode(String barcode) {
        System.out.println("By barcode " + barcode + " the following item was found: ");
        int i = 0;
        for (; i < getWarehouse().size(); i++) {
            if (barcode.equals(getWarehouse().get(i).selectedByBarcode())) {
                System.out.println(getWarehouse().get(i));
                break;
            }
            if (i == getWarehouse().size() - 1) {
                System.out.println("There is no product with such barcode!\nTry with another barcode!");
            }
        }
        if (i == 11) System.out.println("NICE!");
    }

    public void printProducersList() {
        for (Producer producer : getProducers()) {
            System.out.println(producer.toString());
        }
    }

    public void printProvidersList() {
        int n = 1;
        for (Provider provider : getProviders()) {
            System.out.println(n + ". " + provider.toString());
            n++;
        }
    }

    public void printRemainInStockSelectedByProvider(String providerCode) {
        List<Goods> selectedByProvider = selectedByProvider(providerCode);
        int counter = 1;
        for (Goods goods : selectedByProvider) {
            System.out.println(counter + ". " + goods);
            counter++;
        }
    }

    public void printRemainInStockSelectedByGroup(String groupID) {
        List<Goods> selectedByGroup = selectedByGroup(groupID);
        int counter = 1;
        for (Goods goods : selectedByGroup) {
            System.out.println(counter + ". " + goods);
            counter++;
        }
    }

    public void printCatalogue() {
        for (Group group: getCatalogue()) {
            System.out.println(group.toString());
            for (Group finalGroup : group.getChildren()) {
                System.out.println("      -" + finalGroup.toString());
                int counter = 1;
                for (Goods goods : finalGroup.getGroupGoods()) {
                    System.out.println("          " + counter + ". " + goods.toString());
                    counter++;
                }
            }
        }
    }

    public void printReceiptsJournal() {
        System.out.println("Receipts Journal: ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
        for(Receipt receipt : getReceiptsJournal()) {
            receipt.printReceipt();
        }
    }



}
