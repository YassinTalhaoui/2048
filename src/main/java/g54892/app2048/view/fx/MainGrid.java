/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.view.fx;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Customized gridPane containing all the necessary elements for the
 * application.
 *
 * @author Talhaoui Yassin - G54892
 */
public class MainGrid extends GridPane {

    private final ListView<Text> list;

    /**
     * Constructor of MainGrid.
     *
     * @param c a given instance of Canvas
     */
    public MainGrid(Canvas c) {
        this.list = new ListView<>();
        this.list.setFocusTraversable(false);
        Text txt = new Text("Bienvenue au jeu 2048");
        txt.setFont(Font.font("Verdana"));
        this.list.getItems().add(txt);
        this.add(c, 1, 1);
        this.add(this.list, 2, 1);
    }

    /**
     * Simple getter of list.
     *
     * @return list.
     */
    public ListView<Text> getList() {
        return this.list;
    }
}
