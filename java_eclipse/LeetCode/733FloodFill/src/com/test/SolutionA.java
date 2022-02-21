package com.test;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * An image is represented by a 2-D array of integers, 
 * each integer representing the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
 * and a pixel value newColor, "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, 
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), 
 * and so on. 
 * 
 * Replace the color of all of the aforementioned pixels with the newColor.
 * 
 * At the end, return the modified image.
 * 
 * 直接bsf遍历即可
 * 
 * @author yline
 */
public class SolutionA
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	if (null == image || image.length == 0) {
			return image;
		}
    	
    	final int SOURCE_COLOR = image[sr][sc];
    	final int ROW_SIZE = image.length;
    	final int COLUMN_SIZE = image[0].length;
    	ArrayDeque<Integer> queue = new ArrayDeque<>();
    	queue.add(sr * COLUMN_SIZE + sc);
    	
    	HashSet<Integer> floodSet = new HashSet<>();
    	while (!queue.isEmpty()) {
			int index = queue.pollFirst();
			floodSet.add(index); // 代表当前的点已经被处理过了
			
			// 处理当前的点
			int r = index / COLUMN_SIZE;
			int c = index % COLUMN_SIZE;
			if (image[r][c] != SOURCE_COLOR) {
				continue;
			}
			
			// 染色，并拓展
			image[r][c] = newColor;
			
			// 上
			int topIndex = index - COLUMN_SIZE;
			if (r != 0 && !floodSet.contains(topIndex)) {
				queue.addLast(topIndex);
			}
			
			// 下
			int bottomIndex = index + COLUMN_SIZE;
			if (r != ROW_SIZE-1 && !floodSet.contains(bottomIndex)) {
				queue.addLast(bottomIndex);
			}
			
			// 左
			int leftIndex = index - 1;
			if (c != 0 && !floodSet.contains(leftIndex)) {
				queue.addLast(leftIndex);
			}
			
			// 右
			int rightIndex = index + 1;
			if (c != COLUMN_SIZE-1 && !floodSet.contains(rightIndex)) {
				queue.addLast(rightIndex);
			}
		}
    	
        return image;
    }
}
