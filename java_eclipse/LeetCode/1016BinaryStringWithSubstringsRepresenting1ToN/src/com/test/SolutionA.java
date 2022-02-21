package com.test;

import java.util.BitSet;

/**
 * Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
 * 给一个字符串，有0和1组成
 * 
 * return true if and only if for every integer X from 1 to N, 
 * the binary representation of X is a substring of S.
 * 
 * 当字符串的子字符串，可以表示1-N的所有数时，返回true
 * 
 * 解决方案：从后往前遍历，如果某个值未赋值，则赋值，最后校验是否全部为true即可
 * 
 * 特点：假设N 的大小 = 2^length + x, x <= 2^length时，只需要满足最后那一层的二进制，就满足所有的了。如果未满足，则失败
 * 因此，只需要对最后 2^length个数字，进行赋值即可【即，二进制的长度为length、length+1】
 * 
 * 耗时 24ms，时间比较长
 * 
 * @author YLine
 *
 * 2019年5月31日 上午7:59:41
 */
public class SolutionA
{
    /**
     * 输入参数 N >= 1
     * S >= 1
     */
    public boolean queryString(String S, int N)
    {
        if (N == 1) // N = 1，只考虑1
        {
            for (int i = S.length() - 1; i >= 0; i--)
            {
                if (S.charAt(i) == '1')
                {
                    return true;
                }
            }
            return false;
        }
        else if (N == 2) // N = 2, 只考虑10 
        {
            if (S.length() == 1) // 长度不够
            {
                return false;
            }
            
            int value = getFirstValue(S, 2);
            if (value == 2)
            {
                return true;
            }
            for (int i = S.length() - 3; i >= 0; i--)
            {
                value >>= 1;
                value |= (S.charAt(i) == '1' ? 2 : 0);
                
                if (value == 2)
                {
                    return true;
                }
            }
            return false;
        }
        else // N > 2的情况
        {
            int index = 0; // index表示，N对应有几个'0'或'1'
            
            int temp = N;
            while (temp > 0)
            {
                index++;
                temp = (temp >> 1);
            }
            
            int start = (1 << (index - 2)) + 1; // 需要确定有的数据，的对应的开始值
            
            System.out.println("N = " + N + ", index = " + index + ", start = " + start + ", end = " + N);
            if (S.length() < index)
            {
                return false;
            }
            
            int value = getFirstValue(S, index);
            Result result = new Result(start, N);
            result.addValue(value);
            
            int topValue = 1 << (index - 1);
            for (int i = S.length() - index - 1; i >= 0; i--)
            {
                value >>= 1;
                value |= (S.charAt(i) == '1' ? topValue : 0);
                
                result.addValue(value >> 1); // 前 length - 1个的情况
                result.addValue(value); // length个
                if (result.isTrue())
                {
                    return true;
                }
            }
            
            return false;
        }
    }
    
    /**
     * 求，某个字符串，倒数第几位，对应的值
     * @param S 字符串
     * @param length 最后长度
     * @return 对应的int值
     */
    public int getFirstValue(String S, int length)
    {
        int lastIndex = S.length() - 1;
        int value = 0;
        
        for (int i = 0; i < length; i++)
        {
            if (S.charAt(lastIndex - i) == '1')
            {
                value |= (1 << i);
            }
        }
        return value;
    }
    
    public static class Result
    {
        private int sSize; // 当前数
        
        private BitSet sBitSet; // 缓存
        
        private int sStart; // 开始值
        
        private int sEnd; // 结束值
        
        private int sTotalCount; // 总数
        
        public Result(int start, int end)
        {
            sStart = start;
            sEnd = end;
            sTotalCount = end - start + 1;
            
            sSize = 0;
            sBitSet = new BitSet(sTotalCount);
        }
        
        /**
         * 当前值
         * @param value
         */
        public void addValue(int value)
        {
            // 不在范围内，直接过滤
            if (value < sStart || value > sEnd)
            {
                return;
            }
            
            int index = value - sStart;
            if (!sBitSet.get(index)) // 如果未添加过，则添加
            {
                sSize++;
                sBitSet.set(index, true);
            }
        }
        
        /**
         * 判断最终结果
         * @return true if 已经被填充满了
         */
        public boolean isTrue()
        {
            return sSize == sTotalCount;
        }
    }
}
