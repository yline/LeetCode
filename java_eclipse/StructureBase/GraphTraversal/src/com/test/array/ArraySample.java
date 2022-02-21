package com.test.array;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import com.test.base.ArrayGraph;
import com.test.base.ArraySolution;

import junit.framework.TestCase;

/**
 * http://blog.csdn.net/ochangwen/article/details/50729993
 * .数组实现的图; 思想是OK的，但数组实现图，麻烦事很多；不如链表
 * 
 * @author YLine
 *
 * 2019年2月22日 下午4:39:56
 */
public class ArraySample extends TestCase
{
    private ArrayGraph graph;
    
    private ArraySolution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        graph = ArrayGraph.createUndirectGraph(6);
        super.setUp();
    }
    
    // 广度优先遍历算法 Breadth-first search（非递归）
    public void testBFS()
    {
        solution = new SolutionBFS();
        graph.resetState();
        
        assertSolution("BFS", "0", "1", "2", "3", "4", "5");
    }
    
    // 深度优先遍历算法 Depth-first search（递归）
    public void testDFS()
    {
        solution = new SolutionDFS();
        graph.resetState();
        
        assertSolution("DFS", "0", "1", "2", "4", "5", "3");
    }
    
    // 深度优先遍历算法 Depth-first search（递归）【从第二个开始】
    public void testDFSBySecond()
    {
        solution = new SolutionDFS();
        if (solution instanceof SolutionDFS)
        {
            ((SolutionDFS)solution).setStartIndex(1);
        }
        graph.resetState();
        
        assertSolution("DFSBySecond", "1", "0", "2", "4", "5", "3");
    }
    
    // 深度优先遍历算法 Depth-first search（非递归）
    public void testDFSNonRecursive()
    {
        solution = new SolutionDFSNonRecursive();
        graph.resetState();
        
        assertSolution("DFSNonRecursive", "0", "2", "4", "5", "3", "1");
    }
    
    private void assertSolution(String tag, Object... expected)
    {
        Object[] objArray = solution.traverse(graph);
        
        System.out.println("--------------------------" + tag + "-----------------------");
        System.out.println(Arrays.toString(objArray));
        assertArrayEquals(expected, objArray);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        graph = null;
        super.tearDown();
    }
}
