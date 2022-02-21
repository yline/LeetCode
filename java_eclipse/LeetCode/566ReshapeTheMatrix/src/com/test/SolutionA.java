package com.test;

/**
 * In MATLAB, there is a very useful function called 'reshape', 
 * which can reshape a matrix into a new one with different size but keep its original data.
 * 
 * You're given a matrix represented by a two-dimensional array, 
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, 
 * respectively.
 * 
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * 
 * If the 'reshape' operation with given parameters is possible and legal, 
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * @author yline
 */
public class SolutionA
{
    public int[][] matrixReshape(int[][] nums, int r, int c) {
    	if (null == nums || nums.length == 0) {
			return nums;
		}
    	
    	final int oldR = nums.length;
    	final int oldC = nums[0].length;
    	if (oldR * oldC != r * c) {
			return nums;
		}
    	
    	int[][] result = new int[r][c];
    	int index = 0;
    	while (index < oldR * oldC) {
    		int numsR = index / oldC;
    		int numsC = index % oldC;
    		int resultR = index / c;
    		int resultC = index % c;
    		
    		int length = Math.min(oldC - numsC, c - resultC);
			System.arraycopy(nums[numsR], numsC, result[resultR], resultC, length);
			index += length;
		}
    	
    	return result;
    }
}
