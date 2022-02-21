package com.test.single.bm;

import java.util.Arrays;

/**
 * 好后缀规则 + 坏字符规则
 * @author YLine
 *
 * 2019年3月30日 下午8:03:41
 */
public class BMMerge
{
    /**
     * 坏字符，优先；
     * 若坏字符，不合适，则，好后缀规则
     * @param mainStr 主串
     * @param patternStr 模式串
     * @return -1 if 不匹配
     */
    public static int mergeBm(String mainStr, String patternStr)
    {
        if (patternStr.length() == 0)
        {
            return 0;
        }
        
        // 好后缀，规则，badIndex - 移动的位置，映射关系
        int[] suffixArray = BMGoodSuffix.getNextArray(patternStr.toCharArray());
        
        // 坏字符，规则
        int[] badArray = getBadCharArray(patternStr.toCharArray());
        
        // 坏字符，规则
        int mainIndex = 0;
        int length = mainStr.length() - patternStr.length() + 1;
        while (mainIndex < length)
        {
            // 坏字符位置
            int badIndex = -1;
            for (int i = patternStr.length() - 1; i >= 0; i--)
            {
                if (patternStr.charAt(i) != mainStr.charAt(mainIndex + i))
                {
                    badIndex = i;
                    break;
                }
            }
            
            if (-1 == badIndex)
            {
                return mainIndex;
            }
            
            int next = getBadCharNext(badArray, badIndex, mainStr.charAt(mainIndex + badIndex));
            if (next > 0) // 坏字符
            {
                mainIndex += next;
            }
            else // 好后缀
            {
                mainIndex += suffixArray[badIndex];
            }
        }
        
        return -1;
    }
    
    /**
     * 依据，字符出现的最后位置，定位下一个移动的距离
     * 可能结果只为负数
     * @param badArray 最后出现的位置
     * @param badIndex 坏字符的位置
     * @param badChar 坏字符(主串)
     * @return 移动的距离
     */
    private static int getBadCharNext(int[] badArray, int badIndex, char badChar)
    {
        int nextIndex = badArray[badChar];
        return badIndex - nextIndex;
    }
    
    /**
     * .一般字符, 128个足够满足，获取坏字符，在模式串中最后出现的位置
     * @param patternArray 模式串
     * @return 最后出现的位置
     */
    private static int[] getBadCharArray(char[] patternArray)
    {
        int[] ascArray = new int[128];
        Arrays.fill(ascArray, -1);
        
        for (int i = 0; i < patternArray.length; i++)
        {
            ascArray[patternArray[i]] = i;
        }
        return ascArray;
    }
}
