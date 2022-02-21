package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 看到的答案，利用-1，作为特殊标记量
 * @author YLine
 *
 * 2018年11月26日 下午9:32:25
 */
public class SolutionB implements Solution
{
    
    @Override
    public boolean isBalanced(TreeNode root)
    {
        int res = helper(root);
        return res == -1 ? false : true;
    }
    
    private int helper(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1)
        {
            return -1;
        }
        
        if (Math.abs(left - right) > 1)
        {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
