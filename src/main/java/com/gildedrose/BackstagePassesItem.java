package com.gildedrose;

public class BackstagePassesItem {

    private Item item;

    public BackstagePassesItem(Item item) {
        this.item = item;
    }

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