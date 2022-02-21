package com.test;

import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * 依次生成即可
 * @author YLine
 *
 * 2018年12月10日 下午4:53:43
 */
public class SolutionA implements Solution
{
    @Override
    public List<Integer> getRow(int numRows)
    {
        int length = numRows + 1;
        Integer[] array = new Integer[length];
        
        for (int i = 0; i < length; i++)
        {
            int oldLast = 1; // 记录一个临时变量
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                {
                    array[j] = 1;
                }
                else
                {
                    int last = array[j];
                    array[j] = oldLast + array[j];
                    oldLast = last;
                }
            }
        }
        
        return Arrays.asList(array);
    }
}
