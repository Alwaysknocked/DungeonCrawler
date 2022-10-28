package Com.Kader.DungeonCrawler.Shop.Armors;

public class PlateArmor extends Armor {

    public String getName() {

        return "PLATE ARMOR";
    }

    public PlateArmor(int price, int healthBonus, double damageReduction, String reductionProcent) {
        super(price, healthBonus, damageReduction, reductionProcent);
    }

}

