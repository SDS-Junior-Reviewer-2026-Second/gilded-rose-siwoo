package com.gildedrose;

public class NormalItem {

    private Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    public void updateQuality(Item item) {
        int decrease = 1;

        if (item.sellIn <= 0) {
            decrease = 2;
        }

        item.quality = Math.max(0, item.quality - decrease);
    }
}