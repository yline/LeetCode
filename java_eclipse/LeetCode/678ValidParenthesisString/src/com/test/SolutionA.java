package com.test;

import com.test.base.Solution;

/**
 * 时间复杂度：n
 * 
 * 直接去遍历一次就好了
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean checkValidString(String s)
    {
        // 记录'('的个数，记录')'的个数
        int leftSize = 0, rightSize = 0;
        
        // 记录可作为'('或'empty'存在的个数，可作为')'或'empty'存在的个数
        int leftPatt = 0, rightPatt = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                leftSize++;
            }
            else if (s.charAt(i) == ')')
            {
                rightSize++;
            }
            else
            {
                if (leftSize > rightSize)
                {
                    rightPatt++;
                }
                else
                {
                    leftPatt++;
                }
            }
            
            // 判断是否合法
            if (rightSize > (leftSize + leftPatt + rightPatt))
            {
                return false;
            }
            
            // 当 '(' - ')'的数量，小于rightPatt时，rightPatt值有上限 = leftSize - rightSize
            if (leftSize - rightSize < rightPatt)
            {
                rightPatt--;
                leftPatt++;
            }
        }
        
        if (leftSize > rightSize)
        {
            return rightPatt >= (leftSize - rightSize);
        }
        
        return true;
    }
    
}
