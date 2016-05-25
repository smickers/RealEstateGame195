import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Purpose:Allows user to select trainers/player number. Passes trainer info to
 * the main game Date: May 10, 2016
 * 
 * @author cst109 Hilary, cst152 Travis
 *
 */
public class TrainerSelectScreen
{
    // The list of trainers who will be in the game
    static public ArrayList<Player> UsedTrainers;
    static int count;
    static Button button;

    /**
     * Purpose: Creates and returns the Trainer Select Screen layout
     * 
     * @param stage
     * @return Pane
     */
    public static Pane displayScreen( Stage stage )
    {
        UsedTrainers = new ArrayList<Player>();

        VBox main = new VBox();
        HBox trainerImages = new HBox();

        ImageView title = new ImageView(new Image("img/cyttitle.png"));
        title.setFitWidth(900);
        title.setFitHeight(150);

        ImageView trainerOne = new ImageView(new Image("trainers/ash.png"));
        trainerOne.setFitWidth(150);
        trainerOne.setFitHeight(400);

        ImageView trainerTwo = new ImageView(new Image("trainers/gary.png"));
        trainerTwo.setFitWidth(150);
        trainerTwo.setFitHeight(400);

        ImageView trainerThree = new ImageView(new Image("trainers/may.png"));
        trainerThree.setFitWidth(150);
        trainerThree.setFitHeight(400);

        ImageView trainerFour = new ImageView(new Image("trainers/hilda.png"));
        trainerFour.setFitWidth(200);
        trainerFour.setFitHeight(450);

        trainerImages.getChildren().addAll(trainerOne, trainerTwo,
                trainerThree, trainerFour);
        main.getChildren().addAll(title, trainerImages);
        trainerImages.setAlignment(Pos.CENTER);

        button = new Button("Start!");
        button.setPrefHeight(80);
        button.setPrefWidth(200);

        trainerOne.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            /**
             * Purpose: Gives selected trainer a glow effect
             */
            @Override
            public void handle( MouseEvent me )
            {

                DropShadow ds = new DropShadow(20, Color.RED);

                if ( trainerOne.getEffect() == null )
                {
                    count++;
                    trainerOne.setEffect(ds);
                }
                else
                {
                    count--;
                    trainerOne.setEffect(null);
                }

                System.out.println(count);
                enableContinueButton();
            }
        });

        trainerTwo.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            /**
             * Purpose: Gives selected trainer a glow effect
             */
            @Override
            public void handle( MouseEvent me )
            {

                DropShadow ds = new DropShadow(25, Color.PURPLE);

                if ( trainerTwo.getEffect() == null )
                {
                    count++;
                    trainerTwo.setEffect(ds);
                }
                else
                {
                    count--;
                    trainerTwo.setEffect(null);
                }

                enableContinueButton();
            }
        });

        trainerThree.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            /**
             * Purpose: Gives selected trainer a glow effect
             */
            @Override
            public void handle( MouseEvent me )
            {

                DropShadow ds = new DropShadow(30, Color.rgb(51, 171, 149));

                if ( trainerThree.getEffect() == null )
                {
                    count++;
                    trainerThree.setEffect(ds);
                }
                else
                {
                    count--;
                    trainerThree.setEffect(null);
                }
                enableContinueButton();

            }
        });

        trainerFour.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            /**
             * Purpose: Gives selected trainer a glow effect
             */
            @Override
            public void handle( MouseEvent me )
            {

                DropShadow ds = new DropShadow(20, Color.rgb(255, 84, 167));

                if ( trainerFour.getEffect() == null )
                {
                    count++;
                    trainerFour.setEffect(ds);
                }
                else
                {
                    count--;
                    trainerFour.setEffect(null);
                }
                enableContinueButton();

            }
        });

        button.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            /**
             * Purpose: Adds selected trainer to trainers array Closes trainer
             * select window and opens game board
             */
            @Override
            public void handle( MouseEvent arg0 )
            {

                if ( trainerOne.getEffect() != null )
                {
                    Trainer Ash = new Trainer("Ash", "trainers/ash.png",
                            "images/pkoeball1.png");
                    Player ash = new Player(Ash);
                    UsedTrainers.add(ash);

                }
                if ( trainerTwo.getEffect() != null )
                {
                    Trainer Gary = new Trainer("Gary", "trainers/gary.png",
                            "images/pkoeball2.png");
                    Player gary = new Player(Gary);
                    UsedTrainers.add(gary);

                }
                if ( trainerThree.getEffect() != null )
                {
                    Trainer May = new Trainer("May", "trainers/may.png",
                            "images/pkoeball3.png");

                    Player may = new Player(May);
                    UsedTrainers.add(may);

                }
                if ( trainerFour.getEffect() != null )
                {

                    Trainer Hilda = new Trainer("Hilda", "trainers/hilda.png",
                            "images/pkoeball4.png");
                    Player hilda = new Player(Hilda);
                    UsedTrainers.add(hilda);

                }

                // This is actually being used
                GameMain gm = new GameMain(UsedTrainers);
                stage.close();
            }
        });

        main.getChildren().add(button);
        main.setAlignment(Pos.CENTER);
        button.setDisable(true);
        return main;
    }

    /**
     * Purpose: Enables and disables continue button according to number of
     * selected players
     */
    public static void enableContinueButton()
    {
        if ( count >= 2 )
        {
            button.setDisable(false);
        }
        else
        {
            button.setDisable(true);
        }
    }

    // public static void returnTrainers()
    // {
    // GameMainTest gmt = new GameMainTest();
    // gmt.setPlayers(trainers);
    // }

}