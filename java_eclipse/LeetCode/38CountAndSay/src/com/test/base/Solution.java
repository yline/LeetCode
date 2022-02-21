package com.test.base;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * count-and-say 队列是一个整数队列，以下是前五个数
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 6.     312211
 * 7.     13112221
 * 
 * 1 is read off as "one 1" or 11.
 * 1读作，one 1或者一个1
 * 
 * 11 is read off as "two 1s" or 21.
 * 11读作，two 1或者两个1
 * 
 * 21 is read off as "one 2, then one 1" or 1211.
 * 21读作，one 2以及one 1，或者一个2以及一个1
 * 
 * 案例1：
 * Input: 1
 * Output: "1"
 * 
 * 案例2：
 * Input: 4
 * Output: "1211"
 * 
 * 即：数数，从前一个推到出后一个
 * 
 * @author YLine
 *
 * 2018年11月5日 下午8:47:14
 */
public interface Solution
{
    /**
     * @param n 第几个数
     * @return 结果
     */
    public String countAndSay(int n);
}
