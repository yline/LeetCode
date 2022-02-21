package com.test.base;

import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens
 * on an n×n chessboard such that no two queens attack each other.
 * 
 * n皇后披萨，是放n个皇后，在n*n的楼盘上，没有任何一个与彼此相连接
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 参数：n，返回所有可能解
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * 每个解只包含“Q”和“.”
 * 
 * @author YLine
 *
 * 2018年12月3日 下午10:22:04
 */
public interface Solution
{
    public List<List<String>> solveNQueens(int n);
}
