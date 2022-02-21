package com.test;

import java.util.Arrays;

/**
 * Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  
 * Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
 * 
 * 给一个二维矩阵，你可以进行行变换或列变换，变换方式就是0-1,1-0
 * 
 * Return the maximum number of rows that have all values equal after some number of flips.
 * 求，经过行列变换之后，最多的可能结果
 * 
 * 方案：
 * 1，先对第一列遍历，将所有值遍历为0【记录变换过得行，以及当前满足状态】
 * 2，之后用递归，判断下一行去满足添加下的，“0”的个数，以及“1”的个数，然后，取最大值；
 * 
 * @author YLine
 *
 * 2019年6月4日 上午7:14:19
 */
public class SolutionA
{
    public int maxEqualRowsAfterFlips(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            return 0;
        }
        
        if (matrix[0].length == 1)
        {
            return matrix.length;
        }
        
        // 第一行，全部满足
        boolean[] matchArray = new boolean[matrix.length];
        Arrays.fill(matchArray, true);
        
        // 第一行，是否进行了行变换【将它全部变成0，好了】
        boolean[] firstChangeArray = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++)
        {
            firstChangeArray[i] = (matrix[i][0] == 1);
        }
        
        return dfs(matchArray, firstChangeArray, matrix, 1);
    }
    
    /**
     * 
     * 需要递归，藏的好深啊
     * 
     * @param matchArray 前一行，匹配的情况
     * @param firstArray 该行，是否进行了行变换
     * @param valueArray 该列的值
     */
    private int dfs(boolean[] matchArray, boolean[] firstArray, int[][] matrix, int column)
    {
        // 前一个为true时，1的个数，和0的个数
        int pSize = 0, nSize = 0;
        
        // 这里会浪费很多栈内存，不过我没其他办法了
        boolean[] cacheArray = new boolean[matchArray.length];
        
        // 遍历，找出1和0的较大值
        for (int i = 0; i < matrix.length; i++)
        {
            if (matchArray[i]) // 前一个为true
            {
                // 当前值为，0但进行了行变换，则认为为1；否则为0
                boolean isOne = (firstArray[i] && matrix[i][column] == 0) || (!firstArray[i] && matrix[i][column] == 1);
                if (isOne)
                {
                    // A代表，假设该列，全部由1 -> 0之后的情况
                    matchArray[i] = true;
                    cacheArray[i] = false;
                    pSize++;
                }
                else
                {
                    // B代表，假设该列，全部由0 -> 0之后的满足情况
                    cacheArray[i] = true;
                    matchArray[i] = false;
                    nSize++;
                }
            }
            else
            {
                matchArray[i] = false;
                cacheArray[i] = false;
            }
        }
        
        // 已经到达最后一列了
        if (column == matrix[0].length - 1)
        {
            return Math.max(pSize, nSize);
        }
        else
        {
            if (pSize != 0)
            {
                pSize = dfs(matchArray, firstArray, matrix, column + 1); // 子情况，1的个数
            }
            
            if (nSize != 0)
            {
                System.arraycopy(cacheArray, 0, matchArray, 0, matchArray.length);
                nSize = dfs(matchArray, firstArray, matrix, column + 1); // 子情况，0的个数
            }
            
            return Math.max(pSize, nSize);
        }
    }
    
}
