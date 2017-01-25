package com.foxminded.warehouse.model.dao;

import com.foxminded.warehouse.model.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBLocal_Creator implements IWDBCreator {

    private Catalogue catalogue;
    private List<Goods> warehouse;
    private List<Producer> producers;
    private List<Provider> providers;
    private List<Receipt> receiptsJournal;
    private List<Order> ordersJournal;

    private static Goods commerse[] = new Goods[]{
            new Goods(1, "Pipe steel 09g2s, d=120", 290, "25675432", 17,4.24f, "t", new BigDecimal(18700), new BigDecimal(12619)),
            new Goods(2, "Pipe steel 09g2s, d=125",290, "25675432", 17, 8.16f, "t", new BigDecimal(18750), new BigDecimal(12540)),
            new Goods(3, "Pipe steel 09g2s, d=150",290, "25675432", 18,0.75f, "t",new BigDecimal(18800), new BigDecimal(12825)),
            new Goods(4, "Pipe steel 09g2s, d=180",290, "34567890", 14,0.96f, "t", new BigDecimal(18850), new BigDecimal(12720)),
            new Goods(5, "Angle lintel 09g2s, f.20x20",210, "14876512", 7, 1.24f, "t", new BigDecimal(18950), new BigDecimal(13600)),
            new Goods(6, "Angle lintel 09g2s, f.25x25",210, "14876512", 7,1.87f, "t", new BigDecimal(19220), new BigDecimal(14700)),
            new Goods(7, "Angle lintel 09g2s, f.40x450",210, "00126711", 8, 1.6f, "t", new BigDecimal(19740), new BigDecimal(14990)),
            new Goods(8, "Angle lintel 09g2s, f.50x50",210, "00126711", 12, 0.4f, "t", new BigDecimal(18750), new BigDecimal(12619)),
            new Goods(9, "Profile metal \"Polka\" f.40",280, "26113487", 5, 12, "items", new BigDecimal(1240), new BigDecimal(916)),
            new Goods(10, "Profile metal \"Polka\" f.45",280, "26113487", 5, 16, "items", new BigDecimal(1255), new BigDecimal(937)),
            new Goods(11, "Profile metal \"Polka\" f.50",280, "26113487", 5,14, "items", new BigDecimal(1267), new BigDecimal(962)),
            new Goods(12, "Profile metal \"Polka\" f.35",280, "25121114", 5, 16, "items", new BigDecimal(1205), new BigDecimal(895)),
    };

    private static Goods goodsArr[] = new Goods[]{
            new Goods(1, "Pipe steel 09g2s, d=120", 290, "25675432", 17,4.24f, "t", new BigDecimal(18700), new BigDecimal(12619)),
            new Goods(2, "Pipe steel 09g2s, d=125",290, "25675432", 17, 0.5f, "t", new BigDecimal(18750), new BigDecimal(12540)),
            new Goods(3, "Pipe steel 09g2s, d=150",290, "25675432", 18,9.70f, "t",new BigDecimal(18800), new BigDecimal(12825)),
            new Goods(4, "Pipe steel 09g2s, d=180",290, "34567890", 14,3.21f, "t", new BigDecimal(18850), new BigDecimal(12720)),
            new Goods(5, "Angle lintel 09g2s, f.20x20",210, "14876512", 7, 1.24f, "t", new BigDecimal(18950), new BigDecimal(13600)),
            new Goods(6, "Angle lintel 09g2s, f.25x25",210, "14876512", 7,1.87f, "t", new BigDecimal(19220), new BigDecimal(14700)),
            new Goods(7, "Angle lintel 09g2s, f.40x450",210, "00126711", 8, 2.245f, "t", new BigDecimal(19740), new BigDecimal(14990)),
            new Goods(8, "Angle lintel 09g2s, f.50x50",210, "00126711", 12, 4.20f, "t", new BigDecimal(18750), new BigDecimal(12619)),
            new Goods(9, "Profile metal \"Polka\" f.40",280, "26113487", 5, 48, "items", new BigDecimal(1240), new BigDecimal(916)),
            new Goods(10, "Profile metal \"Polka\" f.45",280, "26113487", 5, 54, "items", new BigDecimal(1255), new BigDecimal(937)),
            new Goods(11, "Profile metal \"Polka\" f.50",280, "26113487", 5,24, "items", new BigDecimal(1267), new BigDecimal(962))
    };

    private static ReceiptItem receiptItemsArr[] = new ReceiptItem[]{
            new ReceiptItem(commerse[3]),
            new ReceiptItem(commerse[2]),
            new ReceiptItem(commerse[1]),
            new ReceiptItem(commerse[8]),
            new ReceiptItem(commerse[10]),
            new ReceiptItem(commerse[9]),
            new ReceiptItem(commerse[6]),
            new ReceiptItem(commerse[7]),
            new ReceiptItem(commerse[11])
    };

    public DBLocal_Creator() {
        catalogue = new Catalogue("WAREHOUSE");
        catalogue = fillCatalogue();
        warehouse = new ArrayList<>();
        warehouse = initWarehouse();
        producers = new ArrayList<>();
        producers = fillProducersList();
        providers = new ArrayList<>();
        providers = fillProvidersList();
        receiptsJournal = new ArrayList<>();
        receiptsJournal = fillReceiptsJournal();
        ordersJournal = new ArrayList<>();
        ordersJournal = fillOrdersJournal();
    }

    private Catalogue fillCatalogue() {

        Group groupMetal = new Group("Metals", 200);

        Group angles = new Group("Angles", 210);
        List<Goods> anglesGroupGoods = new ArrayList<>();
        anglesGroupGoods.add(goodsArr[4]);
        anglesGroupGoods.add(goodsArr[5]);
        anglesGroupGoods.add(goodsArr[6]);
        anglesGroupGoods.add(goodsArr[7]);
        angles.setGroupGoods(anglesGroupGoods);

        Group pipes = new Group("Pipes", 290);
        List<Goods> pipesGroupGoods = new ArrayList<>();
        pipesGroupGoods.add(goodsArr[0]);
        pipesGroupGoods.add(goodsArr[1]);
        pipesGroupGoods.add(goodsArr[2]);
        pipesGroupGoods.add(goodsArr[3]);
        pipes.setGroupGoods(pipesGroupGoods);

        Group profiles = new Group("Profiles", 280);
        List<Goods> profilesGroupGoods = new ArrayList<>();
        profilesGroupGoods.add(goodsArr[8]);
        profilesGroupGoods.add(goodsArr[9]);
        profilesGroupGoods.add(goodsArr[10]);
        profiles.setGroupGoods(profilesGroupGoods);

        List<Group> metalGroups = new ArrayList<>();
        metalGroups.add(new Group("Armature", 205));
        metalGroups.add(angles);
        metalGroups.add(new Group("I-Beams", 215));
        metalGroups.add(new Group("T-Beams", 220));
        metalGroups.add(new Group("Round Bars", 225));
        metalGroups.add(new Group("Rectangles", 230));
        metalGroups.add(new Group("Nets", 235));
        metalGroups.add(new Group("Lists", 240));
        metalGroups.add(new Group("Chains", 245));
        metalGroups.add(new Group("Balls", 250));
        metalGroups.add(new Group("Rails", 255));
        metalGroups.add(new Group("Wires", 260));
        metalGroups.add(profiles);
        metalGroups.add(pipes);
        groupMetal.setChildren(metalGroups);

        List<Group> catalogueGroups = new ArrayList<>();
        catalogueGroups.add(new Group("Woods", 100));
        catalogueGroups.add(groupMetal);
        catalogueGroups.add(new Group("Plastics", 300));
        catalogueGroups.add(new Group("Instrumentals", 400));
        catalogueGroups.add(new Group("Machines", 500));
        catalogue.setChildren(catalogueGroups);

        return catalogue;
    }

    private List<Goods> initWarehouse() {
        for (Goods goods : goodsArr) {
            warehouse.add(goods);
        }
        return warehouse;
    }

    private List<Producer> fillProducersList() {
        producers.add(new Producer(5, "Warsawa DSF Ltd."));
        producers.add(new Producer(7, "Dniprovskiy MSM Factory"));
        producers.add(new Producer(8, "Donetsk Metallurgical Plant"));
        producers.add(new Producer(12, "Kharkiv Experimental Mechanic Plant"));
        producers.add(new Producer(14, "Kam'yanskiy Pipe Plant"));
        producers.add(new Producer(17, "Khartsyzskiy Pipe Plant"));
        producers.add(new Producer(18, "Nikolayevskiy Pipe Plant"));
        return producers;
    }

    private List<Provider> fillProvidersList() {
        providers.add(new Provider(24, "PJSC \"Premiyera-Lux\"", "00126711"));
        providers.add(new Provider(27, "Odessa - Kabel Ltd", "25675432"));
        providers.add(new Provider(28, "Nova Ltd", "34567890"));
        providers.add(new Provider(33, "Poland ExIm Company", "26113487"));
        providers.add(new Provider(44, "Dniprovski Shili Ltd", "14876512"));
        return providers;
    }

    private List<Receipt> fillReceiptsJournal() {
        Receipt receipt1 = new Receipt(1, "24.01.2017", Arrays.asList(receiptItemsArr[0], receiptItemsArr[1], receiptItemsArr[2]));
        Receipt receipt2 = new Receipt(2, "25.01.2017", Arrays.asList(receiptItemsArr[3], receiptItemsArr[4], receiptItemsArr[5]));
        Receipt receipt3 = new Receipt(3, "26.01.2017", Arrays.asList(receiptItemsArr[6], receiptItemsArr[7], receiptItemsArr[8]));
        receiptsJournal.add(receipt1);
        receiptsJournal.add(receipt2);
        receiptsJournal.add(receipt3);
        return receiptsJournal;
    }

    private List<Order> fillOrdersJournal() {

        return null;
    }

    @Override
    public List<Goods> getWarehouse() { return new ArrayList<>(warehouse); }

    @Override
    public List<Producer> getProducers() {
        return new ArrayList<>(producers);
    }

    @Override
    public List<Provider> getProviders() {
        return new ArrayList<>(providers);
    }

    @Override
    public List<Group> getCatalogue() {
        return new ArrayList<>(catalogue.getChildren());
    }

    @Override
    public List<Receipt> getReceiptsJournal() {
        return receiptsJournal;
    }



    // - O P E R A T I O N S -

    // - INSERT - Goods
    @Override
    public void insertNewGoods(Goods newGoods) {
        if (warehouse != null && !warehouse.isEmpty()) {
            for (int i = 0; i < warehouse.size(); i++) {
                if (newGoods.equals(warehouse.get(i))) {
                    addGoodsQuantity(warehouse.get(i), newGoods);
                    break;
                }
                if (i == (warehouse.size() - 1)) {
                    warehouse.add(newGoods);
                    insertGoodsIntoGroupe(newGoods);
                    break;
                }
            }
        }
        if (warehouse != null && warehouse.isEmpty()) {
            warehouse.add(newGoods);
            insertGoodsIntoGroupe(newGoods);
        }
    }

    private void addGoodsQuantity(Goods goods, Goods addedGoods) {
        goods.setQuantity(goods.getQuantity() + addedGoods.getQuantity());
        goods.setItems(goods.getItems() + addedGoods.getItems());
    }

    private void insertGoodsIntoGroupe(Goods goods) {
        if (catalogue != null) {
            for (Group group : catalogue.getChildren()) {
                for (Group finalGroup : group.getChildren()) {
                    if (goods.getGroupID() == finalGroup.getId()) {
                        List<Goods> finalGroupGoods = finalGroup.getGroupGoods();
                        finalGroupGoods.add(goods);
                        finalGroup.setGroupGoods(finalGroupGoods);
                    }
                }
            }
        }
    }

    // - CHANGE (ALTER) - Goods
    @Override
    public void subtractGoodsQuantity(Goods alterGoods) {
        if (warehouse != null && !warehouse.isEmpty()) {
            for (Goods goods : warehouse) {
                if (alterGoods.equals(goods)) {
                    if ((goods.getQuantity() >= alterGoods.getQuantity() && alterGoods.getQuantity() != 0) ||
                            (goods.getItems() >= alterGoods.getItems() && alterGoods.getItems() != 0)) {
                        goods.setItems(goods.getItems() - alterGoods.getItems());
                        goods.setQuantity(goods.getQuantity() - alterGoods.getQuantity());
                    } else {
                        System.out.println("There is no enough Goods in the Warehouse!\n Try with another quantity, please.");
                    }
                    break;
                }
            }
        }
    }

    public void alterGoodsName(Goods goods, String newName) {
        goods.setName(newName);
    }

    // - DELETE - Goods
    @Override
    public void deleteGoodsFromWarehouse(Goods goodsToDelete) {
        if (warehouse != null && !warehouse.isEmpty()) {
            for (int i = 0; i < warehouse.size(); i++) {
                if (goodsToDelete.equals(warehouse.get(i))) {
                    warehouse.remove(i);
                    break;
                }
                if (i == warehouse.size() - 1) {
                    System.out.println("There is no such Goods in Warehouse!");
                }
            }
        }
    }

    public void deleteGoodsByBarcode(String barcode) {
        if (warehouse != null && !warehouse.isEmpty()) {
            for (int i = 0; i < warehouse.size(); i++) {
                if (barcode.equals(warehouse.get(i).getBarcode())) {
                    warehouse.remove(i);
                    break;
                }
                if (i == warehouse.size() - 1) {
                    System.out.println("There is no Goods with such barcode!");
                }
            }
        }
    }
}
