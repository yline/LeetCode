import unittest


class Solution:
    # List[int]
    def numOfSubarrays(self, arr: list, k: int, threshold: int) -> int:
        pass


class SolutionA(Solution):

    def numOfSubarrays(self, arr: list, k: int, threshold: int) -> int:
        _lowest = k * threshold

        _value = 0
        _index = 0
        while _index < k:
            _value += arr[_index]
            _index += 1

        result = 1 if _value >= _lowest else 0
        while _index < arr.__len__():
            _value -= arr[_index - k]
            _value += arr[_index]
            if _value >= _lowest:
                result += 1
            _index += 1

        return result


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
        self.assertEqual(3, solution.numOfSubarrays([2, 2, 2, 2, 5, 5, 5, 8], 3, 4))
        self.assertEqual(5, solution.numOfSubarrays([1, 1, 1, 1, 1], 1, 0))
        self.assertEqual(6, solution.numOfSubarrays([11, 13, 17, 23, 29, 31, 7, 5, 2, 3], 3, 5))
        self.assertEqual(1, solution.numOfSubarrays([7, 7, 7, 7, 7, 7, 7], 7, 7))
        self.assertEqual(1, solution.numOfSubarrays([4, 4, 4, 4], 4, 1))

        pass


"""
Given an array of integers arr and 
two integers k and threshold.「门槛」

Return the number of sub-arrays of size k and average greater than or equal to threshold.
返回：连续子集的个数
子集的长度：k
子集的要求：平均值大于门槛

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. 
All other sub-arrays of size 3 have averages less than 4 (the threshold).


Example 2:
Input: arr = [1,1,1,1,1], k = 1, threshold = 0
Output: 5

Example 3:
Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. 
Note that averages are not integers.

Example 4:
Input: arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
Output: 1

Example 5:
Input: arr = [4,4,4,4], k = 4, threshold = 1
Output: 1

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^4
1 <= k <= arr.length
0 <= threshold <= 10^4

@author: yline
@time 2020/2/19 19:08
"""
