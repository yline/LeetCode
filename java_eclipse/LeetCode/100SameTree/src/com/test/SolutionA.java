package com.test;

import com.test.base.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * 
 * 判断二叉树，是否相等
 * 
 * @author YLine
 *
 * 2019年9月25日 下午4:19:51
 */
public class SolutionA
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        return isEqual(p, q);
    }
    
    /**
     * .判断两个结构是否相等
     */
    public static boolean isEqual(TreeNode a, TreeNode b)
    {
        if (null == a && null == b)
        {
            return true;
        }
        
        if (null == a || null == b)
        {
            return false;
        }
        
        return a.val == b.val && isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}
