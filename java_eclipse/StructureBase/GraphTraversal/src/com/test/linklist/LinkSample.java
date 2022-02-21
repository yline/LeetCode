package com.test.linklist;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import com.test.base.LinkGraph;

import junit.framework.TestCase;

/**
 * .链表实现的图
 * @author YLine
 *
 * 2019年3月22日 下午4:23:46
 */
public class LinkSample extends TestCase
{
    private LinkSolution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 广度优先，遍历算法
    public void testBFS()
    {
        solution = new SolutionLinkBFS();
        LinkGraph graph = LinkGraph.createGraph();
        
        Object[] actualArray = solution.traverse(graph);
        assertSolution("BFS", actualArray, "A", "B", "C", "D", "E", "F");
    }
    
    // 深度优先，遍历算法
    public void testDFS()
    {
        solution = new SolutionLinkDFS();
        LinkGraph graph = LinkGraph.createGraph();
        
        Object[] actualArray = solution.traverse(graph);
        assertSolution("DFS", actualArray, "A", "B", "D", "F", "E", "C");
    }
    
    private void assertSolution(String tag, Object[] actualArray, Object... expected)
    {
        System.out.println("--------------------------" + tag + "-----------------------");
        System.out.println(Arrays.toString(actualArray));
        assertArrayEquals(expected, actualArray);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
