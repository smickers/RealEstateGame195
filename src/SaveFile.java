import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Purpose: saves the state of the current game
 * Date: May 9 2016
 * @author cstCam
 *
 */
public class SaveFile {

	 /**
     * 
     * Purpose: A static method to save an object to a file.
     * 
     * @param save
     * @param fileName
     * @throws Exception
     */
    public static void save(Object toSave, String fileName) throws Exception
    {
        // Setting up a FOS and OOS to quickly save the file. Since I'm using
        // an OOS, it's nice and easy to reconstruct the stack when we decide
        // to load the file again.
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        // Write out the stack to our file
        oos.writeObject(toSave);
        
        // Save the file, and close the connection.
        oos.close();
        
        // A friendly little message to let the user know that their very
        // important calculations are safely tucked away.
        System.out.println("File saved!");

    }
}
