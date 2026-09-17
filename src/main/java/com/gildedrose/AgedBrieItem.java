package com.gildedrose;

public class AgedBrieItem {

    private Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    // [67p 변경]
    // updateQualityForAgedBrie() → updateQuality()
    public void updateQuality(Item item) {
        int increase = 1;

        if (item.sellIn <= 0) {
            increase = 2;
        }

        item.quality = Math.min(50, item.quality + increase);
    }
}