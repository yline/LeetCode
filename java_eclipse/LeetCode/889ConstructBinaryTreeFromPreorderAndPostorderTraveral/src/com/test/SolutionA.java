package com.test;

import com.test.base.TreeNode;

/**
 * Return any binary tree that matches the given preorder and postorder traversals.
 * 给前序和后序，返回一个二叉树
 * 
 * Values in the traversals pre and post are distinct positive integers.
 * 所有值，都是正整数
 * 
 * @author YLine
 *
 * 2019年6月17日 下午7:31:56
 */
public class SolutionA
{
    public TreeNode constructFromPrePost(int[] pre, int[] post)
    {
        return construct(pre, post, 0, 0, pre.length);
    }
    
    private TreeNode construct(int[] pre, int[] post, int preStart, int postStart, int length)
    {
        if (length <= 0)
        {
            return null;
        }
        
        if (length == 1)
        {
            return new TreeNode(pre[preStart]);
        }
        
        TreeNode node = new TreeNode(pre[preStart]);
        int next = findNext(pre, post, preStart, postStart, length);
        
        node.left = construct(pre, post, preStart + 1, postStart, next + 1);
        node.right = construct(pre, post, preStart + next + 2, postStart + next + 1, length - next - 2);
        
        return node;
    }
    
    private int findNext(int[] pre, int[] post, int preStart, int postStart, int length)
    {
        final int nextCenter = pre[preStart + 1];
        for (int i = 0; i < length; i++)
        {
            if (nextCenter == post[postStart + i])
            {
                return i;
            }
        }
        
        return -1;
    }
}
