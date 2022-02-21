package com.test.dynamic.editdistance;

/**
 * 问题：量化两个字符的相似度，编辑距离【莱文斯距离和最长公共字符串】
 * 
 * 参考：https://blog.csdn.net/every__day/article/details/88226722
 * 
 * 最长公共字符串，只支持：增加和删除，不支持修改
 * 
 * 状态方程：
 * f(x,y) = max{f(x-1,y), f(x-1,y-1), f(x,y-1)}; 当a[x]==b[y]时
 * f(x,y) = max{f(x-1,y), f(x-1,y-1)+1, f(x,y-1)}; 当a[x]!=b[y]时
 * 
 * @author YLine
 *
 * 2019年4月15日 下午5:34:16
 */
public class LongestLengthImpl
{
    /**
     * 回溯实现，最长公共字符串
     */
    public static int backtrack(String main, String pattern)
    {
        LongestLengthImpl lengthImpl = new LongestLengthImpl();
        lengthImpl.mMaxResult = 0;
        lengthImpl.backtrackInner(main, pattern, 0, 0, 0);
        return lengthImpl.mMaxResult;
    }
    
    private int mMaxResult;
    
    private void backtrackInner(String main, String pattern, int mainIndex, int patternIndex, int result)
    {
        // 主串结束
        if (mainIndex == main.length())
        {
            mMaxResult = Math.max(mMaxResult, result);
            return;
        }
        
        // 模式串结束
        if (patternIndex == pattern.length())
        {
            mMaxResult = Math.max(mMaxResult, result);
            return;
        }
        
        if (main.charAt(mainIndex) == pattern.charAt(patternIndex))
        {
            backtrackInner(main, pattern, mainIndex + 1, patternIndex + 1, result + 1);
        }
        else
        {
            backtrackInner(main, pattern, mainIndex + 1, patternIndex, result);
            backtrackInner(main, pattern, mainIndex, patternIndex + 1, result);
        }
    }
    
    /**
     * 动态规划实现，最长公共字符串
     */
    public static int dynamic(String main, String pattern)
    {
        // 申请内存
        int[][] maxArray = new int[main.length()][pattern.length()];
        
        // 初始化第一列【遍历主串】
        char pChar = pattern.charAt(0);
        for (int i = 0; i < main.length(); i++)
        {
            if (pChar == main.charAt(i))
            {
                maxArray[i][0] = 1;
            }
            else if (i == 0)
            {
                maxArray[i][0] = 0;
            }
            else
            {
                maxArray[i][0] = maxArray[i - 1][0];
            }
        }
        
        // 初始化第一行【遍历模式串】
        char mChar = main.charAt(0);
        for (int i = 0; i < pattern.length(); i++)
        {
            if (mChar == pattern.charAt(i))
            {
                maxArray[0][i] = 1;
            }
            else if (i == 0)
            {
                maxArray[0][i] = 0;
            }
            else
            {
                maxArray[0][i] = maxArray[0][i - 1];
            }
        }
        
        // 状态转移方程
        for (int i = 1; i < main.length(); i++)
        {
            for (int j = 1; j < pattern.length(); j++)
            {
                if (main.charAt(i) == pattern.charAt(j))
                {
                    maxArray[i][j] =
                        Math.max(Math.max(maxArray[i - 1][j], maxArray[i][j - 1]), maxArray[i - 1][j - 1] + 1);
                }
                else
                {
                    maxArray[i][j] = Math.max(Math.max(maxArray[i - 1][j], maxArray[i][j - 1]), maxArray[i - 1][j - 1]);
                }
            }
        }
        
        return maxArray[main.length() - 1][pattern.length() - 1];
    }
}
