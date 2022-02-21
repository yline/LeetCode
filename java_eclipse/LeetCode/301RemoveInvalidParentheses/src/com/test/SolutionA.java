package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.test.base.Solution;

/**
 * Remove the minimum number of invalid parentheses in order to
 * make the input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * Example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * Example 3:
 * Input: ")("
 * Output: [""]
 * 
 * 方案分类递归
 * 
 * @author YLine
 *
 * 2019年9月10日 上午11:25:58
 */
public class SolutionA implements Solution
{
    @Override
    public List<String> removeInvalidParentheses(String s)
    {
        int[] valid = validParentheses(s);
        final int max = valid[0];
        final int length = valid[1];
        
        HashSet<String> result = new HashSet<>();
        dfs(result, s, 0, new char[length], 0, max, max, 0);
        
        System.out.println(Arrays.toString(result.toArray()));
        return new ArrayList<>(result);
    }
    
    private void dfs(HashSet<String> result, String s, int sIndex, char[] array, int chIndex,
        int leftMax, int rightMax, int left)
    {
        if (sIndex == s.length())
        {
            if (chIndex == array.length)
            {
                result.add(new String(array));
            }
            return;
        }
        
        final char ch = s.charAt(sIndex);
        switch (ch)
        {
            case '(':
                if (leftMax > 0) // 还能添加
                {
                    // 不添加
                    dfs(result, s, sIndex + 1, array, chIndex, leftMax, rightMax, left);
                    
                    // 添加
                    array[chIndex] = ch;
                    dfs(result, s, sIndex + 1, array, chIndex + 1, leftMax - 1, rightMax, left + 1);
                }
                else
                {
                    // 不添加
                    dfs(result, s, sIndex + 1, array, chIndex, leftMax, rightMax, left);
                }
                break;
            case ')':
                if (rightMax > 0 && left > 0) // 还能添加
                {
                    // 不添加
                    dfs(result, s, sIndex + 1, array, chIndex, leftMax, rightMax, left);
                    
                    // 添加
                    array[chIndex] = ch;
                    dfs(result, s, sIndex + 1, array, chIndex + 1, leftMax, rightMax - 1, left - 1);
                }
                else
                {
                    // 不添加
                    dfs(result, s, sIndex + 1, array, chIndex, leftMax, rightMax, left);
                }
                break;
            default:
                array[chIndex] = ch;
                dfs(result, s, sIndex + 1, array, chIndex + 1, leftMax, rightMax, left);
                break;
        }
    }


    private int[] validParentheses(String s)
    {
        int left = 0, max = 0, num = 0;
        for (int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i))
            {
                case '(':
                    left++;
                    break;
                case ')':
                    if (left > 0)
                    {
                        left--;
                        max++;
                    }
                    break;
                default:
                    num++;
                    break;
            }
        }
        
        System.out.println("max = " + max + ", num = " + num);
        return new int[] {max, 2 * max + num};
    }
}
