/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import javafx.scene.paint.Color;

/**
 * This class represents the bricks on the board.
 *
 * @author Talhoui Yassin - G54892
 */
public class Brick {

    private int x;
    private int y;
    private int value;
    private boolean merged;

    /**
     * Constructor of Brick.
     *
     * @param x horizontal posiiton of the brick in the board.
     * @param y vertical posiiton of the brick in the board.
     * @param value of the brick (Integer).
     */
    public Brick(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /**
     * Simple getter of x.
     *
     * @return x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Simple getter of y.
     *
     * @return y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Simple getter of value.
     *
     * @return the value of the brick.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Simple setter of x.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Simple setter if y.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Simple setter of value.
     *
     * @param value of the brick.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Static method that takes a brick and checks that it's empty.
     *
     * @param brick to check.
     * @return true if the given brick is empty, false otherwise.
     */
    public static boolean isEmpty(Brick brick) {
        return brick == null;
    }

    /**
     * Cheks that the cuurent bricks can merge with the other given brick.
     *
     * @param other the brick with which we test.
     * @return true if the bricks can merge, false otherwise.
     */
    public boolean canMergeWith(Brick other) {
        return !this.merged && other != null && !other.merged && this.equals(other);
    }
    
    /**
     * Cheks the value of the brick and returns the corresponding color.
     *
     * @return the color that corresponds to the value.
     */
    public Color getColor() {
        switch (this.value) {
            case 2   :  return Color.rgb(238, 228, 218, 1.0);
            case 4   :  return Color.rgb(237, 224, 200, 1.0);
            case 8   :  return Color.rgb(242, 177, 121, 1.0);
            case 16  :  return Color.rgb(245, 149, 99, 1.0);
            case 32  :  return Color.rgb(246, 124, 95, 1.0);
            case 64  :  return Color.rgb(246, 94, 59, 1.0);
            case 128 :  return Color.rgb(237, 207, 114, 1.0);
            case 256 :  return Color.rgb(237, 204, 97, 1.0);
            case 512 :  return Color.rgb(237, 200, 80, 1.0);
            case 1024:  return Color.rgb(237, 197, 63, 1.0);
            case 2048:  return Color.rgb(237, 194, 46, 1.0);
        }
        return Color.rgb(205, 193, 180, 1.0);
    }

    /**
     * Gets the fore ground color of the brick.
     *
     * @return the fore ground color.
     */
    public Color getForeground() {
        Color foreground;
        if (this.value < 16) {
            foreground = Color.rgb(119, 110, 101, 1.0);
        } else {
            foreground = Color.rgb(249, 246, 242, 1.0);
        }
        return foreground;
    }

    /**
     * Returns the hash code the object (Brick).
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.getValue();
        return hash;
    }

    /**
     * Overrided method from Object class that cheks that 2 bricks are equal. To
     * be equal 2 bricks must have the same value.
     *
     * @param obj a given object to test (in our case a Brick).
     * @return true if the 2 objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Brick other = (Brick) obj;
        return this.getValue() == other.getValue();
    }

    /**
     * Represents an object into a String.
     *
     * @return the String itself.
     */
    @Override
    public String toString() {
        return this.value + "";
    }
}
