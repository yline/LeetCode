package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertEquals(127, solution.distinctSubseqII("abcdefg"));
        assertEquals(39, solution.distinctSubseqII("abcdddd"));
        assertEquals(67, solution.distinctSubseqII("abcdcdd"));
        assertEquals(79, solution.distinctSubseqII("abcdcdc"));
        assertEquals(6783551, solution.distinctSubseqII("pcrdhwdxmqdznbenhwjsenj"));
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertEquals(127, solution.distinctSubseqII("abcdefg"));
        assertEquals(39, solution.distinctSubseqII("abcdddd"));
        assertEquals(67, solution.distinctSubseqII("abcdcdd"));
        assertEquals(79, solution.distinctSubseqII("abcdcdc"));
        assertEquals(6783551, solution.distinctSubseqII("pcrdhwdxmqdznbenhwjsenj"));
        assertEquals(97915677,
            solution.distinctSubseqII(
                "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
