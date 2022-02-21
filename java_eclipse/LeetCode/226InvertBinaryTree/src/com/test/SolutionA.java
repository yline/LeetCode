package com.test;

import com.test.base.TreeNode;

/**
 * 
 * 将某一个二叉树。左右分支，交换
 * 
 * @author YLine
 *
 * 2019年6月10日 下午2:58:01
 */
public class SolutionA
{
    public TreeNode invertTree(TreeNode root)
    {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode node)
    {
        if (null == node)
        {
            return;
        }
        
        if (null == node.left && null == node.right)
        {
            return;
        }
        
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        dfs(node.left);
        dfs(node.right);
    }
}
