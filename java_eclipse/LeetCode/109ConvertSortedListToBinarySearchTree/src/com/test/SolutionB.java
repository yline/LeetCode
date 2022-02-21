package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 每次都全量遍历，然后，分段成 二叉树
 * 
 * 时间复杂度：
 * n + 2*n/2 + 4*n/4 = n*log2(n)
 * 空间复杂度：
 * O(1)
 * 
 * @author YLine
 *
 * 2018年11月26日 下午8:40:29
 */
public class SolutionB implements Solution
{
    @Override
    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        
        if (head.next == null)
        {
            return new TreeNode(head.val);
        }
        
        ListNode fast = head; // 结尾值
        ListNode slow = head; // 中间值
        ListNode pre = head;
        
        while (fast != null && fast.next != null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow becomes the root, break the list
        ListNode second = slow.next; // 下一段的开始值
        pre.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(second);
        root.left = sortedListToBST(head);
        
        return root;
    }
}
