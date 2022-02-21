package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 普通 递归，没啥好说的
 * @author YLine
 *
 * 2019年5月5日 下午7:12:04
 */
public class SolutionA implements Solution
{
    private int mTotal;
    
    @Override
    public int sumRootToLeaf(TreeNode root)
    {
        mTotal = 0;
        dfs(root, 0);
        return mTotal;
    }
    
    private void dfs(TreeNode node, int result)
    {
        // 节点为空，直接不处理
        if (null == node)
        {
            return;
        }
        
        // 叶子结点
        if (null == node.left && null == node.right)
        {
            // 总和
            mTotal += ((result << 1) + node.val);
            System.out.println("result = " + result);
            return;
        }
        
        result = (result << 1) + node.val;
        if (null != node.left)
        {
            dfs(node.left, result);
        }
        
        if (null != node.right)
        {
            dfs(node.right, result);
        }
    }
    
}
