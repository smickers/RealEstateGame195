import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;


public class sound {

	
	public static MediaPlayer player;
	/**
	 * Purpose: Takes in file name, creates a new media player
	 * 		    and plays audio file
	 * @param fileName
	 */
	public static void playSound(String fileName){
        Media m = new Media(Paths.get("src/audio/" + fileName).toUri().toString());
        player = new MediaPlayer(m);
        player.play();
        
    }
	/**
	 * Purpose: stops media player
	 */
	public static void stop()
	{
		if (player != null)
		{
			player.stop();
		}

		else
		{
			System.out.println("Media Player cannot be stopped at this time");
		}
	}
	
}
