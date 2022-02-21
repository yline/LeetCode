package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii
 * 
 * @author yline
 */
public class SolutionA {
	public List<List<Integer>> combinationSum3(int k, int n) {
		if (n <= 0) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] state = new boolean[9];
		Arrays.fill(state, false);

		dfs(result, state, 0, k, n);
		return result;
	}

	private void dfs(List<List<Integer>> result, boolean[] state, int index, int restK, int restN) {
		if (restN < 0) {
			return;
		}

		if (restK == 0) {
			if (restN != 0) {
				return;
			}

			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < state.length; i++) {
				if (state[i]) {
					temp.add(i + 1);
				}
			}
			result.add(temp);
			return;
		}

		if (index >= state.length) {
			return;
		}

		dfs(result, state, index + 1, restK, restN);

		state[index] = true;
		dfs(result, state, index + 1, restK - 1, restN - index - 1);
		state[index] = false;
	}
}
