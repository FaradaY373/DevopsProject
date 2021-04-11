package main;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void addition()
    {
    	assertEquals("Test1 1+2 = 3",3,App.add(1, 2));
    	assertNotEquals("Test1 1+2 != 4",4,App.add(1, 2));
    }
}
