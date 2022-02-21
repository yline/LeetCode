package com.test.base;

import java.util.ArrayList;
import java.util.List;

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
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
        for (int i = 1; i < 14; i++)
        {
            System.out.println("i = " + i + ",number = " + solution.generateParenthesis(i).size());
        }
    }
    
    public void testSolutionC()
    {
        solution = new SolutionC();
        assertSolution();
        for (int i = 1; i < 14; i++)
        {
            System.out.println("i = " + i + ",number = " + solution.generateParenthesis(i).size());
        }
    }
    
    private void assertSolution()
    {
        List<String> result1 = new ArrayList<>();
        result1.add("()");
        assertEquals(true, isEqual(result1, solution.generateParenthesis(1)));
        System.out.println(solution.generateParenthesis(1).toString());
        
        List<String> result2 = new ArrayList<>();
        result2.add("(())");
        result2.add("()()");
        
        System.out.println(solution.generateParenthesis(2).toString());
        System.out.println(solution.generateParenthesis(3).toString());
        System.out.println(solution.generateParenthesis(4).toString());
        assertEquals(true, isEqual(result2, solution.generateParenthesis(2)));
    }
    
    /** 并不严谨,但是临时够用 */
    private boolean isEqual(List<String> temp, List<String> result)
    {
        if (temp.size() == result.size())
        {
            for (String string : result)
            {
                if (!temp.contains(string))
                {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
