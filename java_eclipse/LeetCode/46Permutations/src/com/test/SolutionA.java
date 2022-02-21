package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * dfs 函数
 * 
 * 确定执行次数：n!次
 * 
 * 每次都将  已添加的数据和开始数据交换。（避免最后重复）
 * 
 * @author YLine
 *
 * 2018年11月28日 下午12:28:33
 */
public class SolutionA implements Solution
{
    @Override
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> data, int start)
    {
        if (start == nums.length)
        {
            result.add(new ArrayList<>(data));
        }
        
        for (int i = start; i < nums.length; i++)
        {
            data.add(nums[i]);
            swap(nums, i, start);
            
            dfs(result, nums, data, start + 1);
            
            swap(nums, i, start);
            data.remove(data.size() - 1);
        }
    }
    
    /**
     * 交换
     */
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
