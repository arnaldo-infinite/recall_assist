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
   
    public WordScorerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {

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
    public void testGetsentencescore() {
        System.out.println("getsentencescore");
        WordScorer instance = new WordScorer("IN CHURCH MEETING");
        instance.processData();
        int expResult = 550;
        int result = instance.gettotalscore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//      fail("The test case is a prototype.");
    }

    
        @Test
    public void testGetwordscore() {
        System.out.println("getwordscore");
        WordScorer instance = new WordScorer("IN CHURCH MEETING");
        instance.processData();
        instance.processUnwantedData();
        int expResult = 513;
        int result = instance.gettotalscore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//      fail("The test case is a prototype.");
    }
    
        @Test
        public void testGetwordcount() {
        System.out.println("getwordcount");
        WordScorer instance = new WordScorer("IN CHURCH MEETING");
        instance.processData();
        instance.processUnwantedData();
        int expResult = 2;
        String [] arrayLength = instance.getarraywords();
        int result = arrayLength.length;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//      fail("The test case is a prototype.");
    }
        
        
    
    
//    /**
//     * Test of getarraycountscore method, of class WordScorer.
//     */
//    @Test
//    public void testGetarraycountscore() {
//        System.out.println("getarraycountscore");
//        WordScorer instance = new WordScorer();
//        int[] expResult = null;
//        int[] result = instance.getarraycountscore();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of gettotalscore method, of class WordScorer.
//     */
//    @Test
//    public void testGettotalscore() {
//        System.out.println("gettotalscore");
//        WordScorer instance = new WordScorer();
//        int expResult = 0;
//        int result = instance.gettotalscore();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

   
    
}
