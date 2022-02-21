package com.test;

import com.test.base.SolBase;

/**
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7,
 * write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * 
 * 给一个可以随机生成1-7的函数，求一个随机生成1-10的函数
 * 
 * Do NOT use system's Math.random().
 * 不准用系统函数
 * 
 * @author YLine
 *
 * 2019年5月27日 下午7:11:35
 */
public class SolutionA extends SolBase
{
    public int rand10()
    {
        int result = 7 * (rand7() - 1) + rand7(); // 生成，1-49的随机数
        while (result > 40)
        {
            result = 7 * (rand7() - 1) + rand7();
        }
        
        return result % 10 + 1;
    }
}
