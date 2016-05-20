import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Purpose: This class is used to represent the visual game board,
 * 			and the overlaying grid that maps the tiles.
 * 
 * @author Paz Aloni, Stephanie McCallum
 *
 */

public class GameBoard extends GridPane
{
    static final Image[] FACES = {new Image("./img/img1.png"),
        new Image("./img/img2.png"),
        new Image("./img/img3.png"),
        new Image("./img/img4.png"),
        new Image("./img/img5.png"),
        new Image("./img/img6.png")};
    
	//High res
	//private final static int narrowBorder = 82;
	//private final static int wideBorder = 207;
	
	//Low res
	private final static int narrowBorder = 64;
	private final static int wideBorder = 106;
	
	private static final Color CLEAR = Color.TRANSPARENT;
	
	private static final Image BACKGROUND_IMAGE = new Image("images/monopolyBoard.png");
	
	Rectangle tilesOverlay[] = new Rectangle[GameMain.NUM_OF_TILES];
	
	/**
	 * Constructor for a new game board
	 */
	public GameBoard()
	{
		//add the background image
		this.add(new ImageView(BACKGROUND_IMAGE), 0, 0, 40, 40);
		
		//keeps track inside the loop of rows and columns to add in the grid pane
		int col = 10;
		int row = 10;
		
		//generate all the square "place-holders" for the grid pane
		for(int i=0 ; i < GameMain.NUM_OF_TILES ; i++)
		{
			if(i%10 == 0)
			{
				//corner tile
				tilesOverlay[i] = new Rectangle(wideBorder, wideBorder, CLEAR);
			}
			else if((i/10)%2 == 0)
			{
				//horizontal tile
				tilesOverlay[i] = new Rectangle(narrowBorder, wideBorder, CLEAR);
			}
			else
			{
				//vertical tile
				tilesOverlay[i] = new Rectangle(wideBorder, narrowBorder, CLEAR);
			}
			
			
			//####################
			//## For DEMO Only! ##
			//####################
			//for acceptance testing - display borders
			//tilesOverlay[i].setStroke(Color.RED);
			//this.add(new Text("\t"+i), col , row);
			
			//### END OF DEMO ###
			
			//add the placeholder to the grid, based on the order of the grids
			//left column
			if(col == 0 && row > 0)
			{
				this.add(tilesOverlay[i], col , row);
				row--;
			}
			//bottom row
			else if(row == 10 && col > 0)
			{
				this.add(tilesOverlay[i], col , row);
				col--;
			}
			//right column
			else if(col < 10)
			{
				this.add(tilesOverlay[i], col , row);
				col++;
			}
			//top row
			else if(row < 10)
			{
				this.add(tilesOverlay[i], col , row);
				row++;
			}
		}
		
		
	}
	
	//Variable holding the Image of the first die
	public DieView die1 = new DieView();
	//Variable holding the Image of the second die.
	public DieView die2 = new DieView();
	//Variable holding the button that will be used to roll the dice.
	public Button btnRoll = new Button("Roll");
	//TODO reference to GameMain that will will 
	public GameMain gm = new GameMain();
	
	/**
	 * Purpose: to start the thread that will visually display the dice being 
	 *  rolled.
	 */
	public void rollDie()
	{
	    //Create a thread that will roll the dice that will last 3 seconds.
	    Spinners rollDie = new Spinners(3);
	    
	    //Start the thread.
	    rollDie.start();
	}
	
	//TODO test method to try roll dice button, will be replaced by a larger
	// class to add all listeners.
	
    /**
     * Purpose: to add a handler to the roll dice button that will roll the
     *  dice.
     */
    public void testAddListener()
    {
        btnRoll.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent ae)
            {
                //Disable the roll button so it can't be clicked again.
                btnRoll.setDisable(true);
                
                //Start the dice rolling.
                rollDie();
            }
        });
    }
    
	//TODO make a separate class. 
    /**
     * Purpose: 
     * @author Hilary Fehr, Nathan MacNeil
     *
     */
  private class Spinners extends Thread implements Runnable
  {
      
      int time;
      long start;
      long end;
      
      public Spinners( int time )
      {
        
          this.time = time;
          this.start = System.currentTimeMillis();
          this.end = start + (time * 1000);
      }
      
      @Override
      public void run()
      {
          while(System.currentTimeMillis() < end)
          {
              for (int i = 0; i < time; i++)
              {
                  Platform.runLater(new Runnable()
                      {
                          @Override
                          public void run()
                          {
                              //Set the image of both dice to be randomly
                              // selected images.
                        	  die1.setFace((int) Math.floor(Math.random() * 
                        	          DieView.MAX_SIDES_TO_DICE ));
                        	  die2.setFace((int) Math.floor(Math.random() * 
                        	          DieView.MAX_SIDES_TO_DICE ));
                          }
                      });
                  try
                  {
                      
                      Thread.sleep(130);
                  }
                  catch (InterruptedException e)
                  {
                      currentThread().interrupt();
                  } 
                  
              }
          }
          TurnOutcome outcome = gm.getTurnOutcome();
          System.out.println(outcome.getDieOne() + 1);
          System.out.println(outcome.getDieTwo() + 1);
          die1.setFace(outcome.getDieOne());
          die2.setFace(outcome.getDieTwo());
        
      }
  }
	
	
}

