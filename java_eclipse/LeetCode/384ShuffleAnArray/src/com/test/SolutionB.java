package com.test;

import com.test.base.Solution;

/**
 * 每一个有 1/length 可能交换，则出现的序列总的可能性就是 1/总数；因为均分
 * 
 * 但这个均分是理论上的，实际上，小数的情况下，并不会出现很均匀的均分
 * @author YLine
 *
 * 2019年2月2日 上午12:38:58
 */
public class SolutionB extends Solution
{
    private int[] nums;
    
    public SolutionB(int[] nums)
    {
        super(nums);
        this.nums = nums;
    }
    
    @Override
    public int[] reset()
    {
        return nums;
    }
    
    @Override
    public int[] shuffle()
    {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            // 可能性
            int r = (int)(Math.random() * (i + 1));
            
            // 交换
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }
    
}
