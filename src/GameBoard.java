import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GameBoard  {

	
	//Center
		static ImageView ivCenter = new ImageView();
		static Pane paneFace = new Pane();
		//End center
		
		
		//bottom side
		static ImageView  ivGo		= new ImageView();
		static ImageView  ivBrown1 = new ImageView();
		static ImageView  ivPoke1	= new ImageView();
		static ImageView  ivBrown2 = new ImageView();
		static ImageView  ivTax1 	= new ImageView();
		static ImageView  ivTrainer1 = new ImageView();
		static ImageView  ivAqua1 	= new ImageView();
		static ImageView  ivPoke2 = new ImageView();
		static ImageView  ivAqua2 	= new ImageView();
		static ImageView  ivAqua3 	= new ImageView();
		static ImageView  ivTower = new ImageView();
		//end of bottom side
		
		//left side
		static ImageView ivOrange3 = new ImageView();
		static ImageView ivOrange2 = new ImageView();
		static ImageView ivPoke3 = new ImageView();
		static ImageView ivOrange1 = new ImageView();
		static ImageView ivTrainer2 = new ImageView();
		static ImageView ivPink3 = new ImageView();
		static ImageView ivPink2 = new ImageView();
		static ImageView ivUtil1 = new ImageView();
		static ImageView ivPink1 = new ImageView();
		//end of left
		//top side
		static ImageView ivGoToTower = new ImageView();
		static ImageView ivYellow3 = new ImageView();
		static ImageView ivUtil2 = new ImageView();
		static ImageView ivYellow2 = new ImageView();
		static ImageView ivYellow1 = new ImageView();
		static ImageView ivTrainer3 = new ImageView();
		static ImageView ivRed3 = new ImageView();
		static ImageView ivRed2 = new ImageView();
		static ImageView ivPoke4 = new ImageView();
		static ImageView ivRed1 = new ImageView();
		static ImageView ivCerulean = new ImageView();
		//End of top side
		
		//Right side
		static ImageView ivBlue2 = new ImageView();
		static ImageView ivTax2 = new ImageView();
		static ImageView ivBlue1 = new ImageView();
		static ImageView ivPoke6 = new ImageView();
		static ImageView ivTrainer4 = new ImageView();
		static ImageView ivGreen3 = new ImageView();
		static ImageView ivPoke5 = new ImageView();
		static ImageView ivGreen2 = new ImageView();
		static ImageView ivGreen1 = new ImageView();
		//End of right side
		
		
		
		@SuppressWarnings("static-access")
		public static Pane displayScreen()  {
			
			StackPane p = new StackPane();
		
			AnchorPane ap = new AnchorPane();
			
			Image iCenter = new Image("images/center.jpg");
			ivCenter.setImage(iCenter);
			ivCenter.setFitHeight(300);
			ivCenter.setFitWidth(300);
			
			//p.getChildren().add(ivCenter);
			ap.getChildren().add(ivCenter);
			ap.setLeftAnchor(ivCenter, 200.0);
			ap.setTopAnchor(ivCenter, 200.0);
			
			p.getChildren().add(ap);
			ap.setPrefSize(700, 700);
			HBox bottom = new HBox();
			HBox top = new HBox();
			VBox right = new VBox();
			VBox left = new VBox();
			
			
			
			Image i1 = new Image("images/pikachu.png");
			Image iGo = new Image("images/go.png");
			Image iTax = new Image("images/tax.png");
			Image iPoke = new Image("images/pokeCard.jpg");
			Image iTower = new Image("images/tower.png");
			Image iTrainer = new Image("images/trainer.png");
			
			
			
		
			/**
			 * BOTTOM ROW
			 */
		
			ivGo.setImage(iGo);
			ivGo.setFitHeight(80);
			ivGo.setFitWidth(80);
			
			ivBrown1.setImage(i1);
			ivBrown1.setFitHeight(80);
			ivBrown1.setFitWidth(60);
			
			ivPoke1.setImage(iPoke);
			ivPoke1.setFitHeight(80);
			ivPoke1.setFitWidth(60);
			
			ivBrown2.setImage(i1);
			ivBrown2.setFitHeight(80);
			ivBrown2.setFitWidth(60);

			ivTax1.setImage(iTax);
			ivTax1.setFitHeight(80);
			ivTax1.setFitWidth(60);
			
			ivTrainer1.setImage(iTrainer);
			ivTrainer1.setFitWidth(60);
			ivTrainer1.setFitHeight(80);
			ivAqua1.setImage(i1);
			ivAqua1.setFitHeight(80);
			ivAqua1.setFitWidth(60);
			
			ivPoke2.setImage(iPoke);
			ivPoke2.setFitHeight(80);
			ivPoke2.setFitWidth(60);
			
			ivAqua2.setImage(i1);
			ivAqua2.setFitHeight(80);
			ivAqua2.setFitWidth(60);
			
			ivAqua3.setImage(i1);
			ivAqua3.setFitHeight(80);
			ivAqua3.setFitWidth(60);
			
			ivTower.setImage(iTower);
			ivTower.setFitHeight(80);
			ivTower.setFitWidth(80);
			/**
			 * End of Bottom side
			 */
			
			
			
			/**
			 * Left side
			 */
			
			
			
			ivOrange3.setRotate(90);
			ivOrange2.setRotate(90);
			ivPoke3.setRotate(90);
			ivOrange1.setRotate(90);
			ivTrainer2.setRotate(90);
			ivPink3.setRotate(90);
			ivPink2.setRotate(90);
			ivUtil1.setRotate(90);
			ivPink1.setRotate(90);
			
			
			//left.setSpacing(10);
		
			
		
			Image iOrange3 = new Image("images/Pikachu.png");
			Image iOrange2 = new Image("images/Pikachu.png");
			Image iPoke3 = new Image("images/Poke.png");
			Image iOrange1 = new Image("images/Pikachu.png");
			Image iTrainer2 = new Image("images/Trainer.png");
			Image iPink3 = new Image("images/Pikachu.png");
			Image iPink2 = new Image("images/Pikachu.png");
			Image iUtil1 = new Image("images/Util.png");
			Image iPink1 = new Image("images/Pikachu.png");

			
		

			ivOrange3.setImage(iOrange3);
			ivOrange3.setFitHeight(61);
			ivOrange3.setFitWidth(80);

			ivOrange2.setImage(iOrange2);
			ivOrange2.setFitHeight(61);
			ivOrange2.setFitWidth(80);

			ivPoke3.setImage(iPoke3);
			ivPoke3.setFitHeight(61);
			ivPoke3.setFitWidth(80);

			ivOrange1.setImage(iOrange1);
			ivOrange1.setFitHeight(61);
			ivOrange1.setFitWidth(80);

			ivTrainer2.setImage(iTrainer2);
			ivTrainer2.setFitHeight(61);
			ivTrainer2.setFitWidth(80);

			ivPink3.setImage(iPink3);
			ivPink3.setFitHeight(61);
			ivPink3.setFitWidth(80);

			ivPink2.setImage(iPink2);
			ivPink2.setFitHeight(61);
			ivPink2.setFitWidth(80);

			ivUtil1.setImage(iUtil1);
			ivUtil1.setFitHeight(61);
			ivUtil1.setFitWidth(80);

			ivPink1.setImage(iPink1);
			ivPink1.setFitHeight(61);
			ivPink1.setFitWidth(80);

		
			/**
			 * TOP ROW
			 */


			
			Image igoToTower = new Image("images/goToTower.png");
			Image iYellow3 = new Image("images/Pikachu.png");
			Image iUtil2 = new Image("images/Util.png");
			Image iYellow2 = new Image("images/Pikachu.png");
			Image iYellow1 = new Image("images/Pikachu.png");
			Image iTrainer3 = new Image("images/Trainer.png");
			Image iRed3 = new Image("images/Pikachu.png");
			Image iRed2 = new Image("images/Pikachu.png");
			Image iPoke4 = new Image("images/Poke.png");
			Image iRed1 = new Image("images/Pikachu.png");
			Image iCerulean = new Image("images/Cerulean.png");
			
			ivGoToTower.setImage(igoToTower);
			ivGoToTower.setFitHeight(80);
			ivGoToTower.setFitWidth(80);

			ivYellow3.setImage(iYellow3);
			ivYellow3.setFitHeight(80);
			ivYellow3.setFitWidth(60);

			ivUtil2.setImage(iUtil2);
			ivUtil2.setFitHeight(80);
			ivUtil2.setFitWidth(60);

			ivYellow2.setImage(iYellow2);
			ivYellow2.setFitHeight(80);
			ivYellow2.setFitWidth(60);

			ivYellow1.setImage(iYellow1);
			ivYellow1.setFitHeight(80);
			ivYellow1.setFitWidth(60);

			ivTrainer3.setImage(iTrainer3);
			ivTrainer3.setFitHeight(80);
			ivTrainer3.setFitWidth(60);

			ivRed3.setImage(iRed3);
			ivRed3.setFitHeight(80);
			ivRed3.setFitWidth(60);

			ivRed2.setImage(iRed2);
			ivRed2.setFitHeight(80);
			ivRed2.setFitWidth(60);

			ivPoke4.setImage(iPoke4);
			ivPoke4.setFitHeight(80);
			ivPoke4.setFitWidth(60);

			ivRed1.setImage(iRed1);
			ivRed1.setFitHeight(80);
			ivRed1.setFitWidth(60);

			ivCerulean.setImage(iCerulean);
			ivCerulean.setFitHeight(80);
			ivCerulean.setFitWidth(80);

			
			ivGoToTower.setRotate(180);
			ivYellow3.setRotate(180);
			ivUtil2.setRotate(180);
			ivYellow2.setRotate(180);
			ivYellow1.setRotate(180);
			ivTrainer3.setRotate(180);
			ivRed3.setRotate(180);
			ivRed2.setRotate(180);
			ivPoke4.setRotate(180);
			ivRed1.setRotate(180);
			ivCerulean.setRotate(180);

			/**
			 * END OF TOP ROW
			 */

			
			/**
			 * RIGHT ROW
			 */
			
		
			
			Image iBlue2 = new Image("images/Pikachu.png");
			Image iTax2 = new Image("images/Tax.png");
			Image iBlue1 = new Image("images/Pikachu.png");
			Image iPoke6 = new Image("images/Poke.png");
			Image iTrainer4 = new Image("images/Trainer.png");
			Image iGreen3 = new Image("images/Pikachu.png");
			Image iPoke5 = new Image("images/Poke.png");
			Image iGreen2 = new Image("images/Pikachu.png");
			Image iGreen1 = new Image("images/Pikachu.png");
			
			ivBlue2.setImage(iBlue2);
			ivBlue2.setFitHeight(60);
			ivBlue2.setFitWidth(80);

			ivTax2.setImage(iTax2);
			ivTax2.setFitHeight(60);
			ivTax2.setFitWidth(80);

			ivBlue1.setImage(iBlue1);
			ivBlue1.setFitHeight(60);
			ivBlue1.setFitWidth(80);

			ivPoke6.setImage(iPoke6);
			ivPoke6.setFitHeight(60);
			ivPoke6.setFitWidth(80);

			ivTrainer4.setImage(iTrainer4);
			ivTrainer4.setFitHeight(60);
			ivTrainer4.setFitWidth(80);

			ivGreen3.setImage(iGreen3);
			ivGreen3.setFitHeight(60);
			ivGreen3.setFitWidth(80);

			ivPoke5.setImage(iPoke5);
			ivPoke5.setFitHeight(60);
			ivPoke5.setFitWidth(80);

			ivGreen2.setImage(iGreen2);
			ivGreen2.setFitHeight(60);
			ivGreen2.setFitWidth(80);

			ivGreen1.setImage(iGreen1);
			ivGreen1.setFitHeight(60);
			ivGreen1.setFitWidth(80);

			
			ivBlue2.setRotate(270);
			ivTax2.setRotate(270);
			ivBlue1.setRotate(270);
			ivPoke6.setRotate(270);
			ivTrainer4.setRotate(270);
			ivGreen3.setRotate(270);
			ivPoke5.setRotate(270);
			ivGreen2.setRotate(270);
			ivGreen1.setRotate(270);

			
			/**
			 * END OF RIGHT ROW
			 */
			//bottom.getChildren().addAll(ivGo,ivBrown1,ivPoke1,ivBrown2,ivTax1,ivTrainer1,ivAqua1,ivPoke2,ivAqua2,ivAqua3,ivTower);
			bottom.getChildren().addAll(ivTower,ivAqua3,ivAqua2,ivPoke2,ivAqua1,ivTrainer1,ivTax1,ivBrown2,ivPoke1,ivBrown1,ivGo);
			left.getChildren().addAll(ivOrange3,ivOrange2,ivPoke3,ivOrange1,ivTrainer2,ivPink3,ivPink2,ivUtil1,ivPink1);
			top.getChildren().addAll(ivCerulean,ivRed1,ivPoke4,ivRed2,ivRed3,ivTrainer3,ivYellow1,ivYellow2,ivUtil2,ivYellow3,ivGoToTower);
			right.getChildren().addAll(ivBlue2,ivTax2,ivBlue1,ivPoke6,ivTrainer4,ivGreen3,ivPoke5,ivGreen2,ivGreen1);
			
			ap.getChildren().addAll(top,bottom,left,right);
			ap.setTopAnchor(top,0.0);
			
			ap.setBottomAnchor(bottom, 0.0);
			
			ap.setLeftAnchor(right, 620.0);
			ap.setTopAnchor(right, 80.0);
			
			ap.setLeftAnchor(left, 0.0);
			ap.setTopAnchor(left, 80.0);
			
			
	
			
			
			
			/**
			 * Setting the trainers you want to use
			 */
			ivBrown1.setOnMouseClicked(new EventHandler <MouseEvent>()
					{

						@Override
						public void handle(MouseEvent me) {	
							DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
							
							System.out.println(ivBrown1.getEffect());
							if (ivBrown1.getEffect() == null)
							{
							ivBrown1.setEffect(ds);
							}
							else
							{
								ivBrown1.setEffect(null);
							}
						}
					
					}
					);
			
			handlers();
			paneFace.getChildren().add(p);
			return paneFace;
		}
		

		public static void main(String[] args)
		{
			Application.launch(args);
		}
		
		public static void handlers()
		{
			
			//Start of bottom side handlers
			ivGo.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivGo.getEffect() == null)
									{
									ivGo.setEffect(ds);
									}
									else
									{
										ivGo.setEffect(null);
									}
								}
							}
							);
			ivBrown1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivBrown1.getEffect() == null)
									{
									ivBrown1.setEffect(ds);
									}
									else
									{
										ivBrown1.setEffect(null);
									}
								}
							}
							);
			ivPoke1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPoke1.getEffect() == null)
									{
									ivPoke1.setEffect(ds);
									}
									else
									{
										ivPoke1.setEffect(null);
									}
								}
							}
							);
			ivBrown2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivBrown2.getEffect() == null)
									{
									ivBrown2.setEffect(ds);
									}
									else
									{
										ivBrown2.setEffect(null);
									}
								}
							}
							);
			ivTax1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivTax1.getEffect() == null)
									{
									ivTax1.setEffect(ds);
									}
									else
									{
										ivTax1.setEffect(null);
									}
								}
							}
							);
			ivTrainer1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivTrainer1.getEffect() == null)
									{
									ivTrainer1.setEffect(ds);
									}
									else
									{
										ivTrainer1.setEffect(null);
									}
								}
							}
							);
			ivAqua1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivAqua1.getEffect() == null)
									{
									ivAqua1.setEffect(ds);
									}
									else
									{
										ivAqua1.setEffect(null);
									}
								}
							}
							);
			ivPoke2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPoke2.getEffect() == null)
									{
									ivPoke2.setEffect(ds);
									}
									else
									{
										ivPoke2.setEffect(null);
									}
								}
							}
							);
			ivAqua2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivAqua2.getEffect() == null)
									{
									ivAqua2.setEffect(ds);
									}
									else
									{
										ivAqua2.setEffect(null);
									}
								}
							}
							);
			ivAqua3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivAqua3.getEffect() == null)
									{
									ivAqua3.setEffect(ds);
									}
									else
									{
										ivAqua3.setEffect(null);
									}
								}
							}
							);

			
			//End of bottom side handlers
			
			//Start of left side handlers
			ivOrange3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivOrange3.getEffect() == null)
									{
									ivOrange3.setEffect(ds);
									}
									else
									{
										ivOrange3.setEffect(null);
									}
								}
							}
							);
			ivOrange2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivOrange2.getEffect() == null)
									{
									ivOrange2.setEffect(ds);
									}
									else
									{
										ivOrange2.setEffect(null);
									}
								}
							}
							);
			ivPoke3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPoke3.getEffect() == null)
									{
									ivPoke3.setEffect(ds);
									}
									else
									{
										ivPoke3.setEffect(null);
									}
								}
							}
							);
			ivOrange1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivOrange1.getEffect() == null)
									{
									ivOrange1.setEffect(ds);
									}
									else
									{
										ivOrange1.setEffect(null);
									}
								}
							}
							);
			ivTrainer2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivTrainer2.getEffect() == null)
									{
									ivTrainer2.setEffect(ds);
									}
									else
									{
										ivTrainer2.setEffect(null);
									}
								}
							}
							);
			ivPink3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPink3.getEffect() == null)
									{
									ivPink3.setEffect(ds);
									}
									else
									{
										ivPink3.setEffect(null);
									}
								}
							}
							);
			ivPink2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPink2.getEffect() == null)
									{
									ivPink2.setEffect(ds);
									}
									else
									{
										ivPink2.setEffect(null);
									}
								}
							}
							);
			ivUtil1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivUtil1.getEffect() == null)
									{
									ivUtil1.setEffect(ds);
									}
									else
									{
										ivUtil1.setEffect(null);
									}
								}
							}
							);
			ivPink1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPink1.getEffect() == null)
									{
									ivPink1.setEffect(ds);
									}
									else
									{
										ivPink1.setEffect(null);
									}
								}
							}
							);

			
			//End of left side handlers
			
			
			//Start of TopSide Handlers
			ivGoToTower.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivGoToTower.getEffect() == null)
									{
									ivGoToTower.setEffect(ds);
									}
									else
									{
										ivGoToTower.setEffect(null);
									}
								}
							}
							);
			ivYellow3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivYellow3.getEffect() == null)
									{
									ivYellow3.setEffect(ds);
									}
									else
									{
										ivYellow3.setEffect(null);
									}
								}
							}
							);
			ivUtil2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivUtil2.getEffect() == null)
									{
									ivUtil2.setEffect(ds);
									}
									else
									{
										ivUtil2.setEffect(null);
									}
								}
							}
							);
			ivYellow2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivYellow2.getEffect() == null)
									{
									ivYellow2.setEffect(ds);
									}
									else
									{
										ivYellow2.setEffect(null);
									}
								}
							}
							);
			ivYellow1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivYellow1.getEffect() == null)
									{
									ivYellow1.setEffect(ds);
									}
									else
									{
										ivYellow1.setEffect(null);
									}
								}
							}
							);
			ivTrainer3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivTrainer3.getEffect() == null)
									{
									ivTrainer3.setEffect(ds);
									}
									else
									{
										ivTrainer3.setEffect(null);
									}
								}
							}
							);
			ivRed3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivRed3.getEffect() == null)
									{
									ivRed3.setEffect(ds);
									}
									else
									{
										ivRed3.setEffect(null);
									}
								}
							}
							);
			ivRed2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivRed2.getEffect() == null)
									{
									ivRed2.setEffect(ds);
									}
									else
									{
										ivRed2.setEffect(null);
									}
								}
							}
							);
			ivPoke4.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPoke4.getEffect() == null)
									{
									ivPoke4.setEffect(ds);
									}
									else
									{
										ivPoke4.setEffect(null);
									}
								}
							}
							);
			ivRed1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivRed1.getEffect() == null)
									{
									ivRed1.setEffect(ds);
									}
									else
									{
										ivRed1.setEffect(null);
									}
								}
							}
							);
			ivCerulean.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivCerulean.getEffect() == null)
									{
									ivCerulean.setEffect(ds);
									}
									else
									{
										ivCerulean.setEffect(null);
									}
								}
							}
							);

			
			//End of Top Side Handlers
			
			
			//Start of Right Side Handlers
			ivBlue2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivBlue2.getEffect() == null)
									{
									ivBlue2.setEffect(ds);
									}
									else
									{
										ivBlue2.setEffect(null);
									}
								}
							}
							);
			ivTax2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivTax2.getEffect() == null)
									{
									ivTax2.setEffect(ds);
									}
									else
									{
										ivTax2.setEffect(null);
									}
								}
							}
							);
			ivBlue1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivBlue1.getEffect() == null)
									{
									ivBlue1.setEffect(ds);
									}
									else
									{
										ivBlue1.setEffect(null);
									}
								}
							}
							);
			ivPoke6.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPoke6.getEffect() == null)
									{
									ivPoke6.setEffect(ds);
									}
									else
									{
										ivPoke6.setEffect(null);
									}
								}
							}
							);
			ivTrainer4.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivTrainer4.getEffect() == null)
									{
									ivTrainer4.setEffect(ds);
									}
									else
									{
										ivTrainer4.setEffect(null);
									}
								}
							}
							);
			ivGreen3.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivGreen3.getEffect() == null)
									{
									ivGreen3.setEffect(ds);
									}
									else
									{
										ivGreen3.setEffect(null);
									}
								}
							}
							);
			ivPoke5.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivPoke5.getEffect() == null)
									{
									ivPoke5.setEffect(ds);
									}
									else
									{
										ivPoke5.setEffect(null);
									}
								}
							}
							);
			ivGreen2.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivGreen2.getEffect() == null)
									{
									ivGreen2.setEffect(ds);
									}
									else
									{
										ivGreen2.setEffect(null);
									}
								}
							}
							);
			ivGreen1.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivGreen1.getEffect() == null)
									{
									ivGreen1.setEffect(ds);
									}
									else
									{
										ivGreen1.setEffect(null);
									}
								}
							}
							);

			
			//End of Right Side Handlers
			
			
			//Center
			
			ivCenter.setOnMouseClicked(new EventHandler <MouseEvent>()
			{
								@Override
								public void handle(MouseEvent me) {
									DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
									System.out.println(ivBrown1.getEffect());
									if (ivCenter.getEffect() == null)
									{
										
									ivCenter.setEffect(ds);

									}
									else
									{
										ivCenter.setEffect(null);
									}
								}
							}
							);

		}
	}

