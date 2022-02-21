package com.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 1,Each child must have at least one candy.
 * 2,Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * Input: [1,0,2]
 * Output: 5
 * 
 * Example 2:
 * Input: [1,2,2]
 * Output: 4
 * 
 * @author YLine
 *
 * 2019年12月10日 上午9:35:49
 */
public class SolutionA
{
    public int candy(int[] ratings)
    {
        if (null == ratings || ratings.length == 0)
        {
            return 0;
        }
        
        if (ratings.length == 1)
        {
            return 1;
        }
        
        Deque<Integer> indexQueue = new ArrayDeque<>(); // 已添加过的值
        
        Result result = new Result(ratings.length);
        for (int i = 0; i < ratings.length; i++)
        {
            // 比左边大，直接排除
            if (i != 0 && ratings[i] > ratings[i - 1])
            {
                continue;
            }
            
            // 比右边大，直接排除
            if (i != ratings.length - 1 && ratings[i] > ratings[i + 1])
            {
                continue;
            }
            
            result.giveCandy(i, 1);
            indexQueue.addLast(i);
        }
        
        // 遍历咯，每次都是找出较小的值
        while (!result.isEnd() && !indexQueue.isEmpty())
        {
            int index = indexQueue.pollFirst(); // 将首个poll出来
            
            handleIndex(ratings, indexQueue, result, index - 1);
            handleIndex(ratings, indexQueue, result, index + 1);
        }
        
        return result.candySize;
    }
    
    private void handleIndex(int[] ratings, Deque<Integer> queue, Result result, int index)
    {
        // 越界，或已经有值
        if (index < 0 || index >= ratings.length || result.candyArray[index] != -1)
        {
            return;
        }
        
        // 0，肯定是1过来的，直接给值
        if (index == 0)
        {
            result.giveCandy(index, result.candyArray[index + 1] + 1);
            return;
        }
        
        // 最后1个，肯定是前一个过来的
        if (index == ratings.length - 1)
        {
            result.giveCandy(index, result.candyArray[index - 1] + 1);
            return;
        }
        
        // 接下来不用考虑边界问题，并且范围为（1，length -2）
        
        int leftValue = result.candyArray[index - 1];
        int rightValue = result.candyArray[index + 1];
        
        // 两边都有值
        if (leftValue != -1 && rightValue != -1)
        {
            // 同时大于两边，则取较大值；然后，再校验一次
            int value = Math.max(leftValue, rightValue);
            
            // 左边违反规则
            if (ratings[index] > ratings[index - 1] && value <= leftValue)
            {
                value += 1;
            }
            
            // 右边违反规则
            if (ratings[index] > ratings[index + 1] && value <= rightValue)
            {
                value += 1;
            }
            
            result.giveCandy(index, value);
            queue.addLast(index);
            return;
        }
        
        // 右边有值，并且当前值比左边小，则直接填充
        if (rightValue != -1 && ratings[index] <= ratings[index - 1])
        {
            result.giveCandy(index, rightValue + 1);
            queue.add(index);
            return;
        }
        
        // 左边有值，并且当前值比右边小，则直接填充
        if (leftValue != -1 && ratings[index] <= ratings[index + 1])
        {
            result.giveCandy(index, leftValue + 1);
            queue.add(index);
            return;
        }
        
        // 两边都没有值不可值；
        // 有值不满足条件的，会通过另一边进行填充
    }

    private static class Result
    {
        private final int[] candyArray;
        
        private int size; // 当前已经给了糖果的人的个数
        
        private int candySize; // 当前给了的糖果的数量
        
        public Result(int N)
        {
            this.candyArray = new int[N];
            Arrays.fill(candyArray, -1);
            
            size = 0;
            candySize = 0;
        }
        
        private boolean isEnd()
        {
            return size == candyArray.length;
        }
        
        private void giveCandy(int index, int candy)
        {
            candySize += candy;
            size++;
            
            candyArray[index] = candy;
        }
    }
}
