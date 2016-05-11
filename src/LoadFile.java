import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Purpose: Loads a saved game, and returns it
 * Date: May 9 2016
 * @author cstCam
 *
 */
public class LoadFile {
	/**
     * Purpose: A static method to load an object from a file, and then return
     * it.
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
    public static Object load(String fileName) throws Exception
    {
        // Set up a FIS and OIS to grab the object from the file.
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        // We'll grab the object in the file, and then convert it to a Stack
        // I know this won't ever throw an error, since only Stacks will ever
        // be saved to this file
        Object toReturn = ois.readObject();
        
        // Return the stack
        return toReturn;
    }
}
