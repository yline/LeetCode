package com.test;

import com.test.base.Solution;

/**
 * 桶概念的使用
 * @author YLine
 *
 * 2018年11月13日 下午8:05:34
 */
public class SolutionA implements Solution
{
    
    @Override
    public int firstMissingPositive(int[] nums)
    {
        // 入口校验
        if (null == nums || nums.length == 0)
        {
            return 1;
        }
        
        // 遍历n，记录标记量
        boolean[] signArray = new boolean[nums.length];
        for (int i : nums)
        {
            if (i <= nums.length && i > 0)
            {
                signArray[i - 1] = true;
            }
        }
        
        // 遍历n是否存在标记量
        for (int i = 0; i < signArray.length; i++)
        {
            if (!signArray[i])
            {
                return i + 1;
            }
        }
        
        return signArray.length + 1;
    }
}
