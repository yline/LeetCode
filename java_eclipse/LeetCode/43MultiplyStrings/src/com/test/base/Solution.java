package com.test.base;

/**
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2, also represented as a string.
 * 
 * 给定两个非负数，求乘积
 * 
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * Note:
 *  The length of both num1 and num2 is < 110. 长度小于110
 *  Both num1 and num2 contain only digits 0-9. 只包含0-9的数字
 *  Both num1 and num2 do not contain any leading zero, except the number 0 itself. 头部不包含0，除非本身为0
 *  You must not use any built-in BigInteger library or convert the inputs to integer directly. 不准使用大数计算等辅助库
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:30:35
 */
public interface Solution
{
    public String multiply(String num1, String num2);
}
