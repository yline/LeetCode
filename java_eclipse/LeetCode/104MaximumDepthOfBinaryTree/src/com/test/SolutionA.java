package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * f(root, level) = Math.max(f(root.left, level+1), f(root.right, level+1));
 * 
 * 1，先递归添加
 * 2，递归后，对于奇数，进行颠倒
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    @Override
    public int maxDepth(TreeNode root)
    {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int level)
    {
        if (null == node)
        {
            return level;
        }
        else
        {
            return Math.max(dfs(node.left, level + 1), dfs(node.right, level + 1));
        }
    }
}
