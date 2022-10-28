package Com.Kader.DungeonCrawler.Shop.Potions;

public class PotionOfLionsStrength extends Potion {
    public PotionOfLionsStrength(int price, int strength, int intelligence, int agility, int health) {
        super(price, strength, intelligence, agility, health);
    }

    public String getName() {
        return "Potion of Lions Strength";
    }

}
