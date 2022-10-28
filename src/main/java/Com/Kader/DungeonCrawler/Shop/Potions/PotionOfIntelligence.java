package Com.Kader.DungeonCrawler.Shop.Potions;

public class PotionOfIntelligence extends Potion {

    public String getName() {
        return "Potion of Intelligence";
    }

    public PotionOfIntelligence(int price, int strength, int intelligence, int agility, int health) {
        super(price, strength, intelligence, agility, health);
    }

}
