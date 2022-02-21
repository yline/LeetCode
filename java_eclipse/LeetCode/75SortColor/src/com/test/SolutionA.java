package com.test;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to
 * represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * @author YLine
 *
 * 2019年7月25日 下午2:57:57
 */
public class SolutionA
{
    public void sortColors(int[] nums)
    {
        int redLength = 0, whiteLength = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 1)
            {
                swap(nums, redLength + whiteLength, i);
                whiteLength++;
            }
            else if (nums[i] == 0)
            {
                swap(nums, redLength + whiteLength, i);
                swap(nums, redLength, redLength + whiteLength);
                redLength++;
            }
        }
    }
    
    /**
     * 交换位置
     * @param nums 数组
     * @param aIndex 第一个下标
     * @param bIndex 第二个下表
     */
    private void swap(int[] nums, int aIndex, int bIndex)
    {
        if (aIndex != bIndex)
        {
            int temp = nums[aIndex];
            nums[aIndex] = nums[bIndex];
            nums[bIndex] = temp;
        }
    }
}
