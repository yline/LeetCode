package com.test.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后问题
 * 皇后能横向，纵向和斜向移动，在这三条线上的其他棋子都可以被吃掉
 * 
 * 将八位皇后放在一张8x8的棋盘上，使得每位皇后都无法吃掉别的皇后，
 * （即任意两个皇后都不在同一条横线，竖线和斜线上），问一共有多少种摆法。
 * 
 * 参考：https://www.jianshu.com/p/65c8c60b83b8
 * 利用，每一行，必定有一个皇后的原理，大概率的下降了遍历难度
 * 
 * @author YLine
 *
 * 2019年4月15日 下午1:55:35
 */
public class EightQueens
{
    public void eightQueen()
    {
        Board board = new Board();
        
        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 8; i++)
        {
            findPosition(board, 0, i, dataList);
        }
    }
    
    /**
     * 当前添加的内容
     * @param x 当前行数
     * @param y 当前列数
     */
    private void findPosition(Board board, int x, int y, List<Integer> dataList)
    {
        // 添加某个点
        board.add(x, y);
        dataList.add(y);
        
        // 满足条件，退出
        if (x == 7)
        {
            print(dataList, x);
            board.remove(x, y);
            dataList.remove(Integer.valueOf(y));
            
            return;
        }
        
        // 找出下一行，剩余的点；若下一行没有；则代表结束
        List<Integer> nextList = board.next(x+1);
        if (nextList.isEmpty())
        {
            print(dataList, x);
            
            board.remove(x, y);
            dataList.remove(Integer.valueOf(y));
        }
        else
        {
            for (Integer nextY : nextList)
            {
                findPosition(board, x + 1, nextY, dataList);
            }
            
            board.remove(x, y);
            dataList.remove(Integer.valueOf(y));
        }
    }
    
    // 解法对应的下表值
    private int value = -1;
    
    private void print(List<Integer> dataList, int x)
    {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < dataList.size(); i++)
        {
            sBuilder.append('(');
            sBuilder.append(i);
            sBuilder.append(',');
            sBuilder.append(dataList.get(i));
            sBuilder.append(')');
            sBuilder.append("   ");
        }
        
        if (x == 7)
        {
            value++;
            System.out.println(sBuilder.toString() + ", index = " + value);
        }
        /* 遍历错误的分支就不打印了
        else
        {
            System.err.println(sBuilder.toString());
        }*/
    }
    
    /**
     * @return 总共的解法
     */
    public int getValue()
    {
        return value + 1;
    }
    
    /**
     * .实现棋盘
     * .当前的行数 = 插入的值【0-8】
     */
    private static class Board
    {
        private int filledSize = 0;
        
        private final int[][] sBoard = new int[8][8];
        
        public Board()
        {
            filledSize = 0;
            for (int i = 0; i < sBoard.length; i++)
            {
                for (int j = 0; j < sBoard[i].length; j++)
                {
                    sBoard[i][j] = -1;
                }
            }
        }
        
        /**
         * 往棋盘，放置一个皇后
         * 往上遍历，完全没必要【因为之前的插入，行肯定是被填充完了】
         * @param x x位置
         * @param value 当前第几行
         */
        public void add(int x, int y)
        {
            // 当前行、列
            for (int i = 0; i < sBoard.length; i++)
            {
                addInner(x, i, x);
                addInner(i, y, x);
            }
            
            // 右下 斜线
            int sx = x, sy = y;
            while (sx < 8 && sy < 8)
            {
                addInner(sx, sy, x);
                sx++;
                sy++;
            }
            
            // 左下 斜线
            sx = x;
            sy = y;
            while (sx < 8 && sy >= 0)
            {
                addInner(sx, sy, x);
                sx++;
                sy--;
            }
        }
        
        private void addInner(int x, int y, int value)
        {
            if (sBoard[x][y] == -1)
            {
                filledSize++;
                sBoard[x][y] = value;
            }
        }
        
        /**
         * 从棋盘中，移除一个皇后
         * 往上遍历，完全没必要；因为添加的顺序是从小到大，肯定是小的占据了大的地盘；不可能反过来
         * @param x x位置
         * @param value 当前第几个
         */
        public void remove(int x, int y)
        {
            // 当前行、列
            for (int i = 0; i < sBoard.length; i++)
            {
                removeInner(x, i, x);
                removeInner(i, y, x);
            }
            
            // 右下 斜线
            int sx = x, sy = y;
            while (sx < 8 && sy < 8)
            {
                removeInner(sx, sy, x);
                sx++;
                sy++;
            }
            
            // 左下 斜线
            sx = x;
            sy = y;
            while (sx < 8 && sy >= 0)
            {
                removeInner(sx, sy, x);
                sx++;
                sy--;
            }
        }
        
        private void removeInner(int x, int y, int value)
        {
            if (sBoard[x][y] == value)
            {
                filledSize--;
                sBoard[x][y] = -1;
            }
        }
        
        /**
         * 棋盘，是否满状态
         * @return
         */
        public boolean isEnd()
        {
            return (filledSize == 64);
        }
        
        /**
         * 在当前行，找到下一个合法的值；如果没有则返回-1
         * @param x 当前行
         * @param y 当前列
         * @return -1 if not match
         */
        public List<Integer> next(int x)
        {
            List<Integer> nextList = new ArrayList<>();
            for (int i = 0; i < sBoard[x].length; i++)
            {
                if (sBoard[x][i] == -1)
                {
                    nextList.add(i);
                }
            }
            return nextList;
        }
    }
    
}
