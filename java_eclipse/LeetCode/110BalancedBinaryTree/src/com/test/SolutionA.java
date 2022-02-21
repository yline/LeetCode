package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 使用标记量，实现dfs
 * @author YLine
 *
 * 2018年11月26日 下午9:09:22
 */
public class SolutionA implements Solution
{
    @Override
    public boolean isBalanced(TreeNode root)
    {
        TreeNode sign = new TreeNode(0);
        dfs(root, sign);
        return (sign.val != 1);
    }
    
    private int dfs(TreeNode node, TreeNode sign)
    {
        if (null == node || sign.val == 1) // 当已经失败时
        {
            return 0;
        }
        
        if (null == node.left && null == node.right)
        {
            return 1;
        }
        
        int left = dfs(node.left, sign);
        int right = dfs(node.right, sign);
        if (Math.abs(left - right) > 1)
        {
            sign.val = 1;
        }
        return Math.max(left, right) + 1;
    }
}
