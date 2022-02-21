package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * 方案：递推
 * 
 * 案例：{2,3,6,7}  target = 7
 * 1 --> 2,2,2,2 
 * 2 --> 2,2,3 通过添加
 * 3 --> 2,3,3 排除
 * 4 --> 2,6 排除
 * 5 --> 3,3,3 排除
 * 6 --> 3,6   排除
 * 7 --> 6,6   排除
 * 8 --> 7 通过，添加；结束
 * 
 * @author YLine
 *
 * 2018年11月12日 下午8:09:22
 */
public class SolutionA implements Solution
{
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        int rightMax = getMaxIndex(candidates, target);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        
        int tempResult = 0;
        
        int index = 0;
        while (index <= rightMax)
        {
            if (tempResult + candidates[index] >= target)
            {
                // 添加内容
                if (tempResult + candidates[index] == target)
                {
                    List<Integer> array = new ArrayList<>();
                    for (Integer integer : tempList)
                    {
                        array.add(candidates[integer]);
                    }
                    array.add(candidates[index]);
                    result.add(array);
                }
                
                // 处理
                if (tempList.isEmpty())
                {
                    return result;
                }
                else
                {
                    // 更新
                    index = tempList.get(tempList.size() - 1); // 获取最后一个添加的index
                    tempList.remove(tempList.size() - 1); // 移除数组的最后一个index
                    tempResult -= candidates[index]; // 修改当前结果值
                    
                    index++;
                    
                    // 排除，2,5,5 --> 8 这种情况，直接index过界，再往后退一步
                    while (!tempList.isEmpty() && index > rightMax)
                    {
                        index = tempList.get(tempList.size() - 1);
                        tempList.remove(tempList.size() - 1);
                        tempResult -= candidates[index];
                        
                        index++;
                    }
                }
            }
            else
            {
                tempResult += candidates[index];
                tempList.add(index);
            }
        }
        
        return result;
    }
    
    /**
     * 获取 数组中 比较目标值，最大的值
     * 防止超越最大值，超越目标值，导致的没必要的多次循环
     * 
     * @param candidates 数组
     * @param target 目标值
     * @return 最右侧的值
     */
    private int getMaxIndex(int[] candidates, int target)
    {
        for (int i = candidates.length - 1; i >= 0; i--)
        {
            if (candidates[i] <= target)
            {
                return i;
            }
        }
        return 0;
    }
    
}
