package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

	private static final String JIHUN_SWORD = "지훈의검";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASS =
			"Backstage passes to a TAFKAL80ETC concert";


	// 1. 아이템이 없는 경우
	@Test
	public void should_be_nothing_when_no_item() {

		Item[] items = new Item[]{};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(0, items.length);
	}


	// =========================
	// Normal Item
	// =========================

	@Test
	public void 지훈의검_sellin_0_quality_0() {

		Item[] items = new Item[]{
				new Item(JIHUN_SWORD, 0, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}


	@Test
	public void 지훈의검_sellin_0_quality_1() {

		Item[] items = new Item[]{
				new Item(JIHUN_SWORD, 0, 1)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}


	// 기한이 지나면 quality가 2씩 감소하는지 확인
	@Test
	public void 지훈의검_sellin_0_quality_3() {

		Item[] items = new Item[]{
				new Item(JIHUN_SWORD, 0, 3)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(1, items[0].quality);
	}


	// =========================
	// Sulfuras
	// =========================

	@Test
	public void sulfuras_sellin_0_quality_80() {

		Item[] items = new Item[]{
				new Item(SULFURAS, 0, 80)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(0, items[0].sellIn);
		assertEquals(80, items[0].quality);
	}


	// 네가 추가했던 테스트
	@Test
	public void sulfuras_sellin_30_quality_80() {

		Item[] items = new Item[]{
				new Item(SULFURAS, 30, 80)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(30, items[0].sellIn);
		assertEquals(80, items[0].quality);
	}


	// sellIn < 0 분기에서도 Sulfuras가 변하지 않는지 확인
	@Test
	public void sulfuras_sellin_minus2_quality_80() {

		Item[] items = new Item[]{
				new Item(SULFURAS, -2, 80)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-2, items[0].sellIn);
		assertEquals(80, items[0].quality);
	}


	// =========================
	// Aged Brie
	// =========================

	@Test
	public void agedBrie_sellin_0_quality_0() {

		Item[] items = new Item[]{
				new Item(AGED_BRIE, 0, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(2, items[0].quality);
	}


	// 49 → 50까지만 올라가는지
	@Test
	public void agedBrie_sellin_0_quality_49() {

		Item[] items = new Item[]{
				new Item(AGED_BRIE, 0, 49)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(50, items[0].quality);
	}


	// 이미 최대 quality라면 증가하지 않는지
	@Test
	public void agedBrie_sellin_0_quality_50() {

		Item[] items = new Item[]{
				new Item(AGED_BRIE, 0, 50)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(50, items[0].quality);
	}


	// =========================
	// Backstage Pass
	// =========================

	// 콘서트가 끝나면 quality = 0
	@Test
	public void backstagePass_sellin_0_quality_0() {

		Item[] items = new Item[]{
				new Item(BACKSTAGE_PASS, 0, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}


	// 0이 아닌 값도 콘서트 종료 후 실제로 0으로 떨어지는지
	@Test
	public void backstagePass_sellin_0_quality_49() {

		Item[] items = new Item[]{
				new Item(BACKSTAGE_PASS, 0, 49)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}


	// 10일보다 많이 남음 → +1
	@Test
	public void backstagePass_sellin_12_quality_0() {

		Item[] items = new Item[]{
				new Item(BACKSTAGE_PASS, 12, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(11, items[0].sellIn);
		assertEquals(1, items[0].quality);
	}


	// 10 ~ 6일 → +2
	@Test
	public void backstagePass_sellin_6_quality_0() {

		Item[] items = new Item[]{
				new Item(BACKSTAGE_PASS, 6, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(5, items[0].sellIn);
		assertEquals(2, items[0].quality);
	}


	// 5 ~ 1일 → +3
	@Test
	public void backstagePass_sellin_5_quality_0() {

		Item[] items = new Item[]{
				new Item(BACKSTAGE_PASS, 5, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(4, items[0].sellIn);
		assertEquals(3, items[0].quality);
	}
}