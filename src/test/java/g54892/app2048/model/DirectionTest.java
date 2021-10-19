/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.app2048.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests for the class Direction.
 *
 * @author Talhaoui Yassin - G54892
 */
public class DirectionTest {

    /**
     * Test of method getDeltaX() for NORD.
     */
    @Test
    public void testGetDeltaXNord() {
        assertTrue(Direction.NORD.getDeltaX() == -1);
    }

    /**
     * Test of method getDeltaY) for NORD.
     */
    @Test
    public void testGetDeltaYNord() {
        assertTrue(Direction.NORD.getDeltaY() == 0);
    }

    /**
     * Test of method getDeltaX() for SUD.
     */
    @Test
    public void testGetDeltaXSud() {
        assertTrue(Direction.SUD.getDeltaX() == 1);
    }

    /**
     * Test of method getDeltaY() for SUD.
     */
    @Test
    public void testGetDeltaYSud() {
        assertTrue(Direction.SUD.getDeltaY() == 0);
    }

    /**
     * Test of method getDeltaX() for EST
     */
    @Test
    public void testGetDeltaXEst() {
        assertTrue(Direction.EST.getDeltaX() == 0);
    }

    /**
     * Test of method getDeltaY() for EST.
     */
    @Test
    public void testGetDeltaYEst() {
        assertTrue(Direction.EST.getDeltaY() == 1);
    }

    /**
     * Test of method getDeltaX() for OUEST.
     */
    @Test
    public void testGetDeltaXOuest() {
        assertTrue(Direction.OUEST.getDeltaX() == 0);
    }

    /**
     * Test of method getDeltaY() for OUEST.
     */
    @Test
    public void testGetDeltaYOuest() {
        assertTrue(Direction.OUEST.getDeltaY() == -1);
    }
}
