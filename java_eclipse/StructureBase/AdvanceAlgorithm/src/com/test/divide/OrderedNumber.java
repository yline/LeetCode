package com.test.divide;

import org.junit.Assert;

/**
 * 有序对个数
 * 如果编程求出一组数据的有序对个数？
 * 
 * 最笨的方法：拿每个数字和他后面的数字对比，将比他大的个数记做K，然后考察一遍，最终求和。就是有序对个数
 * 
 * 优化：分治算法，将数组分为A1，A2;分别计算A1为K1，A2为K2，A1和A2之间为K3
 * 则：结果 = K1 + K2 + K3
 * 
 * 参考：https://blog.csdn.net/qq_16399991/article/details/88385128
 * 
 * @author YLine
 *
 * 2019年4月15日 上午10:46:59
 */
public class OrderedNumber
{
    /**
     * 求有序对，个数
     * 
     * 时间复杂度：n*log(2n)
     * 空间复杂度：n*log(2n)【可以用全局量优化】
     * 
     * 主要是，并归的思想
     * 
     * @param array 队列
     * @return 有序对个数
     */
    public int calculateOrder(char[] array)
    {
        int step = 1;
        int size = 1 + (array.length - 1) / 2 / step;
        
        // 分治
        int result = 0;
        while (step < array.length)
        {
            for (int i = 0; i < size; i++)
            {
                int start = 2 * step * i;
                int end = start + 2 * step - 1;
                
                // 可能数组越界，这里处理一下
                result += merge(array, start, start + step - 1, (end >= array.length ? array.length - 1 : end));
            }
            
            step *= 2;
            size = 1 + (array.length - 1) / 2 / step;
        }
        
        return result;
    }
    
    public void testMerge()
    {
        char[] arrayA = {'1', '3', '5', '2', '4', '6'};
        int resultA = merge(arrayA, 0, 2, arrayA.length - 1);
        Assert.assertArrayEquals(new char[] {'1', '2', '3', '4', '5', '6'}, arrayA);
        Assert.assertEquals(6, resultA);
        
        char[] arrayB = {'1', '2'};
        int resultB = merge(arrayB, 0, 0, arrayB.length - 1);
        Assert.assertArrayEquals(new char[] {'1', '2'}, arrayB);
        Assert.assertEquals(1, resultB);
        
        char[] arrayC = {'1'};
        int resultC = merge(arrayC, 0, 0, arrayC.length - 1);
        Assert.assertArrayEquals(new char[] {'1'}, arrayC);
        Assert.assertEquals(0, resultC);
        
        char[] arrayD = {'1', '2', '3', '4'};
        int resultD = merge(arrayD, 0, 1, arrayD.length - 1);
        Assert.assertArrayEquals(new char[] {'1', '2', '3', '4'}, arrayD);
        Assert.assertEquals(4, resultD);
    };
    
    /**
     * AB区间大小不能为1
     * 
     * 对数组中的某一段，从中间分开；为A区间和B区间
     * A区间内 和 B区间内，分别是有序的，并且两个区间连续
     * 
     * 最终，AB区间是有序的，并且返回有序对数
     * 
     * 时间复杂度：rightEnd-leftStart
     * 空间复杂度：rightEnd-leftStart
     * 
     * @param array 数组
     * @param finalLeftStart 开始位置
     * @param rightEnd 结束位置
     * @return
     */
    private int merge(char[] array, final int finalLeftStart, final int finalLeftEnd, final int finalRightEnd)
    {
        int length = finalRightEnd - finalLeftStart + 1;
        
        // 长度小于2，则不用进行比较了
        if (length < 2)
        {
            return 0;
        }
        
        char[] tempArray = new char[length];
        
        // 计算结果值
        int index = 0;
        int result = 0;
        int leftStart = finalLeftStart;
        int rightStart = finalLeftEnd + 1;
        
        while (leftStart <= finalLeftEnd || rightStart <= finalRightEnd)
        {
            // 左边达到最大值
            if (leftStart > finalLeftEnd)
            {
                for (int i = rightStart; i <= finalRightEnd; i++)
                {
                    tempArray[index] = array[i];
                    index++;
                }
                break;
            }
            
            // 右边达到最大值
            if (rightStart > finalRightEnd)
            {
                for (int i = leftStart; i <= finalLeftEnd; i++)
                {
                    tempArray[index] = array[i];
                    index++;
                }
                break;
            }
            
            // 两边都还未达到最大值
            if (array[leftStart] < array[rightStart])
            {
                result += (finalRightEnd - rightStart + 1);
                
                tempArray[index] = array[leftStart];
                index++;
                leftStart++;
            }
            else
            {
                tempArray[index] = array[rightStart];
                index++;
                rightStart++;
            }
        }
        
        // 迁移位置
        for (int i = 0; i < length; i++)
        {
            array[i + finalLeftStart] = tempArray[i];
        }
        
        return result;
    }
}
