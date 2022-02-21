package com.test.base;

import java.util.Arrays;

import com.test.SolutionB;
import com.test.logn.SolutionMerge;
import com.test.logn.SolutionMergeB;
import com.test.logn.SolutionQuick;
import com.test.n.SolutionBucket;
import com.test.n.SolutionCounting;
import com.test.n.SolutionRadix;
import com.test.n2.SolutionBubble;
import com.test.n2.SolutionInsert;
import com.test.n2.SolutionSelect;
import com.test.n2.SolutionShell;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        // solution = new SolutionB();
        super.setUp();
    }
    
    // 冒泡排序
    public void testBubble()
    {
        solution = new SolutionBubble();
        logSolution("Bubble");
    }
    
    // 插入排序
    public void testInsert()
    {
        solution = new SolutionInsert();
        logSolution("Insert");
    }
    
    // 选择排序
    public void testSelect()
    {
        solution = new SolutionSelect();
        logSolution("Select");
    }
    
    // 希尔排序
    public void testShell()
    {
        solution = new SolutionShell();
        logSolution("Shell");
    }
    
    // 并归排序
    public void testMerge()
    {
        solution = new SolutionMerge(); // 递推
        logSolution("Merge");
        
        solution = new SolutionMergeB(); // 递归
        logSolution("MergeB");
    }
    
    // 快速排序
    public void testQuick()
    {
        solution = new SolutionQuick();
        logSolution("Quick");
    }
    
    // 桶排序
    public void testBucket()
    {
        solution = new SolutionBucket();
        logSolution("Bucket");
    }
    
    // 基数排序
    public void testCounting()
    {
        solution = new SolutionCounting();
        logSolution("Counting");
    }
    
    // 基数排序
    public void testRadix()
    {
        SolutionRadix radix = new SolutionRadix();
        radix.sort();
    }
    
    // 待分析的排序方式
    public void testSort()
    {
        SolutionB solution = new SolutionB();
        System.out.println("------------------- sort other ----------------");
        System.out.println(Arrays.toString(solution.sortHeap()));
    }
    
    private void logSolution(String tag)
    {
        Node[] array = Node.createNodeArray();
        System.out.println("-------------------" + tag + "----------------");
        System.out.println("start--" + Arrays.toString(array));
        solution.sort(array);
        System.out.println("finish-" + Arrays.toString(array));
        
        // 校验是增量的数组
        Node temp = array[0];
        for (int i = 1; i < array.length; i++)
        {
            assert temp.value <= array[i].value;
            temp = array[i];
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        // solution = null;
        super.tearDown();
    }
}
