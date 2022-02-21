package com.test.order;

import com.test.base.DataSource;
import com.test.base.TreeNode;

import junit.framework.TestCase;

/**
 * .先序、中序、后序、层序遍历
 * @author YLine
 *
 * 2019年2月22日 下午5:40:24
 */
public class OrderExample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionPreOrder()
    {
        TreeNode<String> rootNode = DataSource.createTreeNode();
        SolutionOrderPre solution = new SolutionOrderPre();
        
        assertEquals("ABDEHICFJGK", solution.preOrder(rootNode));
        assertEquals("ABDEHICFJGK", solution.preOrderNonRecursive(rootNode));
        assertEquals("ABDEHICFJGK", solution.preOrderNonRecursive2(rootNode));
    }
    
    public void testSolutionMiddleOrder()
    {
        TreeNode<String> rootNode = DataSource.createTreeNode();
        SolutionOrderMiddle solution = new SolutionOrderMiddle();
        
        assertEquals("DBHEIAFJCKG", solution.middleOrder(rootNode));
        assertEquals("DBHEIAFJCKG", solution.middleOrderNonRecursive(rootNode));
    }
    
    public void testSolutionAfterOrder()
    {
        TreeNode<String> rootNode = DataSource.createTreeNode();
        SolutionOrderAfter solution = new SolutionOrderAfter();
        
        assertEquals("DHIEBJFKGCA", solution.afterOrder(rootNode));
        assertEquals("DHIEBJFKGCA", solution.afterOrderNonRecursive(rootNode));
    }
    
    public void testSolutionLeverOrder()
    {
        TreeNode<String> rootNode = DataSource.createTreeNode();
        SolutionOrderLevel solution = new SolutionOrderLevel();
        
        assertEquals("ABCDEFGHIJK", solution.levelOrder(rootNode));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
