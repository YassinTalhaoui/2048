/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.main;

import g54892.app2048.controller.Controller;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Entry point of the game 2048 (console version).
 *
 * @author Talhaoui Yassin - G54892
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        Controller controller = new Controller();
        controller.start();
    }
}
