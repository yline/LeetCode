package com.test;

import java.util.HashMap;

import com.test.base.Solution;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 * 在一个二维矩阵上，放置一些点，每个点最多有一个值
 * 
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * 然后，如果点的行或列相同，可以移除一些点
 * 
 * What is the largest possible number of moves we can make?
 * 请问，最多可以移除多少个点
 * 
 * 点 个数范围：
 * 1 <= stones.length <= 1000
 * 点 大小范围：
 * 0 <= stones[i][j] < 10000
 * 
 * 方案1：
 * 通过，依次校验，点的位置，从而判断最终的方案
 * 尝试失败，原因：可能有散列点，从而未添加，但实际上是需要添加上的。
 * 
 * 案例：
 * {{3, 2}, {0, 0}, {3, 3}, {2, 1}, {2, 3}, {2, 2}, {0, 2}}
 * 
 * 这失败，说明，遍历需要考虑顺序因素
 * 
 * @author YLine
 *
 * 2019年6月3日 上午10:17:29
 */
public class SolutionA implements Solution
{
    @Override
    public int removeStones(int[][] stones)
    {
        // 三种状态
        // null -> 该行，没有过， “点”
        // -1   -> 该行，有过，“点”，但全部被添加了
        // >= 0 -> 该行，有值，并且存在未被添加的值
        HashMap<Integer, Integer> xMap = new HashMap<>();
        
        // 列与行相同
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        int result = 0;
        for (int i = 0; i < stones.length; i++)
        {
            int x = stones[i][0];
            int y = stones[i][1];
            
            // 一共九种可能性，行3 * 列3 = 9； 遍历即可
            Integer yState = xMap.get(x);
            Integer xState = yMap.get(y);
            
            if (null == yState)
            {
                if (null == xState)
                {
                    xMap.put(x, y);
                    yMap.put(y, x);
                }
                else if (xState >= 0)
                {
                    result += 1;
                    
                    xMap.put(x, -1); // (x, y)被添加了，(xState, y)不修改值
                }
                else
                {
                    result += 1;
                    
                    xMap.put(x, -1); // (x, y)被添加了，(-1, y)依旧是 -1
                }
            }
            else if (yState >= 0)
            {
                if (null == xState)
                {
                    result += 1;
                    
                    yMap.put(y, -1); // (x, y)被添加了
                }
                else if (xState >= 0)
                {
                    result += 2;
                    
                    yMap.put(y, -1); // (x,y)、(xState,y)被添加了
                    xMap.put(xState, -1); // (xState,y)被添加了
                }
                else
                {
                    result += 1;
                    yMap.put(y, -1); // (x, y)被添加了
                }
            }
            else
            {
                if (null == xState)
                {
                    result += 1;
                    
                    yMap.put(y, -1); // (x, y)被添加了
                }
                else if (xState >= 0)
                {
                    result += 1; // (x, y)被添加了
                }
                else
                {
                    result += 1; // (x, y)被添加了
                }
            }
        }
        
        return result;
    }
}
