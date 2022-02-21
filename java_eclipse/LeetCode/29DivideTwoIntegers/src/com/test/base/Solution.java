package com.test.base;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 *
 * 题目大意：
 * 不使用除法，乘法和取余，求两个整数的相除的结果，如果有溢出就返回最大的整数
 * 
 * @author YLine
 *
 * 2018年8月30日 上午10:19:18
 */
public interface Solution
{
    public int divide(int dividend, int divisor);
}
