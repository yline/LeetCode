package com.test.base;

public class ListNodeUtils
{
    public static ListNode buildListNode(int... array)
    {
        ListNode result = new ListNode(-1);
        
        ListNode temp = result;
        for (int i = 0; i < array.length; i++)
        {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        
        return result.next;
    }
    
    public static void print(ListNode head)
    {
        StringBuilder sBuilder = new StringBuilder("->");
        ListNode temp = head;
        while (null != temp)
        {
            sBuilder.append(temp.val);
            sBuilder.append("->");
            temp = temp.next;
        }
        System.out.println(sBuilder.toString());
    }
    
    /**
     * 会破坏原有链表
     * @param head 原始链表
     * @return 反转后的内容
     */
    public static ListNode reverse(ListNode head)
    {
        if (null == head)
        {
            return null;
        }
        
        ListNode result = new ListNode(-1);
        result.next = head;
        
        // 开始反转
        ListNode right = head;
        while (null != right.next)
        {
            ListNode left = right.next;
            
            right.next = left.next; // 右侧倒数第二个，断开
            left.next = result.next; // 右侧倒数第一个，断开
            result.next = left; // 插入左侧第一个
        }
        
        return result.next;
    }
}
