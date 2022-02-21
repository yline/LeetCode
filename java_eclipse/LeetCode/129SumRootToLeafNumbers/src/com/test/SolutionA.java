package com.test;

import com.test.base.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * @author YLine
 *
 * 2019年11月1日 上午10:32:32
 */
public class SolutionA
{
    public int sumNumbers(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        
        Result result = new Result();
        dfs(root, result);
        return result.sum;
    }
    
    /**
     * @return 倍数
     */
    private int dfs(TreeNode node, Result result)
    {
        if (null == node.left && null == node.right)
        {
            result.add(node.val);
            return 10;
        }
        
        if (null != node.left && null != node.right)
        {
            int leftMultiple = dfs(node.left, result);
            int rightMultiple = dfs(node.right, result);
            
            result.add(node.val, leftMultiple + rightMultiple);
            return 10 * (leftMultiple + rightMultiple);
        }
        
        int multiple = dfs(null != node.left ? node.left : node.right, result);
        result.add(node.val, multiple);
        return 10 * multiple;
    }
    
    private static class Result
    {
        private int sum = 0;
        
        private void add(int value)
        {
            sum += value;
        }
        
        private void add(int value, int multiple)
        {
            sum += (value * multiple);
        }
    }
}
