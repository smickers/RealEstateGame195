import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
	
	
}

