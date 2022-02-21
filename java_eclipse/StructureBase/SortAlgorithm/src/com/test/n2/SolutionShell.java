package com.test.n2;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * 希尔排序
 * 
 * 1，最好情况时间复杂度
 * O(n)
 * 
 * 2，最坏情况时间复杂度
 * O(n^(3/2))  增量序列为[1,2,4,8,16...]
 * 
 * 3，平均情况时间复杂度
 * ...
 * 
 * 4，空间复杂度
 * O(1)
 * 
 * 5，稳定性
 * 不稳定
 * 
 * @author YLine
 *
 * 2019年2月20日 上午10:21:58
 */
public class SolutionShell implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        // 进行分组，最开始的增量(gap)为数组长度的一半
        for (int gap = array.length / 2; gap > 0; gap /= 2)
        {
            // 对各个分组进行插入排序
            for (int i = gap; i < array.length; i++)
            {
                insert(array, gap, i);
            }
        }
    }
    
    /**
     * .将 array[i] 插入到所在分组的正确位置上
     * array[i] 所在分组为：
     * ...array[i - 2*gap]、array[i - gap]、array[i]、array[i+gap]...
     * 
     * @param array
     * @param gap
     * @param i
     */
    private void insert(Node[] array, int gap, int i)
    {
        Node inserted = array[i];
        int j;
        
        // 插入的时候，按组进行插入(组内元素两两相隔gap)
        for (j = i - gap; j >= 0 && inserted.value < array[j].value; j -= gap)
        {
            array[j + gap] = array[j];
        }
        
        array[j + gap] = inserted;
    }
}
