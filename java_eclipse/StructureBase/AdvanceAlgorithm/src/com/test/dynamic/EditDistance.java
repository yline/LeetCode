package com.test.dynamic;

import static org.junit.Assert.assertEquals;

import com.test.dynamic.editdistance.LevenDistanceImpl;
import com.test.dynamic.editdistance.LongestLengthImpl;

/**
 * 问题：量化两个字符的相似度，编辑距离【莱文斯距离和最长公共字符串】
 * 
 * 1，先回溯求解，然后，再优化为动态规划
 * 2，有LevenDistance 和 LongestLength
 * 
 * 参考：https://blog.csdn.net/every__day/article/details/88226722
 * 
 * @author YLine
 *
 * 2019年4月15日 下午5:34:16
 */
public class EditDistance
{
    /**
     * 莱文斯距离
     * @param main 主串
     * @param pattern 模式串
     * @param result 莱文斯距离，应该的结果
     */
    public static void levenDistance(String main, String pattern, int result)
    {
        // 防止数据量过大，导致很长时间回溯在执行的问题
        if (main.length() + pattern.length() > 30)
        {
            int dynamic = LevenDistanceImpl.dynamic(main, pattern);
            assertEquals(dynamic, result);
        }
        else
        {
            int backtrack = LevenDistanceImpl.backtrack(main, pattern);
            int dynamic = LevenDistanceImpl.dynamic(main, pattern);
            assertEquals(backtrack, dynamic);
            assertEquals(dynamic, result);
        }
    }
    
    /**
     * 最长公共字符串
     * @param main 主串
     * @param pattern 模式串
     * @param result 莱文斯距离，应该的结果
     */
    public static void longestLength(String main, String pattern, int result)
    {
        // 防止数据量过大，导致很长时间回溯在执行的问题
        if (main.length() + pattern.length() > 30)
        {
            int dynamic = LongestLengthImpl.dynamic(main, pattern);
            assertEquals(dynamic, result);
        }
        else
        {
            int backtrack = LongestLengthImpl.backtrack(main, pattern);
            int dynamic = LongestLengthImpl.dynamic(main, pattern);
            assertEquals(backtrack, dynamic);
            assertEquals(dynamic, result);
        }
    }
}
