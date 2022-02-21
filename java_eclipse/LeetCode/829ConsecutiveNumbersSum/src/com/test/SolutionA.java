package com.test;

/**
 * Given a positive integer N,
 * how many ways can we write it as a sum of consecutive positive integers?
 * 
 * .给一个正整数
 * .有多少种方法，能够使连续的数字之和，等于该数字
 * 
 * .假设由h个数字组成，h大于等于1；连续的数字最小值为x，给定的数值为num
 * 
 * 2:x + (x+1)
 * 3:x + (x+1) + (x+2)
 * 4:x + (x+1) + (x+2) + (x+3)
 * n:x + (x+1) + (x+2) + (x+3) + ... + (x+n-1)
 * 
 * .因此：sum = h*x + (h)*(h-1)/2
 * 
 * @author YLine
 *
 * 2019年8月15日 下午5:30:09
 */
public class SolutionA
{
    public int consecutiveNumbersSum(int N)
    {
        StringBuilder sBuilder = new StringBuilder("1,");
        
        int count = 1;
        for (int h = 2; h < N; h++)
        {
            int multi = N - h * (h - 1) / 2;
            
            // 超过最大值了，直接退出
            if (multi <= 0)
            {
                break;
            }
            
            if (multi % h == 0)
            {
                count++;
                sBuilder.append(h + ",");
            }
        }
        
        System.out.println("N = " + N + ", hArray = " + sBuilder.toString());
        return count;
    }
}
