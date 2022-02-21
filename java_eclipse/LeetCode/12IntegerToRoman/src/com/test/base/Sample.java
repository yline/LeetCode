package com.test.base;

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
        System.out.println("->" + solution.intToRoman(1));
        System.out.println("->" + solution.intToRoman(2));
        System.out.println("->" + solution.intToRoman(3));
        System.out.println("->" + solution.intToRoman(13));
        System.out.println("->" + solution.intToRoman(14));
        System.out.println("->" + solution.intToRoman(19));
        System.out.println("->" + solution.intToRoman(3999));
        System.out.println("->" + solution.intToRoman(1234));
        System.out.println("->" + solution.intToRoman(12345));
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        System.out.println("->" + solution.intToRoman(1));
        System.out.println("->" + solution.intToRoman(2));
        System.out.println("->" + solution.intToRoman(3));
        System.out.println("->" + solution.intToRoman(13));
        System.out.println("->" + solution.intToRoman(14));
        System.out.println("->" + solution.intToRoman(19));
        System.out.println("->" + solution.intToRoman(3999));
        System.out.println("->" + solution.intToRoman(1234));
        // System.out.println("->" + solution.intToRoman(12345)); 最大3999；超过则不符合了
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
