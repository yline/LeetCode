package com.test.dynamic;

import java.math.BigDecimal;

/**
 * 0-1背包问题 升级版：
 * n个物品，重量对应为n(i)，每件物品价值为value(i)，背包总承受重量C；
 * 在满足背包最大重量限制的前提下，背包中物品总价值的最大值是多少呢？
 * 
 * 参考：https://blog.csdn.net/every__day/article/details/88100379
 * 
 * 回溯法：全排列，然后对比；优化：对计算结果进行缓存【com.test.backtracking.Knapsack 有实现】
 * 
 * 动态规划：
 * 当f(x-1)+a[x] <= C时；f(x) = f(x-1) + a[x];
 * 当f(x-1)+a[x] >  C时；f(x) = max{f(x-1), ......}; 省略号，代表需要去遍历所有状态
 * 因此，需要提前记录之前的计算结果；然后，每次都计算到最贴近的值
 * 
 * @author YLine
 *
 * 2019年4月15日 下午4:03:07
 */
public class Knapsack2
{
    
    public static float dynamic(int[] heavyArray, float[] valueArray, int capacity)
    {
        // 这里保存的是，之前计算的保存的量【其实用二叉树，等会节省一些内存空间，但带来一些时间复杂度】
        // true 代表有值；false 代表无值
        boolean[] cacheArray = new boolean[capacity + 1]; // 总重量的缓存
        float[] maxValueArray = new float[capacity + 1]; // 总重量对应的价值的缓存

        int maxValueIndex = -1;
        float maxValue = 0;
        
        // 每次读取到新的内容，更新缓存
        for (int i = 0; i < heavyArray.length; i++)
        {
            if (heavyArray[i] > capacity)
            {
                // 超重
                continue;
            }
            else
            {
                // 必须从后往前遍历，这样避免当前改变，对之后遍历的影响
                int index = heavyArray[i];
                for (int j = capacity - index; j >= 0; j--)
                {
                    if (cacheArray[j])
                    {
                        int changeIndex = j + index;
                        float changeValue = maxValueArray[j] + valueArray[i];
                        
                        cacheArray[changeIndex] = true;
                        maxValueArray[changeIndex] = Math.max(changeValue, maxValueArray[changeIndex]);
                        
                        if (maxValueArray[changeIndex] > maxValue)
                        {
                            maxValue = maxValueArray[changeIndex];
                            maxValueIndex = changeIndex;
                        }
                    }
                }
                
                // 变量为了不影响遍历，必须放在后面
                cacheArray[index] = true;
                maxValueArray[index] = Math.max(maxValueArray[index], valueArray[i]);
            }
        }
        
        //
        for (int i = capacity; i >= 0; i--)
        {
            if (cacheArray[i])
            {
                String format = "最大重量：%d, 最大价值：%s, 最大价值对应的重量：%d";
                System.out.println(String.format(format, i, String.valueOf(maxValue), maxValueIndex));
                break;
            }
        }
        
        // 全部没有，则返回【只去后两位，避免浮点数相加、赋值导致的问题】
        return handlerFloat(maxValue);
    }
    
    private static float handlerFloat(float value)
    {
        BigDecimal decimal = new BigDecimal(value);
        decimal = decimal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return decimal.floatValue();
    }
}
