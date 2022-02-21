package com.test.base;

/**
 * 分析方面：
 * 1，最好、最坏、平均时间复杂度
 * 2，时间复杂度的系数、常数、低阶
 * 3，比较次数 和 交换次数
 * 4，算法额外的内存消耗，即：空间复杂度；O(1)称为原地排序
 * 5，算法的稳定性，即：若待排序序列中存在值相等的原色，排序后，先后顺序不变
 * 
 * @author YLine
 *
 * 2018年12月6日 下午10:11:50
 */
public interface Solution
{
    /**
     * 排序算法
     * @param array 输入队列
     */
    public void sort(Node[] array);
}
