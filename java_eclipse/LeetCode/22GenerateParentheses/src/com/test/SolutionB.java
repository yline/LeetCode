package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 递归的方式，递归公式  f(m) = f(m-1)'('*(是否存在) + f(m-1)')';
 * 
 * 时间复杂度：
 * n*n
 * 
 * @author YLine
 *
 * 2018年8月20日 下午2:18:21
 */
public class SolutionB implements Solution
{
    
    /**
     * <pre>
     * Given n pairs of parentheses, write a function to generate all combinations
     * of well-formed parentheses.
     *
     * For example, given n = 3, a solution set is:
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     *
     * 题目大意：
     * 给定n对括号，输出他们所有正确的组合
     *
     * 解题思路：
     * 采用递归求解试
     * </pre>
     *
     * @param n
     * @return
     */
    @Override
    public List<String> generateParenthesis(int n)
    {
        // 保存结果的队列
        List<String> result = new ArrayList<>();
        // 括号数大于0
        if (n > 0)
        {
            // 捛使用数组
            char[] parentheses = new char[2 * n];
            // 问题求解
            solve(n, n, parentheses, result);
        }
        return result;
    }
    
    /**
     * @param left        剩余可用的左括号数
     * @param right       剩余可用的右括号数
     * @param parentheses 到上一次为止括号使用的情况
     * @param result      存放结果的集合
     */
    public void solve(int left, int right, char[] parentheses, List<String> result)
    {
        // 剩下的括号数不能小于0，并且每次剩下的右括号数都不能小于左括号数
        if (left < 0 || right < 0 || right < left)
        {
            // 什么都不用做
        }
        // 左右括号都被使用完了
        else if (left == 0 && right == 0)
        {
            result.add(new String(parentheses));
        }
        // 可以使用
        else
        {
            // 当前使用的位置
            int idx = parentheses.length - left - right;
            // 使用左括号
            parentheses[idx] = '(';
            // 递归求解
            solve(left - 1, right, parentheses, result);
            // 使用右括号
            parentheses[idx] = ')';
            solve(left, right - 1, parentheses, result);
        }
    }
}
