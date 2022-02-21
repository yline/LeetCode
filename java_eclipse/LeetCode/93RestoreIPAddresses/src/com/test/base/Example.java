package com.test.base;

import java.util.Arrays;
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
        List<String> resultA = solution.restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(resultA.toArray()));
        
        List<String> resultB = solution.restoreIpAddresses("0000");
        System.out.println(Arrays.toString(resultB.toArray()));
        
        List<String> resultC = solution.restoreIpAddresses("1111");
        System.out.println(Arrays.toString(resultC.toArray()));
        
        List<String> resultD = solution.restoreIpAddresses("101023");
        System.out.println(Arrays.toString(resultD.toArray()));
        
        List<String> resultE = solution.restoreIpAddresses("240102");
        System.out.println(Arrays.toString(resultE.toArray()));
        
        List<String> resultF = solution.restoreIpAddresses("000256");
        System.out.println(Arrays.toString(resultF.toArray()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
