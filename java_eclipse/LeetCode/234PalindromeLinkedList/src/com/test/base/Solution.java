package com.test.base;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 给定一个单向的链表，判断是否是回文
 * 
 * Example 1:
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 空间复杂度是 n和1，都实现一份
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:34:27
 */
public interface Solution
{
    public boolean isPalindrome(ListNode head);
}
