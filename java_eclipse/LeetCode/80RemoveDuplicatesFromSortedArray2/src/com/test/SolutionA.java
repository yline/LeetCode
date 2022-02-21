package com.test;

/**
 * Given a sorted array nums,
 * .给一个排序好的数组
 * remove the duplicates in-place such
 * .移除重复的
 * that duplicates appeared at most twice and return the new length.
 * .重复最多出现两次，返回新的数组长度
 * 
 * Do not allocate extra space for another array,
 * .不允许申请额外的数组
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * .即：空间复杂度为O(1)
 * 
 * Example 1:
 * input: [1,1,1,2,2,3],
 * output: 5 = [1,1,2,2,3]
 * 
 * Example 2:
 * input: [0,0,1,1,1,1,2,3,3]
 * output: 7 = [0,0,1,1,2,3,3]
 * 
 * note:
 * .必须去修改num的值
 * 
 * @author YLine
 *
 * 2019年8月16日 上午9:35:58
 */
public class SolutionA
{
    public int removeDuplicates(int[] nums)
    {
        // 入参
        if (null == nums || nums.length == 0)
        {
            return 0;
        }
        
        int doubleSize = 0;
        
        int value = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == value) // 和上一个相同
            {
                if (count == 1)
                {
                    count = 2;
                }
                else
                {
                    doubleSize++;
                }
            }
            else
            {
                // 和上一个不同
                
                count = 1;
                value = nums[i];
            }
            
            // 值前移
            nums[i - doubleSize] = nums[i];
        }
        return nums.length - doubleSize;
    }
}
