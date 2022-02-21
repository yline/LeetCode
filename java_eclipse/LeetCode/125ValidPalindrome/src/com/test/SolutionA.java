package com.test;

import com.test.base.Solution;

/**
 * 两端开始直接校验
 * @author YLine
 *
 * 2018年12月12日 上午10:57:39
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean isPalindrome(String s)
    {
        if (null == s)
        {
            return true;
        }
        
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            char leftChar = s.charAt(left);
            if (leftChar >= 'A' && leftChar <= 'Z') // 满足于大写
            {
                leftChar += 32; // 全部转成小写
            }
            else if (leftChar >= '0' && leftChar <= '9') // 满足于字母
            {
                // do nothing
            }
            else if (leftChar < 'a' || leftChar > 'z') // 不满足小写
            {
                left++;
                continue;
            }
            
            char rightChar = s.charAt(right);
            if (rightChar >= 'A' && rightChar <= 'Z') // 满足于大写
            {
                rightChar += 32;
            }
            else if (rightChar >= '0' && rightChar <= '9') // 满足于字母
            {
                // do nothing
            }
            else if (rightChar < 'a' || rightChar > 'z') // 不满足小写
            {
                right--;
                continue;
            }
            
            if (leftChar == rightChar)
            {
                left++;
                right--;
                continue;
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}
