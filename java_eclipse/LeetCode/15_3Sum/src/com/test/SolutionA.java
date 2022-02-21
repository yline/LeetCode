package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * 三层遍历
 * 
 * 算法复杂度：n*log(n) + n*n*n = n*n*n
 * 
 * @author YLine
 *
 * 2018年8月13日 下午2:31:37
 */
public class SolutionA implements Solution
{
    /**
     * 暴力 遍历，复杂度高了
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        int first = 0, tempFirst;
        int tempOpposite;
        int length = nums.length;
        
        Arrays.sort(nums);
        
        if (length < 3)
        {
            return result;
        }
        
        while (first < length - 2)
        {
            // 如果最小的数,都大于0之后,结束循环
            if (nums[first] > 0)
            {
                break;
            }
            
            tempOpposite = 0 - nums[first];
            
            for (int i = first + 1; i < length; i++)
            {
                for (int j = i + 1; j < length; j++)
                {
                    if (nums[i] + nums[j] == tempOpposite)
                    {
                        setResult(result, nums[first], nums[i], nums[j]);
                        break;
                    }
                    else if (nums[i] + nums[j] > tempOpposite)
                    {
                        break;
                    }
                }
            }
            
            tempFirst = first + 1;
            for (int i = tempFirst; i < length; i++)
            {
                if (nums[first] == nums[tempFirst])
                {
                    tempFirst++;
                }
            }
            first = tempFirst;
        }
        
        return result;
    }
    
    private void setResult(List<List<Integer>> result, int one, int two, int three)
    {
        for (List<Integer> list : result)
        {
            if (list.get(0) == one && list.get(1) == two)
            {
                return;
            }
        }
        
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(one);
        tempResult.add(two);
        tempResult.add(three);
        
        result.add(tempResult);
    }
    
}
