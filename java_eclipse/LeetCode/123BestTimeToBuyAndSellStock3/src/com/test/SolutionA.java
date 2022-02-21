package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int maxProfit(int[] prices)
    {
        if (null == prices || prices.length < 2)
        {
            return 0;
        }
        
        List<Point> dataList = new ArrayList<>();
        
        int minValue = prices[0];
        int lastValue = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > lastValue)
            {
                lastValue = prices[i];
            }
            else
            {
                if (lastValue > minValue)
                {
                    dataList.add(new Point(minValue, lastValue));
                }
                minValue = prices[i];
                lastValue = prices[i];
            }
        }
        
        if (lastValue > minValue) // 最后一个
        {
            dataList.add(new Point(minValue, lastValue));
        }
        
        if (dataList.isEmpty())
        {
            return 0;
        }
        else if (dataList.size() == 1)
        {
            return dataList.get(0).max - dataList.get(0).min;
        }
        else if (dataList.size() == 2)
        {
            return (dataList.get(0).max - dataList.get(0).min) + (dataList.get(1).max - dataList.get(1).min);
        }
        else
        {
            final int endIndex = dataList.size() - 1;
            int profit = 0;
            for (int i = 0; i < endIndex; i++)
            {
                int preMax = dfs(dataList, 0, i);
                int postMax = dfs(dataList, i + 1, endIndex);
                profit = Math.max(profit, preMax + postMax);
            }
            return profit;
        }
    }
    
    /**
     * 计算 start - end中的最大值
     * 这里可以使用，hashMap优化
     */
    private int dfs(List<Point> data, int start, int end)
    {
        if (start == end)
        {
            return data.get(start).max - data.get(start).min;
        }
        
        int preMax = dfs(data, start, end - 1);
        
        int postMax = data.get(end).max - data.get(end).min;
        for (int i = end; i >= start; i--)
        {
            postMax = Math.max(postMax, data.get(end).max - data.get(i).min);
        }
        
        return Math.max(preMax, postMax);
    }
    
    private static class Point
    {
        public int min;
        
        public int max;
        
        private Point(int min, int max)
        {
            this.min = min;
            this.max = max;
        }
    }
    
    private void log(List<Point> dataList)
    {
        System.out.println("---------------------------");
        for (int i = 0; i < dataList.size(); i++)
        {
            Point point = dataList.get(i);
            System.out.println("min = " + point.min + ", max = " + point.max);
        }
    }
}
