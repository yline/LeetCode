package com.test.n;

import java.util.Arrays;

/**
 * .基数排序[假设位数m, 位数容量为cap]
 * 
 * 1，最好情况时间复杂度
 * O(n*m)
 * 
 * 2，最坏情况时间复杂度
 * O(n*n*m)
 * 
 * 3，平均情况时间复杂度
 * O(n*m)
 * 
 * 4，空间复杂度
 * O(m*cap)
 * 
 * 5，稳定性
 * .稳定
 * 
 * @author YLine
 *
 * 2019年2月21日 下午4:59:25
 */
public class SolutionRadix
{
    private static final String[] ARRAY = {"hke", "iba", "hzg", "ikf", "hac"};
    
    public void sort()
    {
        System.out.println("------------------- Radix ----------------");
        System.out.println("start--" + Arrays.toString(ARRAY));
        // 三位，就排序三次
        for (int i = 2; i >= 0; i--)
        {
            stableSort(ARRAY, i);
        }
        System.out.println("finish-" + Arrays.toString(ARRAY));
    }
    
    /**
     * .插入排序,实现每次的排序
     * @param array 数组
     * @param index 下标
     */
    private static void stableSort(String[] array, int index)
    {
        for (int i = 0; i < array.length; i++)
        {
            String str = array[i];
            
            int j = i - 1;
            for (; j >= 0; j--)
            {
                if (str.charAt(index) < array[j].charAt(index))
                {
                    array[j + 1] = array[j];
                }
                else
                {
                    break;
                }
            }
            array[j + 1] = str;
        }
    }
}
