import javafx.scene.image.Image;


public abstract class Tile
{
    protected String name;
    protected Image image;
    
    public Tile(String name, Image image)
    {
        this.name = name;
        this.image = image;
    }
    
    public abstract void action(Player player);

}
