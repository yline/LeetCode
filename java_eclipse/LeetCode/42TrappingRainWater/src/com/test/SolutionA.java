package com.test;

import com.test.base.Solution;

/**
 * 1,第一次遍历，从左往右；找到每一个阶梯点（只考虑上升）[记录最高点，以及总和]
 * 2,第二次遍历，从右往左；找到每一个阶梯点（只考虑上升）[到最高点即可停止]
 * 
 * 3,使用每个最高点，计算阶梯总和，减去每个数的和，就是剩余的量
 * 
 * 由于使用了乘法，并且遍历了两次，因此运行时间只超过了34.16%
 * 
 * @author YLine
 *
 * 2018年11月16日 下午4:06:07
 */
public class SolutionA implements Solution
{
    @Override
    public int trap(int[] height)
    {
        if (null == height || height.length < 3)
        {
            return 0;
        }
        
        // 从左侧开始遍历
        int unTrapValue = height[0]; // 未加水的总和
        int trapValue = 0;
        
        int lastLeftIndex = 0; // 上一个上高的位置
        for (int i = 1; i < height.length; i++)
        {
            unTrapValue += height[i];
            if (height[i] > height[lastLeftIndex]) // 明显是阶梯
            {
                trapValue += height[lastLeftIndex] * (i - lastLeftIndex);
                lastLeftIndex = i;
            }
        }
        
        // 从右侧开始遍历
        int lastRightIndex = height.length - 1;
        for (int i = height.length - 2; i >= lastLeftIndex; i--)
        {
            if (height[i] > height[lastRightIndex]) // 明显是阶梯
            {
                trapValue += height[lastRightIndex] * (lastRightIndex - i);
                lastRightIndex = i;
            }
        }
        
        trapValue += height[lastLeftIndex] * (lastRightIndex - lastLeftIndex + 1);
        return trapValue - unTrapValue;
    }
}
