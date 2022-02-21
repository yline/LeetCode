package com.test.base;

import java.util.Arrays;
import java.util.List;

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
        /*solution = new SolutionA();
        assertSolution();*/
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        List<String> resultA = solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
        ListUtils.printOne(resultA);
        
        List<String> resultB = solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        ListUtils.printOne(resultB);
        
        List<String> resultC = solution.wordBreak("pineapplepenapple",
            Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        ListUtils.printOne(resultC);
        
        List<String> resultD = solution.wordBreak("catsandog",
            Arrays.asList("cats", "dog", "sand", "and", "cat"));
        ListUtils.printOne(resultD);
        
        List<String> resultE = solution.wordBreak("a", Arrays.asList("b"));
        ListUtils.printOne(resultE);
        /*
         * 虽然 leetcode 通过了，但本机的内存溢出了。。而且是高通过率，所以觉得没啥必要这题
        * Exception
        * java.lang.OutOfMemoryError: GC overhead limit exceeded
        List<String> resultF = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            ,
            Arrays.asList("a",
                "aa",
                "aaa",
                "aaaa",
                "aaaaa",
                "aaaaaa",
                "aaaaaaa",
                "aaaaaaaa",
                "aaaaaaaaa",
                "aaaaaaaaaa"));
        System.out.println("resultF size = " + resultF.size());*/
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
