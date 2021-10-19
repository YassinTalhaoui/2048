/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.controller;

import g54892.app2048.model.Direction;
import g54892.app2048.model.Game;
import g54892.app2048.view.console.ConsoleView;
import java.util.Observable;
import java.util.Observer;

/**
 * Controller of the application, this class is responsible for the dynamics of
 * the game and the updating of sight as you go.
 *
 * @author Talhaoui Yassin - G54892
 */
public class Controller implements Observer {

    Game game = new Game();
    ConsoleView cv = new ConsoleView();

    /**
     * Constructor of Controller.
     */
    public Controller() {
        this.game.getBoard().addObserver(this);
    }

    /**
     * Starts the game and plays while the party is won or lost.
     */
    public void start() {
        this.cv.displayTitle();
        this.game.getBoard().newBrick();
        while (!this.game.isWon()) {
            this.checkDirections();
            if (!this.game.canMove()) {
                this.cv.displayMoveNotAllowed();
                this.cv.printBoard(this.game.getBoard());
            }
            if (this.game.isFail()) {
                this.cv.displayLosingMessage();
                System.exit(0);
            }
        }
        this.cv.displayWinningMessage();
    }

    /**
     * Cheks the entered direction of makes the corresponding move.
     */
    private void checkDirections() {
        Direction d = this.cv.choseDirection();
        if (null != d) {
            switch (d) {
                case EST:
                    this.game.moveRight();
                    break;
                case OUEST:
                    this.game.moveLeft();
                    break;
                case NORD:
                    this.game.moveUp();
                    break;
                case SUD:
                    this.game.moveDown();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Updates the view of the game after adding each brick (console version).
     *
     * @param o given instance of Observable.
     * @param arg an Object.
     */
    @Override
    public void update(Observable o, Object arg) {
        this.cv.printBoard(this.game.getBoard());
        this.cv.displayScore(this.game.getBoard().getScore());
    }
}
