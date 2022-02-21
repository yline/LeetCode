package com.test;

import com.test.base.RLEIterator;

/**
 * 
 * Write an iterator that iterates through a run-length encoded sequence.
 * 实现一个迭代器，迭代一个已编码的数组
 * 
 * The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.
 * 迭代器，首先有一个初始化方法
 * 
 * More specifically, for all even i, A[i] tells us the number of times that
 * the non-negative integer value A[i+1] is repeated in the sequence.
 * A[i]和A[i+1]，i为偶数，表示：有A[i]个A[i+1]
 * 
 * The iterator supports one function: next(int n), which exhausts the next n elements (n >= 1)
 * and returns the last element exhausted in this way.
 * If there is no element left to exhaust, next returns -1 instead.
 * 
 * 实现next方法，输出第n个数字，如果没有，则返回-1
 * 
 * For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].
 * This is because the sequence can be read as "three eights, zero nines, two fives".
 * 
 *  案例：A = [3,8,0,9,2,5]，表达的序列为：[8,8,8,5,5]，解释为3个8,0个9,2个5
 *
 *分别调用2,1,1,2；则输出，8,8,5，-1
 *
 * @author YLine
 *
 * 2019年5月28日 下午2:08:16
 */
public class SolutionA extends RLEIterator
{
    
    public SolutionA(int[] A)
    {
        super(A);
    }
    
    @Override
    public int next(int n)
    {
        if (index >= length)
        {
            return -1;
        }
        
        if (n < data[index])
        {
            data[index] -= n;
            return data[index + 1];
        }
        else if (n == data[index])
        {
            data[index] = 0;
            int result = data[index + 1];
            index += 2;
            return result;
        }
        else
        {
            int lastSize = data[index];
            data[index] = 0;
            index += 2;
            return next(n - lastSize);
        }
    }
}
