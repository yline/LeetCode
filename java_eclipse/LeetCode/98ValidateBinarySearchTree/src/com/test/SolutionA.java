package com.test;

import com.test.base.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * 平衡二叉树
 * 左 < 中 < 右
 * 
 * @author YLine
 *
 * 2019年9月24日 下午4:26:00
 */
public class SolutionA
{
    public boolean isValidBST(TreeNode root)
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max)
    {
        if (null == node)
        {
            return true;
        }
        
        if (node.val >= max || node.val <= min)
        {
            return false;
        }
        
        return isValidBST(node.left, min, Math.min(max, node.val))
            && isValidBST(node.right, Math.max(min, node.val), max);
    }
}
