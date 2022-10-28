package Com.Kader.DungeonCrawler.Shop.Armors;
public class ChainArmor extends Armor {

    public String getName() {

        return "CHAIN ARMOR";
    }
    public ChainArmor(int price, int healthBonus, double damageReduction, String reductionProcent) {
        super(price, healthBonus, damageReduction, reductionProcent);
    }
}
