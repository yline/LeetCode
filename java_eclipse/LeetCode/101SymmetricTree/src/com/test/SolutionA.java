package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * f(left, right) = f(left.left, right.right) + f(left.right, rifht.left)
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    @Override
    public boolean isSymmetric(TreeNode root)
    {
        if (null == root)
        {
            return true;
        }
        
        return recurion(root.left, root.right);
    }
    
    private boolean recurion(TreeNode left, TreeNode right)
    {
        if (null == left && null == right)
        {
            return true;
        }
        
        if (null != left && null != right)
        {
            if (left.val != right.val)
            {
                return false;
            }
            return recurion(left.left, right.right) && recurion(left.right, right.left);
        }
        
        return false;
    }
}
