/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.controller;

import g54892.app2048.main.FxMain;
import g54892.app2048.model.Game;
import g54892.app2048.view.fx.FxGame;
import g54892.app2048.view.fx.MainGrid;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Controller for the FX UI version of the application.
 *
 * @author Talhaoui Yassin - G54892
 */
public class FxController implements Observer {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 400;

    Game game = new Game();
    FxGame fxg = new FxGame();
    Canvas canva = new Canvas(WIDTH, HEIGHT);
    GraphicsContext gc = canva.getGraphicsContext2D();
    MainGrid grid = new MainGrid(canva);

    /**
     * Constructor of FxController.
     */
    public FxController() {
        game.getBoard().addObserver(this);
    }

    /**
     * Simple getter of canva.
     *
     * @return canva.
     */
    public Canvas getCanva() {
        return canva;
    }

    /**
     * Simple getter of grid.
     *
     * @return grid.
     */
    public MainGrid getGrid() {
        return grid;
    }

    /**
     * Initialises the game and controls every updates.
     *
     * @param stage a given instance of Stage.
     * @param myScene a given instance of Scene.
     */
    public void control(Stage stage, Scene myScene) {
        game.getBoard().newBrick();
        myScene.setOnKeyPressed((KeyEvent event) -> {
            enterPressed(event, stage, game);
            checkArrows(event, game);
        });
    }

    /**
     * Cheks the pressed arrow on the keyBoard and makes the corresponding move.
     *
     * @param event a given keyEvent corresponding to the press of a key.
     * @param game a given instance of Game.
     */
    private void checkArrows(KeyEvent event, Game game) {
        if (!game.isWon() && !game.isFail()) {
            switch (event.getCode()) {
                case LEFT:
                    game.moveLeft();
                    break;
                case RIGHT:
                    game.moveRight();
                    break;
                case DOWN:
                    game.moveDown();
                    break;
                case UP:
                    game.moveUp();
                    break;
            }
        }
    }

    /**
     * Cheks that the enter key has been pressed and restarts the game if this
     * is the case.
     *
     * @param event event a given keyEvent corresponding to the press of a key.
     * @param stage a given instance of Stage.
     * @param game a given instance of Game.
     */
    private void enterPressed(KeyEvent event, Stage stage, Game game) {
        if (event.getCode() == KeyCode.ENTER && (game.isFail() || game.isWon())) {
            try {
                new FxMain().start(stage);
            } catch (Exception ex) {
                Logger.getLogger(FxGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Starts a new animation timer and draws the new state of the board while
     * the game is not won or lost.
     *
     * @param grid a given instance of MainGrid.
     */
    private void animationUpdater() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                fxg.drawGamingBoard(game, gc, grid.getList());
            }
        }.start();
    }

    /**
     * Updates the view of the game after adding each brick (graphic version).
     *
     * @param o given instance of Observable.
     * @param arg an Object.
     */
    @Override
    public void update(Observable o, Object arg) {
        animationUpdater();
    }
}
