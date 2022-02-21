package com.test;

/**
 * Given two words word1 and word2,
 * find the minimum number of operations required to convert word1 to word2.
 * 给两个字符，找到最小距离，从word1到word2
 * 
 * You have the following 3 operations permitted on a word:
 * 你允许以下三个步骤：
 * Insert a character：插入字符串
 * Delete a character：删除字符串
 * Replace a character：替换字符串
 * 
 * 这题我做过，从开始是递归+缓存去解决
 * 然后，转向动态规划
 * 
 * @author YLine
 *
 * 2019年7月15日 上午11:03:30
 */
public class SolutionA
{
    public int minDistance(String word1, String word2)
    {
        if (word1.length() == 0)
        {
            return word2.length();
        }
        
        if (word2.length() == 0)
        {
            return word1.length();
        }
        
        int[][] matrix = new int[word1.length()][word2.length()];
        
        // 初始化第一行
        boolean equal = false;
        for (int j = 0; j < word2.length(); j++)
        {
            if (equal)
            {
                matrix[0][j] = j;
            }
            else if (word1.charAt(0) == word2.charAt(j))
            {
                equal = true;
                matrix[0][j] = j;
            }
            else
            {
                matrix[0][j] = j + 1;
            }
        }

        // 初始化第一列
        equal = false;
        for (int i = 0; i < word1.length(); i++)
        {
            if (equal)
            {
                matrix[i][0] = i;
            }
            else if (word1.charAt(i) == word2.charAt(0))
            {
                equal = true;
                matrix[i][0] = i;
            }
            else
            {
                matrix[i][0] = i + 1;
            }
        }

        // 剩余的值
        for (int i = 1; i < word1.length(); i++)
        {
            for (int j = 1; j < word2.length(); j++)
            {
                int min = 1 + Math.min(matrix[i-1][j], matrix[i][j-1]);
                if (word1.charAt(i) == word2.charAt(j))
                {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], min);
                }
                else
                {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, min);
                }
            }
        }

        return matrix[word1.length() - 1][word2.length() - 1];
    }
}
