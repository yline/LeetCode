package com.test;

import com.test.base.DataSource;
import com.test.base.TreeNode;

import junit.framework.TestCase;

/**
 * .获取节点个数、等； 需要加上 新建二叉树、二叉树查找
 * .二叉树大全
 * https://github.com/yuzhangcmu/LeetCode/blob/master/tree/TreeDemo.java
 * 
 * @author YLine
 *
 * 2019年2月22日 下午5:14:00
 */
public class Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testNodeNumber()
    {
        TreeNode<String> parentNode = DataSource.createTreeNode();
        SolutionCount solution = new SolutionCount();
        
        assertEquals(11, solution.getNodeNumber(parentNode));
        assertEquals(11, solution.getNodeNumberNonRecursive(parentNode));
    }
    
    public void testNodeLevel()
    {
        TreeNode<String> parentNode = DataSource.createTreeNode();
        SolutionDepth solution = new SolutionDepth();
        
        assertEquals(3, solution.getDepth(parentNode));
        assertEquals(3, solution.getDepthNonRecursive(parentNode));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
