import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Purpose: This class is used to represent the visual game board, and the
 * overlaying grid that maps the tiles.
 * 
 * @author Paz Aloni, Stephanie McCallum, Cameron Auser
 *
 */

public class GameBoard extends GridPane
{

    // High res
    // private final static int narrowBorder = 82;
    // private final static int wideBorder = 207;

    static final Image[] FACES = { new Image("./img/img1.png"),
            new Image("./img/img2.png"), new Image("./img/img3.png"),
            new Image("./img/img4.png"), new Image("./img/img5.png"),
            new Image("./img/img6.png") };

    // Low res
    private final static int NARROW_BORDER = 64;
    private final static int WIDE_BORDER = 106;
    private final static int CENTER_COL = 1;
    private final static int CENTER_ROW = 1;
    private final static int CENTER_PANE_COLSPAN = 9;
    private final static int CNETER_PANE_ROWSPAN = 9;

    private static final Color CLEAR = Color.TRANSPARENT;

    private static final Image BACKGROUND_IMAGE = new Image(
            "images/monopolyBoard.png");

    Rectangle tilesOverlay[] = new Rectangle[GameMain.NUM_OF_TILES];

    ImageView token1, token2, token3, token4;
    ImageView[] tokenArray = { token1, token2, token3, token4 };
    GameMain gm;
    Pane currentPane;

