package com.test;

import com.test.base.Solution;

/**
 * 思路：
 * 从结果出发；
 * 某个最大值，肯定是，某个值，左边和右边，都比他高的数，然后，乘积
 * 
 * 
 * @author YLine
 *
 * 2019年6月26日 下午2:40:39
 */
public class SolutionB implements Solution
{
    
    @Override
    public int largestRectangleArea(int[] heights)
    {
        if (heights.length == 0)
        {
            return 0;
        }
        
        // 某个数，左边和右边，都比他高的数的，个数
        int[] numArray = new int[heights.length];
        for (int i = 0; i < numArray.length; i++)
        {
            updateNumArray(numArray, heights, i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numArray.length; i++)
        {
            max = Math.max(max, numArray[i] * heights[i]);
        }
        
        return max;
    }
    
    private void updateNumArray(int[] numArray, int[] heights, int index)
    {
        int left = index, right = index;
        for (int i = index - 1; i >= 0; i--)
        {
            if (heights[i] < heights[index])
            {
                break;
            }
            else
            {
                left = i;
            }
        }
        
        for (int i = index + 1; i < heights.length; i++)
        {
            if (heights[i] < heights[index])
            {
                break;
            }
            else
            {
                right = i;
            }
        }
        
        numArray[index] = right - left + 1;
        
        System.out.println("index = " + index + ", value = " + numArray[index]);
    }
}
