/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import static g54892.app2048.model.Board.COL;
import static g54892.app2048.model.Board.ROW;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the class Board.
 *
 * @author Talhaoui Yassin - G54892
 */
public class BoardTest {

    private final Board board = new Board();

    /**
     * Test of method getBoard().
     */
    @Test
    public void testGetBoard() {
        Brick[][] test = new Brick[ROW][ROW];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                test[i][j] = null;
            }
        }
        assertEquals(Arrays.deepToString(test),
                Arrays.deepToString(this.board.getBoard()));
    }

    /**
     * Test of method getScore().
     */
    @Test
    public void testGetScore() {
        assertEquals(0, this.board.getScore());
    }

    /**
     * Test of method setScore().
     */
    @Test
    public void testSetScore() {
        Board b = new Board();
        b.setScore(10);
        assertFalse(b.equals(this.board));
    }

    /**
     * Test of method emptyBricks().
     */
    @Test
    public void testEmptyBricks() {
        Board test = new Board();
        test.newBrick();
        assertEquals(test.emptyBricks().size(), 15);
    }

    /**
     * Test of method newBrick().
     */
    @Test
    public void testNewBrick() {
        Board test = new Board();
        test.newBrick();
        assertEquals(15, test.emptyBricks().size());
    }
}
