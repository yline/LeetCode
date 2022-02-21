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
		char[][] matrixA = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(solution.maximalSquare(matrixA));

		char[][] matrixB = { { '0', '1' }, { '0', '1' } };
		System.out.println(solution.maximalSquare(matrixB));

		char[][] matrixC = { { '1', '0', '1', '0' }, { '1', '0', '1', '1' }, { '1', '0', '1', '1' },
				{ '1', '1', '1', '1' } };
		System.out.println(solution.maximalSquare(matrixC));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
