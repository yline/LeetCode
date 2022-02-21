package com.test;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 * 
 * 你是一个产品管理，当前正在开发一个产品；
 * 然而，最近的版本质量出现了问题；
 * 有一个出问题的版本，在其之后的所有版本，也是有问题的；
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * 假设你有版本，1、2...n个，你想要找到坏的那一个版本
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 * 
 * 求坏的那一个版本；要求调用检测的api的次数最少
 * 
 * @author YLine
 *
 * 2019年7月22日 上午9:58:12
 */
public class SolutionA
{
    public int firstBadVersion(int n)
    {
        int left = 0, right = n;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            System.out.println(mid);
            if (isBadVersion(mid))
            {
                if (mid == 0 || !isBadVersion(mid - 1))
                {
                    return mid;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return -1;
    }
    
    boolean isBadVersion(int version)
    {
        return false;
    }
}
