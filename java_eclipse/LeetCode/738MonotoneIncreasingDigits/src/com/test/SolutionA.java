package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 采用空间缓存的策略
 * @author YLine
 *
 * 2019年5月9日 上午8:25:07
 */
public class SolutionA implements Solution
{
    
    @Override
    public int monotoneIncreasingDigits(int N)
    {
        // N范围为 [0-10^9]
        List<Integer> tempList = new ArrayList<>(10);
        
        // 存入缓存
        int temp = N;
        while (temp > 0)
        {
            tempList.add(temp % 10);
            temp /= 10;
        }
        
        // 找到首个不是单调递增的
        int index = -1;
        for (int i = tempList.size() - 1; i > 0; i--)
        {
            if (tempList.get(i) > tempList.get(i - 1))
            {
                index = i;
                break;
            }
        }
        
        if (index == -1)
        {
            return N;
        }
        else
        {
            // 防止因为减少，而导致前面比后面大的情况
            for (int i = index + 1; i < tempList.size(); i++)
            {
                if (tempList.get(i - 1) != tempList.get(i))
                {
                    break;
                }
                else
                {
                    index++;
                }
            }
            
            int result = 0;
            for (int i = tempList.size() - 1; i > index; i--)
            {
                result = (result * 10 + tempList.get(i));
            }
            
            // 修改的那一个
            result = result * 10 + tempList.get(index) - 1;
            
            // 末尾
            for (int i = index - 1; i >= 0; i--)
            {
                result = (result * 10 + 9);
            }
            
            return result;
        }
    }
}
