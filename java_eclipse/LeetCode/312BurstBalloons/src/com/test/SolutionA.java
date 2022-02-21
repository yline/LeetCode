package com.test;

import java.util.HashMap;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public int maxCoins(int[] nums)
    {
        if (null == nums)
        {
            return 0;
        }
        
        // i表示，当前路径下，最后一个气球
        return fun(nums, 0, nums.length - 1);
    }
    
    private HashMap<Integer, Integer> cache = new HashMap<>();
    
    private int fun(int[] nums, int start, int end)
    {
        if (start > end)
        {
            return 0;
        }
        
        final int key = start * nums.length + end;
        // 读取缓存
        Integer value = cache.get(key);
        if (null != value)
        {
            return value;
        }
        
        final int startBorder = start == 0 ? 1 : nums[start - 1];
        final int endBorder = end == nums.length - 1 ? 1 : nums[end + 1];
        
        // i表示，当前路径下，最后一个气球
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++)
        {
            int tempMax = fun(nums, start, i - 1) + startBorder * nums[i] * endBorder + fun(nums, i + 1, end);
            max = Math.max(max, tempMax);
        }
        
        // 存入缓存
        cache.put(key, max);
        return max;
    }

    
}
