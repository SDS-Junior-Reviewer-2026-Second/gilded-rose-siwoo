package com.gildedrose;

public class NormalItem extends GildedRoseItem {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality(Item item) {
        int decrease = 1;

        if (item.sellIn <= 0) {
            decrease = 2;
        }

        item.quality = Math.max(0, item.quality - decrease);
    }
}