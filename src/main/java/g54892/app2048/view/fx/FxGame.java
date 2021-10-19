/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.view.fx;

import static g54892.app2048.model.Board.*;
import g54892.app2048.model.Brick;
import g54892.app2048.model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class is a graphical interpretation of the game 2048.
 *
 * @author Talhaoui Yassin - G54892
 */
public class FxGame {

    public static final int CELL_SIZE = 64;

    /**
     * Draws all the bricks of the gaming board and displays a corresponding
     * message if the game is won or lost.
     *
     * @param game an instance of Game.
     * @param gc an instance of GraphicsContext.
     * @param listView an instance of ListView.
     */
    public void drawGamingBoard(Game game, GraphicsContext gc, ListView listView) {
        DrawUtil.updateGameScreen(gc);
        int value;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Brick brick = game.getBoard().getBoard()[i][j];
                int xOffset = offsetCoors(j);
                int yOffset = offsetCoors(i);
                if (Brick.isEmpty(game.getBoard().getBoard()[i][j])) {
                    value = 0;
                    DrawUtil.drawZeroBrick(gc, xOffset, yOffset);
                } else {
                    value = brick.getValue();
                    DrawUtil.drawNonZeroBrick(gc, xOffset, yOffset, brick);
                }
                final int size = value < 100 ? 32 : value < 1000 ? 28 : 24;
                String s = String.valueOf(value);
                DrawUtil.updateBrickValue(gc, xOffset, yOffset, size, s);
                DrawUtil.displayScore(gc, game.getBoard());
                if (!game.canMove()) {
                    Text txt = new Text("mouvement impossible !");
                    txt.setFont(Font.font("Verdana"));
                    listView.getItems().add(txt);
                    game.setCanMove(true);
                }
                if (game.isWon()) {
                    DrawUtil.displayWinningMessage(gc);
                }
                if (game.isFail()) {
                    DrawUtil.displayLosingMessage(gc);
                }
            }
        }
    }

    /**
     * Calculates and defines the offset that must be between the differents
     * bricks.
     *
     * @param factor that allows us to have corresponding offset.
     * @return the offset compared to the initial brick.
     */
    private static int offsetCoors(int factor) {
        return factor * (16 + CELL_SIZE) + 16;
    }
}
