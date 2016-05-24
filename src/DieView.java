import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Nathan MacNeil, Hilary Fehr
 *
 */
public class DieView extends ImageView
{
    //Variable that will hold the different faces of the dice to be displayed.
    public Image[]  faces;
    //Constant holding the amount of sides of the die.
    static final int MAX_SIDES_TO_DICE = 6;
    //Constant holding the initial face to be displayed on the dice.
    static final int STARTING_POSITION_FOR_DICE = 0;
    
    /**
     * Constructor for the DieView class.
     */
    public DieView()
    {
        //Set the faces for this view to be the same as the GameBoard's array 
        // of faces.
        this.faces = GameBoard.FACES;
        
        //Set the initial image to be the starting position for the dice.
        this.setImage(this.faces[STARTING_POSITION_FOR_DICE]);
        
        this.preserveRatioProperty();
        this.setFitWidth( 170 );
        this.setFitHeight( 170 );
        
    }
    
  
    /**
     * Purpose: to change the image on the imageView
     * @param face
     */
    public void setFace(int face)
    {
        this.setImage(this.faces[face]);
    }
    

}
