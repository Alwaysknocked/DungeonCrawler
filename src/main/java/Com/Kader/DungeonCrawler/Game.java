package Com.Kader.DungeonCrawler;

import Com.Kader.DungeonCrawler.Monsters.Monster;
import Com.Kader.DungeonCrawler.Monsters.MonstersGenerator;
import Com.Kader.DungeonCrawler.Shop.Shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Com.Kader.DungeonCrawler.Colors.*;

public class Game {
    public static Player player = new Player();
    MonstersGenerator mG = new MonstersGenerator();
    List<Monster> monsterList = mG.getGeneratedMonsterList();
    List<Monster> slainMonstersList = new ArrayList<>();
    static int monsterChoice;

    public void playerName() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hello mighty warrior!\nBless us with your name:");
        boolean correctPlayerName = false;
        while (!correctPlayerName) {
            String pName = myScanner.next();
            if (pName.matches("[a-zA-Z]+")) {
                player.setName(pName);
                correctPlayerName = true;
            } else System.out.println("Invalid name, make sure to enter only letters!\nPlease try again:");
        }
        gameMenu();
    }

    public void gameMenu() {
        while (true) {
            System.out.println(RESET + "\n___________________________________________\n" +
                    "Choose one of the options below\n▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼" +
                    "\n1.Enter the dungeon.\n2.Display player stats.\n3.Enter the shop.\n4.Show Score\n5.Exit game." +
                    "\n___________________________________________");
            int menuChoice = intInput(5);
            switch (menuChoice) {
                case 1 -> {
                    System.out.println("you enter the dungeon to your surprise its full of monsters!!.");
                    mG.addAvailableMonsters();
                    printMonsterList();
                    monsterChoice = intInput(9);
                    playerCombatAct();
                    while (true) {
                        if (player.getHealth() == 0) {
                            saveScore();
                            System.out.println("\nExiting game..");
                            return;
                        } else if (monsterList.get(monsterChoice).getHealth() == 0) {
                            break;
                        }
                        System.out.println("\nChoose next move:");
                        System.out.println(RESET + "___________________\n1.Flee the battle!\n2.Attack again!\n3.Show Stats!\n___________________");
                        int inBattleChoice = intInput(3);
                        switch (inBattleChoice) {
                            case 1 -> fleeBattle();
                            case 2 -> playerCombatAct();
                            case 3 -> printStatsInBattle();
                        }
                    }
                }
                case 2 -> {
                    player.playerStats();
                    gameMenu();
                }
                case 3 -> {
                    System.out.println("Entering the shop...");
                    System.out.printf("Welcome " + player.getName() + " to my humble shop, here you can find the tools to make your job easier.\n");
                    boolean stillShopping = true;
                    Shop shop = new Shop();
                    while (stillShopping) {
                        System.out.printf("\n1.Potions\n2.Weapons\n3.Armor\n%s4.Main menu.%s\n", RED, RESET);
                        int shopChoice = intInput(4);
                        switch (shopChoice) {
                            case 1 -> {
                                shop.printPotionList();
                                while (true) {
                                    int potionChoice = intInput(5);
                                    if (potionChoice != 4) {
                                        shop.buyPotion(potionChoice);
                                    } else {
                                        break;
                                    }
                                }
                            }
                            case 2 -> {
                                shop.printWeaponsList();
                                while (true) {
                                    int weaponChoice = intInput(5);
                                    if (weaponChoice != 4) {
                                        shop.buyWeapon(weaponChoice);
                                    } else {
                                        break;
                                    }

                                }
                            }
                            case 3 -> {
                                shop.printArmorList();
                                while (true) {
                                    int armorChoice = intInput(5);
                                    if (armorChoice != 4) {
                                        shop.buyArmor(armorChoice);
                                    } else {
                                        break;
                                    }
                                }
                            }
                            case 4 -> stillShopping = false;

                        }

                    }
                }
                case 4 -> displayScore();
                case 5 -> {
                    saveScore();
                    System.out.println("\nExiting game..");
                    return;
                }

            }

        }
    }

    public void playerCombatAct() {
        if (monsterList.get(monsterChoice).getHealth() > 0 & player.getHealth() > 0) {
            if (monsterList.get(monsterChoice).dodge()) {
                System.out.printf("%s dodged your attack!\n", monsterList.get(monsterChoice).getName());
            } else {
                monsterList.get(monsterChoice).setHealth(monsterList.get(monsterChoice).getHealth() - player.fight());
                if (monsterList.get(monsterChoice).getHealth() <= 0) {
                    monsterList.get(monsterChoice).setHealth(0);
                    System.out.printf("%s remaining health: %s%s%s\n", monsterList.get(monsterChoice).getName(), RED, monsterList.get(monsterChoice).getHealth(), RESET);
                    wonBattle();
                    return;
                } else
                    System.out.printf("%s remaining health: %s%s%s\n", monsterList.get(monsterChoice).getName(), RED, monsterList.get(monsterChoice).getHealth(), RESET);
            }
            if (player.dodge()) {
                System.out.printf("you dodged the %s attack\n", monsterList.get(monsterChoice).getName());
            } else {
                player.setHealth(player.getHealth() - player.getPlayerArmor().calculateDamageReduction(monsterList.get(monsterChoice).fight()));
                if (player.getHealth() <= 0) {
                    player.setHealth(0);
                    System.out.printf("\n%s armor blocked %s", player.getName(), player.getPlayerArmor().getReductionProcent());
                    System.out.printf("\n%s remaining health: %s%s%s\n", player.getName(), RED, player.getHealth(), RESET);
                    System.out.println("\n------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("As bravely you fought the %s got the best of you...", monsterList.get(monsterChoice).getName());
                } else
                    System.out.printf("\n%s armor blocked %s ", player.getName(), player.getPlayerArmor().getReductionProcent());
                System.out.printf("\n%s remaining health: %s%s%s\n", player.getName(), RED, player.getHealth(), RESET);
            }

        } else if (player.getHealth() == 0) {
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("As bravely you fought the %s got the best of you...", monsterList.get(monsterChoice).getName());
        } else {
            System.out.println("This monster is already dead!");
        }
    }

    public void printMonsterList() {
        System.out.printf("%23s %15s %20s  %13s  %15s", "Name", "Agility", "Intelligence", "Health", """
                       Base damage
                ------------------------------------------------------------------------------------------------------------------------
                """);
        for (int i = 0; i < monsterList.size(); i++) {
            System.out.printf("%s %s %20s %s %10S %S %s %15S %S   %s %15S %S %s %12s %s  %4s %S\n", RESET, i,
                    monsterList.get(i).getName(), GREEN, monsterList.get(i).getAgility(), RESET, BLUE, monsterList.get(i).getIntelligence(),
                    RESET, RED, monsterList.get(i).getHealth(), RESET, PURPLE,
                    RESET, CYAN, monsterList.get(i).calculateDamage(), RESET);
        }
        System.out.println(RESET + "Enter monster number you want to fight: ");
    }


    public void fleeBattle() {
        Player player = new Player();
        if (player.dodge()) {
            System.out.printf("\n%sYou managed to get away from certain death!!%s\n", GREEN, RESET);
            gameMenu();
        } else {
            System.out.printf("\n%sThe beast managed to stop you from escaping!!%s\n", RED, RESET);
            playerCombatAct();
        }
    }

    public void wonBattle() {
        System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n" +
                        "you slayed the %s, it dropped you %s gold, and you gained %s experience!\n",
                monsterList.get(monsterChoice).getName(),
                monsterList.get(monsterChoice).getGold(),
                monsterList.get(monsterChoice).getExperience());
        player.setGold(player.getGold() + monsterList.get(monsterChoice).getGold());
        System.out.printf("\n%s total gold:%s%s%s", player.getName(), YELLOW, player.getGold(), RESET);
        player.setExperience(player.getExperience() + monsterList.get(monsterChoice).getExperience());
        System.out.printf("\n%s total Experience:%s", player.getName(), player.getExperience());
        player.levelUp();
        player.setHealth(player.getMaxHealth());
        slainMonstersList.add(monsterList.get(monsterChoice));
    }

    public void printStatsInBattle() {
        System.out.printf("%7s %15s %20s %15s  %1s", "Name", "Agility", "Intelligence", "Health", "     Base damage\n" +
                "------------------------------------------------------------------------------------------------------------------------\n");

        System.out.printf("%s %7s %s %10S %S %s %15S %S  %s %17S %S %s %10s %s \n", RESET, monsterList.get(monsterChoice).getName(), GREEN, monsterList.get(monsterChoice).getAgility(), RESET, BLUE,
                monsterList.get(monsterChoice).getIntelligence(), RESET, RED, monsterList.get(monsterChoice).getHealth(), RESET
                , CYAN, monsterList.get(monsterChoice).calculateDamage(), RESET);
        System.out.printf("%s %7s %s %10S %S %s %15S %S  %s %17S %S %s %10s %s \n", RESET, player.getName(), GREEN, player.getAgility(), RESET, BLUE,
                player.getIntelligence(), RESET, RED, player.getHealth(), RESET
                , CYAN, player.calculateDamage(), RESET);
    }

    public void saveScore() {
        try {
            FileWriter writer = new FileWriter("playerScore.txt", true);
            writer.write("__________________________________________________________________________________________________");
            writer.write("\nPlayer name: " + player.getName() + " Level: " + player.getLevel() + " Gold:" + player.getGold());
            writer.write("\nSlain monsters(" + slainMonstersList.size() + "): ");
            for (int i = 0; i < slainMonstersList.size(); i++) {
                writer.write(slainMonstersList.get(i).getName() + "  | ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("playerScore.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int intInput(int range) {
        Scanner myScanner = new Scanner(System.in);
        int intInput = 0;
        boolean correctInput = false;
        while (!correctInput) {
            try {
                intInput = myScanner.nextInt();
                if (intInput < 0 || intInput > range) {
                    System.out.println("enter a valid choice!");
                } else
                    correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please make sure to enter only integers!\nPlease try again:");
                myScanner.nextLine();
            }
        }
        return intInput;
    }
}
