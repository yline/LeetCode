package com.test.base;

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
		solution = new SolutionA();
		System.out.println("------A------");
		assertSolution();
	}
	
	public void testSolutionB() {
		solution = new SolutionB();
		System.out.println("-------B-----");
		assertSolution();
	}

	private void assertSolution() {
		System.out.println(solution.nthUglyNumber(10));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
