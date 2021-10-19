/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.view.fx;

import static g54892.app2048.controller.FxController.*;
import g54892.app2048.model.Board;
import g54892.app2048.model.Brick;
import static g54892.app2048.view.fx.FxGame.CELL_SIZE;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * This utility class contains static methods to draw differents messages on the
 * gaming screen.
 *
 * @author Talhaoui Yassin - G54892
 */
public class DrawUtil {

    /**
     * Displays the current score.
     *
     * @param gc an instance of GraphicsContext.
     * @param b a given board.
     */
    public static void displayScore(GraphicsContext gc, Board b) {
        gc.setFont(Font.font("Verdana", FontWeight.LIGHT, 18));
        gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText("Votre score: " + b.getScore(), 180, 370);
    }

    /**
     * Displays a message when the palyer wins.
     *
     * @param gc an instance of GraphicsContext.
     */
    public static void displayWinningMessage(GraphicsContext gc) {
        updateGameScreen(gc);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", FontWeight.LIGHT, 20));
        gc.setFill(Color.rgb(0, 0, 0));
        gc.fillText("Bravo, vous avez obtenu 2048!", 190, 170);
        gc.setFont(Font.font("Verdana", FontWeight.LIGHT, 13));
        gc.fillText("Pressez la touche ENTER pour recommencer", 190, 200);
    }

    /**
     * Displays a message when the player loses.
     *
     * @param gc an instance of GraphicsContext.
     */
    public static void displayLosingMessage(GraphicsContext gc) {
        updateGameScreen(gc);
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Game over!", 160, 130);
        gc.fillText("Vous avez perdu!", 160, 200);
        gc.setFont(Font.font("Verdana", FontWeight.LIGHT, 13));
        gc.setFill(Color.rgb(0, 0, 0));
        gc.fillText("Pressez la touche ENTER pour recommencer", 160, 250);
    }

    /**
     * Draws the bricks that have 0 as value with the correponding color.
     *
     * @param gc an instance of GraphicsContext.
     * @param xOffset a vertical offset.
     * @param yOffset a horizontal offset.
     */
    public static void drawZeroBrick(GraphicsContext gc, int xOffset, int yOffset) {
        gc.setFill(Color.rgb(205, 193, 180, 1.0));
        gc.fillRect(xOffset, yOffset, CELL_SIZE, CELL_SIZE);
        gc.setFill(Color.rgb(205, 193, 180, 1.0));
    }

    /**
     * Draws the bricks that doesn't have 0 as value with the correponding
     * color.
     *
     * @param gc an instance of GraphicsContext.
     * @param xOffset a vertical offset.
     * @param yOffset a horizontal offset.
     * @param brick an instance of Brick.
     */
    public static void drawNonZeroBrick(GraphicsContext gc, int xOffset,
            int yOffset, Brick brick) {
        gc.setFill(brick.getColor());
        gc.fillRect(xOffset, yOffset, CELL_SIZE, CELL_SIZE);
        gc.setFill(brick.getForeground());
    }

    /**
     * Updates the value of the bricks.
     *
     * @param gc an instance of GraphicsContext.
     * @param xOffset a vertical offset.
     * @param yOffset a horizontal offset.
     * @param size a given Integer.
     * @param s a given String, represents the value of the brick.
     */
    public static void updateBrickValue(GraphicsContext gc, int xOffset,
            int yOffset, int size, String s) {
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, size));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(s, xOffset + CELL_SIZE / 2, yOffset + CELL_SIZE / 2 - 2);
    }

    /**
     * Updates the gaming screen.
     *
     * @param gc an instance of GraphicsContext.
     */
    public static void updateGameScreen(GraphicsContext gc) {
        gc.setFill(Color.rgb(187, 173, 160, 1.0));
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.rgb(0, 0, 0));
    }
}
