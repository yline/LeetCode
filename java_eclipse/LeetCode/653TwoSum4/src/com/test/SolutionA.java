package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean findTarget(TreeNode root, int k)
    {
        if (null == root)
        {
            return false;
        }
        
        return dfs(root, k);
    }
    
    /**
     * 一共5种情况
     * 1，节点 + 左分支
     * 2，节点 + 右分支
     * 3，左分支
     * 4，右分支
     * 5，左分支+右分支【最麻烦】
     * @param node 当前节点
     * @param k 值
     * @return
     */
    private boolean dfs(TreeNode node, int k)
    {
        if (null == node)
        {
            return false;
        }
        
        return (isExist(node.left, k - node.val)) || (isExist(node.right, k - node.val))
            || (dfs(node.left, k)) || (dfs(node.right, k))
            || (isMatchExist(node.left, node.right, k));
    }
    
    /**
     * 左分支必有一个，右分支必有一个，总和是否 = k
     * @param left 左分支
     * @param right 右分支
     * @param k 总值
     * @return
     */
    private boolean isMatchExist(TreeNode left, TreeNode right, int k)
    {
        if (null != left)
        {
            if (isExist(right, k - left.val))
            {
                return true;
            }
            return (isMatchExist(left.left, right, k) || isMatchExist(left.right, right, k));
        }
        return false;
    }
    
    private boolean isExist(TreeNode node, int val)
    {
        while (null != node)
        {
            if (val > node.val)
            {
                node = node.right;
            }
            else if (val < node.val)
            {
                node = node.left;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
}
