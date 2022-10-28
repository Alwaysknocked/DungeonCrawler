package Com.Kader.DungeonCrawler.Monsters;

import Com.Kader.DungeonCrawler.Game;
import Com.Kader.DungeonCrawler.ICombat;
import Com.Kader.DungeonCrawler.Player;

import java.util.Random;

import static Com.Kader.DungeonCrawler.Colors.CYAN;
import static Com.Kader.DungeonCrawler.Colors.RESET;

public class Monster implements ICombat {
    Player player = Game.player;
    private String name;
    private int agility;
    private int health;
    private int intelligence;
    private int gold;
    private int baseDamage;
    private int experience;
    public Monster(String name, int agility, int health, int intelligence, int gold, int baseDamage, int experience) {
        this.name=name;
        this.agility = agility;
        this.health = health;
        this.intelligence = intelligence;
        this.gold = gold;
        this.baseDamage = baseDamage;
        this.experience = experience;
    }
    public int getBaseDamage() {
        return baseDamage;
    }

    public String getName() {
        return name;
    }


    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {

        return health;
    }

    public boolean critHit() {
        int critChance = randomReturn(1, 100);
        return critChance <= getIntelligence();
    }

    public boolean dodge() {
        int dodgeChance = randomReturn(1, 100);
        return dodgeChance <= getAgility();
    }

    public int randomReturn(int origin, int bound) {
        Random random = new Random();
        return random.nextInt(origin, bound);
    }

    @Override
    public int fight() {
        System.out.printf("the %s attacks %s...", getName(), player.getName());
        int damage;
        if (critHit()) {
            damage = calculateDamage() * 2;
            System.out.printf("%s Deals double damage against %s, it deals %s%s%s damage", getName(), player.getName(), CYAN, damage, RESET);
        } else {
            damage = calculateDamage();
            System.out.printf("%s Deals %s%s%s damage! ", getName(),CYAN, calculateDamage(), RESET);
        }
        return damage;
    }

    @Override
    public int calculateDamage() {
        return getBaseDamage();
    }

}
