package Com.Kader.DungeonCrawler;

import Com.Kader.DungeonCrawler.Shop.Weapons.Sword;
import Com.Kader.DungeonCrawler.Shop.Weapons.Weapon;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PlayerBaseDamageTest {

    private String name = "Player";
    private int level;
    private Weapon playerWeapon = new Weapon(0, 0, 0, 0);
    private int strength;
    private int intelligence;

    public int calculateDamage() {
        return ((strength + level) / 2) + playerWeapon.getBonusDamage();
    }

    public boolean critHit() {
        Random random = new Random();
        int critChance = random.nextInt(1, 100);
        return critChance <= intelligence;
    }

    public int fight() {
        System.out.printf("\n%s attacks ...", name);
        int baseDamage;
        if (critHit()) {
            baseDamage = calculateDamage() * 2;
            System.out.printf("%s Deals double damage!!, he deals %s%s%s \n", name, Colors.CYAN, baseDamage, Colors.RESET);
        } else {
            baseDamage = calculateDamage();
            System.out.printf("%s Deals %s%s%s damage!! \n", name, Colors.CYAN, calculateDamage(), Colors.RESET);
        }
        return baseDamage;
    }

    @Test
    public void baseDamageTest() {
        //Level+Strength/2
        level = 10;
        strength = 10;
        Assert.assertEquals(10, fight());
    }

    @Test
    public void critHitBonusTest() {
        level = 10;
        strength = 10;
        intelligence = 100;       //in case Critical hit returns true = double damage.
        Assert.assertEquals(20, fight());
    }

    @Test
    public void weapondDamageAddition() {
        level = 10;
        strength = 10;
        intelligence = 100;
        playerWeapon = new Sword(0, 5, 0, 0);     //The weapon damage doubles as well.
        Assert.assertEquals(30, fight());
    }
}
