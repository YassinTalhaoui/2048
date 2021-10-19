/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * This class represents the gaming board of the application, composed by
 * bricks.
 *
 * @author Talhaoui Yassin - G54892
 */
public class Board extends Observable {

    public static final int ROW = 4;
    public static final int COL = 4;
    private final Brick[][] board;
    private int score;

    /**
     * Constructor of Brick.
     */
    public Board() {
        this.board = new Brick[ROW][COL];
    }

    /**
     * Simple getter of board.
     *
     * @return board 2D array of bricks.
     */
    public Brick[][] getBoard() {
        return this.board;
    }

    /**
     * Simple gettre of score.
     *
     * @return the score, an Integer.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Simple setter of score
     *
     * @param score an Integer.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Genarate a new brick at a random position in the board. In 90% of case
     * the value of the new brick is 2, otherwise it's 4.
     */
    public void newBrick() {
        Random random = new Random();
        boolean notValid = true;
        while (notValid) {
            int row = random.nextInt(ROW);
            int col = random.nextInt(COL);
            Brick current = this.board[row][col];
            if (Brick.isEmpty(current)) {
                Brick brick = new Brick(row, col, random.nextInt(10) < 9 ? 2 : 4);
                this.board[row][col] = brick;
                notValid = false;
            }
        }
        super.setChanged();
        super.notifyObservers();
    }

    /**
     * Collect all empty bricks and add them to the list.
     *
     * @return the list of all the empty bricks.
     */
    public List<Brick> emptyBricks() {
        List<Brick> empty = new ArrayList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (Brick.isEmpty(getBoard()[i][j])) {
                    empty.add(getBoard()[i][j]);
                }
            }
        }
        return empty;
    }
}
