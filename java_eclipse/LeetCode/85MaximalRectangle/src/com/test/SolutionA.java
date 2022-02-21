package com.test;

import java.util.HashMap;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 * 
 * 给一个二维矩阵，用0和1填充
 * 找出其中包含1最多的矩阵，并返回它的面积值（其中不能含有0）
 * 
 * 应该要用动态规划，然后向右拓展
 * 问题在于：每一个节点对应的数据结构需要哪些数据
 * 
 * @author YLine
 *
 * 2019年8月23日 上午9:31:18
 */
public class SolutionA
{
    public int maximalRectangle(char[][] matrix)
    {
        if (null == matrix || matrix.length == 0)
        {
            return 0;
        }
        
        int result = 0;
        
        int temp = 0;
        Node[] cacheNode = new Node[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++)
        {
            cacheNode[j] = new Node(matrix[0][j]);
            if (matrix[0][j] == '1')
            {
                cacheNode[j].init();
                temp++;
            }
            else
            {
                result = Math.max(result, temp);
                temp = 0;
            }
        }
        result = Math.max(result, temp);
        
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == '1')
                {
                    Node preNode = (j == 0 ? null : cacheNode[j - 1]);
                    result = Math.max(result, cacheNode[j].update(preNode));
                }
                else
                {
                    // 值为0，则该节点没有任何矩阵
                    cacheNode[j].clear();
                }
            }
        }
        
        return result;
    }
    
    /**
     * .表示，右下角x,y时；对应的所有矩阵
     * key -> 垂直1的连续个数
     * value -> 水平1的连续个数
     * maxKey -> key的最大值
     */
    private static class Node
    {
        private HashMap<Integer, Integer> cacheMap = new HashMap<>();
        
        private int maxKey;
        
        private Node(int value)
        {
            maxKey = 0;
        }
        
        public void init()
        {
            maxKey = 1;
            cacheMap.put(1, 1);
        }
        
        /**
         * .当值为0时，
         */
        public void clear()
        {
            maxKey = 0;
            cacheMap.clear();
        }
        
        /**
         * .当值为1时，更新矩阵，并返回当前所有矩阵的最大值
         */
        public int update(Node preNode)
        {
            if (null == preNode)
            {
                maxKey++;
                cacheMap.put(maxKey, 1);
                
                return maxKey;
            }
            else
            {
                maxKey++;
                int max = maxKey;
                
                // 垂直1的连续个数
                for (int i = 1; i <= maxKey; i++)
                {
                    Integer oldValue = preNode.cacheMap.get(i);
                    if (null == oldValue)
                    {
                        cacheMap.put(i, 1);
                    }
                    else
                    {
                        cacheMap.put(i, oldValue + 1);
                        max = Math.max(max, i * (oldValue + 1));
                    }
                }
                
                return max;
            }
        }
    }
}
