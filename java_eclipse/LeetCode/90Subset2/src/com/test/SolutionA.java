package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * 1，排序
 * 2，处理相同的内容，处理成List<List<Integer>>
 * 3，01递归，处理成最终结果
 * 
 * @author YLine
 *
 * 2019年9月2日 上午9:58:05
 */
public class SolutionA
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        if (null == nums)
        {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
        {
            result.add(new ArrayList<>());
            return result;
        }
        
        // 排序
        Arrays.sort(nums);
        
        // 处理相同的内容
        List<Integer> valueList = new ArrayList<>();
        List<Integer> duplicateList = new ArrayList<>();
        
        int value = nums[0], duplicate = 1;
        int numIndex = 1;
        while (numIndex < nums.length)
        {
            if (value == nums[numIndex])
            {
                duplicate++;
            }
            else
            {
                valueList.add(value);
                duplicateList.add(duplicate);
                
                value = nums[numIndex];
                duplicate = 1;
            }
            
            numIndex++;
        }
        valueList.add(value);
        duplicateList.add(duplicate);

        // 01递归，处理成最终结果
        build(result, valueList, duplicateList, new ArrayList<>(), 0);

        return result;
    }
    
    private void build(List<List<Integer>> result, List<Integer> valueList, List<Integer> duplicateList,
        List<Integer> temp, int index)
    {
        if (index == valueList.size())
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // 0
        build(result, valueList, duplicateList, temp, index + 1);
        
        // 1
        for (int i = 0; i < duplicateList.get(index); i++)
        {
            for (int j = 0; j <= i; j++)
            {
                temp.add(valueList.get(index));
            }
            
            build(result, valueList, duplicateList, temp, index + 1);
            
            for (int j = 0; j <= i; j++)
            {
                temp.remove(valueList.get(index));
            }
        }
    }
}
