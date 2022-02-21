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
		assertEquals(3, solution.maxProfit(new int[] { 1, 2, 3, 0, 2 }));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
