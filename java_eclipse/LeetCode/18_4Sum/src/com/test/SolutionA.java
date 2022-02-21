package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * 固定前面两层，后两层通过夹逼方式，降低一个维度
 * 
 * 时间复杂度：n*log(n) + n^3 = n^3
 * 
 * @author YLine
 *
 * 2018年8月13日 下午5:45:31
 */
public class SolutionA implements Solution
{
    /** Time Limit Exceeded(n^4);
     * 采用同时移动3.4的方式,降低一个维度的复杂度 */
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        int length = nums.length;
        if (length < 4)
        {
            return result;
        }
        
        Arrays.sort(nums);
        
        int one, two, three, four;
        
        one = 0;
        while (one < length - 3)
        {
            two = one + 1;
            while (two < length - 2)
            {
                three = two + 1;
                while (three < length - 1)
                {
                    four = three + 1;
                    while (four < length)
                    {
                        // 符合条件,就添加到内容
                        if (nums[one] + nums[two] + nums[three] + nums[four] == target)
                        {
                            result.add(getList(nums[one], nums[two], nums[three], nums[four]));
                        }
                        
                        four++;
                        while (four < length && nums[four] == nums[four - 1])
                        {
                            four++;
                        }
                    }
                    
                    // 移动 three
                    three++;
                    while (three < length - 1 && nums[three] == nums[three - 1])
                    {
                        three++;
                    }
                }
                
                // 移动 two
                two++;
                while (two < length - 2 && nums[two] == nums[two - 1])
                {
                    two++;
                }
            }
            
            // 移动 one
            one++;
            while (one < length - 3 && nums[one] == nums[one - 1])
            {
                one++;
            }
        }
        
        return result;
    }
    
    public List<Integer> getList(int one, int two, int three, int four)
    {
        return Arrays.asList(one, two, three, four);
    }
}
