package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 别人的，耗时 1ms，应该是计算单次计算次数少导致的
 * @author YLine
 *
 * 2018年11月23日 下午6:20:34
 */
public class SolutionB implements Solution
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder.length == 0)
        {
            return null;
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight)
    {
        if (preLeft == preorder.length)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight)
        {
            return root;
        }
        
        for (int index = inRight; index >= inLeft; index--)
        {
            if (preorder[preLeft] == inorder[index])
            {
                int length = index - inLeft;
                root.left = dfs(preorder, inorder, preLeft + 1, preLeft + length, inLeft, index - 1);
                root.right = dfs(preorder, inorder, preLeft + length + 1, preRight, index + 1, inRight);
                return root;
            }
        }
        return null;
    }
}
