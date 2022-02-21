package com.test;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 
 * 给正整数n，建立所有的唯一的搜索二叉树
 * 
 * 搜索二叉树：
 * 左 < 中 < 右
 * 
 * 动态规划
 * 
 * @author YLine
 *
 * 2019年9月23日 下午1:39:05
 */
public class SolutionA
{
    public int numTrees(int n)
    {
        if (n < 1)
        {
            return 0;
        }
        
        if (n == 1)
        {
            return 1;
        }
        
        if (n == 2)
        {
            return 2;
        }
        
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            updateArray(array, i);
        }
        
        System.out.println("n = " + n + ", result = " + array[n]);
        return array[n];
    }
    
    private void updateArray(int[] array, int index)
    {
        int total = 0;
        for (int i = 1; i <= index; i++)
        {
            if (i == 1 || i == index)
            {
                total += array[index - 1];
            }
            else
            {
                total += (array[i - 1] * array[index - i]);
            }
        }
        
        array[index] = total;
    }
}
