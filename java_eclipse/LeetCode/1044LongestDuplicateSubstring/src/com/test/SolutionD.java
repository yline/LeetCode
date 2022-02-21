package com.test;

import java.util.HashSet;

import com.test.base.Solution;

/**
 * 思路和SolutionC一样，虽然通过了Leetcode！！
 * 
 * 但是！解法是有问题的。。因为，search的时候，并没有考虑hash冲突的情况！！
 * 
 * @author yline
 *
 */
public class SolutionD implements Solution {

	public int search(int L, int a, long modulus, int n, int[] nums) {
		// compute the hash of string S[:L]
		long h = 0;
		for (int i = 0; i < L; ++i) {
			h = (h * a + nums[i]) % modulus;
		}

		// already seen hashes of strings of length L
		HashSet<Long> seen = new HashSet<>();
		seen.add(h);
		// const value to be used often : a**L % modulus
		long aL = 1;
		for (int i = 1; i <= L; ++i) {
			aL = (aL * a) % modulus;
		}

		for (int start = 1; start < n - L + 1; ++start) {
			// compute rolling hash in O(1) time
			h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
			h = (h + nums[start + L - 1]) % modulus;
			if (seen.contains(h)) {
				return start;
			}
			seen.add(h);
		}
		return -1;
	}

	@Override
	public String longestDupSubstring(String S) {
		int n = S.length();
		// convert string to array of integers
		// to implement constant time slice
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = (int) S.charAt(i) - (int) 'a';
		}

		// base value for the rolling hash function
		int a = 26;
		// modulus value for the rolling hash function to avoid overflow
		long modulus = (long) Math.pow(2, 32);

		// binary search, L = repeating string length
		int left = 1, right = n;
		int L;
		while (left != right) {
			L = left + (right - left) / 2;
			if (search(L, a, modulus, n, nums) != -1) {
				left = L + 1;
			} else {
				right = L;
			}
		}

		int start = search(left - 1, a, modulus, n, nums);
		return start != -1 ? S.substring(start, start + left - 1) : "";
	}

}
