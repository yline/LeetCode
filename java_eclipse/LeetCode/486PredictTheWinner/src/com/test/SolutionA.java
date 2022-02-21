package com.test;

import com.test.base.Solution;

/**
 * 用回溯法，依次遍历；
 * 
 * 函数f(0,x)表示，A选手开始选择，能相对B选手，的最大差值，肯定越大越好
 * 
 * 第一次，A选，要最大化自己的利益
 * f(0,x) = oneOf{a[0] - f(1,x), a[x] - f(0,x-1)}; 对A来说，肯定是两者中的其中一个
 * 
 * 而接下来B选，肯定也是剩余两者中的一个
 * f(1,x) = oneOf{a[1] - f(2,x), a[x] - f(1,x-1)}; 当A选择第一个时，B的结果肯定两者中的其中一个
 * f(0,x-1) = oneOf{a[0] - f(1,x-1), a[x-1] - f(0,x-2)}; 当A选择第二个时，B的结果肯定是两者中的其中一个
 * 
 * 因此，对于f(0,x)，合并一下，为
 * f(0, x) = max{
 * a[0] - max{a[1] - f(2,x), a[x] - f(1,x-1)},
 * a[x] - max{a[0] - f(1,x-1), a[x-1] - f(0,x-2)}
 * }
 * 
 * @author YLine
 *
 * 2019年5月5日 下午7:12:04
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean PredictTheWinner(int[] nums)
    {
        int[][] matrix = new int[nums.length][nums.length];
        int result = dfs(matrix, nums, 0, nums.length - 1);
        
        System.out.println("result = " + result);
        return (result >= 0);
    }
    
    private int dfs(int[][] matrix, int[] nums, int x, int y)
    {
        // 边际条件
        if (x == y)
        {
            return nums[x];
        }
        
        if (x + 1 == y)
        {
            return Math.max(nums[x], nums[y]);
        }
        
        // 利用缓存，直接返回
        if (matrix[x][y] != 0)
        {
            return matrix[x][y];
        }
        
        // 利用缓存减少一次计算
        int b1 = (matrix[x + 2][y] != 0 ? matrix[x + 2][y] : dfs(matrix, nums, x + 2, y));
        int b2 = (matrix[x + 1][y - 1] != 0 ? matrix[x + 1][y - 1] : dfs(matrix, nums, x + 1, y - 1));
        int b3 = (matrix[x][y - 2] != 0 ? matrix[x][y - 2] : dfs(matrix, nums, x, y - 2));
        
        // 计算实际的最大化的值
        int aFirst = nums[x] - Math.max(nums[x + 1] - b1, nums[y] - b2);
        int aSecond = nums[y] - Math.max(nums[x] - b2, nums[y - 1] - b3);
        matrix[x][y] = Math.max(aFirst, aSecond);
        return matrix[x][y];
    }
}
