package com.test.backtracking;

/**
 * 数独问题：9*9的矩阵，要求每一行，每一列，每个九宫格都是1-9这九个数字且不能重复。
 * 
 * 参考：https://www.cnblogs.com/AndyJee/p/4985593.html
 * @author YLine
 *
 * 2019年4月15日 下午1:50:55
 */
public class Sudoku
{
    public void fill(NineSquare square)
    {
        fillInner(square, 0);
    }
    
    /**
     * 回溯，找到解
     * @param square 九宫格
     * @param index 当前遍历的位置
     */
    private void fillInner(NineSquare square, int index)
    {
        if (index >= NineSquare.COUNT_ALL || index < 0)
        {
            square.print("square");
            return;
        }
        
        if (index == 1)
        {
            int j = 1;
            int z = j + 1;
            int x = z + 2;
            j = x * x;
        }
        
        // 行列信息
        int i = index / NineSquare.COUNT;
        int j = index % NineSquare.COUNT;
        
        // 查找合法的值【除当前值以外的值】
        int validValue = -1;
        int startValue = square.getValue(i, j);
        for (int k = startValue + 1; k < NineSquare.COUNT; k++)
        {
            if (square.isValid(i, j, k))
            {
                validValue = k;
                break;
            }
        }
        
        // 循环遍历
        if (validValue != -1)
        {
            // 填充值
            square.setValue(i, j, validValue);
            
            // 下一个值
            int nextIndex = square.nextIndex(i, j);
            fillInner(square, nextIndex);
        }
        else
        {
            square.removeValue(i, j);
            
            // 上一个值
            int preIndex = square.preIndex(i, j);
            fillInner(square, preIndex);
        }
    }
    
    /**
     * 九宫格
     */
    public static class NineSquare
    {
        // 3
        private static final int COUNT_LITTLE = 3;
        
        // 9
        private static final int COUNT = 9;
        
        // 9*9
        private static final int COUNT_ALL = NineSquare.COUNT * NineSquare.COUNT;

        // 当前填充的数据
        private int size = 0;
        
        // 记录值是否允许改变
        private boolean[][] initArray = new boolean[COUNT][COUNT];
        
        // 记录值
        private int[][] valueArray = new int[COUNT][COUNT];
        
        public NineSquare()
        {
            reset();
        }
        
        public void reset()
        {
            // 初始化
            this.size = 0;
            for (int i = 0; i < COUNT; i++)
            {
                for (int j = 0; j < COUNT; j++)
                {
                    this.initArray[i][j] = false;
                    this.valueArray[i][j] = -1;
                }
            }
        }
        
        /**
         * 校验某个位置插入，某个值是否合法
         * @param i 行
         * @param j 列
         * @param value 值
         */
        public boolean isValid(int i, int j, int value)
        {
            // 行、列
            for (int k = 0; k < COUNT; k++)
            {
                if (valueArray[i][k] == value || valueArray[k][j] == value)
                {
                    return false;
                }
            }
            
            // 三格子
            int iK = (i / COUNT_LITTLE) * COUNT_LITTLE, jK = (j / COUNT_LITTLE) * COUNT_LITTLE;
            for (int k = 0; k < COUNT_LITTLE; k++)
            {
                for (int k2 = 0; k2 < COUNT_LITTLE; k2++)
                {
                    if (valueArray[k + iK][k2 + jK] == value)
                    {
                        return false;
                    }
                }
            }
            
            return true;
        }
        
        /**
         * 找到下一个，需要遍历的index【初始化的值】
         * @param i 行
         * @param j 列
         * @return 下一个index
         */
        public int nextIndex(int i, int j)
        {
            // 同一行
            for (int j2 = j + 1; j2 < COUNT; j2++)
            {
                if (!initArray[i][j2])
                {
                    return i * COUNT + j2;
                }
            }
            
            // 其他行
            for (int i2 = i + 1; i2 < COUNT; i2++)
            {
                for (int j2 = 0; j2 < COUNT; j2++)
                {
                    if (!initArray[i2][j2])
                    {
                        return i2 * COUNT + j2;
                    }
                }
            }
            
            return COUNT_ALL;
        }
        
        /**
         * 找到上一个，需要遍历的index【初始化的值】
         * @param i 行
         * @param j 列
         * @return 上一个index
         */
        public int preIndex(int i, int j)
        {
            // 同一行
            for (int j2 = j - 1; j2 >= 0; j2--)
            {
                if (!initArray[i][j2])
                {
                    return i * COUNT + j2;
                }
            }
            
            // 其他行
            for (int i2 = i - 1; i2 >= 0; i2--)
            {
                for (int j2 = COUNT; j2 >= 0; j2--)
                {
                    if (!initArray[i2][j2])
                    {
                        return i2 * COUNT + j2;
                    }
                }
            }
            
            return -1;
        }
        
        /**
         * 设置某个值
         * @param i 行
         * @param j 列
         * @param value 值
         */
        public void setValue(int i, int j, int value)
        {
            if (valueArray[i][j] == -1)
            {
                // 首次新增
                size++;
                valueArray[i][j] = value;
            }
            else
            {
                // 后续修改
                valueArray[i][j] = value;
            }
        }
        
        /**
         * 设置初始化值
         */
        public void setInitValue(int i, int j, int value)
        {
            if (valueArray[i][j] == -1)
            {
                initArray[i][j] = true;
                
                // 首次新增
                size++;
                valueArray[i][j] = value;
            }
            else
            {
                initArray[i][j] = true;
                
                // 后续修改
                valueArray[i][j] = value;
            }
        }
        
        public void removeValue(int i, int j)
        {
            if (valueArray[i][j] != -1)
            {
                // 后续清零
                size--;
                valueArray[i][j] = -1;
            }
        }
        
        public void removeInitValue(int i, int j)
        {
            if (valueArray[i][j] != -1)
            {
                initArray[i][j] = false;
                
                // 后续清零
                size--;
                valueArray[i][j] = -1;
            }
        }
        
        public int getSize()
        {
            return size;
        }
        
        public int getValue(int i, int j)
        {
            return valueArray[i][j];
        }
        
        /**
         * 打印结果
         */
        public void print(String tag)
        {
            System.out.println("+++++++++++++++++++" + tag + "+++++++++++++++++++" + size);
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < COUNT; i++)
            {
                sBuilder.append('[');
                for (int j = 0; j < valueArray.length; j++)
                {
                    if (initArray[i][j])
                    {
                        // 初始化的数据，用‘+’号表示
                        sBuilder.append('+');
                    }
                    else
                    {
                        // 打印数据
                        sBuilder.append(valueArray[i][j] == -1 ? "*" : String.valueOf(valueArray[i][j] + 1));
                    }
                    sBuilder.append(' ');
                }
                sBuilder.append(']');
                sBuilder.append('\n');
            }
            System.out.println(sBuilder.toString());
        }
        

    }
}
