package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * 中序遍历【左中右】
 */
public class SolutionA
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> resultList = new ArrayList<>();
        dfs(resultList, root);
        return resultList;
    }
    
    private void dfs(List<Integer> result, TreeNode node)
    {
        if (null == node)
        {
            return;
        }
        
        dfs(result, node.left);
        result.add(node.val);
        dfs(result, node.right);
    }
}
