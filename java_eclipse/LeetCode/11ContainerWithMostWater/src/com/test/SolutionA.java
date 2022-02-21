package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    /**
     *   额外条件:如果两边向中间移动
     * 1,左边移动,比先前地点低的,不需要移动
     * 2,右边移动,比先前地点低的,不需要移动
     * 3,左边和右边,移动较高的一边完全对于改变水容量完全没有意义
     * @param height
     * @return
     */
    @Override
    public int maxArea(int[] height)
    {
        if (null == height || height.length < 2)
        {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int maxResult = 0;
        while (left < right)
        {
            maxResult = Math.max(maxResult, (right - left) * Math.min(height[left], height[right]));
            
            if (height[left] < height[right])
            {
                // 移动左边
                int i = left + 1;
                for (; i <= right; i++)
                {
                    if (height[i] > height[left])
                    {
                        left = i;
                        break;
                    }
                }
                
                if (i >= right)
                {
                    return maxResult;
                }
            }
            else
            {
                // 移动右边
                int i = right - 1;
                for (; i >= left; i--)
                {
                    if (height[i] > height[right])
                    {
                        right = i;
                        break;
                    }
                }
                
                if (i <= left)
                {
                    return maxResult;
                }
            }
        }
        
        return maxResult;
    }
}
