/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.view.console;

import g54892.app2048.model.Board;
import static g54892.app2048.model.Board.*;
import g54892.app2048.model.Brick;
import g54892.app2048.model.Direction;
import java.util.Scanner;

/**
 * this class represents a console version of the application regroups every
 * interaction with the user and any view details.
 *
 * @author Talhaoui Yassin - G54892
 */
public class ConsoleView implements InterfaceView {

    private final Scanner kbd = new Scanner(System.in);

    /**
     * Displays the title.
     */
    @Override
    public void displayTitle() {
        System.out.println("                         ======================= \n"
                + "                          Bienvenue au jeu 2048 \n"
                + "                         ======================= \n");
    }

    /**
     * Displays the board of the bricks.
     *
     * @param board a gieven instance of Board.
     */
    public void printBoard(Board board) {
        System.out.println("\033[34;38m" + "Le plateau de jeu : ");
        System.out.println("--------------------\n");

        System.out.println("+-------------------------------+");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                if (!Brick.isEmpty(board.getBoard()[i][j])) {
                    System.out.printf("%1$8s", board.getBoard()[i][j] + "   | ");
                } else {
                    System.out.printf("%8s", "0   | ");
                }
            }
            System.out.println("");
            System.out.println("+-------------------------------+");
        }
        System.out.println("");
    }

    /**
     * Return the chosen direction among all possible directions.
     *
     * @return the chosen direction.
     */
    @Override
    public Direction choseDirection() {
        this.askDirection();
        Direction chosen = null;
        switch (this.askNumber()) {
            case 1:
                chosen = Direction.NORD;
                break;
            case 2:
                chosen = Direction.SUD;
                break;
            case 3:
                chosen = Direction.EST;
                break;
            case 4:
                chosen = Direction.OUEST;
                break;
            default:
                break;
        }
        return chosen;
    }

    /**
     * Proposes the different possible movements that can be carried out.
     */
    private void askDirection() {
        System.out.print("Veuillez entrer un chiffre parmi: 1 -> vers le nord\n"
                + "                                  2 -> vers le sud\n"
                + "                                  3 -> vers l'est\n"
                + "                                  4 -> vers l'ouest\n");
    }

    /**
     * Asks for a number between 0 and 4 and returns it.
     *
     * @return the entered number.
     */
    @Override
    public int askNumber() {
        int nb = this.checkInteger();
        while (nb <= 0 || nb > 4) {
            System.out.println("\033[31;38m" + "Le nombre saisi n'est pas correct.\n"
                    + "Veuillez entrer un nombre entier compris entre 1 et 4. \n");
            nb = this.checkInteger();
        }
        return nb;
    }

    /**
     * Cheks that the input is an Integer.
     *
     * @return the checked Integer.
     */
    private int checkInteger() {
        while (!this.kbd.hasNextInt()) {
            this.kbd.next();
            System.out.println("\033[31;38m" + "Entrez un entier !!! 👎");
            this.askDirection();
        }
        return this.kbd.nextInt();
    }

    /**
     * Displays the current score.
     *
     * @param score an Integer, the score.
     */
    @Override
    public void displayScore(int score) {
        System.out.println("\033[34;38m" + "Votre score actuel : " + score);
        System.out.println("-------------------------\n");
    }

    /**
     * Announces that the party is won.
     */
    @Override
    public void displayWinningMessage() {
        System.out.println("================================");
        System.out.println("\033[32;38m" + "Bravo, vous avez obtenu 2048 🤗");
        System.out.println("================================");
    }

    /**
     * Announces that the party is lost.
     */
    @Override
    public void displayLosingMessage() {
        System.out.println("===========================");
        System.out.println("\033[31;38m" + "Désolé, vous avez perdu 😡");
        System.out.println("===========================");
    }

    /**
     * Displays a message to indicate that movement is not allowed.
     */
    @Override
    public void displayMoveNotAllowed() {
        System.out.println("\033[31;38m" + "Déplacement non autorisé\n");
    }
}
