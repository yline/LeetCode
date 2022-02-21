package com.test.base;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import com.test.SolutionA;
import com.test.SolutionB;
import com.test.SolutionC;

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
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
        
        int[] result1 = SolutionB.getNext("ABCDABDABAB");
        System.out.println("ABCDABDABAB - " + Arrays.toString(result1));
        
        int[] result2 = SolutionB.getNext("SSSSSSSSSSS");
        System.out.println("SSSSSSSSSSS - " + Arrays.toString(result2));
    }
    
    public void testSolutionC()
    {
        assertArrayEquals(new int[] {0}, SolutionC.next("A"));
        assertArrayEquals(new int[] {0, 0}, SolutionC.next("AB"));
        assertArrayEquals(new int[] {0, 0, 1, 0, 1, 2, 2}, SolutionC.next("aabaaac"));
        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 1, 2, 0, 1, 2, 1}, SolutionC.next("ABCDABDABAB"));
        assertArrayEquals(new int[] {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, SolutionC.next("SSSSSSSSSSS"));
        
        solution = new SolutionC();
        assertSolution();
    }
    
    private void assertSolution()
    {
        String haystack0 = "";
        String needle0 = "";
        assertEquals(0, solution.strStr(haystack0, needle0));
        
        String haystack1 = "nibicongqiankuaile";
        String needle1 = "ni";
        assertEquals(0, solution.strStr(haystack1, needle1));
        
        String haystack2 = "nibicongqiankuaile";
        String needle2 = "qiankuaile";
        assertEquals(8, solution.strStr(haystack2, needle2));
        
        String haystack3 = "nibicongqiankuaile";
        String needle3 = "cao";
        assertEquals(-1, solution.strStr(haystack3, needle3));
        
        String haystack4 = "nibicongqiankuaile";
        String needle4 = "y";
        assertEquals(-1, solution.strStr(haystack4, needle4));
        
        String haystack5 = "mississippi";
        String needle5 = "issip";
        assertEquals(4, solution.strStr(haystack5, needle5));
        
        String haystack6 = "a";
        String needle6 = "";
        assertEquals(0, solution.strStr(haystack6, needle6));
        
        String haystack7 = "aabaaabaaac";
        String needle7 = "aabaaac";
        assertEquals(4, solution.strStr(haystack7, needle7));
        
        String haystack8 = "ababcaababcaabc";
        String needle8 = "ababcaabc";
        assertEquals(6, solution.strStr(haystack8, needle8));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
