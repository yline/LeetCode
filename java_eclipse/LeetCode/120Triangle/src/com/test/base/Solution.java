package com.test.base;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
给一个三角，找出最小值；每一步你只能调整列数，到相邻列（即列数 和 列数+1）

PS：题意中难理解的部分
1）相邻，即：列数 和 列数+1
2）最小，指的是所有相邻从头到底，可能的组合，中的最小值；不是每次求最小值

For example, given the following triangle
例如：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 * @author YLine
 *
 * 2018年12月10日 下午5:38:28
 */
public interface Solution
{
    public int minimumTotal(List<List<Integer>> triangle);
}
