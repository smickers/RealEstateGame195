import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class evolutionPane extends Thread implements Runnable{

	private static String evolutionSong = "evolution.mp3";
	private static String devolutionSong = "devolutionCut.mp3";
	private static Pokemon pokemon;
	private static ImageView iv1;
	static Image pokemonFirstImage;
	private Thread evolveDevolveAnimation;

	public static Pane buildEvolutionPane(Pokemon p)
	{
		pokemon = p;
		
		sound music = new sound();
		music.playSound(evolutionSong);
		
		
		VBox vbox = new VBox();
		vbox.setPrefSize(500, 500);
		String pokemonFirstName = pokemon.currentName;
		pokemonFirstImage = pokemon.currentImage;
		Text t = new Text(pokemon.currentName + " is evolving!");
		iv1 = new ImageView(pokemon.currentImage);
		Button button = new Button("Continue");
		Text title = new Text("EVOLUTION!");
		vbox.getChildren().add(title);
		vbox.getChildren().add(iv1);
		vbox.getChildren().add(t);
		vbox.getChildren().add(button);
		
		//Alert alert = new Alert(AlertType.INFORMATION, "Woah, " + pokemon.currentName + " is evolving!" );
		//alert.show();
		vbox.setAlignment(Pos.CENTER);
		
		button.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
        	 * Purpose: shows the evolution when button is pressed
        	 */
            @SuppressWarnings("static-access")
			public void handle( ActionEvent event )
            {
            	pokemon.evolve();
            	t.setText(pokemonFirstName + " evolved into " + pokemon.currentName +"!");
            	iv1.setImage(pokemon.currentImage);
            }

        });
		
		return vbox;
	}
	
	public static Pane buildDevolutionPane(Pokemon p)
	{
		pokemon = p;
		sound music = new sound();
		music.playSound(devolutionSong);
		
		VBox vbox = new VBox();
		vbox.setPrefSize(500, 500);
		String pokemonFirstName = pokemon.currentName;
		pokemonFirstImage = pokemon.currentImage;
		Text t = new Text(pokemon.currentName + " is devolving!");
		iv1 = new ImageView(pokemon.currentImage);
		Button button = new Button("Continue");
		Text title = new Text("DEVOLUTION! I didn't know that could happen");
		vbox.getChildren().add(title);
		vbox.getChildren().add(iv1);
		vbox.getChildren().add(t);
		vbox.getChildren().add(button);
		
		//Alert alert = new Alert(AlertType.INFORMATION, "Woah, " + pokemon.currentName + " is evolving!" );
		//alert.show();
		vbox.setAlignment(Pos.CENTER);
		
		button.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
        	 * Purpose: shows the devolution when button is pressed
        	 */
            @SuppressWarnings("static-access")
			public void handle( ActionEvent event )
            {
            	pokemon.devolve();
            	t.setText(pokemonFirstName + " devolved into " + pokemon.currentName +"!");
            	iv1.setImage(pokemon.currentImage);
//            	music.stop();
//            	music.playSound("");
            	//run();
            }

        });
		
		return vbox;
	}
	
	
	private class animation extends Thread implements Runnable
	{
		
		public animation()
		{
			
		}
		
		@Override
		public void run() {
			
			for (int i = 0; i < 100; i ++)
			{
				iv1.setImage(pokemon.currentImage);
				try 
				{
					Thread.sleep(20);
					
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				iv1.setImage(pokemonFirstImage);
			}
			
		}
		
	}
	
}
