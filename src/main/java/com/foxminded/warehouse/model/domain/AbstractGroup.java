package com.foxminded.warehouse.model.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGroup {

    protected String name;
    protected List<Group> children = new ArrayList<>();
    protected List<Goods> groupGoods = new ArrayList<>();

    protected AbstractGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getChildren() {
        return new ArrayList<>(children);
    }

    public void setChildren(List<Group> children) {
        this.children = children;
    }

    public List<Goods> getGroupGoods() {
        return new ArrayList<>(groupGoods);
    }

    public void setGroupGoods(List<Goods> groupGoods) {
        this.groupGoods = groupGoods;
    }


    // special methods
    public String retrieveChildrenGroupByID(int childrenGroupID) {
        String seekedGroup = null;
        int i = 0;
        for (;i < children.size(); i++) {
            if (childrenGroupID == children.get(i).getId()) {
                seekedGroup = children.get(i).toString();
                break;
            }
            if (i == children.size() - 1) {
                seekedGroup = "Group with such ID not found!";
            }
        }
        return seekedGroup;
    }
}
