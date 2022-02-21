package com.test.base;

import java.util.Arrays;
import java.util.List;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Sample extends TestCase
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
    }
    
    private void assertSolution()
    {
        String param0 = "2";
        String[] result0 = {"a", "b", "c"};
        assertEquals(true, judge(result0, solution.letterCombinations(param0)));
        
        String param1 = "23";
        String[] result1 = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        assertEquals(true, judge(result1, solution.letterCombinations(param1)));
    }
    
    /** 校验性的 代码 */
    private boolean judge(String[] str1, List<String> strList)
    {
        System.out.println(Arrays.toString(str1));
        System.out.println(strList.toString());
        
        if (str1.length != strList.size())
        {
            return false;
        }
        
        for (int i = 0; i < str1.length; i++)
        {
            String a = str1[i];
            String b = strList.get(i);
            
            if (!a.equals(b))
            {
                System.out.println("a = " + a + ",b = " + b);
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
