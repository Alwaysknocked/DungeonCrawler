package Com.Kader.DungeonCrawler.Shop;
import Com.Kader.DungeonCrawler.Game;
import Com.Kader.DungeonCrawler.Player;
import Com.Kader.DungeonCrawler.Shop.Armors.Armor;
import Com.Kader.DungeonCrawler.Shop.Armors.ArmorFactory;
import Com.Kader.DungeonCrawler.Shop.Potions.MixingPotions;
import Com.Kader.DungeonCrawler.Shop.Potions.Potion;
import Com.Kader.DungeonCrawler.Shop.Weapons.ForgeWeapons;
import Com.Kader.DungeonCrawler.Shop.Weapons.Weapon;

import java.util.List;

import static Com.Kader.DungeonCrawler.Colors.*;

public class Shop {

    ArmorFactory aF = new ArmorFactory();
    List<Armor> armorList = aF.getArmorList();
    ForgeWeapons fG = new ForgeWeapons();
    List<Weapon> weaponList = fG.getWeaponList();
    MixingPotions mP=new MixingPotions();
    List<Potion>potionsList= mP.getPotionsList();
    Player player = Game.player;

    public void buyArmor(int armorChoice) {

        if (armorList.get(armorChoice).getPrice() < player.getGold()) {
            equipArmor(armorChoice);
        } else System.out.println("YOU DON'T HAVE ENOUGH GOLD!" +
                "go slaughter some more beasts!");
    }
    public void equipArmor(int armorChoice) {

        if (player.getPlayerArmor().equals(armorList.get(armorChoice))) {
            System.out.println("You already wearing that armor silly!");
        } else {
            player.setMaxHealth(player.getMaxHealth() - player.getPlayerArmor().getHealthBonus());
            player.setPlayerArmor(armorList.get(armorChoice));
            player.setMaxHealth(player.getPlayerArmor().getHealthBonus() + player.getMaxHealth());
            System.out.printf("congrats!! you have bought %s !!!\n", armorList.get(armorChoice).getName());
            player.setGold(player.getGold() - armorList.get(armorChoice).getPrice());
        }
    }

    public void buyWeapon(int weaponChoice) {
        if (weaponList.get(weaponChoice).getPrice() < player.getGold()) {
            player.setGold(player.getGold() - weaponList.get(weaponChoice).getPrice());
            equipWeapon(weaponChoice);
        } else System.out.println("YOU DON'T HAVE ENOUGH GOLD!" +
                "go slaughter some more beasts!");
    }

    public void equipWeapon(int weaponChoice) {
        player.setAgility(player.getAgility() - player.getPlayerWeapon().getBonusAgility());
        player.setAgility(player.getIntelligence() - player.getPlayerWeapon().getBonusIntelligence());
        player.setPlayerWeapon(weaponList.get(weaponChoice));
        player.setAgility(player.getAgility() + weaponList.get(weaponChoice).getBonusAgility());
        player.setAgility(player.getIntelligence() + weaponList.get(weaponChoice).getBonusIntelligence());
        System.out.printf("congrats!! you have bought %s , use it wisely!\n", weaponList.get(weaponChoice).getName());
    }

    public void printArmorList() {
        System.out.printf("%25s %20s %25s %20s ", "Name", "Health bonus", "Damage reduction %", """
                       Price
                -------------------------------------------------------------------------------------------------------------------------
                """);
        for (int i = 0; i < armorList.size(); i++) {
            System.out.printf("%s %s %20s %s %15S %S %s %20S %S %s %16S %s\n", i, ".", armorList.get(i).getName(),
                    RED,armorList.get(i).getHealthBonus(), RESET,CYAN,
                    armorList.get(i).getReductionProcent(), RESET, YELLOW,
                    armorList.get(i).getPrice(), RESET, RESET);
        }
        System.out.printf("\n %s4 return to shop menu%s\n", RED, RESET);
    }

    public void printPotionList() {
        System.out.println("Here is my finest potions, mixed by the hands of the most legendary alchemists\n");
        System.out.printf("%20s %23s %23s %20s %18s %s", "Name", "Agility bonus", "Intelligence bonus", "Strength bonus", "Health bonus", """
                  Price
                -------------------------------------------------------------------------------------------------------------------------
                """);
        for (int i = 0; i < potionsList.size(); i++) {
            System.out.printf("%s %s %25s %s %10S %S %s %20S %S %s %16S %S %s %18S %S %s %11s %s\n", RESET, i, potionsList.get(i).getName(),
                    GREEN, potionsList.get(i).getAgility(), RESET, BLUE,
                    potionsList.get(i).getIntelligence(), RESET, PURPLE_BOLD_BRIGHT,
                    potionsList.get(i).getStrength(), RESET, RED, potionsList.get(i).getHealth(),
                    RESET, RESET, YELLOW, potionsList.get(i).getPrice(), RESET);

        }
        System.out.printf("\n %s4 return to shop menu%s\n", RED, RESET);
    }

    public void printWeaponsList() {
        System.out.println();
        System.out.printf("%15s %25s %25s %15s %15s", "Name", "Agility bonus", "Intelligence bonus", "Damage bonus", """
                   Price
                ------------------------------------------------------------------------------------------------
                """);
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.printf("%s %s %20s %s %10s %S %s %20s %s %s %17s %s %s %10s %s \n"
                    , RESET, i, weaponList.get(i).getName(), GREEN, weaponList.get(i).getBonusAgility(), RESET
                    , BLUE, weaponList.get(i).getBonusIntelligence(), RESET, PURPLE_BOLD_BRIGHT, weaponList.get(i).getBonusDamage()
                    , RESET, YELLOW, weaponList.get(i).getPrice(), RESET);
        }
        System.out.printf("\n %s4 return to shop menu%s\n", RED, RESET);
    }

    public void buyPotion(int potionChoice) {
        if (potionsList.get(potionChoice).getPrice() < player.getGold()) {
            player.setGold(player.getGold() - potionsList.get(potionChoice).getPrice());
            drinkPotion(potionChoice);
            System.out.println("You feel the power flowing through your veins after you drank the potion!!!");
        } else System.out.println("YOU DON'T HAVE ENOUGH GOLD!" +
                "go slaughter some more beasts!");
    }

    public void drinkPotion(int potionChoice) {
        List<Potion> drinkPotionList = potionsList;
        player.setHealth(player.getHealth() + drinkPotionList.get(potionChoice).getHealth());
        if (player.getHealth()>player.getMaxHealth()){
            player.setHealth(player.getMaxHealth());
        }
        player.setAgility(player.getAgility() + drinkPotionList.get(potionChoice).getAgility());
        player.setIntelligence(player.getIntelligence() + drinkPotionList.get(potionChoice).getIntelligence());
        player.setStrength(player.getStrength() + drinkPotionList.get(potionChoice).getStrength());
    }

}