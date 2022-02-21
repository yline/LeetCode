package com.test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.SolutionA;

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
    
    private void assertSolution()
    {
        // A
        String[] arrayA = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultA = new ArrayList<List<String>>();
        resultA.add(Arrays.asList("eat", "tea", "ate"));
        resultA.add(Arrays.asList("tan", "nat"));
        resultA.add(Arrays.asList("bat"));
        
        isEqual(resultA, solution.groupAnagrams(arrayA));
        
        // B
        System.out.println("--------------B--------------");
        String[] arrayB = {"ron", "huh", "gay", "tow", "moe", "tie", "who", "ion", "rep", "bob", "gte", "lee", "jay",
            "may", "wyo", "bay", "woe", "lip", "tit", "apt", "doe", "hot", "dis", "fop", "low", "bop", "apt", "dun",
            "ben", "paw", "ere", "bad", "ill", "fla", "mop", "tut", "sol", "peg", "pop", "les"};
        solution.groupAnagrams(arrayB);
    }
    
    private void isEqual(List<List<String>> expected, List<List<String>> actual)
    {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i).size(), actual.get(i).size());
            for (int j = 0; j < expected.get(i).size(); j++)
            {
                assertEquals(expected.get(i).get(j), actual.get(i).get(j));
            }
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
