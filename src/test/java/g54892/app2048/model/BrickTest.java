/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import javafx.scene.paint.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests for the class Brick.
 *
 * @author Talahoui Yassin - G54892
 */
public class BrickTest {

    private final Brick brick = new Brick(2, 1, 10);

    /**
     * Test of method getX().
     */
    @Test
    public void testGetX() {
        assertEquals(2, this.brick.getX());
    }

    /**
     * Test of method getY().
     */
    @Test
    public void testGetY() {
        assertEquals(1, this.brick.getY());
    }

    /**
     * Test of method getValue().
     */
    @Test
    public void testGetValue() {
        this.brick.setValue(20);
        assertFalse(this.brick.getValue() == 2);
    }

    /**
     * Test of method setValue().
     */
    @Test
    public void testSetValue() {
        this.brick.setValue(10);
        assertEquals(10, this.brick.getValue());
    }

    /**
     * Test of method setX().
     */
    @Test
    public void testSetX() {
        Brick test = new Brick(1, 0, 0);
        test.setX(0);
        assertFalse(test.getX() == 1);
    }

    /**
     * Test of method setY().
     */
    @Test
    public void testSetY() {
        Brick test = new Brick(1, 4, 0);
        test.setY(3);
        assertTrue(test.getY() == 3);
    }

    /**
     * Test of method isEmpty().
     */
    @Test
    public void testIsEmpty() {
        assertFalse(Brick.isEmpty(this.brick));
    }

    /**
     * Test of method canMergeWith().
     */
    @Test
    public void testCanMergeWith() {
        Brick test1 = new Brick(0, 0, 8);
        Brick test2 = new Brick(4, 3, 8);
        assertTrue(test1.canMergeWith(test2));
    }

    /**
     * Test of method canMergeWith().
     */
    @Test
    public void testCanMergeWithNull() {
        Brick test1 = new Brick(0, 0, 8);
        Brick test2 = null;
        assertFalse(test1.canMergeWith(test2));
    }

    /**
     * Test of method canMergeWith().
     */
    @Test
    public void testCanMergeWithDifferentBricks() {
        Brick test1 = new Brick(0, 0, 8);
        Brick test2 = new Brick(4, 3, 2);
        assertFalse(test1.canMergeWith(test2));
    }

    /**
     * Test for method getColor().
     */
    @Test
    public void testGetColor() {
        Brick test = new Brick(2, 1, 8);
        assertEquals(Color.rgb(242, 177, 121, 1.0), test.getColor());
    }

    /**
     * Test for method getForegroundColor().
     */
    @Test
    public void testGetForegroundColor() {
        Brick test = new Brick(2, 1, 16);
        assertEquals(Color.rgb(249, 246, 242, 1.0), test.getForeground());
    }

    /**
     * Test for method hashCode().
     */
    @Test
    public void testHashCode() {
        Brick test = new Brick(2, 1, 8);
        assertFalse(this.brick.hashCode() == test.hashCode());
    }

    /**
     * Test for method equals().
     */
    @Test
    public void testEquals() {
        Brick test = new Brick(2, 1, 8);
        assertFalse(this.brick.equals(test));
    }

    /**
     * Test for method toString().
     */
    @Test
    public void testToString() {
        Brick test = new Brick(2, 1, 8);
        assertFalse(String.valueOf(this.brick.getValue()).equals(test.toString()));
    }
}
