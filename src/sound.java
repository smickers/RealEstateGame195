import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;


public class sound {

	
	public static MediaPlayer player;
	
	public static void playSound(String fileName){
        Media m = new Media(Paths.get("src/audio/" + fileName).toUri().toString());
        player = new MediaPlayer(m);
        player.play();
        
    }
	
	public static void stop()
	{
		if (player != null)
		{
			player.stop();
		}

		else
		{
			System.out.println("too fuckiin bad");
		}
	}
}
