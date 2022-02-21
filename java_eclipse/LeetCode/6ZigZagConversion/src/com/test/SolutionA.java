package com.test;

import com.test.base.Solution;

/**
 * 解题思路
 * 依据题目，将ZigZag的规律找出来，然后依据递增规律书写即可
 * 
 * 时间复杂度
 * n
 * 
 * @author YLine
 *
 * 2018年7月23日 下午4:25:13
 */
public class SolutionA implements Solution
{
    
    @Override
    public String convert(String s, int numRows)
    {
        if (numRows == 1)
        {
            return s;
        }
        
        // 长度
        int length = s.length();
        // 用于计算点的量
        int pointIndex = 0;
        // 用于计算中间的量
        int leftIndex, rightIndex;
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++)
        {
            // 计算横向只有一个点的情况
            if (i == 0 || i == (numRows - 1))
            {
                pointIndex = i;
                while (pointIndex < length)
                {
                    stringBuilder.append(s.charAt(pointIndex));
                    pointIndex += (2 * numRows - 2);
                }
            }
            else // 计算横向可能有两个点的情况
            {
                leftIndex = i;
                rightIndex = 2 * numRows - 2 - i;
                while (leftIndex < length || rightIndex < length)
                {
                    stringBuilder.append(s.charAt(leftIndex));
                    leftIndex += (2 * numRows - 2);
                    
                    if (rightIndex < length)
                    {
                        stringBuilder.append(s.charAt(rightIndex));
                        rightIndex += (2 * numRows - 2);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
    
}
