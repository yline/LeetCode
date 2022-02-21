package com.test.base;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 实现一个程序，解决数独问题（通过填充空白的内容）
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 数独解决必须满足，以下条件
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * 每行必须 有且只有1-9的数字，并且不重复出现
 * Each of the digits 1-9 must occur exactly once in each column.
 * 每列必须 有且只有1-9的数字，并且不重复出现
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * 划分成9个，3*3的宫格，必须有且只有1-9的数字，并且不重复出现
 * 
 * Empty cells are indicated by the character '.'.
 * 空白的内容，由'.'表示
 * 
 * @author YLine
 *
 * 2018年10月8日 上午11:00:55
 */
public interface Solution
{
    /**
     * The given board contain only digits 1-9 and the character '.'.
     * 输入内容，有且只有 1-9，或者'.'
     * 
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * 可以假设，数组有唯一解
     * 
     * The given board size is always 9x9.
     * 给定的数组，肯定是9*9的
     * 
     * @param board 给定的数组
     */
    public void solveSudoku(char[][] board);
}
