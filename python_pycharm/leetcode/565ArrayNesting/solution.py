import unittest


class Solution:
    # List[int]
    def arrayNesting(self, nums: list) -> int:
        pass


class SolutionA(Solution):

    def arrayNesting(self, nums: list) -> int:
        _len = nums.__len__()
        _max = 0

        cache_set = set()
        for i in range(_len):
            # 已经遍历过，直接过滤
            if i in cache_set:
                continue

            cache_set.add(i)

            _val = nums[i]
            temp = 1
            while _val != i:
                _val = nums[_val]
                temp = temp + 1
                cache_set.add(_val)

            _max = max(_max, temp)
        return _max


class SolutionB(Solution):
    def arrayNesting(self, nums: list) -> int:
        visisted = [False] * len(nums)
        ans = 0

        for idx, num in enumerate(nums):
            if not visisted[idx]:
                start = nums[idx]
                visisted[start] = True
                cnt = 0

                while True:
                    start = nums[start]
                    visisted[start] = True
                    cnt += 1

                    if start == nums[idx]:
                        break

                ans = max(ans, cnt)

        return ans


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def test_solution_b(self):
        self.solution = SolutionB()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        self.assertEqual(4, solution.arrayNesting([5, 4, 0, 3, 1, 6, 2]))

        # 实现具体的校验内容
        pass


"""
A zero-indexed array A of length N contains all integers from 0 to N-1. 
Find and return the longest length of set S, 
where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i,
 the next element in S should be A[A[i]], and then A[A[A[i]]]… 
 
By that analogy, we stop adding right before a duplicate element occurs in S.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].

# 实际上，一条链路存在，肯定是循环的

@author: yline
@time 2020/3/7 13:06
"""
