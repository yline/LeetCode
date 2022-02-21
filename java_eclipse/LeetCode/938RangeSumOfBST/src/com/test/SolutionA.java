package com.test;

import com.test.base.TreeNode;

/**
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).
 * 
 * The binary search tree is guaranteed to have unique values.
 * 
 * @author YLine
 *
 * 2019年10月16日 下午1:31:01
 */
public class SolutionA
{
    public int rangeSumBST(TreeNode root, int L, int R)
    {
        if (null == root)
        {
            return 0;
        }
        
        if (root.val < L)
        {
            return rangeSumBST(root.right, L, R);
        }
        
        if (root.val > R)
        {
            return rangeSumBST(root.left, L, R);
        }
        
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
