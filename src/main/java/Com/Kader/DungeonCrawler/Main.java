package Com.Kader.DungeonCrawler;
public class Main {
    public static void main(String[] args) {
        System.out.println("\n________________________________________________________________________________________________\nWelcome to Dungeon Runner, You never know what kind of monster you will face.\n" +
                "Be wise... sometimes its better to run than fight!\n________________________________________________________________________________________________\n");
        newGame();
    }
    public static void newGame(){
        Game game = new Game();
        game.playerName();
    }
}
