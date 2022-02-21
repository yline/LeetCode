package com.test;

import java.util.List;

import com.test.base.Solution;

/**
 * 动态规划
 * 
 * @author YLine
 *
 * 2018年12月10日 下午5:44:53
 */
public class SolutionA implements Solution
{
    @Override
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (null == triangle || triangle.isEmpty())
        {
            return 0;
        }
        
        for (int i = triangle.size() - 1; i > 0; i--)
        {
            List<Integer> tempAbove = triangle.get(i - 1);
            List<Integer> tempNow = triangle.get(i);
            for (int j = 0; j < tempAbove.size(); j++)
            {
                tempAbove.set(j, tempAbove.get(j) + Math.min(tempNow.get(j), tempNow.get(j + 1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
    
}
