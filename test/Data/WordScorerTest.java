/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class WordScorerTest {
    
    public WordScorerTest(String Content) {
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
     * Test of getarraywords method, of class WordScorer.
     */
    @Test
    public void testGetarraywords() {
        System.out.println("getarraywords");
        WordScorer instance = new WordScorer();
        String[] expResult = null;
        String[] result = instance.getarraywords();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getarraycountscore method, of class WordScorer.
     */
    @Test
    public void testGetarraycountscore() {
        System.out.println("getarraycountscore");
        WordScorer instance = new WordScorer();
        int[] expResult = null;
        int[] result = instance.getarraycountscore();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gettotalscore method, of class WordScorer.
     */
    @Test
    public void testGettotalscore() {
        System.out.println("gettotalscore");
        WordScorer instance = new WordScorer();
        int expResult = 0;
        int result = instance.gettotalscore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processData method, of class WordScorer.
     */
    @Test
    public void testProcessData() {
        System.out.println("processData");
        WordScorer instance = new WordScorer();
        instance.processData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processUnwantedData method, of class WordScorer.
     */
    @Test
    public void testProcessUnwantedData() {
        System.out.println("processUnwantedData");
        WordScorer instance = new WordScorer();
        instance.processUnwantedData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