    /**
     * Constructor for a new game board
     */
    public GameBoard(ArrayList<Player> players, GameMain gm)
    {
        this.gm = gm;

        // add the background image
        this.add(new ImageView(BACKGROUND_IMAGE), 0, 0, 40, 40);

        // keeps track inside the loop of rows and columns to add in the grid
        // pane
        int col = 10;
        int row = 10;

        // generate all the square "place-holders" for the grid pane
        for ( int i = 0; i < GameMain.NUM_OF_TILES; i++ )
        {
            if ( i % 10 == 0 )
            {
                // corner tile
                tilesOverlay[i] = new Rectangle(WIDE_BORDER, WIDE_BORDER, CLEAR);
            }
            else if ( (i / 10) % 2 == 0 )
            {
                // horizontal tile
                tilesOverlay[i] = new Rectangle(NARROW_BORDER, WIDE_BORDER,
                        CLEAR);
            }
            else
            {
                // vertical tile
                tilesOverlay[i] = new Rectangle(WIDE_BORDER, NARROW_BORDER,
                        CLEAR);
            }

            // required for token alignments
            tilesOverlay[i].setStroke(CLEAR);

            // ####################
            // ## For DEMO Only! ##
            // ####################
            // for acceptance testing - display borders
            // tilesOverlay[i].setStroke(Color.RED);
            // this.add(new Text("\t"+i), col , row);

            // ### END OF DEMO ###

            // add the placeholder to the grid, based on the order of the grids
            // left column
            if ( col == 0 && row > 0 )
            {
                this.add(tilesOverlay[i], col, row);
                row--;
            }
            // bottom row
            else if ( row == 10 && col > 0 )
            {
                this.add(tilesOverlay[i], col, row);
                col--;
            }
            // right column
            else if ( col < 10 )
            {
                this.add(tilesOverlay[i], col, row);
                col++;
            }
            // top row
            else if ( row < 10 )
            {
                this.add(tilesOverlay[i], col, row);
                row++;
            }
        }

        for ( int i = 0; i < players.size(); i++ )
        {
            tokenArray[i] = (players.get(i).token);

            placeToken(tokenArray[i], 0);
        }
        // this.setGridLinesVisible(true);

        Button btnMoveToken = new Button("Roll Dice");

        btnMoveToken.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle( ActionEvent arg0 )
            {

                rollDice();
                // gm.currentPlayer++;
                //
                // if ( gm.currentPlayer == players.size() )
                // {
                // gm.currentPlayer = 0;
                // }

            }

        });

        StackPane temp = new StackPane();
        temp.setPrefHeight(50);
        temp.setPrefWidth(50);
        temp.getChildren().add(btnMoveToken);
        this.add(temp, 4, 9, 1, 1);

    }

    /**
     * Purpose: This method is used to add ImageViews of tokens to the board
     * 
     * @param token
     *            - reference to the token ImageView to place on the board
     * @param index
     *            - index of the tile to place the token on
     */
    public void placeToken( ImageView token, int index )
    {
        // add the ImageView to the tile that corresponds to the index
        this.add(token, GridPane.getColumnIndex(tilesOverlay[index]),
                GridPane.getRowIndex(tilesOverlay[index]));

        // set the token's alignment to be centered
        GridPane.setHalignment(token, HPos.CENTER);
        GridPane.setValignment(token, VPos.CENTER);

    }

    /**
     * Purpose: This method is used to move a ImageView token that is already
     * placed on the board, to a different tile on the board (based on its
     * index)
     * 
     * @param token
     *            - reference to the token ImageView to move on the board
     * @param index
     *            - index of the tile to move the token to
     */
    public void moveToken( ImageView token, int index )
    {
        // fade-out effect
        FadeTransition ft = new FadeTransition(Duration.millis(500), token);
        ft.setFromValue(1.0);
        ft.setToValue(0);

        // when the fade-out finishes
        ft.setOnFinished(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle( ActionEvent event )
            {
                // remove token from the board
                GameBoard.this.getChildren().remove(token);

                // add token in the new location
                placeToken(token, index);

                // fade-in effect
                FadeTransition ft2 = new FadeTransition(Duration.millis(500),
                        token);
                ft2.setFromValue(0);
                ft2.setToValue(1.0);
                ft2.play();
            }

        });

        // start the fade effect
        ft.play();
    }

    // ### FOR TESTING PURPOSES ONLY ###
    // add click listeners to move a single token on the board
    private void testMovementByClicks( ImageView token )
    {
        for ( int i = 0; i < tilesOverlay.length; i++ )
        {
            DropShadow ds = new DropShadow(50, Color.rgb(255, 0, 0));
            token.setEffect(ds);

            int loc = i;
            tilesOverlay[i].setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle( MouseEvent arg0 )
                {
                    moveToken(token, loc);
                }
            });
        }
        token.setEffect(null);
    }

    public void displayPane( Pane pane, int col, int row, int colspan,
            int rowspan )
    {
        currentPane = pane;
        pane.setPrefSize(586, 586);
        this.add(pane, col + CENTER_COL, row + CENTER_ROW, colspan, rowspan);

    }

    public void removeCurrentPane()
    {
        if ( currentPane != null )
        {
            this.getChildren().remove(currentPane);
        }
    }

    /**
     * Purpose: rolls dice, returns values to GameMain
     */
    public boolean rollDice()
    {

        // Create first die, set face
        DieView die1 = new DieView();
        // Create second die, set face
        DieView die2 = new DieView();
        // Update GUI
        HBox hb = new HBox();

        hb.getChildren().add(die1);
        hb.getChildren().add(die2);

        displayPane(hb, 0, 8, 2, 1);

        Thread t = new Thread(new Spinners(10, die1, die2));
        t.start();

        return true;

    }

    // TODO make a separate class.
    /**
     * Purpose:
     * 
     * @author Hilary Fehr, Nathan MacNeil
     *
     */
    private class Spinners extends Thread
    {

        int time;
        DieView die1;
        DieView die2;

        public Spinners(int time, DieView die1, DieView die2)
        {
            this.time = time;
            this.die1 = die1;
            this.die2 = die2;
        }

        @Override
        public void run()
        {

            for ( int i = 0; i < time; i++ )
            {
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        // Set the image of both dice to be randomly
                        // selected images.
                        die1.setFace((int) Math.floor(Math.random()
                                * DieView.MAX_SIDES_TO_DICE));
                        die2.setFace((int) Math.floor(Math.random()
                                * DieView.MAX_SIDES_TO_DICE));
                    }
                });
                try
                {

                    Thread.sleep(130);
                }
                catch ( InterruptedException e )
                {
                    currentThread().interrupt();
                }

            }

            // }

            // Create a new turn outcome.
            TurnOutcome outcome = gm.getTurnOutcome();

            // Set the faces of the die to the results returned.
            die1.setFace(outcome.getDieOne() - 1);
            die2.setFace(outcome.getDieTwo() - 1);

            moveToken(gm.players.get(gm.currentPlayer).token,
                  gm.players.get(gm.currentPlayer).currentLocation);
                    
            Platform.runLater(new Runnable()
            {
                public void run()
                {
                    GameBoard.this.displayPane(
                            new DemoTileView(gm.players.get(gm.currentPlayer),
                                    outcome.getDieOne() + outcome.getDieTwo()),
                            0, 0, 9, 8);

                    gm.currentPlayer++;
                    if ( gm.currentPlayer == gm.players.size() )
                    {
                        gm.currentPlayer = 0;
                    }
                }
            });

        }
    }
}
