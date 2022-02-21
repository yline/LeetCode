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
		assertEquals(4, solution.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
