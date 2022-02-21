package com.test.search2;

import java.util.Arrays;
import java.util.List;

import com.test.base.DataSource;
import com.test.base.TreeNode;
import com.test.search.SolutionSearchOrderMiddle;

import junit.framework.TestCase;

/**
 * 二叉查找树[允许重复数据]，测试
 * @author YLine
 *
 * 2019年3月14日 上午9:52:37
 */
public class Search2Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 查找
    public void testLookup()
    {
        TreeNode<Integer> root = DataSource.createSearch2TreeNode();
        SolutionSearch2Lookup solution = new SolutionSearch2Lookup();
        
        assertEquals(0, solution.find(root, -1));
        assertEquals(0, solution.find(root, 0));
        assertEquals(1, solution.find(root, 1));
        assertEquals(2, solution.find(root, 2));
        assertEquals(2, solution.find(root, 3));
        assertEquals(1, solution.find(root, 4));
        assertEquals(2, solution.find(root, 5));
        assertEquals(2, solution.find(root, 6));
        assertEquals(2, solution.find(root, 7));
        assertEquals(1, solution.find(root, 8));
        assertEquals(0, solution.find(root, 9));
    }
    
    // 插入
    public void testInsert()
    {
        final int LEFT = SolutionSearch2Insert.LEFT;
        final int RIGHT = SolutionSearch2Insert.RIGHT;
        
        TreeNode<Integer> root = DataSource.createSearch2TreeNode();
        SolutionSearch2Insert solution = new SolutionSearch2Insert();
        
        assertSolutionInsert(solution.insert(root, -1), 5, 3, 2, 1, LEFT);
        assertSolutionInsert(solution.insert(root, 0), 5, 3, 2, 1, LEFT);
        assertSolutionInsert(solution.insert(root, 1), 5, 3, 2, 1, RIGHT);
        assertSolutionInsert(solution.insert(root, 2), 5, 3, 2, 2, RIGHT);
        assertSolutionInsert(solution.insert(root, 3), 5, 3, 3, 4, LEFT);
        assertSolutionInsert(solution.insert(root, 4), 5, 3, 3, 4, RIGHT);
        assertSolutionInsert(solution.insert(root, 5), 5, 7, 6, 5, RIGHT);
        assertSolutionInsert(solution.insert(root, 6), 5, 7, 6, 6, RIGHT);
        assertSolutionInsert(solution.insert(root, 7), 5, 7, 7, 8, LEFT);
        assertSolutionInsert(solution.insert(root, 8), 5, 7, 7, 8, RIGHT);
        assertSolutionInsert(solution.insert(root, 9), 5, 7, 7, 8, RIGHT);
    }
    
    private void assertSolutionInsert(List<Integer> actual, int... expected)
    {
        assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++)
        {
            int value = actual.get(i);
            assertEquals(expected[i], value);
        }
    }
    
    // 删除
    public void testDelete()
    {
        TreeNode<Integer> root = DataSource.createSearch2TreeNode();
        SolutionSearch2Delete solution = new SolutionSearch2Delete();
        
        assertEquals(0, solution.delete(root, -1));
        assertEquals(0, solution.delete(root, 0));
        assertEquals(1, solution.delete(root, 1));
        assertEquals(2, solution.delete(root, 2));
        assertEquals(2, solution.delete(root, 3));
        assertEquals(1, solution.delete(root, 4));
        assertEquals(2, solution.delete(root, 5));
        assertEquals(2, solution.delete(root, 6));
        assertEquals(2, solution.delete(root, 7));
        assertEquals(1, solution.delete(root, 8));
        assertEquals(0, solution.delete(root, 9));
    }
    
    // 中序遍历
    public void testOrderMiddle()
    {
        TreeNode<Integer> rootNode = DataSource.createSearch2TreeNode();
        SolutionSearchOrderMiddle solution = new SolutionSearchOrderMiddle();
        
        List<Integer> result = solution.middlerOrder(rootNode);
        System.out.println(Arrays.toString(result.toArray()));
        for (int i = 1; i < result.size(); i++)
        {
            assert (result.get(i - 1) <= result.get(i));
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
