package com.test;

/**
 * Let's say a positive integer is a superpalindrome if it is a palindrome,
 * and it is also the square of a palindrome.
 * 
 * 正整数，它本身是回文，平方根也是回文
 * 
 * NowL,given two positive integers L and R (represented as strings),
 * return the number of superpalindromes in the inclusive range [LL,R].
 * 
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L and R are strings representing integers in the range [1L,10^18).
 * int(L) <= int(R)
 * 
 * 给一个区间，判断区间内，回文个数
 * 
 * 方案1：依据小回文数，直接遍历【估计会超时】
 * 
 * 方案2：依据小回文数的乘法，会发现规律
 * 1）如果没有进位，则小回文数的乘积，肯定是回文数
 * 2）考虑进位，则直接考虑进位对应的数，然后加法替代乘法，进行遍历【分析起来太复杂】
 * 
 * 方案3：考虑一下，其实方案2，可以帮忙定位：在规定范围内，这种超级回文数，数量是有限的。
 * 所以，可以直接先建立一个数组，然后查询数组内容就行
 * 
 * 
 * 本文考虑方案三
 * 数据来源：
 * https://zhanghuimeng.github.io/post/leetcode-906-super-palindromes/
 * 
 * @author YLine
 *
 * 2019年5月27日 下午5:27:26
 */
public class SolutionA
{
    public int superpalindromesInRange(String LL, String R)
    {
        // 除最后一个外，全部都是超级回文，最后一个是为了超过阈值，方便遍历
        long[] resultArray = {1L, 4L, 9L, 121L, 484L, 10201L, 12321L, 14641L, 40804L, 44944L, 1002001L, 1234321L,
            4008004L, 100020001L, 102030201L, 104060401L, 121242121L, 123454321L, 125686521L, 400080004,
            404090404L, 10000200001L, 10221412201L, 12102420121L, 12345654321L, 40000800004L,
            1000002000001L, 1002003002001L, 1004006004001L, 1020304030201L, 1022325232201L,
            1024348434201L, 1210024200121L, 1212225222121L, 1214428244121L, 1232346432321L,
            1234567654321L, 4000008000004L, 4004009004004L, 100000020000001L, 100220141022001L,
            102012040210201L, 102234363432201L, 121000242000121L, 121242363242121L, 123212464212321L,
            123456787654321L, 400000080000004L, 10000000200000001L, 10002000300020001L,
            10004000600040001L, 10020210401202001L, 10022212521222001L, 10024214841242001L,
            10201020402010201L, 10203040504030201L, 10205060806050201L, 10221432623412201L,
            10223454745432201L, 12100002420000121L, 12102202520220121L, 12104402820440121L,
            12122232623222121L, 12124434743442121L, 12321024642012321L, 12323244744232321L,
            12343456865434321L, 12345678987654321L, 40000000800000004L, 40004000900040004L, 1000000000000000000L};
        
        long leftValue = Long.parseLong(LL);
        long rightValue = Long.parseLong(R);
        
        int leftIndex = -1, rightIndex = -1;
        for (int i = 0; i < resultArray.length; i++)
        {
            if (leftIndex == -1 && resultArray[i] >= leftValue)
            {
                leftIndex = i;
            }
            
            if (rightIndex == -1 && resultArray[i] > rightValue)
            {
                rightIndex = i; // 包含的下一个
                break;
            }
        }
        
        return rightIndex - leftIndex;
    }
    
}
