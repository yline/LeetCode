package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.base.Solution;

/**
 * https://www.acwing.com/solution/leetcode/content/4699/
 * 
 * 1，假设最大的长度为a，则比它大的长度，一定是没有结果的；因此，可以用二分法，求出这个a。
 * 
 * 2，固定长度，则移动1位，利用hash求值，避免全部比较。
 * 
 *  - 先寻找length
 *  - length 对应的长度hash值进行比较
 *  时间复杂度：O(n*logn)
 * 
 * @author YLine
 *
 * 2019年11月21日 下午6:00:19
 */
public class SolutionC implements Solution
{
    private static final int MOD = 838_4287; // 找到的一个很大的质数了
    
    @Override
    public String longestDupSubstring(String S)
    {
        HashPlugin plugin = new HashPlugin(S.length());

        String mResult = null;
        
        int left = 0, right = S.length() - 1;
        while (left < right)
        {
            int mid = (left + right) >>> 1;
            mResult = getDupSubstring(S, plugin, mid + 1);
            if (null == mResult)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        int length = left;
        if (length == 0)
        {
            return "";
        }
        
        if (null != mResult && length == mResult.length())
        {
            return mResult;
        }
        else
        {
            return getDupSubstring(S, plugin, length);
        }
    }
    
    /**
     * .计算当前长度，是否有重复的字符串
     * @param S
     * @param plugin
     * @param length 长度
     * @return
     */
    private String getDupSubstring(String S, HashPlugin plugin, int length)
    {
        int startHash = plugin.getHash(S, 0, length);
        
        // 添加hash 到 index的关联
        HashMap<Integer, List<Integer>> cacheMap = new HashMap<>();
        List<Integer> list = new ArrayList<>(2);
        list.add(0);
        cacheMap.put(startHash, list);
        
        int preHash = startHash;
        final int endIndex = S.length() - length;
        for (int i = 1; i <= endIndex; i++)
        {
            // int hash = plugin.getHash(S, i, length);
            int hash = plugin.getHashByPre(S, preHash, i - 1, length);
            if (cacheMap.containsKey(hash))
            {
                if (isEqual(S, cacheMap.get(hash), i, length))
                {
                    return S.substring(i, i + length);
                }
                else
                {
                    cacheMap.get(hash).add(i);
                }
            }
            else
            {
                List<Integer> tempList = new ArrayList<>(2);
                tempList.add(i);
                cacheMap.put(hash, tempList);
            }
            preHash = hash;
        }
        
        return null;
    }
    
    /**
     * .判断两个字符串是否相等
     * @param S
     * @param tempList
     * @param index
     * @return
     */
    private boolean isEqual(String S, List<Integer> tempList, int index, int length)
    {
        for (int i = 0; i < tempList.size(); i++)
        {
            int preStart = tempList.get(i);
            
            boolean isEqual = true;
            for (int k = 0; k < length; k++)
            {
                // 不相等
                if (S.charAt(index + k) != S.charAt(preStart + k))
                {
                    isEqual = false;
                    break;
                }
            }
            
            if (isEqual)
            {
                return true;
            }
        }
        
        return false;
    }
    
    private static class HashPlugin
    {
        private final int[] power;
        
        /**
         * .对于String hash值计算公式为： s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
         * 
         * .针对于当前的情况，系数反过来，会比较合适；因此，公式为：
         * hash[n] = s[0]*31^0 + s[1]*31^1 + ... + s[n-1]*31^(n-1)
         * 
         * .换成通用式，对于长度为n，起点为i的hash值
         * hash[i, n] = s[i]*31^0 + s[i+1]*31^1 + ... + s[i+n-1]*31^(n-1)
         * hash[i+1, n] = s[i+1]*31^0 + ... + s[i+n-1]*31^(n-2) + s[i+n]*31^(n-1)
         * 
         * .则可以得到递推式：
         * hash[i+1, n] = (hash[i, n] - s[i]*31^0) / 31 + s[i+n]*31^(n-1)
         * 
         * .由于存在，Integer的越界，因此，递推式，失效。
         * 
         * .改善方案：引入一个较大的质数，不能太大，避免乘法直接越界，1_1134_7293，mod
         * mod < MAX_VALUE / 256
         * mod < 8 388 607，因此，选取的质数为：838_4287
         * 
         * @param length 总的长度
         */
        public HashPlugin(int size)
        {
            power = new int[size];
            
            power[0] = 1;
            for (int i = 1; i < size; i++)
            {
                power[i] = 31 * power[i - 1];
                power[i] /= MOD;
            }
        }
        
        /**
         * .计算第一个 hash值
         * @param S 字符串
         * @param start 起始位置
         * @param length 长度
         * @return hash值
         */
        public int getHash(String S, int start, int length)
        {
            int hash = 0;
            for (int i = 0; i < length; i++)
            {
                hash += (S.charAt(i + start) * power[i]);
                hash /= MOD;
            }
            return hash;
        }
        
        /**
         * .依据前一个值，计算下一个的hash值
         * 
         * @param S 字符串
         * @param preHash 前一个hash值
         * @param preStart 前一个hash开始的位置
         * @param length 长度
         * @return hash值
         */
        public int getHashByPre(String S, int preHash, int preStart, int length)
        {
            int diffA = (preHash - S.charAt(preStart) + MOD) / 31;
            int diffB = S.charAt(preStart + length) * power[length - 1];
            return (diffA + diffB / MOD) / MOD;
        }
    }
}
