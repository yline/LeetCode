package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int reverseBits(int n)
    {
        // 每个int类型都是32位 【0,1】,初始化都是false
        boolean[] dataNums = new boolean[32];
        
        // 0位个位，31为首位
        int index = 0;
        while (0 != n && index < 32)
        {
            dataNums[index] = (n & 1) == 0 ? false : true;
            n = n >> 1;
            index++;
        }
        print(dataNums);
        
        // true为负数，false为正数
        int result = 0, multiply = 1;
        for (int i = dataNums.length - 1; i >= 0; i--)
        {
            if (dataNums[i])
            {
                result += multiply;
            }
            multiply = multiply << 1;
        }
        return result;
    }
    
    private void print(boolean[] nums)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
        {
            stringBuilder.append(nums[i] ? 1 : 0);
        }
        System.out.println(stringBuilder.toString());
    }
    
}
