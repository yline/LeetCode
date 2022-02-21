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
		assertEquals(2, solution.numSquares(41));
		
		assertEquals(3, solution.numSquares(12));
		assertEquals(2, solution.numSquares(13));
		

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
