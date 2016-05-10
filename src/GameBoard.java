import java.util.Queue;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class GameBoard
{
    private Tile[] gameTiles;
    private Pane centerView;
    private Queue<Pokecard> pokecards;
    private GridPane mainBoard;
    
    public GameBoard()
    {
        // Initialize game tiles
    }
    
    public void updateCenterView(Pane newPane)
    {
        centerView = newPane;
    }
    
    public Pokecard drawTopPokecard()
    {
        return pokecards.remove();
    }
    
    public void addPokecardToDeck(Pokecard toAdd)
    {
        pokecards.add(toAdd);
    }
    
    public void initializeTiles()
    {
        // initialize the game tiles in here
    }
    
    public Tile tileAtIndex(int index)
    {
        return gameTiles[index];
    }
}
