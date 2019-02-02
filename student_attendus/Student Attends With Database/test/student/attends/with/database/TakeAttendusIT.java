/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attends.with.database;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmed
 */
public class TakeAttendusIT {
    
    public TakeAttendusIT() {
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
     * Test of adc method, of class TakeAttendus.
     */
    @Test
    public void testAdc() {
        System.out.println("adc");
        TakeAttendus instance = new TakeAttendus();
        instance.adc();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of WA method, of class TakeAttendus.
     */
    @Test
    public void testWA() {
        System.out.println("WA");
        TakeAttendus instance = new TakeAttendus();
        instance.WA();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TakeAttendus.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent z = null;
        TakeAttendus instance = new TakeAttendus();
        instance.actionPerformed(z);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
