package com.test.base;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 * 在一个二维矩阵上，放置一些点，每个点最多有一个值
 * 
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * 然后，如果点的行或列相同，可以移除一些点
 * 
 * What is the largest possible number of moves we can make?
 * 请问，最多可以移除多少个点
 * 
 * 点 个数范围：
 * 1 <= stones.length <= 1000
 * 点 大小范围：
 * 0 <= stones[i][j] < 10000
 * 
 * @author YLine
 *
 * 2019年6月3日 上午10:17:29
 */
public interface Solution
{
    public int removeStones(int[][] stones);
}
