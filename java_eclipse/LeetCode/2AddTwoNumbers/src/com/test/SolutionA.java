package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 解题思路：
 * 将两个链表，逐个相加()
 * 
 * 算法复杂度：
 * O(n)
 * 
 * @author YLine
 *
 * 2016年12月22日 下午1:21:36
 */
public class SolutionA implements Solution
{
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode root = new ListNode(0); // 头结点
        ListNode r = root; // 这种赋值就是地址赋值
        r.next = l1; // 这一个赋值,会导致r 和 root都改变内容
        
        int carry = 0; // 初始进位
        int sum;
        while (l1 != null && l2 != null)
        {
            sum = l1.val + l2.val + carry;
            l1.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位
            
            r.next = l1; // 其实只是使用当前节点的值
            r = r.next; // 利用引用，对新链表进行赋值
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null)
        {
            r.next = l2;
        }
        else
        {
            r.next = l1;
        }
        
        // 最后一次相加还有进位
        if (carry == 1)
        {
            // 开始时r.next是第一个要相加的结点
            while (r.next != null)
            {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }
            
            // 都加完了还有进位，就要创建一个新的结点
            if (carry == 1)
            {
                r.next = new ListNode(1);
            }
        }
        return root.next;
    }
}
