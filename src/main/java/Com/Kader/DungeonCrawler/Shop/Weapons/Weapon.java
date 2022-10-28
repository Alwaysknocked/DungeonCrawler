package Com.Kader.DungeonCrawler.Shop.Weapons;
public class Weapon{

    String name ;
    int price;
    int damageBonus;
    int agilityBonus ;
    int intelligenceBonus;

    public Weapon(int price, int damageBonus, int agilityBonus, int intelligenceBonus) {
        this.price = price;
        this.damageBonus = damageBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getBonusDamage() {
        return damageBonus;
    }

    public int getBonusAgility() {
        return agilityBonus;
    }

    public int getBonusIntelligence() {
        return intelligenceBonus;
    }

    public int returnInt(int x, double y) {
        int roundedInt = (int) Math.round(x * y);
        return roundedInt;
    }
}
