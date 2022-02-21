package com.test.heap;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class HeapExample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 从下至上，以新增为例
    public void testHeapifyUp()
    {
        SolutionHeapifyUp solution = new SolutionHeapifyUp();
        
        List<Integer> dataA = solution.buildTestSource();
        solution.insert(dataA, 1);
        assertSolutionUp(dataA, 1, 9, 21, 33);
        
        List<Integer> dataB = solution.buildTestSource();
        solution.insert(dataB, 11);
        assertSolutionUp(dataB, 9, 11, 21, 33);
        
        List<Integer> dataC = solution.buildTestSource();
        solution.insert(dataC, 25);
        assertSolutionUp(dataC, 9, 21, 25, 33);
        
        List<Integer> dataD = solution.buildTestSource();
        solution.insert(dataD, 125);
        assertSolutionUp(dataD, 9, 21, 33, 125);
    }
    
    private void assertSolutionUp(List<Integer> dataList, int... valueArray)
    {
        assertEquals(dataList.get(14).intValue(), valueArray[0]);
        assertEquals(dataList.get(7).intValue(), valueArray[1]);
        assertEquals(dataList.get(3).intValue(), valueArray[2]);
        assertEquals(dataList.get(1).intValue(), valueArray[3]);
    }
    
    // 从上至下，以删除为例
    public void testHeapifyDown()
    {
        SolutionHeapifyDown solution = new SolutionHeapifyDown();
        
        List<Integer> dataList = solution.buildTestSource();
        assertSolutionDown(dataList, 33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2);
        
        solution.removeTop(dataList);
        assertSolutionDown(dataList, 21, 17, 15, 16, 13, 2, 9, 5, 6, 7, 8, 1);
        
        solution.removeTop(dataList);
        assertSolutionDown(dataList, 17, 16, 15, 6, 13, 2, 9, 5, 1, 7, 8);
        
        solution.removeTop(dataList);
        assertSolutionDown(dataList, 16, 13, 15, 6, 8, 2, 9, 5, 1, 7);
    }
    
    private void assertSolutionDown(List<Integer> dataList, int... valueArray)
    {
        assertEquals(dataList.size(), valueArray.length + 1);
        for (int i = 0; i < valueArray.length - 1; i++)
        {
            assertEquals(dataList.get(i + 1).intValue(), valueArray[i]);
        }
    }
    
    // 堆化；新建堆
    public void testHeapBuild()
    {
        SolutionHeapBuild solution = new SolutionHeapBuild();
        
        List<Integer> dataList = solution.buildDataSource();
        solution.buildHeap(dataList);
        assertSolutionBuild(dataList, 20, 16, 19, 13, 4, 1, 7, 5, 8);
    }
    
    private void assertSolutionBuild(List<Integer> dataList, int... valueArray)
    {
        assertEquals(dataList.size(), valueArray.length + 1);
        for (int i = 0; i < valueArray.length - 1; i++)
        {
            assertEquals(dataList.get(i + 1).intValue(), valueArray[i]);
        }
    }
    
    // 堆，排序
    public void testHeapOrder()
    {
        SolutionHeapBuild solutionBuild = new SolutionHeapBuild();
        
        List<Integer> dataList = solutionBuild.buildDataSource();
        solutionBuild.buildHeap(dataList);
        
        SolutionHeapOrder solutionOrder = new SolutionHeapOrder();
        solutionOrder.heapSort(dataList);
        
        System.out.println(Arrays.toString(dataList.toArray()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
