package Com.Kader.DungeonCrawler.Shop.Weapons;

public class Staff extends Weapon {


    public Staff(int price, int damageBonus, int agilityBonus, int intelligenceBonus) {
        super(price, damageBonus, agilityBonus, intelligenceBonus);
    }

    public String getName() {
        return "WIZARDS STAFF";
    }
}
