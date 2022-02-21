package com.test.dynamic.editdistance;

/**
 * 问题：量化两个字符的相似度，编辑距离【莱文斯距离和最长公共字符串】
 * 
 * 参考：https://blog.csdn.net/every__day/article/details/88226722
 * 
 * 回溯方程：可以先看出，关联关系；再由原始的问题，推导出状态转移方程
 * 
 * 状态转移方程：
 * 当a[x]==b[y]时；f(x, y) = min{f(x-1, y) + 1, f(x, y-1) + 1, f(x-1, y-1)};
 * 当a[x]!=b[y]时；f(x, y) = min{f(x-1, y) + 1, f(x, y-1) + 1, f(x-1, y-1) + 1};
 * 
 * f(x, y):表示当x和y分别为最后一个index时，对应的结果值（莱文斯距离）
 * 
 * @author YLine
 *
 * 2019年4月15日 下午5:34:16
 */
public class LevenDistanceImpl
{
    /**
     * 回溯实现，莱文斯距离
     * 
     * 时间复杂度特别高；可优化的点：将已经计算过的内容用hashMap缓存；
     * 当然，还是动态规划效率最高
     * 
     */
    public static int backtrack(String main, String pattern)
    {
        LevenDistanceImpl distanceImpl = new LevenDistanceImpl();
        distanceImpl.mMaxResult = Integer.MAX_VALUE;
        distanceImpl.backtrackInner(main, pattern, 0, 0, 0);
        return distanceImpl.mMaxResult;
    }
    
    private int mMaxResult;
    
    /**
     * @param main 主串
     * @param pattern 模式串
     * @param mainIndex 主串位置
     * @param patternIndex 模式串位置
     * @return 莱文斯距离
     */
    private void backtrackInner(String main, String pattern, int mainIndex, int patternIndex, int result)
    {
        // 主串结束了
        if (mainIndex >= main.length())
        {
            result += pattern.length() - patternIndex;
            mMaxResult = Math.min(result, mMaxResult);
            return;
        }
        
        // 模式串结束了
        if (patternIndex >= pattern.length())
        {
            result += main.length() - mainIndex;
            mMaxResult = Math.min(result, mMaxResult);
            return;
        }
        
        // 回溯
        if (main.charAt(mainIndex) == pattern.charAt(patternIndex))
        {
            backtrackInner(main, pattern, mainIndex + 1, patternIndex + 1, result);
        }
        else
        {
            backtrackInner(main, pattern, mainIndex + 1, patternIndex, result + 1); // 主串删除或模式串新增
            backtrackInner(main, pattern, mainIndex, patternIndex + 1, result + 1); // 主串新增或模式串删除
            backtrackInner(main, pattern, mainIndex + 1, patternIndex + 1, result + 1); // 主串和模式串，修改
        }
    }
    
    /**
     * 动态规划实现，莱文斯距离
     */
    public static int dynamic(String main, String pattern)
    {
        int[][] minArray = new int[main.length()][pattern.length()];
        
        // 初始化第一列【拿模式串第一个和主串所有对比】
        char pChar = pattern.charAt(0);
        for (int i = 0; i < main.length(); i++)
        {
            // 匹配到相等，这里其实是省略了(因为结果相同)
            if (pChar == main.charAt(i))
            {
                minArray[i][0] = i;
            }
            else if (i == 0)
            {
                minArray[i][0] = 1;
            }
            else
            {
                minArray[i][0] = 1 + minArray[i - 1][0];
            }
        }
        
        // 初始化第一行【拿主串第一个和模式串所有对比】
        char mChar = main.charAt(0);
        for (int i = 0; i < pattern.length(); i++)
        {
            if (mChar == pattern.charAt(i))
            {
                minArray[0][i] = i;
            }
            else if (i == 0)
            {
                minArray[0][i] = 1;
            }
            else
            {
                minArray[0][i] = 1 + minArray[0][i - 1];
            }
        }
        
        // 动态规划
        for (int i = 1; i < main.length(); i++)
        {
            for (int j = 1; j < pattern.length(); j++)
            {
                if (main.charAt(i) == pattern.charAt(j))
                {
                    minArray[i][j] = Math.min(Math.min(minArray[i - 1][j] + 1, minArray[i][j - 1] + 1),
                        minArray[i - 1][j - 1]);
                }
                else
                {
                    minArray[i][j] = Math.min(Math.min(minArray[i - 1][j] + 1, minArray[i][j - 1] + 1),
                        minArray[i - 1][j - 1] + 1);
                }
            }
        }
        
        // 最终结果值
        return minArray[main.length() - 1][pattern.length() - 1];
    }
    
}
