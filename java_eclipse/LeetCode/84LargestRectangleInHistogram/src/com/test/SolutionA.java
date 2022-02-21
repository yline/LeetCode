package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 * 给一个数组，求面积最大的矩形
 * 
 * 思路：
 * 1，先想递归，怎么做
 * 2，通过递归，想到动态规划
 * 
 * 求的结果是，若下标为x，y，则 (y - x + 1) * minFunction(x, y)
 * 
 * minFuntion(x, y) 表示，[x, y]上的最小值
 * 
 * 时间复杂度：n*n
 * 空间复杂度：n
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA implements Solution
{
    @Override
    public int largestRectangleArea(int[] heights)
    {
        // 储存的是，[x，max]的最小值
        int[] minArray = new int[heights.length];
        Arrays.fill(minArray, Integer.MAX_VALUE);
        
        int max = 0;
        
        // 全部遍历
        for (int i = 0; i < minArray.length; i++)
        {
            updateMinArray(minArray, i, heights[i]);
            max = updateMaxValue(minArray, i, heights[i], max);
        }
        
        return max;
    }
    
    private void updateMinArray(int[] minArray, int index, int value)
    {
        for (int i = 0; i <= index; i++)
        {
            minArray[i] = Math.min(minArray[i], value);
        }
    }
    
    private int updateMaxValue(int[] minArray, int index, int value, int max)
    {
        for (int i = 0; i <= index; i++)
        {
            max = Math.max(max, (index - i + 1) * minArray[i]);
        }
        
        // System.out.println("index = " + index + ", max = " + max);
        return max;
    }
}
