
public class ImageReference
{
    private static final String ASH_IMAGE_LOCATION = "trainers/ash.png";
    private static final String GARY_IMAGE_LOCATION = "trainers/Gary.png";
    private static final String HILDA_IMAGE_LOCATION = "trainers/hilda.png";
    private static final String MAY_IMAGE_LOCATION = "trainers/May.png";
    
    private static final String ASH_TOKEN_LOCATION = "images/pkoeball1.png";
    private static final String GARY_TOKEN_LOCATION = "images/pkoeball2.png";
    private static final String HILDA_TOKEN_LOCATION = "images/pkoeball3.png";
    private static final String MAY_TOKEN_LOCATION = "images/pkoeball4.png";
    
    public static String getPlayerImage(Player player)
    {
        String toReturn;
        if (player.name.equals("Ash"))
        {
            toReturn = ASH_IMAGE_LOCATION;
        }
        else if (player.name.equals("Gary"))
        {
            toReturn = GARY_IMAGE_LOCATION;
        }
        else if (player.name.equals("Hilda"))
        {
            toReturn = HILDA_IMAGE_LOCATION;
        }
        else
        {
            toReturn = MAY_IMAGE_LOCATION;
        }
        
        return toReturn;
    }
    
    public static String getPlayerToken(Player player)
    {
        String toReturn;
        if (player.name.equals("Ash"))
        {
            toReturn = ASH_TOKEN_LOCATION;
        }
        else if (player.name.equals("Gary"))
        {
            toReturn = GARY_TOKEN_LOCATION;
        }
        else if (player.name.equals("Hilda"))
        {
            toReturn = HILDA_TOKEN_LOCATION;
        }
        else
        {
            toReturn = MAY_TOKEN_LOCATION;
        }
        
        return toReturn;   
    }
}
