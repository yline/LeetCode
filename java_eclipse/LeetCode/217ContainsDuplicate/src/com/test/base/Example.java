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
		assertEquals(true, solution.containsDuplicate(new int[] {1,2,3,1}));
		assertEquals(false, solution.containsDuplicate(new int[] {1,2,3,4}));
		assertEquals(true, solution.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
