package com.test;

import com.test.base.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if (0 == k || null == head)
        {
            return head;
        }
        
        // 遍历一次获取长度
        int length = 1;
        ListNode tempNode = head; // 遍历完成，tempNode就是尾节点
        while (null != tempNode.next)
        {
            tempNode = tempNode.next;
            length++;
        }
        
        System.out.println("length = " + length);
        
        tempNode.next = head; // 形成一个循环
        k = k % length; // 防止倍数过高，导致计算次数增加的问题
        
        // 断开的位置  + k = length - 1
        int rest = length - 1 - k;
        tempNode = head; // 再次开始遍历
        for (int i = 0; i < rest; i++)
        {
            tempNode = tempNode.next;
        }
        
        // 找到断开节点，断开节点下一个就是结果
        ListNode result = tempNode.next;
        tempNode.next = null;
        
        System.out.println("result = " + result.val);
        
        return result;
    }
}
