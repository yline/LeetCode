package com.test;

import com.test.base.ListNode;

/**
 * 
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 给一个链表和x，比x小的，在左边，比x大的在右边
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 原始顺序不变
 * 
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * @author YLine
 *
 * 2019年8月30日 上午9:53:20
 */
public class SolutionA
{
    public ListNode partition(ListNode head, int x)
    {
        ListNode leftNode = new ListNode(-1);
        ListNode rightNode = new ListNode(-1);

        ListNode temp = head, leftTemp = leftNode, rightTemp = rightNode;
        while (null != temp)
        {
            if (temp.val < x)
            {
                leftTemp.next = temp;
                leftTemp = leftTemp.next;
            }
            else
            {
                rightTemp.next = temp;
                rightTemp = rightTemp.next;
            }
            temp = temp.next;
        }
        
        // 清除掉"尾巴"
        leftTemp.next = null;
        rightTemp.next = null;
        
        // 链接起来
        leftTemp.next = rightNode.next;
        
        return leftNode.next;
    }
}
