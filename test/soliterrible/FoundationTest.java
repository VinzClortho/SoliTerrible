/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soliterrible;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gozer
 */
public class FoundationTest {
    
    public FoundationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDrop method, of class Foundation.
     */
    @Test
    public void testGetDrop() {
        System.out.println("getDrop");
        Point inPoint = null;
        Foundation instance = new Foundation();
        Foundation expResult = null;
        Foundation result = instance.getDrop(inPoint);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flipTopCard method, of class Foundation.
     */
    @Test
    public void testFlipTopCard() {
        System.out.println("flipTopCard");
        Foundation instance = new Foundation();
        instance.flipTopCard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class Foundation.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card inCard = null;
        Foundation instance = new Foundation();
        instance.addCard(inCard);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCards method, of class Foundation.
     */
    @Test
    public void testAddCards() {
        System.out.println("addCards");
        List<Card> inCards = null;
        Foundation instance = new Foundation();
        instance.addCards(inCards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Foundation.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Foundation instance = new Foundation();
        FoundationType expResult = null;
        FoundationType result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardList method, of class Foundation.
     */
    @Test
    public void testGetCardList() {
        System.out.println("getCardList");
        Foundation instance = new Foundation();
        ArrayList expResult = null;
        ArrayList result = instance.getCardList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Foundation.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Foundation instance = new Foundation();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardCount method, of class Foundation.
     */
    @Test
    public void testGetCardCount() {
        System.out.println("getCardCount");
        Foundation instance = new Foundation();
        int expResult = 0;
        int result = instance.getCardCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeListener method, of class Foundation.
     */
    @Test
    public void testRemoveListener() {
        System.out.println("removeListener");
        FoundationListener listener = null;
        Foundation instance = new Foundation();
        instance.removeListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllListeners method, of class Foundation.
     */
    @Test
    public void testRemoveAllListeners() {
        System.out.println("removeAllListeners");
        Foundation instance = new Foundation();
        instance.removeAllListeners();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addListener method, of class Foundation.
     */
    @Test
    public void testAddListener() {
        System.out.println("addListener");
        FoundationListener listener = null;
        Foundation instance = new Foundation();
        instance.addListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class Foundation.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseReleased method, of class Foundation.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mouseReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseEntered method, of class Foundation.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mouseEntered(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseExited method, of class Foundation.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mouseExited(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseClicked method, of class Foundation.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mouseClicked(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseMoved method, of class Foundation.
     */
    @Test
    public void testMouseMoved() {
        System.out.println("mouseMoved");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mouseMoved(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseDragged method, of class Foundation.
     */
    @Test
    public void testMouseDragged() {
        System.out.println("mouseDragged");
        MouseEvent e = null;
        Foundation instance = new Foundation();
        instance.mouseDragged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}