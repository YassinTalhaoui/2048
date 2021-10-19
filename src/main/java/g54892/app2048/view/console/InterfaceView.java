/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.view.console;

import g54892.app2048.model.Board;
import g54892.app2048.model.Direction;

/**
 * Interface that regroups different methods that that each console or graphical
 * view that implements this interface has to respect.
 *
 * @author Talhaoui Yassin - G54892
 */
public interface InterfaceView {

    /**
     * Displays the title.
     */
    void displayTitle();

    /**
     * Displays the board of the bricks.
     *
     * @param board a gieven instance of Board.
     */
    void printBoard(Board board);

    /**
     * Asks for a number between 0 and 4 and returns it.
     *
     * @return the entered number.
     */
    public int askNumber();

    /**
     * Return the chosen direction among all possible directions.
     *
     * @return the chosen direction.
     */
    Direction choseDirection();

    /**
     * Displays the current score.
     *
     * @param score an Integer, the score.
     */
    void displayScore(int score);

    /**
     * Announces that the party is won.
     */
    void displayWinningMessage();

    /**
     * Announces that the party is lost.
     */
    void displayLosingMessage();

    /**
     * Displays a message to indicate that movement is not allowed.
     */
    void displayMoveNotAllowed();
}
