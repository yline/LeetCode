package com.test;

import com.test.base.Solution;

/**
 * 耗时最少的策略
 * 遍历一次，两侧向中间聚拢，边聚拢边加法计算
 * 
 * @author YLine
 *
 * 2018年11月16日 下午5:16:00
 */
public class SolutionB implements Solution
{
    
    @Override
    public int trap(int[] height)
    {
        if (height == null || height.length < 3)
        {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        
        int result = 0;
        while (left <= right)
        {
            if (leftMax <= rightMax)
            {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                
                left++;
            }
            else
            {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                
                right--;
            }
        }
        
        return result;
    }
}
