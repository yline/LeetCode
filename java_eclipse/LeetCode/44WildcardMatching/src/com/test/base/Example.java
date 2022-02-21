package com.test.base;

import com.test.SolutionA;
import com.test.SolutionD;

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
        assertSolution();
    }
    
    public void testSolutionD()
    {
        solution = new SolutionD();
        assertSolution();
    }
    
    private void assertSolution()
    {
        assertEquals(false, solution.isMatch("aa", "a"));
        assertEquals(false, solution.isMatch("cb", "?a"));
        assertEquals(false, solution.isMatch("acdcb", "a*c?b"));
        assertEquals(true, solution.isMatch("aa", "*"));
        assertEquals(true, solution.isMatch("adceb", "*a*b"));
        assertEquals(false, solution.isMatch("b", "?*?"));
        assertEquals(false, solution.isMatch("abc", "abc*defghijk"));
        assertEquals(true, solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        assertEquals(true, solution.isMatch("a", "a*"));
        assertEquals(true, solution.isMatch("a", "*?*"));
        assertEquals(false, solution.isMatch("ac", "*ab"));
        
        String sA = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String pA = "a*******b";
        assertEquals(false, solution.isMatch(sA, pA));
        
        String sB =
            "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaab"
                + "abaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String pB =
            "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        assertEquals(false, solution.isMatch(sB, pB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
