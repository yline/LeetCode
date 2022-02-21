package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 解题思路：
 * 将链表转成ArrayList，然后比较
 * 
 * 时间复杂度
 * n
 * 
 * 空间复杂度为n
 * 
 * @author YLine
 *
 * 2018年7月24日 下午4:33:17
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean isPalindrome(ListNode head)
    {
        if (null == head)
        {
            return true;
        }
        
        List<Integer> nodeArrayList = new ArrayList<>();
        ListNode temp = head;
        while (null != temp)
        {
            nodeArrayList.add(temp.val);
            temp = temp.next;
        }
        
        return isArrayPalindrome(nodeArrayList);
    }
    
    private boolean isArrayPalindrome(List<Integer> nums)
    {
        int left = 0, right = nums.size() - 1;
        while (left < right)
        {
            if (nums.get(left).intValue() != nums.get(right).intValue())
            {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
}
