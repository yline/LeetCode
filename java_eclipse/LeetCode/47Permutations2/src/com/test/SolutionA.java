package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> data, int[] nums, int start)
    {
        if (start == nums.length)
        {
            result.add(new ArrayList<>(data));
        }
        
        HashSet<Integer> hashSet = new HashSet<>(); // 一个循环，就不会重新创建
        for (int i = start; i < nums.length; i++)
        {
            if (hashSet.contains(nums[i])) // 使用hashSet，以便区分；乱序
            {
                continue;
            }
            else
            {
                hashSet.add(nums[i]);
            }
            
            data.add(nums[i]);
            swap(nums, start, i);
            
            dfs(result, data, nums, start + 1);
            
            swap(nums, start, i);
            data.remove(data.size() - 1);
        }
    }
    
    private void swap(int[] nums, int one, int two)
    {
        if (nums[one] != nums[two])
        {
            int temp = nums[one];
            nums[one] = nums[two];
            nums[two] = temp;
        }
    }
}
