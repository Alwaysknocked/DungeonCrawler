package Com.Kader.DungeonCrawler.Shop.Armors;
public class Armor {

    private String name;
    private int price;

    public Armor(int price, int healthBonus, double damageReduction, String reductionProcent) {
        this.price = price;
        this.healthBonus = healthBonus;
        this.damageReduction = damageReduction;
        this.reductionProcent = reductionProcent;
    }

    private int healthBonus;
    private double damageReduction;
    private String reductionProcent;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public String getReductionProcent() {
        return reductionProcent;
    }

    public int returnInt(int x, double y) {
        return (int) Math.round(x * y);
    }

    public int calculateDamageReduction(int damage) {
        return returnInt(damage, damageReduction);
    }
}
