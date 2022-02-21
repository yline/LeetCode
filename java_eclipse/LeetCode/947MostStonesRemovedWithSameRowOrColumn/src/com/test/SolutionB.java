package com.test;

import java.util.HashMap;
import java.util.HashSet;

import com.test.base.Solution;

/**
 * 方案2：【方案1，已经说明，直接遍历方式不可行】
 * 
 * 1，先把他添加到两个HashMap里面，【相当于建立映射关系】
 * 2，随机取一个数字，按照递归的方式，找到所有相连的数据
 * 3，判断HashMap中是否还有值，还有的话继续，直到HashMap值全部清空
 * 
 * @author YLine
 *
 * 2019年6月3日 下午2:15:55
 */
public class SolutionB implements Solution
{
    
    @Override
    public int removeStones(int[][] stones)
    {
        HashMap<Integer, HashSet<Integer>> xMap = new HashMap<>(); // x的映射，映射到stone下标
        HashMap<Integer, HashSet<Integer>> yMap = new HashMap<>(); // y的映射，映射到stone下标
        
        // 建立映射关系
        for (int i = 0; i < stones.length; i++)
        {
            int x = stones[i][0];
            int y = stones[i][1];
            
            // x对应的所有下标值
            HashSet<Integer> xSet = xMap.get(x);
            if (null == xSet)
            {
                xSet = new HashSet<>();
                xSet.add(i);
                
                xMap.put(x, xSet);
            }
            else
            {
                xSet.add(i);
            }
            
            // y对应的所有x值
            HashSet<Integer> ySet = yMap.get(y);
            if (null == ySet)
            {
                ySet = new HashSet<>();
                ySet.add(i);
                
                yMap.put(y, ySet);
            }
            else
            {
                ySet.add(i);
            }
        }
        
        // 开始递归删除内容
        Info info = new Info(stones);
        for (int x : xMap.keySet())
        {
            HashSet<Integer> xSet = xMap.get(x);
            for (int position : xSet)
            {
                if (!info.isDelete(position))
                {
                    info.addCircleCount();
                    dfs(xMap, yMap, info, position);
                }
            }
        }
        
        return info.getResult();
    }
    
    /**
     * 随机取一个值，然后开始，将相连的值递归
     * @param xMap x值维护的所有值
     * @param yMap y值维护的所有值
     * @return 相连的总数
     */
    private void dfs(HashMap<Integer, HashSet<Integer>> xMap, HashMap<Integer, HashSet<Integer>> yMap, Info info,
        int position)
    {
        // 避免太多次进入
        if (info.isDelete(position))
        {
            return;
        }
        info.delete(position);
        
        // 所有的x
        int x = info.getX(position);
        HashSet<Integer> xSet = xMap.get(x);
        for (int xPosition : xSet)
        {
            if (!info.isDelete(xPosition))
            {
                dfs(xMap, yMap, info, xPosition);
            }
        }
        
        // 所有的y
        int y = info.getY(position);
        HashSet<Integer> ySet = yMap.get(y);
        for (int yPosition : ySet)
        {
            if (!info.isDelete(yPosition))
            {
                dfs(xMap, yMap, info, yPosition);
            }
        }
    }
    
    public static class Info
    {
        private final int[][] stones;
        
        private boolean[] isDelete; // 是否已经被删除
        
        private int circleCount; // 循环的个数
        
        public Info(int[][] stones)
        {
            this.stones = stones;
            this.circleCount = 0;
            this.isDelete = new boolean[stones.length];
        }
        
        public void addCircleCount()
        {
            circleCount++;
        }
        
        public void delete(int position)
        {
            isDelete[position] = true;
        }
        
        public boolean isDelete(int position)
        {
            return isDelete[position];
        }
        
        public int getResult()
        {
            return stones.length - circleCount;
        }
        
        public int getX(int position)
        {
            return stones[position][0];
        }
        
        public int getY(int position)
        {
            return stones[position][1];
        }
    }
}
