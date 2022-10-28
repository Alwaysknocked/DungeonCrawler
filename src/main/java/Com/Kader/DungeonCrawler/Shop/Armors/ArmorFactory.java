package Com.Kader.DungeonCrawler.Shop.Armors;
import java.util.ArrayList;
import java.util.List;

public class ArmorFactory {
    List<Armor>ArmorList=new ArrayList<>();

    public List<Armor> getArmorList() {
        createArmor();
        return ArmorList;
    }

    public void createArmor(){
        ArmorList.add(new LeatherArmor(100,10,0.9,"10%"));
        ArmorList.add(new MailArmor(150,20,0.8,"20%"));
        ArmorList.add(new ChainArmor(200,30,0.70,"30%"));
        ArmorList.add(new PlateArmor(250,40,0.6,"40%"));
    }
}
