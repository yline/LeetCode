package com.test.greedy;

/**
 *  钱币找零
 *  1，我们有 1 元、2 元、5 元、10 元、20 元、50 元、100 元这些面额的纸币
 *  2，这些钱来支付 K 元，最少要用多少张纸币呢？【最少数量的纸币】
 * 
 * 贪心算法：
 * 先用面值最大的来支付，如果不够，就继续用更小一点面值的，以此类推
 * 
 * @author YLine
 *
 * 2019年4月15日 上午10:15:35
 */
public class CoinChange
{
    private static final int[] Values = {1, 2, 5, 10, 20, 50, 100};
    
    /**
     * 钱币找零
     * 
     * 贪心算法：每次都只求最大额
     * 
     * @param value 金额
     * @return -1 if parameter is invalid
     */
    public int minPaper(int value)
    {
        if (value < 0)
        {
            return -1;
        }
        
        int minPaper = 0;
        int temp = value;
        for (int i = Values.length - 1; i >= 0; i--)
        {
            minPaper += (temp / Values[i]);
            temp = temp % Values[i];
        }
        return minPaper;
    }
}
