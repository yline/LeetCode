package com.test;

import com.test.base.Solution;

/**
 * 
 * @author YLine
 *
 * 2019年5月9日 上午8:25:07
 */
public class SolutionA implements Solution
{
    
    @Override
    public int minPathSum(int[][] grid)
    {
        if (grid.length == 0)
        {
            return 0;
        }
        
        // 第一列初始化
        for (int x = 1; x < grid.length; x++)
        {
            grid[x][0] += grid[x - 1][0];
        }
        
        // 第一行初始化
        for (int y = 1; y < grid[0].length; y++)
        {
            grid[0][y] += grid[0][y - 1];
        }
        
        // 行
        for (int x = 1; x < grid.length; x++)
        {
            // 列
            for (int y = 1; y < grid[x].length; y++)
            {
                grid[x][y] += Math.min(grid[x - 1][y], grid[x][y - 1]);
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
    
}
