package com.test.base;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * 找最短路径，动态规划最初级
 * 而且不需要记录路径
 * 
 * @author YLine
 *
 * 2019年5月24日 下午4:15:28
 */
public interface Solution
{
    public int minPathSum(int[][] grid);
}
