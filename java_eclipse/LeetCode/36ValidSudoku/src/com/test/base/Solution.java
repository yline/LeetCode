package com.test.base;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following 
 * 校验 9*9的数组是否合法，合法所需要满足的条件有：
 * 
 * Each row must contain the digits 1-9 without repetition.
 * 每一行，包含1-9之间的数字，并且不重复
 * 
 * Each column must contain the digits 1-9 without repetition.
 * 每一列，包含1-9之间的数字，并且不重复
 * 
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 划分成的9个 3*3 小格子，包含1-9之间的数字，并且不重复
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 数独版，并没有被完全填满，空格的位置，被填满'.'符号
 * 
 * Note: 提示
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 数独板可以空格，但不能不可解
 * Only the filled cells need to be validated according to the mentioned rules.
 * 只有已填满的，才能用于校验
 * The given board contain only digits 1-9 and the character '.'.
 * 仅仅只允许包含1-9的字符，或者'.'
 * The given board size is always 9x9.
 * 数组大小为 9*9
 * 
 * @author YLine
 *
 * 2018年9月20日 下午2:43:37
 */
public interface Solution
{
    /**
     * 数独是否合法
     * @param board
     * @return
     */
    boolean isValidSudoku(char[][] board);
}
