package com.test.search;

import java.util.Arrays;
import java.util.List;

import com.test.base.DataSource;
import com.test.base.TreeNode;

import junit.framework.TestCase;

/**
 * 二叉查找树，测试
 * @author YLine
 *
 * 2019年3月12日 下午6:13:07
 */
public class SearchExample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 查找
    public void testLoopup()
    {
        TreeNode<Integer> rootNode = DataSource.createSearchTreeNode();
        SolutionSearchLookup solution = new SolutionSearchLookup();
        
        assertLookupSolution(null, solution.find(rootNode, 1));
        assertLookupSolution(new TreeNode<Integer>(2), solution.find(rootNode, 2));
        assertLookupSolution(new TreeNode<Integer>(5), solution.find(rootNode, 5));
        assertLookupSolution(new TreeNode<Integer>(6), solution.find(rootNode, 6));
        assertLookupSolution(null, solution.find(rootNode, 9));
        assertLookupSolution(new TreeNode<Integer>(10), solution.find(rootNode, 10));
        assertLookupSolution(new TreeNode<Integer>(16), solution.find(rootNode, 16));
        assertLookupSolution(null, solution.find(rootNode, 19));
    }
    
    private void assertLookupSolution(TreeNode<Integer> expected, TreeNode<Integer> actual)
    {
        if (null == expected)
        {
            assertEquals(expected, actual);
        }
        else
        {
            assertEquals(expected.getData(), actual.getData());
        }
    }
    
    // 插入
    public void testInsert()
    {
        TreeNode<Integer> rootNode = DataSource.createSearchTreeNode();
        SolutionSearchInsert solution = new SolutionSearchInsert();
        
        assertInsertSolution(true, 2, solution.insert(rootNode, 1));
        assertInsertSolution(false, -1, solution.insert(rootNode, 2));
        assertInsertSolution(false, -1, solution.insert(rootNode, 5));
        assertInsertSolution(false, -1, solution.insert(rootNode, 6));
        assertInsertSolution(true, 8, solution.insert(rootNode, 9));
        assertInsertSolution(false, -1, solution.insert(rootNode, 10));
        assertInsertSolution(false, -1, solution.insert(rootNode, 16));
        assertInsertSolution(true, 18, solution.insert(rootNode, 19));
        assertInsertSolution(true, 18, solution.insert(rootNode, 20));
    }
    
    private void assertInsertSolution(boolean expectResult, int expectNode, boolean actual)
    {
        assertEquals(expectResult, actual);
        if (expectResult)
        {
            System.out.println("expect node = " + expectNode);
        }
    }
    
    // 删除
    public void testDelete()
    {
        TreeNode<Integer> rootNode = DataSource.createSearchTreeNode();
        SolutionSearchDelete solution = new SolutionSearchDelete();
        
        assertEquals(false, solution.delete(rootNode, 1));
        assertEquals(true, solution.delete(rootNode, 2));
        assertEquals(true, solution.delete(rootNode, 5));
        assertEquals(true, solution.delete(rootNode, 6));
        assertEquals(false, solution.delete(rootNode, 9));
        assertEquals(true, solution.delete(rootNode, 10));
        assertEquals(true, solution.delete(rootNode, 16));
        assertEquals(false, solution.delete(rootNode, 19));
        assertEquals(false, solution.delete(rootNode, 20));
    }
    
    // 中序遍历
    public void testOrderMiddle()
    {
        TreeNode<Integer> rootNode = DataSource.createSearchTreeNode();
        SolutionSearchOrderMiddle solution = new SolutionSearchOrderMiddle();
        
        List<Integer> result = solution.middlerOrder(rootNode);
        System.out.println(Arrays.toString(result.toArray()));
        for (int i = 1; i < result.size(); i++)
        {
            assert (result.get(i - 1) < result.get(i));
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
