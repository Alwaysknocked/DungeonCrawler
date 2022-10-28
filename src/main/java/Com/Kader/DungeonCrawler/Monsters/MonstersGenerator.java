package Com.Kader.DungeonCrawler.Monsters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class MonstersGenerator {
    List<Monster> generatedMonsterList = new ArrayList<>();
    List<Monster> availableMonstersList = new ArrayList<>();

    public void addAvailableMonsters() {
        availableMonstersList.add(new Balrog("BALROG",0, 250, 0, 50, 25,150));
        availableMonstersList.add(new DarkElf("DARK ELF",0, 150, 0, 20, 10, 40));
        availableMonstersList.add(new Dragon("DRAGON",0, 200, 10, 50, 15, 100));
        availableMonstersList.add(new ElderVampire("ELDER VAMPIRE",10, 250, 0, 50, 10, 40));
        availableMonstersList.add(new GiantCrab("GIANT CRAB",0, 300, 0, 20, 5, 20));
        availableMonstersList.add(new GiantSnake("GIANT SNAKE",10, 100, 0, 20, 5, 20));
        availableMonstersList.add(new GiantCrocodile("GIANT CROCODILE",0, 100, 5, 20, 5, 20));
        availableMonstersList.add(new Orc("ORC",0, 100, 0, 20, 5, 20));
        if (generatedMonsterList.isEmpty()) {
            addMonsterListGenerator();
        }else refillDungeon();
    }

    public void addMonsterListGenerator() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Monster monster = availableMonstersList.get(random.nextInt(availableMonstersList.size()));
            generatedMonsterList.add(i, monster);
        }
    }
    public void refillDungeon(){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Monster monster = availableMonstersList.get(random.nextInt(availableMonstersList.size()));
            if (generatedMonsterList.get(i).getHealth()==0){
                generatedMonsterList.set(i,monster);
            }
        }
    }

    public List<Monster> getGeneratedMonsterList() {
        return generatedMonsterList;
    }

}
