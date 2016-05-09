import javafx.scene.image.Image;

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
    public Image trainerImage;
    public Image trainerToken;
    
    public Trainer(String name, Image trainerImage, Image trainerToken)
    {
        this.name = name;
        this.trainerImage = trainerImage;
        this.trainerToken = trainerToken;
    }

}
