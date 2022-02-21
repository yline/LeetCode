package com.test.base;

import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * 一个非负数的行列，生成一个杨辉三角
 * 
 * Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * @author YLine
 *
 * 2018年12月10日 下午4:34:37
 */
public interface Solution
{
    public List<List<Integer>> generate(int numRows);
}
