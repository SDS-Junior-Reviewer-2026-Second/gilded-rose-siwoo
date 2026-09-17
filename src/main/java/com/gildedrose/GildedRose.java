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

            if (item.name.equals(AGED_BRIE)) {

                GildedRoseItem agedBrieItem =
                        new AgedBrieItem(item);

                agedBrieItem.updateQuality(item);

            } else if (item.name.equals(BACKSTAGE_PASSES)) {

                GildedRoseItem backstagePassesItem =
                        new BackstagePassesItem(item);

                backstagePassesItem.updateQuality(item);

            } else if (item.name.equals(SULFURAS)) {

                GildedRoseItem sulfurasItem =
                        new SulfurasItem(item);

                sulfurasItem.updateQuality(item);

            } else {

                GildedRoseItem normalItem =
                        new NormalItem(item);

                normalItem.updateQuality(item);
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn--;
            }
        }
    }
}