package com.test;

import com.test.base.Solution;

/**
 * 使用KMP算法进行实现
 * 
 * 优化点在于:提前计算出了重复匹配的常量,这样一旦出现匹配失败,则跳跃一个较大的量,而不是1
 * 
 * @author YLine
 *
 * 2018年12月24日 下午6:22:55
 */
public class SolutionC implements Solution
{
    @Override
    public int strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return 0;
        }
        
        int[] next = next(needle);
        
        int hayIndex = 0, needIndex = 0;
        while (hayIndex < haystack.length() && needIndex < needle.length())
        {
            if (haystack.charAt(hayIndex) == needle.charAt(needIndex))
            {
                hayIndex++;
                needIndex++;
            }
            else
            {
                if (needIndex == 0)
                {
                    hayIndex++;
                    needIndex = next[needIndex];
                }
                else
                {
                    needIndex = next[needIndex];
                }
            }
        }
        
        if (needIndex == needle.length())
        {
            return hayIndex - needIndex;
        }
        else
        {
            return -1;
        }
    }
    
    private static final int TAG = -5;
    
    /**
     * A --> {0}
     * AB --> {0, 0}
     * aabaaac --> {0, 0, 1, 0, 1, 2, 2}
     * ABCDABDABAB --> {0, 0, 0, 0, 0, 1, 2, 0, 1, 2, 1}
     * SSSSSSSSSSS --> {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     * 
     * @param needle 字符串
     * @return 如果当前位置，不匹配，可以移动的距离
     */
    public static int[] next(String needle)
    {
        int[] next = new int[needle.length()];
        
        next[0] = TAG;
        int k = TAG;
        int index = 0;
        while (index < needle.length() - 1)
        {
            if (k == TAG)
            {
                index++;
                k = 0;
                next[index] = 0;
            }
            else if (needle.charAt(k) == needle.charAt(index))
            {
                index++;
                k++;
                next[index] = k;
            }
            else
            {
                k = next[k];
            }
        }
        
        next[0] = 0;
        return next;
    }
}
