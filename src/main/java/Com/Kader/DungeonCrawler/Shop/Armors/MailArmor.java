package Com.Kader.DungeonCrawler.Shop.Armors;

public class MailArmor extends Armor {

    public String getName() {
        return "MAIL ARMOR";
    }
    public MailArmor(int price, int healthBonus, double damageReduction, String reductionProcent) {
        super(price, healthBonus, damageReduction, reductionProcent);
    }

}
