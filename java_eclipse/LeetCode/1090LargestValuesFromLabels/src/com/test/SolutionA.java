package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 * 有一个集合，value和label，长度相同
 * Then, we choose a subset S of these items, such that:
 * 从中选择一个集合
 * 
 * |S| <= num_wanted
 * values中，最多选择 num_wanted个
 * 
 * For every label L, the number of items in S with label L is <= use_limit.
 * ，每次选中的value，对应的label，允许重复的次数 最多 use_limit次
 * 
 * Return the largest possible sum of the subset S.
 * 返回，S集合最大可能的结果
 * 
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i] <= 20000
 * 1 <= num_wanted, use_limit <= values.length
 * 
 *# 他没说，values是否从大到小排序，所以，先默认它排序了
 *结果它果然没排序，所以要先排个序
 *
 * @author YLine
 *
 * 2019年6月17日 下午5:48:57
 */
public class SolutionA
{
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit)
    {
        Node[] nodeArray = new Node[values.length];
        for (int i = 0; i < nodeArray.length; i++)
        {
            nodeArray[i] = new Node(values[i], labels[i]);
        }
        // 排序一次
        Arrays.sort(nodeArray, new Comparator<Node>()
        {
            
            @Override
            public int compare(Node o1, Node o2)
            {
                return o2.value - o1.value;
            }
        });
        
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // key-value ==> labels值-使用次数
        
        int numIndex = 0, valueIndex = 0;
        while (true)
        {
            // 超过次数，直接结束
            if (numIndex == num_wanted)
            {
                return result;
            }
            
            // 数组越界，直接结束
            if (valueIndex == nodeArray.length)
            {
                return result;
            }
            
            Integer oldSize = hashMap.get(nodeArray[valueIndex].label);
            if (null == oldSize)
            {
                hashMap.put(nodeArray[valueIndex].label, 1);
                result += nodeArray[valueIndex].value;
                
                valueIndex++;
                numIndex++;
            }
            else if (oldSize < use_limit)
            {
                hashMap.put(nodeArray[valueIndex].label, oldSize + 1);
                result += nodeArray[valueIndex].value;
                
                valueIndex++;
                numIndex++;
            }
            else
            {
                valueIndex++;
            }
        }
    }
    
    private static class Node
    {
        private int value;
        
        private int label;
        
        public Node(int value, int label)
        {
            this.value = value;
            this.label = label;
        }
    }
}
