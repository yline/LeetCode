import unittest


class Solution:
    def largestPerimeter(self, A: list) -> int:
        pass


class SolutionA(Solution):

    def largestPerimeter(self, A: list) -> int:
        A.sort(reverse=True)

        index = 0
        while index + 3 <= A.__len__():
            result = self.triangle(A[index], A[index + 1], A[index + 2])
            if result != -1:
                return result
            index = index + 1
        return 0

    def triangle(self, a: int, b: int, c: int):
        if a < b + c:
            return a + b + c
        return -1


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        self.assertEqual(5, solution.largestPerimeter([2, 1, 2]))
        self.assertEqual(0, solution.largestPerimeter([1, 2, 1]))
        self.assertEqual(10, solution.largestPerimeter([3, 2, 3, 4]))
        self.assertEqual(8, solution.largestPerimeter([3, 6, 2, 3]))
        pass


"""
Given an array A of positive lengths, 
return the largest perimeter of a triangle with non-zero area, 
formed from 3 of these lengths.

If it is impossible to form any triangle of non-zero area, return 0.

Example 1:
Input: [2,1,2]
Output: 5

Example 2:
Input: [1,2,1]
Output: 0

Example 3:
Input: [3,2,3,4]
Output: 10

Example 4:
Input: [3,6,2,3]
Output: 8
 
Note:
3 <= A.length <= 10000
1 <= A[i] <= 10^6

@author: yline
@time 2020/3/19 18:32
"""
