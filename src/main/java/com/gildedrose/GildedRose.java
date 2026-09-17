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

            updateQuality(item);

            updateSellIn(item);
        }
    }

    private void updateQuality(Item item) {

        GildedRoseItem gildedRoseItem = getGildedRoseItem(item);

        gildedRoseItem.updateQuality(item);
    }

    private GildedRoseItem getGildedRoseItem(Item item) {

        GildedRoseItem gildedRoseItem;

        if (item.name.equals(AGED_BRIE)) {

            gildedRoseItem = new AgedBrieItem(item);

        } else if (item.name.equals(BACKSTAGE_PASSES)) {

            gildedRoseItem = new BackstagePassesItem(item);

        } else if (item.name.equals(SULFURAS)) {

            gildedRoseItem = new SulfurasItem(item);

        } else {

            gildedRoseItem = new NormalItem(item);
        }

        return gildedRoseItem;
    }

    private void updateSellIn(Item item) {

        if (item.name.equals(SULFURAS)) {
            return;
        }

        item.sellIn--;
    }
}