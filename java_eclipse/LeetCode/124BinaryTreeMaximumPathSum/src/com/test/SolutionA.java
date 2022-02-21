package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

public class SolutionA implements Solution
{
    
    @Override
    public int maxPathSum(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        
        return dfs(root)[1];
    }
    
    /**
     * 1,单向最大值；2,最大值；
     * @param node
     * @return
     */
    private int[] dfs(TreeNode node)
    {
        if (null == node.left)
        {
            if (null == node.right)
            {
                return new int[] {node.val, node.val};
            }
            else
            {
                // 单向最大值可能：node、node+rightThroughMax
                // 最大值可能：node、node+rightThroughMax、rightMax
                int[] rightResult = dfs(node.right);
                rightResult[0] = node.val + Math.max(rightResult[0], 0);
                rightResult[1] = Math.max(rightResult[0], rightResult[1]);
                return rightResult;
            }
        }
        else
        {
            if (null == node.right)
            {
                // 单向最大值可能：node、node+leftThroughMax
                // 最大值可能：node、node+leftThroughMax、leftMax
                int[] leftResult = dfs(node.left);
                leftResult[0] = node.val + Math.max(leftResult[0], 0);
                leftResult[1] = Math.max(leftResult[0], leftResult[1]);
                return leftResult;
            }
            else
            {
                // 单向最大值可能：node、node+leftThroughMax、node+rightThroughMax
                // 最大值可能：node、node+leftThroughMax、node+rightThroughMax、node+leftThroughMax+rightThroughMax、leftMax、rightMax
                int[] leftResult = dfs(node.left);
                int[] rightResult = dfs(node.right);
                
                int[] rootResult = new int[2];
                rootResult[0] = node.val + Math.max(Math.max(leftResult[0], rightResult[0]), 0);
                
                rootResult[1] = Math.max(Math.max(leftResult[1], rightResult[1]),
                    Math.max(rootResult[0], node.val + leftResult[0] + rightResult[0]));
                
                return rootResult;
            }
        }
    }
}
