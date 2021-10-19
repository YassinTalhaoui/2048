/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

/**
 * Interface of the model that defines each method of the game logic and that is
 * implemented by the facade of the model.
 *
 * @author Talhaoui Yassin - G54892
 */
public interface Model {

    /**
     * Simple getter of board.
     *
     * @return board.
     */
    public Board getBoard();

    /**
     * Simple getter of won.
     *
     * @return won.
     */
    public boolean isWon();

    /**
     * Simple getter of fail.
     *
     * @return fail.
     */
    public boolean isFail();
    
    /**
     * Simple getter of canMove.
     *
     * @return canMove.
     */
    public boolean canMove();
    
    /**
     * Simple setter of canMove
     *
     * @param canMove a boolean value.
     */
    public void setCanMove(boolean canMove);

    /**
     * Moves all the bricks to the north.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    public boolean moveUp();

    /**
     * Moves all the bricks to the north.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    public boolean moveDown();

    /**
     * Moves all the bricks to the north.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    public boolean moveLeft();

    /**
     * Moves all the bricks to the north.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    public boolean moveRight();
}
