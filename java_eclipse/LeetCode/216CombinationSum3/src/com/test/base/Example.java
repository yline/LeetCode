package com.test.base;

import java.util.Arrays;
import java.util.List;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase {
	private SolutionA solution;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSolutionA() {
		solution = new SolutionA();
		assertSolution();
	}

	private void assertSolution() {
		List<List<Integer>> resultA = solution.combinationSum3(3, 7);
		ListUtils.printTwoInt(resultA);

		List<List<Integer>> resultB = solution.combinationSum3(3, 9);
		ListUtils.printTwoInt(resultB);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
