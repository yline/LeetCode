package com.test.base;

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
        TreeLinkNode a1 = new TreeLinkNode(1);
        a1.left = new TreeLinkNode(2);
        a1.right = new TreeLinkNode(3);
        
        solution.connect(a1);
        assertEquals("1,#,2,3,#,", log(a1));
    }
    
    private String log(TreeLinkNode root)
    {
        StringBuilder sBuilder = new StringBuilder();
        
        TreeLinkNode node;
        while (null != root)
        {
            node = root;
            while (null != node)
            {
                sBuilder.append(node.val + ",");
                node = node.next;
            }
            sBuilder.append("#,");
            
            root = root.left;
        }
        
        String result = sBuilder.toString();
        System.out.println(result);
        return result;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
