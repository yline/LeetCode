package com.test;

import com.test.base.Solution;

/**
 * 通过SolutionA的探索，发现，可以使用动态规划；
 * 因此，转换实现，就是该解决方案了
 * @author YLine
 *
 * 2019年6月17日 下午5:44:20
 */
public class SolutionB implements Solution
{
    
    @Override
    public String shortestCommonSupersequence(String str1, String str2)
    {
        Node[][] matrix = new Node[str1.length() + 1][str2.length() + 1];
        matrix[0][0] = new Node(0, -1, -1, '/');
        
        // 第一行
        for (int j = 1; j < matrix[0].length; j++)
        {
            matrix[0][j] = new Node(j, 0, j - 1, str2.charAt(j - 1));
        }
        
        // 第一列
        for (int i = 1; i < matrix.length; i++)
        {
            matrix[i][0] = new Node(i, i - 1, 0, str1.charAt(i - 1));
        }
        
        // 动态规划
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                Node corNode = matrix[i - 1][j - 1];
                Node topNode = matrix[i - 1][j];
                Node preNode = matrix[i][j - 1];
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    // 左上角最小
                    if (corNode.size <= topNode.size && corNode.size <= preNode.size)
                    {
                        matrix[i][j] = new Node(corNode.size + 1, i - 1, j - 1, str1.charAt(i - 1));
                    }
                    else if (topNode.size <= corNode.size && topNode.size <= preNode.size) // 顶部最小
                    {
                        matrix[i][j] = new Node(topNode.size + 1, i - 1, j, str1.charAt(i - 1));
                    }
                    else // 前一个最小
                    {
                        matrix[i][j] = new Node(preNode.size + 1, i, j - 1, str2.charAt(j - 1));
                    }
                }
                else
                {
                    if (topNode.size <= preNode.size) // 前一个较小
                    {
                        matrix[i][j] = new Node(topNode.size + 1, i - 1, j, str1.charAt(i - 1));
                    }
                    else
                    {
                        matrix[i][j] = new Node(preNode.size + 1, i, j - 1, str2.charAt(j - 1));
                    }
                }
            }
        }
        
        // 最后一个位置，结果
        Node resultNode = matrix[str1.length()][str2.length()];
        
        // 从结果的位置，去找字符串
        StringBuilder sBuilder = new StringBuilder(resultNode.size);
        while (resultNode.value != '/')
        {
            // 上一个
            sBuilder.append(resultNode.value);
            resultNode = matrix[resultNode.lastX][resultNode.lastY];
        }

        return sBuilder.reverse().toString();
    }
    
    /**
     * .储存每一个节点的选择
     */
    private static class Node
    {
        private int size; // 已选择的个数
        
        private int lastX;
        
        private int lastY;
        
        private char value;
        
        public Node(int size, int lastX, int lastY, char value)
        {
            this.size = size;
            this.lastX = lastX;
            this.lastY = lastY;
            this.value = value;
        }
    }
}
