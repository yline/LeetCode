package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
 * 有一个条形码
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal.
 * You may return any answer, and it is guaranteed an answer exists.
 * 从新排序，保证任意位置，前后不相同
 * 
 * @author YLine
 *
 * 2019年5月26日 下午9:13:17
 */
public class SolutionA
{
    public int[] rearrangeBarcodes(int[] barcodes)
    {
        List<Integer> tempList = new ArrayList<>(); // 缓存不满足的队列
        Result result = new Result(barcodes.length);
        
        result.add(barcodes[0]);
        for (int i = 1; i < barcodes.length; i++)
        {
            // 如果和上一个相等
            if (barcodes[i] == result.getLast())
            {
                tempList.add(barcodes[i]);
            }
            else // 如果和上一个不相等
            {
                result.add(barcodes[i]);
            }
            
            // 清除，队列中的数据
            while (!tempList.isEmpty())
            {
                int matchIndex = -1;
                for (int j = 0; j < tempList.size(); j++)
                {
                    if (tempList.get(j) != result.getLast())
                    {
                        matchIndex = j;
                        break;
                    }
                }
                
                // 没有可以填充的项，退出循环
                if (matchIndex == -1)
                {
                    break;
                }
                else // 有可以填充的项
                {
                    result.add(tempList.get(matchIndex));
                    
                    // 移除填充进的项
                    tempList.remove(matchIndex);
                }
            }
        }
        
        // 最后一次，清除队列中的数据
        for (int i = 0; i < tempList.size(); i++)
        {
            result.insert(tempList.get(i));
        }
        
        result.toString();
        return result.resultArray;
    }
    
    public static class Result
    {
        private int lastPos;
        private final int[] resultArray;
        
        public Result(int size)
        {
            lastPos = -1;
            resultArray = new int[size];
        }
        
        public void add(int value)
        {
            lastPos++;
            resultArray[lastPos] = value;
        }
        
        public int getLast()
        {
            return resultArray[lastPos];
        }
        
        public void insert(int value)
        {
            // 插入首位
            if (resultArray[0] != value)
            {
                System.arraycopy(resultArray, 0, resultArray, 1, lastPos + 1);
                resultArray[0] = value;
                lastPos++;
            }
            else // 插入非首位
            {
                int mathIndex = -1;
                for (int i = 1; i <= lastPos + 1; i++)
                {
                    if (value != resultArray[i - 1] && value != resultArray[i])
                    {
                        mathIndex = i;
                        break;
                    }
                }
                
                if (mathIndex != -1)
                {
                    System.arraycopy(resultArray, mathIndex, resultArray, mathIndex + 1, lastPos - mathIndex + 1);
                    resultArray[mathIndex] = value;
                    lastPos++;
                }
            }
        }
        
        @Override
        public String toString()
        {
            System.out.println("result = " + Arrays.toString(resultArray));
            return super.toString();
        }
    }
}
