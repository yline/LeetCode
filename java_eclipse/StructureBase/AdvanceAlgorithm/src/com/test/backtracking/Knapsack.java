package com.test.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 0-1背包问题
 * 有n件物品和一个容量为c的背包。第i件物品的价值是v[i]，重量是w[i]。
 * 求解将哪些物品装入背包可使价值总和最大。所谓01背包，表示每一个物品只有一个，要么装入，要么不装入。
 * 
 * 参考：https://www.cnblogs.com/lixiaolun/p/4504213.htmlf
 * 
 * 不能用贪心算法【可能出现大头的情况】
 * 
 * 全排列，找出最大值
 * 
 * @author YLine
 *
 * 2019年4月15日 下午1:57:07
 */
public class Knapsack
{
    private List<Goods> mSelectList;
    private int mMaxValue = 0;
    
    public int knapsack(List<Goods> goodsList, int capacity)
    {
        knapsack(goodsList, 0, capacity, 0, new ArrayList<>());
        
        StringBuilder sBuilder = new StringBuilder();
        for (Goods goods : mSelectList)
        {
            sBuilder.append(String.format("(index:%d, value:%d)  ", goods.index, goods.value));
        }
        System.out.println(sBuilder.toString());
        return mMaxValue;
    }
    
    public void reset()
    {
        this.mMaxValue = 0;
        this.mSelectList = null;
    }
    
    /**
     * 0-1 背包问题
     * @param total 当前剩余的总容量
     * @param index 当前index件物品
     * @param max 当前总价值
     */
    private void knapsack(List<Goods> goodsList, int index, int remainCapacity, int max, List<Goods> selectList)
    {
        if (index >= goodsList.size())
        {
            if (max > mMaxValue)
            {
                mMaxValue = max;
                mSelectList = new ArrayList<>(selectList);
            }
            return;
        }
        
        // 选择了该物品
        Goods goods = goodsList.get(index);
        if (goods.weight <= remainCapacity)
        {
            selectList.add(goods);
            knapsack(goodsList, index + 1, remainCapacity - goods.weight, max + goods.value, selectList);
            selectList.remove(goods);
        }
        
        // 未选择该物品
        knapsack(goodsList, index + 1, remainCapacity, max, selectList);
    }
    
    /**
     * 创建一个商品列表
     * @return 商品列表
     */
    public static List<Goods> createGoodsList(int[] valueArray, int[] weightArray)
    {
        if (valueArray.length != weightArray.length)
        {
            throw new IllegalAccessError("value、weight；长度不匹配");
        }
        
        List<Goods> goodsList = new ArrayList<>();
        for (int i = 0; i < weightArray.length; i++)
        {
            goodsList.add(new Goods(i, valueArray[i], weightArray[i]));
        }
        return goodsList;
    }

    public static class Goods
    {
        private int index;
        
        // 价值
        private int value;
        
        // 重量
        private int weight;
        
        public Goods(int value, int weight)
        {
            this(-1, value, weight);
        }
        
        public Goods(int index, int value, int weight)
        {
            this.index = index;
            this.value = value;
            this.weight = weight;
        }
    }
}
