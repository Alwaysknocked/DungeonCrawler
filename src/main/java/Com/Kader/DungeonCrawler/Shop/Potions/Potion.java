package Com.Kader.DungeonCrawler.Shop.Potions;

public class Potion {
    public Potion(int price, int strength, int intelligence, int agility, int health) {
        this.price = price;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
    }

    private String name;
    private int price;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getHealth() {
        return health;
    }
}
