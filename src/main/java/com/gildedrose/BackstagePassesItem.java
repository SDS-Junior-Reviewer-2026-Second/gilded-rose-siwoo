package com.gildedrose;

// [71p 변경]
public class BackstagePassesItem extends GildedRoseItem {

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;

        } else {
            int increase = 1;

            if (item.sellIn <= 10) {
                increase = 2;
            }

            if (item.sellIn <= 5) {
                increase = 3;
            }

            item.quality = Math.min(50, item.quality + increase);
        }
    }
}