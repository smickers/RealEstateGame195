import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;


public class TileHandler
{
    public static void updateItem(Node toChange)
    {
        DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
//        System.out.println(toChange.getEffect());
        if (toChange.getEffect() == null)
        {
            toChange.setEffect(ds);
        }
        else
        {
            toChange.setEffect(null);
        }
    }
}
