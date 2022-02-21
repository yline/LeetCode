package com.test.base;

import java.util.List;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Example extends TestCase {
	private Solution solution;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSolutionA() {
		System.out.println("--------------SolutionA");
		solution = new SolutionA();
		assertSolution();
	}
	
	public void testSolutionB() {
		System.out.println("--------------SolutionB");
		solution = new SolutionB();
		assertSolution();
	}

	private void assertSolution() {
		List<Integer> resultA = solution.majorityElement(new int[] { 3, 2, 3 });
		System.out.println(resultA.toString());

		List<Integer> resultB = solution.majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 });
		System.out.println(resultB.toString());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
