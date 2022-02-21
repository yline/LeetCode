package com.test;

import java.util.Arrays;

import com.test.base.Solution;

/**
 * Leetcode上，排名很靠前的解法
 * 
 * 粗略的看了一下，应该是SolutionC基础上，进行细节的修整
 * 
 * @author yline
 */
public class SolutionE implements Solution {

	
	private class BSTNode {
		int low, high;
		BSTNode left, right;

		BSTNode(int low, int high) {
			this.low = low;
			this.high = high;
		}
	}

	@Override
	public String longestDupSubstring(String S) {
		char[] s = S.toCharArray();
		int len = s.length;
		s = Arrays.copyOf(s, len + 1); // s = S + '*'
		s[len] = '*';

		int[] dp = new int[len], chs = new int[26];
		for (int i = 0; i < len; i++) {
			dp[i] = i;
			chs[s[i] - 'a'] += 1;
		}

		// 考虑全等的情况
		for (int i = 0; i < 26; i++) {
			if (chs[i] == len) {
				return S.substring(1);
			}
		}

		BSTNode[] trees = new BSTNode[len];
		int[] r = helper(s, dp, 0, len, trees);
		return String.valueOf(s, r[0], r[1]);
	}

	/**
	 * 
	 * @param s = S + '*'
	 * @param dp = (0,1,2,3,4,5...,n-1,n)
	 * @param l = 0
	 * @param r = n
	 * @param trees = (0,...,n) = null
	 * @return [pos, max+pos)
	 */
	private int[] helper(char[] s, int[] dp, int l, int r, BSTNode[] trees) {
		int pos = 0, max = -1;
		while (l < r) {
			int nl = partitionAndMoveForward(s, dp, l, r);
			if (nl - l == 1) {
				if (0 > max) {
					pos = dp[l] - 1;
					max = 0;
				}
			} else if (nl - l == 2) {
				int count = 1, a = dp[l], b = dp[l + 1];
				if (s[a] == s[b]) {
					int low = Math.min(a, b), high = Math.max(a, b);
					count = searchAndUpdate(s, low - 1, high - low, trees);
				}
				if (count > max) {
					pos = dp[l] - 1;
					max = count;
				}
			} else {
				int[] m = helper(s, dp, l, nl, trees);
				if (m[1] + 1 > max) {
					pos = m[0] - 1;
					max = m[1] + 1;
				}
			}
			l = nl;
		}
		return new int[] { pos, max };
	}

	private int searchAndUpdate(char[] s, int v, int gap, BSTNode[] trees) {
		BSTNode p = trees[gap];
		while (p != null) {
			if (v < p.high && v >= p.low) {
				return p.high - v;
			}
			if (v >= p.high && p.right != null) {
				p = p.right;
				continue;
			} else if (v < p.low && p.left != null) {
				p = p.left;
				continue;
			}
			break;
		}

		int len = s.length, a = v, b = v + gap;
		while (b < len && s[a] == s[b]) {
			a += 1;
			b += 1;
		}
		int high = a;
		a = v;
		b = v + gap;
		while (a >= 0 && s[a] == s[b]) {
			a -= 1;
			b -= 1;
		}
		int low = a + 1;

		if (p == null) {
			trees[gap] = new BSTNode(low, high);
		} else if (v >= p.high) {
			p.right = new BSTNode(low, high);
		} else {
			p.left = new BSTNode(low, high);
		}

		return high - v;
	}

	private int partitionAndMoveForward(char[] s, int[] dp, int l, int r) {
		char target = s[dp[l]];
		while (l < r) {
			if (s[dp[l]] == target) {
				dp[l] += 1;
				l += 1;
				continue;
			}

			if (s[dp[r - 1]] != target) {
				r -= 1;
				continue;
			}

			int tmp = dp[l];
			dp[l] = dp[r - 1] + 1;
			dp[r - 1] = tmp;
			l += 1;
			r -= 1;
		}
		return l;
	}

}
