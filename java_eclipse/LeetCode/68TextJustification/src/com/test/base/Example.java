package com.test.base;

import java.util.List;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private SolutionA solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        assertOne(new String[] {"This", "is", "an", "example", "of", "text", "justification."},
            16,
            new String[] {"This    is    an", "example  of text", "justification.  "});
        
        assertOne(new String[] {"What", "must", "be", "acknowledgment", "shall", "be"},
            16,
            new String[] {"What   must   be", "acknowledgment  ", "shall be        "});
        

        assertOne(new String[] {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"},
            16,
            new String[] {"ask   not   what", "your country can", "do  for  you ask", "what  you can do",
                "for your country"});
    }
    
    private void assertOne(String[] input, int maxWidth, String[] output)
    {
        List<String> actual = solution.fullJustify(input, 16);
        assertEquals(output.length, actual.size());
        
        for (int i = 0; i < output.length; i++)
        {
            assertEquals(output[i], actual.get(i));
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
