package com.test.base;

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
		List<String> resultA = solution.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 });
		System.out.println(resultA.toString());

		List<String> resultB = solution.summaryRanges(new int[] { -1, 0, 2147483647 });
		System.out.println(resultB.toString());
		
		List<String> resultC = solution.summaryRanges(new int[] { -2147483648, -2147483647, 2147483647 });
		System.out.println(resultC.toString());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
