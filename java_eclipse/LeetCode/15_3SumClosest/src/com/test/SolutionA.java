package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * 第一层n遍历，第二次夹逼原则，将两级遍历变成一级
 * 
 * 算法复杂度：n*log(n) + n*n = n*n
 * 
 * @author YLine
 *
 * 2018年8月13日 下午3:01:08
 */
public class SolutionA implements Solution
{
    @Override
    public int threeSumClosest(int[] nums, int target)
    {
        int result = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        
        // 传入数据 违规
        if (null == nums || nums.length < 3)
        {
            return result;
        }
        
        Arrays.sort(nums);
        
        int length = nums.length;
        
        int one = 0, two, three, tempTraget;
        while (length - one > 2)
        {
            two = one + 1;
            three = length - 1;
            
            while (two < three)
            {
                tempTraget = nums[one] + nums[two] + nums[three];
                if (tempTraget == target)
                {
                    return target;
                }
                else if (tempTraget < target)
                {
                    if (minDiff > target - tempTraget)
                    {
                        minDiff = target - tempTraget;
                        result = tempTraget;
                    }
                    
                    two++;
                }
                else
                {
                    if (minDiff > tempTraget - target)
                    {
                        minDiff = tempTraget - target;
                        result = tempTraget;
                    }
                    
                    three--;
                }
            }
            
            one++;
            while (length > one && nums[one] == nums[one - 1])
            {
                one++;
            }
        }
        
        return result;
    }
}
