package com.gildedrose;

class GildedRose {
    public static final String Aged_Brie = "Aged Brie";
    public static final String Backstage_passes = "Backstage passes to a TAFKAL80ETC concert";
    public static final String Sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String Conjured = "Conjured Mana Cake";
    
    private Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            doUpdateQuality(item);
        }
    }

    private void decquality(Item item){
        if (item.quality > 0 && item.quality < 50){
            if (item.sell_in >0){
                item.quality = item.quality - 1;
                updatesellIn(item);
            }
            else{
                item.quality = item.quality - 2;
                updatesellIn(item);
            }
        }
        else{
            item.quality = item.quality;
            updatesellIn(item);
        }
      
      public Item[] getItems() {
        return items;
      }
    }

    private void decqualitytwice(Item item){
        if (item.quality > 0 && item.quality < 50){
            if (item.sell_in >0){
                item.quality = item.quality - 2;
                updatesellIn(item);
            }
            else{
                item.quality = item.quality - 4;
                updatesellIn(item);
            }
        }
        else{
            item.quality = item.quality;
            updatesellIn(item);
        }
    }
    
    private void incquality(Item item){
        if (item.quality < 50 && item.quality >= 0){
            if (item.sell_in > 0){
                item.quality = item.quality + 1;
            }
            else{
                item.quality = item.quality + 2;
            }
        }
        else{
            item.quality = item.quality;
        }
    }

    private void updatesellIn(Item item){
        item.sell_in = item.sell_in - 1;
    }

    private void doUpdateQuality(Item item){
        if (item.name.equals(Aged_Brie)){
            incquality(item);
            updatesellIn(item);
        }
        else if (item.name.equals(Backstage_passes)){
            if (item.sellIn < 11 && item.sellIn > 5){
                item.quality = item.quality + 2;
                updatesellIn(item);
            }
            else if (item.sell_in < 6 && item.sell_in > 0){
                item.quality = item.quality + 3;
                updatesellIn(item);
            }
            else if (item.sell_in <= 0){
                item.quality = 0;
                updatesellIn(item);
            }
            else{
                incquality(item);
                updatesellIn(item);
            }
        }
        else if (item.name.equals(Sulfuras)){
            item.sell_in = item.sell_in;
            item.quality = item.quality;
        }
        else if (item.name.equals(Conjured)){
            decqualitytwice(item);
        }
        else{
            decquality(item);
        }

    }
}
