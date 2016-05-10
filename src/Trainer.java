import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
public class Trainer
{

    public String name;
    public ImageView trainerImage;
    public ImageView trainerToken;
    
    public Trainer(String name, ImageView trainerImage, ImageView trainerToken)
    {
        this.name = name;
        this.trainerImage = trainerImage;
        this.trainerToken = trainerToken;
    }

}
