import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class DieView extends ImageView
{

    public Image[]  faces;
    static final int MAX_SIDES_TO_DICE = 6;
    
    
    public DieView()
    {
        this.faces = GameBoard.FACES;
        this.setImage(this.faces[0]);
    }
    
  
    
    public void setFace(int face)
    {
        this.setImage(this.faces[face]);
    }
    

}
