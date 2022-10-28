package Com.Kader.DungeonCrawler.Shop.Armors;
public class LeatherArmor extends Armor {


    public String getName() {

        return "LEATHER ARMOR";
    }
    public LeatherArmor(int price, int healthBonus, double damageReduction, String reductionProcent) {
        super(price, healthBonus, damageReduction, reductionProcent);
    }
}
