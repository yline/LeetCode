package com.test;

import java.util.Arrays;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * 
 * Return the minimum number of students not standing in the right positions.  
 * (This is the number of students that must move in order for all students to be 
 * standing in non-decreasing order of height.)
 * 
 * 要求学生，按升序排序，求最少的交换次数
 * 
 * @author YLine
 *
 * 2019年5月26日 下午9:07:34
 */
public class SolutionA
{
    public int heightChecker(int[] heights)
    {
        int[] temp = new int[heights.length];
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = heights[i];
        }
        
        Arrays.sort(temp);
        int result = 0;
        for (int i = 0; i < temp.length; i++)
        {
            if (temp[i] != heights[i])
            {
                result++;
            }
        }
        return result;
    }
}
