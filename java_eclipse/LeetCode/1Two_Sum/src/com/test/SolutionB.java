package com.test;

import java.util.Arrays;
import java.util.Comparator;

import com.test.base.Solution;

/**
 * 解题思路：
 * 1，对数组进行排序（因为会打乱顺序，因此需要提前记录原有顺序）
 * 2，对排序后的数组，指向两端，总和大于则右边左移，总和小于则左边右移，知道所有数据都处理完
 * 
 * 复杂度：
 * n + O(n*log(n)) + n ==> O(n*log(n))
 * 
 * @author YLine
 *
 * 2018年7月19日 上午11:46:45
 */
public class SolutionB implements Solution
{
    @Override
    public int[] twoSum(int[] nums, int target)
    {
        // 遍历复制
        Node[] tmp = new Node[nums.length];
        for (int i = 0; i < tmp.length; i++)
        {
            tmp[i] = new Node(nums[i], i);
        }
        
        // 快速排序
        Arrays.sort(tmp, new Comparator<Node>()
        {
            @Override
            public int compare(Node o1, Node o2)
            {
                return o1.value - o2.value;
            }
        });
        
        // 两端查询
        int i = 0, j = nums.length - 1;
        while (i < j)
        {
            if (tmp[i].value + tmp[j].value == target)
            {
                return new int[] {tmp[i].index, tmp[j].index};
            }
            else if (tmp[i].value + tmp[j].value > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        
        return new int[] {0, 0};
    }
    
    public static class Node
    {
        int index;
        
        int value;
        
        public Node(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }
}
