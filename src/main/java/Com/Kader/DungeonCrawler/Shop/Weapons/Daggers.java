package Com.Kader.DungeonCrawler.Shop.Weapons;

public class Daggers extends Weapon {


    public Daggers(int price, int damageBonus, int agilityBonus, int intelligenceBonus) {
        super(price, damageBonus, agilityBonus, intelligenceBonus);
    }

    public String getName() {
        return "Dual Elf Daggers";
    }
}
