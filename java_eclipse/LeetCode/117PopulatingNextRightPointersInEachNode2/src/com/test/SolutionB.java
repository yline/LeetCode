package com.test;

import com.test.base.Solution;
import com.test.base.TreeLinkNode;

/**
 * 比较 116 多了复杂的判断，空间复杂度O(1)
 * @author YLine
 *
 * 2018年12月10日 下午4:27:41
 */
public class SolutionB implements Solution
{
    @Override
    public void connect(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }
        
        if (root.left != null)
        {
            if (root.right != null)
            {
                root.left.next = root.right;
            }
            else
            {
                TreeLinkNode temp = root.next;
                while (temp != null)
                {
                    if (temp.left != null || temp.right != null)
                    {
                        root.left.next = temp.left != null ? temp.left : temp.right;
                        break;
                    }
                    else
                    {
                        temp = temp.next;
                    }
                }
            }
        }
        
        if (root.right != null)
        {
            TreeLinkNode temp = root.next;
            while (temp != null)
            {
                if (temp.left != null || temp.right != null)
                {
                    root.right.next = temp.left != null ? temp.left : temp.right;
                    break;
                }
                else
                {
                    temp = temp.next;
                }
            }
        }
        connect(root.right);
        connect(root.left);
        
    }
}
