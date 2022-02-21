package com.test;

import java.util.HashSet;
import java.util.Set;

import com.test.base.Solution;

/**
 * 官方给定的answer, 比较人性化的一个方案,而且效率高
 * 解题思路：
 * 1，将第一段"较长的段落"，加入set，并计算出当前最大值
 * 2，往下遍历，若有遇到相同的，则将之前的抛弃掉，并抛出set；
 * 
 * 算法复杂度：
 * n*O(log(n))
 * 
 * @author YLine
 *
 * 2018年7月19日 下午3:05:55
 */
public class SolutionB implements Solution
{
    @Override
    public int lengthOfLongestSubstring(String s)
    {
        int length = s.length();
        
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < length && j < length)
        {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else
            {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
