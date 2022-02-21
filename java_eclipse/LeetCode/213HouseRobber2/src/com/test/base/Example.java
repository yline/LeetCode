package com.test.base;

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
		int[] numsA = { 2, 3, 2 };
		System.out.println(solution.rob(numsA));

		int[] numsB = { 1, 2, 3, 1 };
		System.out.println(solution.rob(numsB));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
