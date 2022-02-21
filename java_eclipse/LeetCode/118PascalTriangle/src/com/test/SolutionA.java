package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * @author YLine
 *
 * 2018年12月10日 下午4:16:42
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>(numRows);
        
        for (int i = 1; i <= numRows; i++)
        {
            List<Integer> temp = new ArrayList<>(i);
            for (int j = 1; j <= i; j++)
            {
                if (j == 1 || j == i)
                {
                    temp.add(1);
                }
                else
                {
                    int newValue = result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1);
                    temp.add(newValue);
                }
            }
            result.add(temp);
        }
        
        return result;
    }
    
}
