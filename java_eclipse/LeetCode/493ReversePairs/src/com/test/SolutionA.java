package com.test;

import java.util.Comparator;
import java.util.TreeMap;

import com.test.base.Solution;

/**
 * 方案1：直接暴力遍历，从头到尾
 * 
 * 方案2：在方案1上优化，可优化的点，
 * 1) 从前往后遍历，如果有相同的，则记录个数，防止重复遍历
 * 2) 从前往后遍历，记录之前某个值，从[1, x]的结果值，从而直接从下一个开始遍历，防止重复遍历 // 之后遍历的是key，因此不适用
 * 3) 从前往后遍历，将key进行排序，从大到小遍历，一旦不满足，则退出
 * 
 * 执行超时
 * 缺点：
 * 1）每次插入一个值，treeMap维持排序需要耗费时间
 * 2) 如果，所有值都不一样，则时间复杂度，退化到了O(n*n)
 * 
 * @author YLine
 *
 * 2019年5月29日 上午9:40:14
 */
public class SolutionA implements Solution
{
    @Override
    public int reversePairs(int[] nums)
    {
        if (nums.length < 2)
        {
            return 0;
        }
        
        // key -> 数组的内容，value -> [内容的个数]
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>()
        {
            
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (o2 - o1);
            }
        });
        
        int result = 0;
        treeMap.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++)
        {
            // 从大到小出现的
            for (int key : treeMap.keySet())
            {
                if (key - nums[i] > nums[i]) // 解决数组越界异常
                {
                    result += treeMap.get(key);
                }
                else // 一旦不满足了，后面就都不满足了
                {
                    break;
                }
            }
            
            Integer value = treeMap.get(nums[i]);
            treeMap.put(nums[i], null == value ? 1 : value + 1);
        }
        
        return result;
    }
    
}
