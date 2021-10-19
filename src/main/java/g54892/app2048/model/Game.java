/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import static g54892.app2048.model.Board.COL;
import static g54892.app2048.model.Board.ROW;

/**
 * Gathers the elements necessary for the game to present a facade to the view.
 *
 * @author Talhaoui Yassin - G54892
 */
public class Game implements Model {

    private final Board board = new Board();
    private boolean won;
    private boolean fail;
    private boolean canMove;

    /**
     * Constructor of Game.
     */
    public Game() {
        this.won = false;
        this.fail = false;
        this.canMove = true;
    }

    /**
     * Simple getter of board.
     *
     * @return board.
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * Simple getter of won.
     *
     * @return won.
     */
    @Override
    public boolean isWon() {
        return this.won;
    }

    /**
     * Simple getter of fail.
     *
     * @return fail.
     */
    @Override
    public boolean isFail() {
        return this.fail;
    }

    /**
     * Simple getter of canMove.
     *
     * @return canMove.
     */
    @Override
    public boolean canMove() {
        return this.canMove;
    }

    /**
     * Simple setter of canMove
     *
     * @param canMove a boolean value.
     */
    @Override
    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    /**
     * Moves all the bricks to the north.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    @Override
    public boolean moveUp() {
        return this.move(Direction.NORD, 0);
    }

    /**
     * Moves all the bricks to the south.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    @Override
    public boolean moveDown() {
        return this.move(Direction.SUD, ROW * COL - 1);
    }

    /**
     * Moves all the bricks to the west.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    @Override
    public boolean moveLeft() {
        return this.move(Direction.OUEST, 0);
    }

    /**
     * Moves all the bricks to the east.
     *
     * @return true if the move is possible and moves, false otherwise.
     */
    @Override
    public boolean moveRight() {
        return this.move(Direction.EST, ROW * COL - 1);
    }

    /**
     * Cheks that each brick can move and moves it.
     *
     * @param d a given direction to move the bricks to.
     * @param countDownFrom an Integer, that is the size of the board - 1 in
     * case of a right or a down move. In the case of a left or up move it's
     * value begins at 0.
     * @return true if the bricks can moves them, false otherwise.
     */
    private boolean move(Direction d, int countDownFrom) {
        this.canMove = false;
        for (int i = 0; i < ROW * COL; i++) {
            int j = Math.abs(countDownFrom - i);
            int r = j / ROW;
            int c = j % COL;
            if (Brick.isEmpty(this.board.getBoard()[r][c])) {
                continue;
            }
            int nextR = r + d.getDeltaX();
            int nextC = c + d.getDeltaY();
            while (nextR >= 0 && nextR < ROW && nextC >= 0 && nextC < COL) {
                Brick next = this.board.getBoard()[nextR][nextC];
                Brick current = this.board.getBoard()[r][c];
                if (Brick.isEmpty(next)) {
                    this.board.getBoard()[nextR][nextC] = current;
                    this.board.getBoard()[r][c] = null;
                    r = nextR;
                    c = nextC;
                    nextR += d.getDeltaX();
                    nextC += d.getDeltaY();
                    this.canMove = true;
                } else if (next.canMergeWith(current)) {
                    this.board.getBoard()[nextR][nextC].setValue(this.board
                            .getBoard()[nextR][nextC].getValue() * 2);
                    this.board.setScore(addToScore(this.board
                            .getBoard()[nextR][nextC].getValue()));
                    this.board.getBoard()[r][c] = null;
                    this.canMove = true;
                    break;
                } else {
                    break;
                }
            }
        }
        if (this.canMove) {
            this.board.newBrick();
            this.checkWin();
            this.checkFail();
        }
        return this.canMove;
    }

    /**
     * check if there are other bricks around the stream and if they have the
     * same value.
     *
     * @param row in the board (Integer).
     * @param col in the board (Integer).
     * @param current a given brick to check
     * @return true if there is a possibility to fuse the bricks together, false
     * otherwise.
     */
    private boolean checkAround(int row, int col, Brick current) {
        if (row > 0) {
            Brick check = this.board.getBoard()[row - 1][col];
            if (Brick.isEmpty(check)) {
                return true;
            }
            if (current.equals(check)) {
                return true;
            }
        }
        if (row < ROW - 1) {
            Brick check = this.board.getBoard()[row + 1][col];
            if (Brick.isEmpty(check)) {
                return true;
            }
            if (current.equals(check)) {
                return true;
            }
        }
        if (col > 0) {
            Brick check = this.board.getBoard()[row][col - 1];
            if (Brick.isEmpty(check)) {
                return true;
            }
            if (current.equals(check)) {
                return true;
            }
        }
        if (col < COL - 1) {
            Brick check = this.board.getBoard()[row][col + 1];
            if (Brick.isEmpty(check)) {
                return true;
            }
            if (current.equals(check)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks that the game is won.
     */
    private void checkWin() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Brick current = this.getBoard().getBoard()[i][j];
                if (Brick.isEmpty(current)) {
                    continue;
                }
                if (current.getValue() == 2048) {
                    this.won = true;
                }
            }
        }
    }

    /**
     * Cheks that the game is not failed. That seems that there no more place in
     * the board and no more combinable bricks with the same value.
     */
    private void checkFail() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (Brick.isEmpty(this.board.getBoard()[i][j])) {
                    return;
                }
                if (this.checkAround(i, j, this.board.getBoard()[i][j])) {
                    return;
                }
            }
        }
        this.fail = true;
    }

    /**
     * Little method that updates to score afther each movement
     *
     * @param nb an Integer to add to the score.
     * @return the new score.
     */
    private int addToScore(int nb) {
        return this.board.getScore() + nb;
    }
}
