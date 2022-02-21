package com.test;

import com.test.single.SolutionBF;
import com.test.single.SolutionBM;
import com.test.single.SolutionKMP;
import com.test.single.SolutionRK;

import junit.framework.TestCase;

/**
 * 单模式，字符串匹配
 * 单模式：在一个模式串和一个主串之间进行匹配
 * @author YLine
 *
 * 2019年4月8日 下午5:17:11
 */
public class SingleSample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 测试 BF算法
    public void testBF()
    {
        System.out.println("-------------testBF--------------");
        SolutionBF solution = new SolutionBF();
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    // 测试 RK算法
    public void testRK()
    {
        System.out.println("-------------testRK--------------");
        SolutionRK solution = new SolutionRK();
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    // 测试 BM算法，后缀计算
    public void testBM()
    {
        System.out.println("-------------testBM--------------");
        SolutionBM solution = new SolutionBM();
        solution.testGoodSuffix();
        
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    // 测试 KMP，多移动几位
    public void testKMP()
    {
        System.out.println("-------------testKMP--------------");
        SolutionKMP solution = new SolutionKMP();
        
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
