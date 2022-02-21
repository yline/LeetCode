package com.test;

import java.util.ArrayDeque;

/**
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
 * 
 * 给两个数组，它的位数，表示（-2）^(length-1-index)，返回，两个数组的和。并且表达方式相同
 * 
 * Each number is given in array format:  as an array of 0s and 1s,
 * from most significant bit to least significant bit.
 * 
 * 案例：
 * For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.
 * A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
 * arr = [1, 1, 0, 1]，代表 arr = (-2)^3 + (-2)^2 + (-2)^0 = -3
 * 
 * Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.
 * 返回，arr1 + arr2的结果，并且还是用数组表示
 * 
 * 1，由加法进位，分析，最多的情况可以多3位，然后直接给前面加0；
 * 2，直接对数组处理，然后两者求和
 * 3，对结果，前面如果未0，进行处理就是结果了
 * 
 * @author YLine
 *
 * 2019年6月4日 上午7:16:39
 */
public class SolutionA
{
    public int[] addNegabinary(int[] arr1, int[] arr2)
    {
        int maxLength = Math.max(arr1.length, arr2.length) + 3;
        ArrayDeque<Integer> queue = new ArrayDeque<>(maxLength);
        
        int[] arrA = new int[maxLength];
        System.arraycopy(arr1, 0, arrA, arrA.length - arr1.length, arr1.length);
        
        int[] arrB = new int[maxLength];
        System.arraycopy(arr2, 0, arrB, arrB.length - arr2.length, arr2.length);
        
        add(arrA, arrB, queue);
        
        if (queue.isEmpty())
        {
            return new int[] {0};
        }
        else
        {
            int[] resultArray = new int[queue.size()];
            for (int i = 0; i < resultArray.length; i++)
            {
                resultArray[i] = queue.poll();
            }
            return resultArray;
        }
    }
    
    /**
     * 将两个值，添加进去
     * @param arrA 数组，长度相同；由于前面三个肯定为0，所以最后就不用考虑enterOne了
     * @param arrB 数组，长度相同
     * @param result 结果
     */
    private void add(int[] arrA, int[] arrB, ArrayDeque<Integer> queue)
    {
        int index = arrB.length - 1;
        int enterOne = 0; // 之前进位的情况
        while (index >= 0)
        {
            int value = arrA[index] + arrB[index] + enterOne;
            if (value == 0)
            {
                queue.addFirst(0);
                enterOne = 0;
            }
            else if (value == 1)
            {
                queue.addFirst(1);
                enterOne = 0;
            }
            else if (value == 2)
            {
                queue.addFirst(0);
                enterOne = -1;
            }
            else if (value == -1)
            {
                queue.addFirst(1);
                enterOne = 1;
            }
            else if (value == 3)
            {
                queue.addFirst(1);
                enterOne = -1;
            }
            
            index--;
        }
        
        // 考虑到首位可能为0，清除首位的0; 但也可能直接导致队列大小为0
        int value = queue.getFirst();
        while (value == 0)
        {
            queue.removeFirst();
            
            if (queue.isEmpty())
            {
                break;
            }
            value = queue.getFirst();
        }
    }
}
