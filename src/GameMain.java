/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  COSC 190
 *  Instructors: Sharon McDonald, Nelson Wong
 * 
 */

/**
 * @author cst104
 *
 */
public class GameMain
{

    private Player[] players;
    private Pokemon[] pokemon;
    private GameBoard gameBoard;
    private UpdateCenterView centerViewUpdater;
    private int currentPlayer;
    private int wPToWin;
    
    public GameMain(Player[] player)
    {
        if(players.length == 2)
        {
            wPToWin = 4;
        }
        else if (players.length == 3)
        {
            wPToWin = 3;
        }
        else if (players.length == 4)
        {
            wPToWin = 2;
        }
    }
    
    private void initializeBoard()
    {
        
    }
    
    private void initializePokemon()
    {
        
    }
    
    public void initializeGame()
    {
        
    }
    
    public void play()
    {
        while(players[currentPlayer].winPoints != wPToWin )
        {
            
        }
    }
}
