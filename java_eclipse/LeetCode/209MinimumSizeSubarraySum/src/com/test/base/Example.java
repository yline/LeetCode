package com.test.base;

import java.util.Arrays;

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
		int[] numA = new int[] { 2,3,1,2,4,3};
		int resultA = solution.minSubArrayLen(7, numA);
		System.out.println(resultA);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
