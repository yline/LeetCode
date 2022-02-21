package com.test.dynamic;

/**
 * 0-1背包问题：
 * n个物品，重量对应为n(i)，背包总承受重量C；
 * 在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
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
 * 2019年4月15日 下午4:01:14
 */
public class Knapsack
{
    public static int dynamic(int[] heavyArray, int capacity)
    {
        // 这里保存的是，之前计算的保存的量【其实用二叉树，等会节省一些内存空间，但带来一些时间复杂度】
        // true 代表有值；false 代表无值
        boolean[] cacheArray = new boolean[capacity + 1]; // 有等号
        
        // 每次读取到新的内容，更新缓存
        for (int i = 0; i < heavyArray.length; i++)
        {
            if (heavyArray[i] > capacity)
            {
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
                        cacheArray[j + index] = true;
                    }
                }
                // 必须放在后面
                cacheArray[index] = true;
            }
        }

        // 最后返回值
        for (int i = capacity; i >= 0; i--)
        {
            if (cacheArray[i])
            {
                return i;
            }
        }
        // 全部没有，则返回
        return 0;
    }
}
