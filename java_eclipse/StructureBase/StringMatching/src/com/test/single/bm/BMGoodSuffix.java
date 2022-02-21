package com.test.single.bm;

/**
 * 好后缀规则
 * @author YLine
 *
 * 2019年3月29日 下午2:44:37
 */
public class BMGoodSuffix
{
    /**
     * 单独使用，好后缀规则，进行字符串匹配
     * @param mainStr 主串
     * @param patternStr 模式串
     * @return -1 if 不匹配
     */
    public static int goodSuffixBm(String mainStr, String patternStr)
    {
        if (patternStr.length() == 0)
        {
            return 0;
        }
        
        int[] suffixArray = getNextArray(patternStr.toCharArray());
        
        int mainIndex = 0;
        int length = mainStr.length() - patternStr.length() + 1;
        while (mainIndex < length)
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
            
            if (badIndex == patternStr.length() - 1)
            {
                // 没有好后缀，移动一位
                mainIndex += 1;
            }
            else
            {
                // 有好后缀，移动计算好的位数
                mainIndex += suffixArray[badIndex];
            }
        }
        
        return -1;
    }
    
    /**
     * 若字符长度为6，则badIndex，依次为：4、3、2、1
     * 
     * 字符串 --> 下一个移动量；下标为：坏字符的位置
     * @param patternArray 模式串
     * @return 坏字符对应的移动量
     */
    public static int[] getNextArray(char[] patternArray)
    {
        int[] suffixArray = badIndex2NextArray(patternArray);
        for (int i = 0; i < suffixArray.length; i++)
        {
            suffixArray[i] = suffixArray.length - suffixArray[i];
        }
        return suffixArray;
    }
    
    /**
     * 模式串中，坏字符的位置为badIndex（badIndex 范围为：[0, pattern.length)）
     * 则，计算得出，后缀，所对应应该移动到下一个的位置(suffixArray)
     * 
     * 而移动的位数 = pattern.length - 1 - suffixArray[badIndex]
     * 
     * @param patternArray 模式串
     * @return 下一个位置，的集合
     */
    public static int[] badIndex2NextArray(char[] patternArray)
    {
        int[] suffixArray = new int[patternArray.length - 1];
        int endIndex = patternArray.length - 2;
        for (int badIndex = endIndex; badIndex >= 0; badIndex--)
        {
            // 每次匹配的位置
            int suffixIndex = badIndex2Next(patternArray, badIndex, endIndex);
            
            // suffixIndex为下一个，移动对齐的位置；而移动的个数 = patternArray.length - 1 - suffixIndex
            suffixArray[badIndex] = suffixIndex;
        }
        
        return suffixArray;
    }
    
    /**
     * 计算suffix，所对应的值，badIndex所对应下一个匹配到的位置
     * @param patternArray 模式串
     * @param badIndex 坏字符的位置，即到坏字符前的位置
     * @param maxIndex 从后往前匹配，开始匹配的位置
     */
    private static int badIndex2Next(char[] patternArray, int badIndex, int maxIndex)
    {
        // 从后往前匹配，maxIndex为遍历位数，需要被匹配的字符开始位置
        while (maxIndex >= 0)
        {
            // 等待匹配的后缀的遍历
            int cacheIndex = maxIndex;
            for (int i = patternArray.length - 1; i > badIndex; i--)
            {
                if (patternArray[i] == patternArray[maxIndex])
                {
                    if (i == (badIndex + 1)) // 最后一个，代表完全匹配
                    {
                        return cacheIndex;
                    }
                    else if (maxIndex == 0) // maxIndex，已经到达首位，代表首位完全匹配
                    {
                        return cacheIndex;
                    }
                    else
                    { // 继续下一个匹配
                        maxIndex--;
                    }
                }
                else // 一旦不匹配，则抛出，并且移动一位
                {
                    maxIndex = cacheIndex - 1;
                    break;
                }
            }
        }
        
        return -1;
    }
    
}
