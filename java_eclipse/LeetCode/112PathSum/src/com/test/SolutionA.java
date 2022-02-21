package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 函数
 * 不能中间断开，因为可能为负数
 * 
 * 坑点：末尾处理，如果 直接或递归，倒数第二个也可能会被加载
 * 
 * @author YLine
 *
 * 2018年11月26日 下午9:09:22
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (null == root)
        {
            return false;
        }
        
        return dfs(root, sum, 0);
    }
    
    private boolean dfs(TreeNode node, int sum, int value)
    {
        value += node.val;
        if (null == node.left)
        {
            if (null == node.right)
            {
                return (sum == value);
            }
            else
            {
                return dfs(node.right, sum, value);
            }
        }
        else
        {
            if (null == node.right)
            {
                return dfs(node.left, sum, value);
            }
            else
            {
                return dfs(node.left, sum, value) || dfs(node.right, sum, value);
            }
        }
    }
    
}
