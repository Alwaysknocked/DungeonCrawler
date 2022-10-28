package Com.Kader.DungeonCrawler.Shop.Weapons;

public class Axe extends Weapon {

    public Axe(int price, int damageBonus, int agilityBonus, int intelligenceBonus) {
        super(price, damageBonus, agilityBonus, intelligenceBonus);
    }

    public String getName() {
        return "ANCIENT BATTLE AXE";
    }
}
