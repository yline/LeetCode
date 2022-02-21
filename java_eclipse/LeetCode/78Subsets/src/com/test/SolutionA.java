package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 给一个正整数集合，返回所有的子集
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 子集不重复出现
 * 
 * @author YLine
 *
 * 2019年7月31日 上午10:28:18
 */
public class SolutionA
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        boolean[] select = new boolean[nums.length];
        for (int i = 1; i <= nums.length; i++)
        {
            Arrays.fill(select, false);
            dfs(result, nums, select, i, 0, 0);
        }
        return result;
    }
    
    /**
     * @param k 需要选中的个数
     * @param selectSize 当前选中的个数
     */
    private void dfs(List<List<Integer>> result, int[] nums, boolean[] select, int size, int selectSize, int deep)
    {
        if (selectSize > size)
        {
            return;
        }
        
        if (selectSize == size)
        {
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < select.length; i++)
            {
                if (select[i])
                {
                    temp.add(nums[i]);
                }
            }
            result.add(temp);
            return;
        }
        
        if (deep < nums.length)
        {
            // 不选择，继续
            dfs(result, nums, select, size, selectSize, deep + 1);
            
            // 选择，继续
            select[deep] = true;
            dfs(result, nums, select, size, selectSize + 1, deep + 1);
            select[deep] = false;
        }
    }
}
