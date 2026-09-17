package com.gildedrose;

public class AgedBrieItem extends GildedRoseItem {

    public AgedBrieItem(Item item) {

        super(item);
    }

    @Override
    public void updateQuality(Item item) {
        int increase = 1;

        if (item.sellIn <= 0) {
            increase = 2;
        }

        item.quality = Math.min(50, item.quality + increase);
    }
}