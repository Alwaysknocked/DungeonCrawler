package Com.Kader.DungeonCrawler.Shop.Weapons;
import java.util.ArrayList;
import java.util.List;
public class ForgeWeapons {
    List<Weapon> weaponList=new ArrayList<>();

    public List<Weapon> getWeaponList() {
        createArmor();
        return weaponList;
    }

    public void createArmor(){
        weaponList.add(new Axe(200,15,-5,0));
        weaponList.add(new Daggers(200,5,5,0));
        weaponList.add(new Staff(200,5,0,5));
        weaponList.add(new Sword(200,5,2,2));
    }
}
