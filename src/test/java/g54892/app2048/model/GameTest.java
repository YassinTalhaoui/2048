/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests for the class Game.
 *
 * @author Talhaoui Yassin - G54892
 */
public class GameTest {

    private final Game game = new Game();

    /**
     * Test for method getBoard().
     */
    @Test
    public void testGetBoard() {
        assertFalse(this.game.getBoard().equals(new Board()));
    }

    /**
     * Test for method isWon().
     */
    @Test
    public void testIsWon() {
        assertFalse(this.game.isWon());
    }

    /**
     * Test for method isFail().
     */
    @Test
    public void testIsFail() {
        assertFalse(this.game.isFail());
    }

    /**
     * Test for method canMove().
     */
    @Test
    public void testCanMove() {
        assertTrue(new Game().canMove());
    }

    /**
     * Test for method setCanMove().
     */
    @Test
    public void testSetCanMove() {
        Game g = new Game();
        g.setCanMove(false);
        assertTrue(!g.canMove());
    }

    /**
     * Test for method moveRight().
     */
    @Test
    public void testMoveBricksEst() {
        Board board = new Board();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board.getBoard()[i][j] = new Brick(i, j, i);
            }
        }
        assertFalse(this.game.moveRight());
    }

    /**
     * Test for method moveLeft().
     */
    @Test
    public void testMoveBricksOuest() {
        Board board = new Board();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board.getBoard()[i][j] = new Brick(i, j, i);
            }
        }
        assertFalse(this.game.moveLeft());
    }

    /**
     * Test for method moveDown().
     */
    @Test
    public void testMoveBricksSud() {
        Board board = new Board();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board.getBoard()[i][j] = new Brick(i, j, i);
            }
        }
        assertFalse(this.game.moveDown());
    }

    /**
     * Test for method moveUp().
     */
    @Test
    public void testMoveBricksNord() {
        Board board = new Board();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board.getBoard()[i][j] = new Brick(i, j, i);
            }
        }
        assertFalse(this.game.moveUp());
    }

    /**
     * This that test cheks that the game is won.
     */
    @Test
    public void testGameIsWon() {
        Board board = new Board();
        board.getBoard()[1][1] = new Brick(0, 0, 2048);
        assertFalse(this.game.isWon());
    }
}
