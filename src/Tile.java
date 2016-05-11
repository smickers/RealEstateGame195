import javafx.scene.image.ImageView;


public abstract class Tile
{
    private String name;
    private ImageView image;
    
    public Tile()
    {
    
    }
    
    public void action(Player player)
    {
        //performs the action associated with the specific tile landed on
    }
}
