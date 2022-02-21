package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 函數：
 * 坑点：如果是单值走下去，不算终止
 * 
 * @author YLine
 *
 * 2018年11月26日 下午9:09:22
 */
public class SolutionA implements Solution
{
    @Override
    public int minDepth(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        
        return dfs(root);
    }
    
    /**
     * @param node 节点
     * @return 最小值
     */
    private int dfs(TreeNode node)
    {
        if (null == node)
        {
            return 0;
        }
        
        if (null == node.left)
        {
            if (null == node.right)
            {
                return 1;
            }
            else
            {
                return 1 + dfs(node.right);
            }
        }
        else
        {
            if (null == node.right)
            {
                return 1 + dfs(node.left);
            }
            else
            {
                return 1 + Math.min(dfs(node.left), dfs(node.right));
            }
        }
    }
}
