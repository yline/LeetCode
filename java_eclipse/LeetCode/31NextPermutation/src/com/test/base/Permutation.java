package com.test.base;

import java.util.Arrays;

/**
 * 全排列介绍
 * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
 * 
 * 总个数为：n! / (n-m)!
 * 
 * 递归方法 + 字典方式
 * 
 * @author YLine
 *
 * 2018年9月17日 下午2:54:49
 */
public class Permutation
{
    public void test()
    {
        char[] arrays = {'1', '2', '3', '4'}; // 
        
        System.out.println("-----------递归方式-----------");
        recursePremutation(arrays, 0);
        
        System.out.println("-----------字典序法方式-----------");
        dictionaryPremutation(arrays);
    }
    
    /**
     * 递归方式实现全排列
     * 
     * 思路：(a,b,c)
     * 取a，接下来是b,c --> a,b,c + a,c,b
     * 取b，接下来是a,c --> b,a,c + b,c,a
     * 取c，接下来是a,b --> c,b,a + c,a,b
     * 
     * 全排列实现方式是，逐个交换；因此实现的结果和理论分析的结果会顺序不一致，但是结果是对的
     */
    private void recursePremutation(char[] arrays, int start)
    {
        if (start == arrays.length - 1)
        {
            System.out.println(Arrays.toString(arrays));
        }
        
        /**
         * 遍历每一次：
         * 将开始的位置和当前需要交换的位置替换，从而获取到a,b,c,d....作为头部，其它字符作为尾部的数据。
         * 
         * 递归，使的每次，都抛弃开头的数据。遍历之后的数据
         */
        for (int i = start; i < arrays.length; i++)
        {
            swapIfNotEqual(arrays, i, start); // 获取这部分的头部
            recursePremutation(arrays, start + 1);
            swapIfNotEqual(arrays, i, start); // 保证下一次遍历，数据不乱
        }
    }
    
    private void swapIfNotEqual(char[] arrays, int index, int start)
    {
        if (index != start)
        {
            char temp = arrays[index];
            arrays[index] = arrays[start];
            arrays[start] = temp;
        }
    }
    
    /**
     * 字典方式
     * 
     * 对给定的字符集中的字符规定了一个先后关系，在此基础上规定两个全排列的先后是从左到右逐个比较对应的字符的先后。
     * 
     * 1, 从右到左找到   右边>左边的数据，记录下左边indexL
     * 2, 从右到左找到  右边>左边index的第一个数据，记录下右边indexR
     * 3, indexL 和 indexR交换，然后将indexL右边的数据，排序一次。（复位的作用）；直到最后一个
     * 
     */
    private void dictionaryPremutation(char[] arrays)
    {
        Arrays.sort(arrays); // 排序
        
        while (true)
        {
            System.out.println(Arrays.toString(arrays));
            
            int index = 0;
            for (int i = arrays.length - 2; i >= 0; i--)
            {
                //从右向左找到第一个非递增的元素
                if (arrays[i] < arrays[i + 1])
                {
                    index = i;
                    break;
                }
                else if (i == 0)
                {
                    return;
                }
            }
            
            // 从右向左找到第一个比非递增元素大的元素
            int j = arrays.length - 1;
            for (int i = arrays.length - 1; i >= 0; i--)
            {
                if (arrays[i] > arrays[index])
                {
                    j = i;
                    break;
                }
            }
            
            swapIfNotEqual(arrays, index, j); // 交换找到的两个元素
            
            // 利用排序，将后面的数据进行遍历
            Arrays.sort(arrays, index + 1, arrays.length); //对非递增元素位置 后面的数组进行排列
        }
    }
}
