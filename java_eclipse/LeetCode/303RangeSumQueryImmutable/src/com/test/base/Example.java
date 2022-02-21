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
		solution = new SolutionA(new int[] { -2, 0, 3, -5, 2, -1 });
		assertSolution();
	}

	private void assertSolution() {
		assertEquals(1, solution.sumRange(0, 2));
		assertEquals(-1, solution.sumRange(2, 5));
		assertEquals(-3, solution.sumRange(0, 5));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
