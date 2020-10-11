package com.dark.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Date: 2020-10-11
 */
public class Item implements Serializable {

    private final String name;
    private final int amount;

    private Item() {
        name = null;
        amount = 0;
    }

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("amount=" + amount)
                .toString();
    }
}
