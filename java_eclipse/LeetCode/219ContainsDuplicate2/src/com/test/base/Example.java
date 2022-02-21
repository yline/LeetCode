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
		assertEquals(true, solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		assertEquals(true, solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		assertEquals(false, solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
