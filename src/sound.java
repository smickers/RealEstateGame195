import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class sound {

	public static void playSound(String fileName){
        Media m = new Media(Paths.get("audio/" + fileName).toUri().toString());
        MediaPlayer player = new MediaPlayer(m);
        player.play();
    }
}
