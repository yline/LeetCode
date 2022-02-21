package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 时间复杂度为 O(n*log(n))
 * 空间复杂度为O(1)
 * 
 * 思路和SolutionA一样，只是增加了时间复杂度，每次log(n)去求前一个
 * 
 * @author YLine
 *
 * 2019年9月25日 下午2:17:49
 */
public class SolutionB implements Solution
{
    
    @Override
    public void recoverTree(TreeNode root)
    {
        // predecessor is a Morris predecessor.
        // In the 'loop' cases it could be equal to the node itself predecessor == root.
        // pred is a 'true' predecessor,
        // the previous node in the inorder traversal.
        TreeNode first = null, second = null;
        TreeNode pred = null, predecessor = null;
        
        TreeNode temp = root;
        while (temp != null)
        {
            // If there is a left child
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (temp.left != null) // 左分支
            {
                // Predecessor node is one step left
                // and then right till you can.
                predecessor = temp.left; // 求得当前root的前一个
                while (predecessor.right != null && predecessor.right != temp)
                {
                    predecessor = predecessor.right;
                }
                
                // set link predecessor.right = root
                // and go to explore left subtree
                if (predecessor.right == null)
                {
                    predecessor.right = temp;
                    temp = temp.left;
                }
                // break link predecessor.right = root
                // link is broken : time to change subtree and go right
                else
                {
                    // check for the swapped nodes
                    if (pred != null && temp.val < pred.val)
                    {
                        second = temp;
                        if (first == null)
                        {
                            first = pred;
                        }
                    }
                    pred = temp;
                    
                    predecessor.right = null;
                    temp = temp.right;
                }
            }
            // If there is no left child
            // then just go right.
            else
            {
                // check for the swapped nodes
                if (pred != null && temp.val < pred.val)
                {
                    second = temp;
                    if (first == null)
                    {
                        first = pred;
                    }
                }
                pred = temp;
                
                temp = temp.right;
            }
        }
        
        swap(first, second);
    }
    
    public void swap(TreeNode a, TreeNode b)
    {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    
}
