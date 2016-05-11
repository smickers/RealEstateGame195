import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class UpdateCenterView
{
//    private static Scene scene;
//    private static Stage stage;
    
    public static void main(String[] args)
    {
        runTests();
    }
    public static void runTests()
    {
//        this.stage = stage;
//        StackPane main = new StackPane();
//        scene = new Scene(main);
//        stage.setScene(scene);
//        stage.show();
        
        
        /////////////////////////////////////////////////
        
        String[] names = new String[] {"a", "b", "c"};
        Pokemon testPokemon = new Pokemon(names, null, 5, 3);
        PokemonTile test = new PokemonTile(testPokemon,50, null, "Test Pokemon", null);
        Player testPlayer = new Player(new Trainer("Test trainer",null, null));
        testPlayer.addToBalance(5000);
        test.action(testPlayer);
        ////////////////////////////////////////////////////
        
        // Test when Pokemon is already owned
        ///////////////////////////////////////////
//        String[] names = new String[] {"a", "b", "c"};
//        Pokemon testPokemon = new Pokemon(names, null, 5, 3);
//        PokemonTile test = new PokemonTile(testPokemon,50, null, "Test Pokemon", null);
//        Player testPlayer = new Player(new Trainer("Test trainer",null, null));
//        Player testPlayerTwo = new Player(new Trainer("Test trainer 2",null, null));
//        testPlayerTwo.addToBalance(5000);
////        test.action(testPlayer);
//        test.changeOwner(testPlayer);
//        test.action(testPlayerTwo);
        ////////////////////////////////////////////////////////
    }
    
//    public static void updateScene(Pane newPane)
//    {
//        stage.setScene(new Scene(newPane));
//    }
    
}
