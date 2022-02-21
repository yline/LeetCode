package com.test.single.bm;

/**
 * 坏字符串
 * @author YLine
 *
 * 2019年3月29日 下午3:05:30
 */
public class BMBadChar
{
    /**
     * 单独使用，坏字符规则，进行字符串匹配
     * @param mainStr  主串
     * @param patternStr 模式串
     * @return -1 if 不匹配
     */
    public static int badCharBm(String mainStr, String patternStr)
    {
        if (patternStr.length() == 0)
        {
            return 0;
        }
        
        char[] patternArray = patternStr.toCharArray();
        
        int mainIndex = 0;
        int length = mainStr.length() - patternStr.length() + 1;
        while (mainIndex < length && mainIndex >= 0)
        {
            int badIndex = -1;
            for (int i = patternStr.length() - 1; i >= 0; i--)
            {
                if (patternStr.charAt(i) != mainStr.charAt(mainIndex + i))
                {
                    badIndex = i;
                    break;
                }
            }
            
            // 完全匹配了
            if (badIndex == -1)
            {
                return mainIndex;
            }
            
            char badChar = mainStr.charAt(mainIndex + badIndex);
            mainIndex += getNextMove(patternArray, badChar, badIndex);
        }
        
        return -1;
    }
    
    /**
     * 利用坏字符，计算下一个需要移动的距离
     * @param patternArray 模式串
     * @param badChar 坏字符在主串中，对应的值
     * @param badIndex 坏字符，允许在模式串的任意位置【在模式串上的位置】
     * @return 下一个移动的距离
     */
    private static int getNextMove(char[] patternArray, char badChar, int badIndex)
    {
        for (int i = badIndex - 1; i >= 0; i--)
        {
            if (badChar == patternArray[i])
            {
                return badIndex - i;
            }
        }
        return badIndex + 1;
    }
}
