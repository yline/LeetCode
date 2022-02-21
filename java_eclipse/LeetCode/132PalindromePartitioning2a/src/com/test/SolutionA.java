package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.base.Solution;

public class SolutionA implements Solution
{
	@Override
    public int minCut(String s) {
		if (null == s || s.length() == 0) {
			return 0;
		}

		// key为left，value为right的所有集合，单个表示为[left, right]
		Map<Integer, List<Integer>> cacheMap = new HashMap<>();
		buildCache(cacheMap, s);

        int[] minArray = new int[s.length()]; // 从0到当前下标，片段最少个数
        Arrays.fill(minArray, Integer.MAX_VALUE);

        findResult(cacheMap, s, minArray, 1, 0);
		return minArray[s.length() - 1] - 1;
	}

	/**
	 * 找出最小的距离
	 * 
	 * @param cacheMap 建立的缓存内容
	 * @param size     当前的片段个数
	 * @param s        字符
	 * @param index    当前下标
	 */
	private void findResult(Map<Integer, List<Integer>> cacheMap, String s, int[] minArray, int size, int index) {
		// 到达终点
		if (index == s.length()) {
			return;
		}

		List<Integer> nextList = cacheMap.get(index);
		// 不可能出现的情况
		if (null == nextList || nextList.isEmpty()) {
			return;
		}

		for (int i = 0; i < nextList.size(); i++) {
            int next = nextList.get(i);
            
            // 减枝
            if (minArray[next] <= size)
            {
                continue;
            }
            // 更新最小值
            minArray[next] = size;
            
            size++;
            findResult(cacheMap, s, minArray, size, next + 1);
			size--;
		}
	}

	private void buildCache(Map<Integer, List<Integer>> cacheMap, String s) {
		// 奇数
		for (int i = 0; i < s.length(); i++) {
			int left = i, right = i;

			// 不超过边界，并且一直符合条件才添加
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				addPalindromeRecord(cacheMap, left, right);
				left--;
				right++;
			}
		}

		// 偶数
		for (int i = 0; i < s.length(); i++) {
			int left = i, right = i + 1;

			// 不超过边界，并且一直符合条件才添加
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				addPalindromeRecord(cacheMap, left, right);
				left--;
				right++;
			}
		}
	}

	private void addPalindromeRecord(Map<Integer, List<Integer>> cacheMap, int left, int right) {
		List<Integer> cacheList = cacheMap.get(left);
		if (null == cacheList) {
			List<Integer> dataList = new ArrayList<>();
			dataList.add(right);
			cacheMap.put(left, dataList);
			return;
		}
		cacheList.add(right);
	}
}
