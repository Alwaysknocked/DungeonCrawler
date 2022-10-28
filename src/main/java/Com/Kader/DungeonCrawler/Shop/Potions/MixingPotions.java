package Com.Kader.DungeonCrawler.Shop.Potions;

import java.util.ArrayList;
import java.util.List;

public class MixingPotions {
    List<Potion> potionsList=new ArrayList<>();

    public List<Potion> getPotionsList() {
        mixPotions();
        return potionsList;
    }
    public void mixPotions(){
        potionsList.add(new PotionOfLionsStrength(100,5,0,0,0));
        potionsList.add(new ElixirOfAgility(100,0,0,5,0));
        potionsList.add(new PhilterOfHealing(20,0,0,0,10));
        potionsList.add(new PotionOfIntelligence(100,0,5,0,0));
    }
}
