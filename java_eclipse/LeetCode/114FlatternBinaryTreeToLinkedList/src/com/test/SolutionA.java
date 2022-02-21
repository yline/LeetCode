package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 成块讨论后，DFS 函数更加清晰
 * @author YLine
 *
 * 2018年11月29日 上午9:23:41
 */
public class SolutionA implements Solution
{
    
    @Override
    public void flatten(TreeNode root)
    {
        if (null == root)
        {
            return;
        }
        
        dfs(root, root.left, root.right);
    }
    
    /**
     * @param root 块中心
     * @param left 块的左侧
     * @param right 块的右侧
     * @return 某一块按照规则的最后一个 TreeNode【一定不为null】
     */
    private TreeNode dfs(TreeNode root, TreeNode left, TreeNode right)
    {
        if (null == left)
        {
            if (null == right)
            {
                return root;
            }
            else
            {
                return dfs(right, right.left, right.right);
            }
        }
        else
        {
            if (null == right)
            {
                root.right = left;
                root.left = null;
                return dfs(left, left.left, left.right);
            }
            else
            {
                TreeNode leftLast = dfs(left, left.left, left.right);
                root.right = left;
                root.left = null;
                
                leftLast.right = right;
                return dfs(right, right.left, right.right);
            }
        }
    }
}
