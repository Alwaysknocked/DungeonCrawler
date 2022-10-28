package Com.Kader.DungeonCrawler.Shop.Weapons;

public class Sword extends Weapon {
    public Sword(int price, int damageBonus, int agilityBonus, int intelligenceBonus) {
        super(price, damageBonus, agilityBonus, intelligenceBonus);
    }
    public String getName() {
        return "ANDURIL SWORD";
    }
}