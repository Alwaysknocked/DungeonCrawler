package Com.Kader.DungeonCrawler;
import Com.Kader.DungeonCrawler.Monsters.Balrog;
import Com.Kader.DungeonCrawler.Monsters.Monster;
import Com.Kader.DungeonCrawler.Shop.Armors.LeatherArmor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static Com.Kader.DungeonCrawler.Colors.RED;
import static Com.Kader.DungeonCrawler.Colors.RESET;

public class RecieveDamageTest {
    Player player = new Player();
    Monster monster = new Balrog("Balrog", 0, 250, 0, 50, 10, 0); //Instantiating a monster for test purposes.

    public void playerCombatAct() {
        if (monster.getHealth() > 0 & player.getHealth() > 0) {
            if (monster.dodge()) {
                System.out.printf("%s dodged your attack!\n", monster.getName());
            } else {
                monster.setHealth(monster.getHealth() - player.fight());
                if (monster.getHealth() <= 0) {
                    monster.setHealth(0);
                    System.out.printf("%s remaining health: %s%s%s\n", monster.getName(), RED, monster.getHealth(), RESET);
                    System.out.println("Won battle!");
                    return;
                } else
                    System.out.printf("%s remaining health: %s%s%s\n", monster.getName(), RED, monster.getHealth(), RESET);
            }
            if (player.dodge()) {
                System.out.printf("you dodged the %s attack\n", monster.getName());
            } else {
                player.setHealth(player.getHealth() - player.getPlayerArmor().calculateDamageReduction(monster.fight()));
                if (player.getHealth() <= 0) {
                    player.setHealth(0);
                    System.out.printf("\n%s armor blocked %s", player.getName(), player.getPlayerArmor().getReductionProcent());
                    System.out.printf("\n%s remaining health: %s%s%s\n", player.getName(), RED, player.getHealth(), RESET);
                    System.out.println("\n------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("As bravely you fought the %s got the best of you...", monster.getName());
                } else
                    System.out.printf("\n%s armor blocked %s ", player.getName(), player.getPlayerArmor().getReductionProcent());
                System.out.printf("\n%s remaining health: %s%s%s\n", player.getName(), RED, player.getHealth(), RESET);
            }

        } else if (player.getHealth() == 0) {
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("As bravely you fought the %s got the best of you...", monster.getName());
        } else {
            System.out.println("This monster is already dead!");
        }
    }
    @Test
    public void playerTakingDamageTest() {
        player.setName("player");
        player.setAgility(0);       //Making sure to avoid dodging by player.
        System.out.printf("player health: %s", player.getHealth());
        playerCombatAct();
        System.out.printf("Player health after attack exchange with the monster: %s", player.getHealth());
        Assert.assertEquals(90,player.getHealth());
    }
    @Test
    public void playerDodgingTest(){
        player.setName("player");
        player.setAgility(100);       //guaranteeing a dodge by player.
        System.out.printf("player health: %s", player.getHealth());
        playerCombatAct();
        System.out.printf("Player health after attack exchange with the monster: %s", player.getHealth());
        Assert.assertEquals(100,player.getHealth());       //player health remains the same.
    }
    @Test
    public void playerArmorblockingTest(){
        player.setName("player");
        player.setAgility(0);       //Making sure to avoid dodging by player.
        player.setPlayerArmor(new LeatherArmor(0,0,0.9,"10%")); //Lets through only 90% of the monsters attack
        System.out.printf("player health: %s", player.getHealth());
        playerCombatAct();
        System.out.printf("Player health after attack exchange with the monster: %s", player.getHealth());
        Assert.assertEquals(91,player.getHealth());
    }
    @Test
    public void playerLoosingTest(){
        player.setName("player");
        player.setAgility(0);       //Making sure to avoid dodging by player.
        player.setHealth(10);
        System.out.printf("player health: %s", player.getHealth());
        playerCombatAct();
        Assert.assertEquals(0,player.getHealth());
    }

}
