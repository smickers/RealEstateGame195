import java.util.ArrayList;


public class GameMainTest {
	
	
	public static ArrayList<Player> players;

	public static void main(String[] args) {

		players = new ArrayList<Player>();
		Trainer Ash = new Trainer("Ash","images/ash.png","images/ash.png");
		Trainer Gary = new Trainer("Gary", "images/gary.png", "images/gary.png");
		
		Player bill = new Player(Ash);
		Player tom = new Player(Gary);
		
		

		players.add(bill);
		players.add(tom);
		GameMain gm = new GameMain(players);
		gm.play();
		
	}

//	public void setPlayers(ArrayList p)
//	{
//		for(int i = 0; i < p.size(); i++){
//		
//		}
//	}
}
