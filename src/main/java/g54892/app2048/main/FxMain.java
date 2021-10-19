/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.main;

import g54892.app2048.controller.FxController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point of 2048 with UI.
 *
 * @author Talhaoui Yassin - G54892
 */
public class FxMain extends Application {

    FxController ctrl = new FxController();

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the game and displays the gaming screen.
     *
     * @param stage an Instance of Stage.
     * @throws Exception if there is an error.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Game 2048");
        stage.setResizable(false);
        Scene myScene = new Scene(ctrl.getGrid());
        ctrl.control(stage, myScene);
        stage.setScene(myScene);
        stage.show();
    }
}
