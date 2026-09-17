package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES =
            "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            Item item = items[i];

            // 전설 아이템은 아무것도 변하지 않는다.
            if (item.name.equals(SULFURAS)) {
                continue;
            }

            if (item.name.equals(AGED_BRIE)) {
                UpdateQualityForAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                UpdateQualityForBackstagePasses(item);
            } else {
                UpdateQualityForNormalItem(item);
            }

            item.sellIn--;
        }
    }

    private static void UpdateQualityForNormalItem(Item item) {
        int decrease = 1;

        if (item.sellIn <= 0) {
            decrease = 2;
        }

        item.quality = Math.max(0, item.quality - decrease);
    }

    private static void UpdateQualityForBackstagePasses(Item item) {
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

    private static void UpdateQualityForAgedBrie(Item item) {
        int increase = 1;

        if (item.sellIn <= 0) {
            increase = 2;
        }

        item.quality = Math.min(50, item.quality + increase);
    }
}