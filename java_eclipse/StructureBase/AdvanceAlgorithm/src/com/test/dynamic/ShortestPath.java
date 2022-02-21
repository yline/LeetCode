package com.test.dynamic;

/**
 * 最短路径问题
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。
 * 棋子起始位置在左上角，终止位置在右下角。我们将棋子从左上角移到右下角。每次只能向右或者向下移动一位。
 * 整个过程，会有多种不同的路径可以选择。我们把每条路径经过的数字加起来看作路径的长度。
 * 那从左上角到右下角的最短路径长度是多少呢？路径是什么？
 * 
 * 参考：https://blog.csdn.net/every__day/article/details/88174082
 * 
 * 解题思路：状态转移表法
 * 
 * @author YLine
 *
 * 2019年4月15日 下午5:19:35
 */
public class ShortestPath
{
    public static int backtrack(int[][] array)
    {
        ShortestPath path = new ShortestPath();
        path.mMinResult = Integer.MAX_VALUE;
        path.backtrackInner(array, 0, 0, 0);
        return path.mMinResult;
    }
    
    private int mMinResult = Integer.MAX_VALUE;
    
    public void backtrackInner(int[][] array, int i, int j, int result)
    {
        if (i == array.length)
        {
            // 达到最后一行
            int endIndex = i - 1;
            for (int k = j + 1; k < array[endIndex].length; k++)
            {
                result += array[endIndex][k];
            }
            mMinResult = Math.min(result, mMinResult);
            return;
        }
        
        if (j == array[0].length)
        {
            // 最后一列
            int endIndex = j - 1;
            for (int k = i + 1; k < array.length; k++)
            {
                result += array[k][endIndex];
            }
            mMinResult = Math.min(result, mMinResult);
            return;
        }
        
        backtrackInner(array, i, j + 1, result + array[i][j]); // 往右走
        backtrackInner(array, i + 1, j, result + array[i][j]); // 往左走
    }
    
    /**
     * 为了节省空间，array经过这个函数之后，数据就不能用了
     * @param array 原始数组
     * @return 最短路径长度
     */
    public static int dynamic(int[][] array)
    {
        int row = array.length; // 行数
        int column = array[0].length; // 列数
        
        // 保存路径信息【代表从上一个到下一个的选择方向】【往右走标记为true，往下走标记为false】
        boolean[][] path = new boolean[row][column];
        
        // 第一行
        for (int i = 1; i < column; i++)
        {
            array[0][i] += array[0][i - 1];
            path[0][i] = true;
        }
        
        // 第一列
        for (int i = 1; i < row; i++)
        {
            array[i][0] += array[i - 1][0];
            path[i][0] = false;
        }
        
        // 动态规划
        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < column; j++)
            {
                int minValue = array[i - 1][j];
                if (minValue > array[i][j - 1])
                {
                    minValue = array[i][j - 1];
                    path[i][j] = true;
                }
                else
                {
                    path[i][j] = false;
                }
                
                array[i][j] += minValue;
                
            }
        }
        
        print(path, row, column, array[row - 1][column - 1]);
        
        return array[row - 1][column - 1];
    }
    
    // 打印路径信息【只能从后往前，遍历】
    private static void print(boolean[][] path, int row, int column, int result)
    {
        String format = "(%d, %d) --> ";
        
        StringBuilder sBuilder = new StringBuilder();
        
        int i = row - 1, j = column - 1;
        sBuilder.append(String.format(format, i, j));
        while (true)
        {
            // 行数已到达第一行
            if (i == 0)
            {
                for (int k = j - 1; k >= 0; k--)
                {
                    sBuilder.append(String.format(format, i, k));
                }
                break;
            }
            
            // 列数已到达第一列
            if (j == 0)
            {
                for (int k = i - 1; k >= 0; k--)
                {
                    sBuilder.append(String.format(format, k, j));
                }
                break;
            }
            
            if (path[i][j])
            {
                // 向右的方向
                j--;
            }
            else
            {
                // 向下的方向
                i--;
            }
            
            sBuilder.append(String.format(format, i, j));
        }
        
        System.out.println(sBuilder.toString() + result);
    }
}
