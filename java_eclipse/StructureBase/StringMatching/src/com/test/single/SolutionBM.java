package com.test.single;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.test.single.bm.BMBadChar;
import com.test.single.bm.BMGoodSuffix;
import com.test.single.bm.BMMerge;

/**
 * BM（Boyer-Moore）算法，在不匹配时，找规律，让模式串多滑动几位
 * 
 * n : 主串长度
 * m : 模式串长度
 * 
 * 坏字符规则：（bad character rule）
 * 好后缀规则：（good suffix shift）
 * 
 * 简介：有三种：坏字符串匹配、好后缀匹配、坏字符串和好后缀融合
 * 1) 坏字符串匹配：利用每次从后往前匹配的坏字符，主串直接每次移动多个位置，模式串从末尾开始匹配
 * 时间复杂度：最坏 = n * m; 最好 = n
 * 空间复杂度：m
 * 
 * 2) 好后缀匹配：利用每次从后往前匹配的好后缀，主串每次移动多个位置，模式串从末尾开始匹配
 * 时间复杂度：最坏 = n * m; 最好 = n
 * 空间复杂度：m
 * 
 * 3) 坏字符串和好后缀融合：先使用部分坏字符串规则，不满足则使用好后缀匹配；主串每次移动多个位置，模式串从末尾开始匹配
 * 时间复杂度：最坏 = n * m; 最好 = n
 * 空间复杂度：m + 128(常量)
 * 
 * @author YLine
 *
 * 2019年3月26日 下午2:38:15
 */
public class SolutionBM implements SingleModelSolution
{
    
    @Override
    public int matching(String mainStr, String patternStr)
    {
        int goodMatch = BMGoodSuffix.goodSuffixBm(mainStr, patternStr);
        
        int badMatch = BMBadChar.badCharBm(mainStr, patternStr);
        
        int mergeMatch = BMMerge.mergeBm(mainStr, patternStr);
        
        assertEquals(goodMatch, badMatch);
        assertEquals(goodMatch, mergeMatch);
        
        return mergeMatch;
    }
    
    /**
     * .好后缀
     */
    public void testGoodSuffix()
    {
        assertGoodSuffix("aaa", 1, 1);
    }
    
    private void assertGoodSuffix(String patternStr, int... nextArray)
    {
        int[] actualArray = BMGoodSuffix.getNextArray(patternStr.toCharArray());
        assertArrayEquals(nextArray, actualArray);
    }
    
}
