/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

/**
 * Direction indicates in which direction the bricks are going to move.
 *
 * @author Talhaoui Yassin - G54892
 */
public enum Direction {
    NORD(-1, 0), SUD(1, 0), EST(0, 1), OUEST(0, -1);

    private final int deltaX;
    private final int deltaY;

    /**
     * Constructor for Direction.
     *
     * @param deltaX horizontal move (Integer).
     * @param deltaY vertical move (Integer).
     */
    private Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    /**
     * Simple getter of deltaX.
     *
     * @return an integer that represents moving east or west.
     */
    public int getDeltaX() {
        return this.deltaX;
    }

    /**
     * Simple getter of deltaY.
     *
     * @return an integer that represents moving north or south.
     */
    public int getDeltaY() {
        return this.deltaY;
    }
}
