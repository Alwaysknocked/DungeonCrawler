package Com.Kader.DungeonCrawler.Shop.Potions;

public class ElixirOfAgility extends Potion {

    public String getName() {
        return "Elixir of Agility";
    }
    public ElixirOfAgility(int price, int strength, int intelligence, int agility, int health) {
        super(price, strength, intelligence, agility, health);
    }

}
