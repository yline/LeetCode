package com.test.base;

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
public interface Solution
{
    public int largestRectangleArea(int[] heights);
}
