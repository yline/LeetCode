package com.test;

import com.test.base.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * 
 * The diameter of a binary tree is the length of the longest path
 * between any two nodes in a tree.
 * 
 * This path may or may not pass through the root.
 * 
 * @author YLine
 *
 * 2019年11月20日 下午4:47:37
 */
public class SolutionA
{
    public int diameterOfBinaryTree(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        
        mResult = 0;
        int maxLength = dfs(root);
        
        // 如果全是单向的
        mResult = Math.max(mResult, maxLength);
        return mResult;
    }
    
    private int mResult;
    
    private int dfs(TreeNode node)
    {
        if (null == node.left && null == node.right)
        {
            return 0;
        }
        
        if (null != node.left && null != node.right)
        {
            int leftMax = 1 + dfs(node.left);
            int rightMax = 1 + dfs(node.right);
            
            // 最大值，肯定是双向的。如果是 非root
            mResult = Math.max(mResult, leftMax + rightMax);
            return Math.max(leftMax, rightMax);
        }
        
        return 1 + dfs(null != node.left ? node.left : node.right);
    }
}
