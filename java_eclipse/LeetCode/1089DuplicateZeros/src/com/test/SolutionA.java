package com.test;

/**
 * 
 * 遇到0，就重复一次
 * 
 * @author YLine
 *
 * 2019年6月16日 上午10:15:35
 */
public class SolutionA
{
    public void duplicateZeros(int[] arr)
    {
        // 创造一个副本
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        
        int aIndex = 0, tempIndex = 0;
        while (aIndex < arr.length)
        {
            if (temp[tempIndex] == 0)
            {
                arr[aIndex] = 0;
                aIndex++;
                
                // 以防数组越界
                if (aIndex == arr.length)
                {
                    return;
                }
                arr[aIndex] = 0;
                aIndex++;
            }
            else
            {
                arr[aIndex] = temp[tempIndex];
                aIndex++;
            }
            
            tempIndex++;
        }
    }
}
