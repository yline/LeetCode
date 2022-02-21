package com.test;

/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * 每一个值，都由 左上，可以推论到 右下。
 * 
 * 设立一个节点，表示当前节点的 连续1的宽高。如果是0 -> 0*0, 1 -> 1*1
 * 
 * 优化空间: 行列可以复用，减少空间的使用
 * 
 * @author yline
 *
 */
public class SolutionA {
	private static final char ZERO = '0';

	public int maximalSquare(char[][] matrix) {
		if (null == matrix || matrix.length == 0) {
			return 0;
		}

		int result = 0;

		int[] heightArray = new int[matrix[0].length];

		// 首行
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == ZERO) {
				heightArray[j] = 0;
			} else {
				heightArray[j] = 1;
				result = 1;
			}
		}

		// 其余行
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// 若当前值为0，则高度修改为0
				if (matrix[i][j] == ZERO) {
					heightArray[j] = 0;
					continue;
				}

				// 若当前值为1，则高度修改为 原来的高度+1
				heightArray[j] += 1;

				// 从当前的点往左边遍历, 求当前节点的 正方形的 边长
				int height = heightArray[j]; // 高度
				int width = 1; // 宽度
				int border = 1;	// 结果边长
				for (int k = j - 1; k >= 0; k--) {
					if (width >= height) {
						break;
					}
					
					height = Math.min(height, heightArray[k]);
					width++;
					
					border = Math.max(border, Math.min(width, height));
				}
				
				result = Math.max(result, border);
			}
		}

		return result * result;
	}

}
