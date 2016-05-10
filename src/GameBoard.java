import java.util.Queue;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class GameBoard
{
    static Tile[] gameTiles;
    private Pane centerView;
    private Queue<Pokecard> pokeCards;
    private GridPane mainBoard;
    
    public void updateCenterView(Pane newPane)
    {
        
    }
    
    public Pokecard drawTopPokecard()
    {
        Pokecard nextCard = Pokecard.deck[Pokecard.deck.length-1];
        return nextCard;
        
    }
    
    public void addPokecardToDeck(Pokecard toAdd)
    {
        
    }
    
    private void initializeTiles()
    {
        
    }
    
}
