package Com.Kader.DungeonCrawler;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class PlayerLevelUpTest {

    int level = 0;
    private int strength = 100;
    private int intelligence = 10;
    private int agility = 10;
    private int maxHealth = 100;
    private int experience = 0;
    private int requiredExperience = 100;

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

    @Test
    void levelUpTest() {
        experience=650;
        levelUp();
        System.out.println("\n"+level+" "+requiredExperience+" "+experience);
        Assert.assertEquals(6, level);
        Assert.assertEquals(50,experience);
        Assert.assertEquals(22,intelligence);
    }
}