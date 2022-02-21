package com.test.base;

import junit.framework.TestCase;

public class Example extends TestCase
{
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        TreeNode rootA = TreeNodeUtils.build(1, 2, null, 3, 4, null, null, 5, 6, 7, 8);
        TreeNodeUtils.print(rootA);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
