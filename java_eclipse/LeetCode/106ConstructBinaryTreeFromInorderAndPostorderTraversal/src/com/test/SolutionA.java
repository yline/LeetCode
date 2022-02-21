package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * f(root, preorder, inorder, preleft, inleft, length)
 * （中、左、右）
 * （左、中、右）规则
 * 
 * 左右，全部满足，左闭右开原则
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    
    @Override
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if (inorder.length == 0)
        {
            return null;
        }
        
        TreeNode root = dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }
    
    private TreeNode dfs(int[] inorder, int inLeft, int inEnd, int[] postorder, int postLeft, int postEnd)
    {
        if (postLeft > postEnd)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        if (postLeft == postEnd)
        {
            return root;
        }
        
        for (int i = inEnd; i >= inLeft; i--)
        {
            if (inorder[i] == postorder[postEnd])
            {
                int leftLength = i - inLeft;
                root.left = dfs(inorder, inLeft, i - 1, postorder, postLeft, postLeft + leftLength - 1);
                
                int rightLength = inEnd - i;
                root.right = dfs(inorder, i + 1, inEnd, postorder, postEnd - rightLength, postEnd - 1);
            }
        }
        return root;
    }
}
