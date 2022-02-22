import unittest

import list_node
from list_node import ListNode


class Solution:
    # List[int]
    def canPartitionKSubsets(self, nums: list, k: int) -> bool:
        pass

    pass


class SolutionA(Solution):

    def canPartitionKSubsets(self, nums: list, k: int) -> bool:
        if nums is None or nums.__len__() == 0 or k < 1:
            return False

        _sum = sum(nums)
        # 除不尽，则不满足
        if _sum % k != 0:
            return False

        # k为1，集合相同，则满足要求
        if k == 1:
            return True

        # 每个集合的，总和
        _value = _sum // k

        _flags = list()
        for index in range(nums.__len__()):
            _flags.append(False)

        return self.can_partition(nums, _flags, _value, 0, k)

    def can_partition(self, _nums, _flags, _value, _sum, _k) -> bool:
        """
        :param _nums: 数据内容
        :param _flags: 是否已经使用
        :param _value: 单个集合的和
        :param _sum: 已经计算的总和
        :param _k: 剩余的集合数
        """
        # 最终的结局
        if _k == 0 and _sum == 0:
            return True

        for index in range(_nums.__len__()):
            # 已经使用过，则过滤
            if _flags[index]:
                continue

            _temp = _sum + _nums[index]

            if _temp < _value:  # 小于目标值
                _flags[index] = True
                if self.can_partition(_nums, _flags, _value, _temp, _k):
                    return True
                _flags[index] = False

            elif _temp == _value:  # 值相同
                _flags[index] = True
                if self.can_partition(_nums, _flags, _value, 0, _k - 1):
                    return True
                _flags[index] = False

            else:
                pass
        return False


class SolutionB(Solution):
    """
    具体做法和SolutionA是一样的
    优化：
    1，某个值和target相同，则k-1，长度-1
    2，某个值为0，则长度-1
    3，排序，从较大的值开始便利。。nums.pops() 后面的内容
    """
    def canPartitionKSubsets(self, nums, k):
        # 求余，整除
        target, rem = divmod(sum(nums), k)
        if rem != 0:
            return False

        def search(groups):
            # 如果为空，则直接推出
            if not nums:
                return True

            v = nums.pop()
            for i, group in enumerate(groups):
                if group + v <= target:
                    groups[i] += v
                    if search(groups):
                        return True
                    groups[i] -= v
                if not group:
                    break
            nums.append(v)
            return False

        nums.sort()
        if nums[-1] > target:
            return False
        while nums and nums[-1] == target:
            nums.pop()
            k -= 1

        return search([0] * k)


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

        nums_a = [4, 3, 2, 3, 5, 2, 1]
        result_a = solution.canPartitionKSubsets(nums_a, 4)
        print(result_a)

        nums_b = [1, 2, 2, 3, 3, 4, 5]
        result_b = solution.canPartitionKSubsets(nums_b, 4)
        print(result_b)

        nums_c = [730, 580, 401, 659, 5524, 405, 1601, 3, 383, 4391, 4485, 1024, 1175, 1100, 2299, 3908]
        result_c = solution.canPartitionKSubsets(nums_c, 4)
        print(result_c)

        # 实现具体的校验内容
        pass


"""
Given an array of integers nums and a positive integer k, 
find whether it's possible to divide this array into k non-empty subsets 
whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets 
(5), (1, 4), (2,3), (2,3) with equal sums.

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.

@author: yline
@time 2020/1/22 11:11
"""
