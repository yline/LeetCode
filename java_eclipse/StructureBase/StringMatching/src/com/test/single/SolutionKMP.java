package com.test.single;

/**
 * KMP算法，在不匹配时，找规律，让模式串多滑动几位
 * 
 * n : 主串长度
 * m : 模式串长度
 * 
 * 简介：遇到坏字符时，主串不再重新匹配，而是将模式串，直接从某个字符串开始匹配
 * 时间复杂度：最坏 = n * m; 最好 = n
 * 空间复杂度：m
 * 
 * @author YLine
 *
 * 2019年4月8日 上午11:34:30
 */
public class SolutionKMP implements SingleModelSolution
{
    
    @Override
    public int matching(String mainStr, String patternStr)
    {
        if (patternStr.length() == 0)
        {
            return 0;
        }
        
        int[] nextArray = next(patternStr);
        
        int mainIndex = 0, patternIndex = 0;
        while (mainIndex < mainStr.length() && patternIndex < patternStr.length())
        {
            // 相匹配，则主串和模式串，继续匹配
            if (mainStr.charAt(mainIndex) == patternStr.charAt(patternIndex))
            {
                mainIndex++;
                patternIndex++;
            }
            else
            {
                if (patternIndex == 0) // 如果，主串和模式串首个就不匹配，则主串继续移动，模式串停留在首位
                {
                    mainIndex++;
                    patternIndex = 0;
                }
                else // 如果，主串和模式串，有前缀，则主串不移动，模式串获取下一次匹配的开始位置
                {
                    // mainIndex = mainIndex;
                    patternIndex = nextArray[patternIndex];
                }
            }
        }
        
        // 如果，模式串溢出，则表明，模式串已经被完全匹配了
        if (patternIndex == patternStr.length())
        {
            return mainIndex - patternIndex;
        }
        
        return -1;
    }
    
    private static final int TAG = -5;
    
    /**
     * A --> {0}
     * AB --> {0, 0}
     * aabaaac --> {0, 0, 1, 0, 1, 2, 2}
     * ABCDABDABAB --> {0, 0, 0, 0, 0, 1, 2, 0, 1, 2, 1}
     * SSSSSSSSSSS --> {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     * 
     * 字符串下标 -> 下一次模式串开始匹配的位置
     * 
     * @param needle 字符串
     * @return 获取某个下标不匹配时，下一次重新开始匹配的位置
     */
    public static int[] next(String needle)
    {
        int[] next = new int[needle.length()];
        
        next[0] = TAG;
        int k = TAG;
        int index = 0;
        while (index < needle.length() - 1)
        {
            if (k == TAG) // a，开始位置，直接置为0
            {
                index++;
                k = 0;
                next[index] = 0;
            }
            else if (needle.charAt(k) == needle.charAt(index)) // b，下一个值相等
            {
                index++;
                k++;
                next[index] = k;
            }
            else // c，下一个值不相等
            {
                k = next[k];
            }
        }
        
        next[0] = 0;
        return next;
    }
}
