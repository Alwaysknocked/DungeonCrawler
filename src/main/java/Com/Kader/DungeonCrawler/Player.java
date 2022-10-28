package Com.Kader.DungeonCrawler;
import Com.Kader.DungeonCrawler.Shop.Armors.Armor;
import Com.Kader.DungeonCrawler.Shop.Armors.LeatherArmor;
import Com.Kader.DungeonCrawler.Shop.Weapons.Weapon;
import java.util.Random;

public class Player implements ICombat {

    private Armor playerArmor=new LeatherArmor(0,0,1,"0%");
    private Weapon playerWeapon=new Weapon(0,0,0,0);
    private String name;
    private int gold = 1000;
    private int strength = 100;
    private int intelligence = 10;
    private int agility = 10;
    private int health=100;
    private int maxHealth=100;
    private int experience = 0;
    private int requiredExperience = 100;
    private int level = 0;

    public Armor getPlayerArmor() {
        return playerArmor;
    }

    public void setPlayerArmor(Armor playerArmor) {
        this.playerArmor = playerArmor;
    }

    public Weapon getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(Weapon playerWeapon) {
        this.playerWeapon = playerWeapon;
    }
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    private int baseDamage = (calculateDamage());

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGold(int gold) {

        this.gold = gold;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) {

        this.agility = agility;
    }

    public void setHealth(int health) {

        this.health = health;
    }

    public void setExperience(int experience) {

        this.experience = experience;
    }

    public int getGold() {

        return gold;
    }

    public int getStrength() {

        return strength;
    }

    public int getIntelligence() {

        return intelligence;
    }

    public int getAgility() {

        return agility;
    }

    public int getHealth() {

        return health;
    }

    public int getExperience() {

        return experience;
    }

    public int getLevel() {

        return level;
    }

    public int getBaseDamage() {
        return calculateDamage();
    }

    @Override
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

    @Override
    public int calculateDamage() {
        return ((strength + level) / 2) + playerWeapon.getBonusDamage();
    }

    public boolean dodge() {
        Random random = new Random();
        int dodgeChance = random.nextInt(1, 100);
        return dodgeChance <= agility;
    }

    public boolean critHit() {
        Random random = new Random();
        int critChance = random.nextInt(1, 100);
        return critChance <= intelligence;
    }
    void levelUp() {
        while (true) {
            if (experience >= requiredExperience) {
                experience=experience-requiredExperience;
                level=level + 1;
                maxHealth=maxHealth + 10;
                agility=agility + 2;
                intelligence=intelligence + 2;
                strength=strength + 2;
                System.out.printf("\nYou reached LEVEL %s",level);
            } else {
                System.out.printf("\nYou need %s Xp to reach level %s",requiredExperience - experience,level+1);
                break;
            }
        }
    }
    public void playerStats() {
        System.out.println(getName() + " Stats:\n▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
        System.out.printf("""   
                        Armor: %s
                        Weapon: %s
                        %sGold:%S %S%s
                        Agility:%S %S%s
                        Intelligence:%S %S%s
                        Strength:%S %S%s
                        Health: %S %S%s
                        Experience:%s%s
                        Level:%s %S%s
                        Base damage:%S %S
                        """, playerArmor.getName(), getPlayerWeapon().getName(), Colors.YELLOW, getGold(), Colors.RESET,
                Colors.GREEN, getAgility(), Colors.RESET, Colors.BLUE,
                getIntelligence(), Colors.RESET, Colors.PURPLE_BOLD_BRIGHT,
                getStrength(), Colors.RESET, Colors.RED, getHealth(),
                Colors.RESET, Colors.RESET, getExperience(), Colors.PURPLE, getLevel()
                , Colors.RESET, Colors.CYAN, getBaseDamage(), Colors.RESET, Colors.RESET);
    }
}
