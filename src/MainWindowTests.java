import static org.junit.Assert.*;
import javafx.scene.layout.StackPane;

import org.junit.Test;


public class MainWindowTests
{
    
    @Test
    public void testThatSetSceneWorksCorrectly()
    {
        StackPane newPane = new StackPane();
        MainWindow.setScene(newPane);
        
        assertTrue(newPane.equals(MainWindow.scene.getRoot()));
    }
    
    @Test
    public void testThatSetSceneDoesntAcceptNullValues()
    {
        StackPane newPane = null;
        MainWindow.setScene(newPane);
        
        assertFalse(MainWindow.scene.getRoot().equals(newPane));
    }
    

}
