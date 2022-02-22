import unittest


class Solution:
    def rotatedDigits(self, N: int) -> int:
        """
        type(0-等于自身): 0 1 8
        type(1-合要求): 2 5 6 9
        type(2-不合要求): 3 4 7

        {?}{??} 这种案例，有代表性，表示 268，中 000-199
        f({?}{??}, 0) = f({?}, 0) * f({??}, 0)
        f({?}{??}, 1) = f({?}, 0) * f({??}, 1) + f({?}, 1) * (f({??}, 0) + f({??}, 1))
0 - [1, 0]
1 - [2, 0]
2 - [2, 1]
3 - [2, 1]
4 - [2, 1]
5 - [2, 2]
6 - [2, 3]
7 - [2, 3]
8 - [3, 3]
9 - [3, 4]
        """
        pass


class SolutionA(Solution):

    def rotatedDigits(self, N: int) -> int:
        source_array = [[1, 0], [2, 0], [2, 1], [2, 1], [2, 1],
                        [2, 2], [2, 3], [2, 3], [3, 3], [3, 4]]

        # 268, 分解为 8,6,2
        array = []
        temp = N
        while temp != 0:
            array.append(temp % 10)
            temp = temp // 10

        length = array.__len__()
        cache = [[0 for i in range(2)] for j in range(length)]
        cache[0] = [3, 4]

        # 动态规划赋值
        for i in range(1, length):
            cache[i][0] = 3 * cache[i - 1][0]
            cache[i][1] = 3 * cache[i - 1][1] + 4 * (cache[i - 1][0] + cache[i - 1][1])

        index = length - 1
        result = 0
        _type = 0
        while index > 0:
            if array[index] == 0:   # 值为0，则直接过滤掉
                index = index - 1
                continue
            result = result + self.merge(cache, index - 1, source_array, array[index] - 1, _type)
            _type = self.type_of(_type, array[index])
            if _type == 2:
                break
            index = index - 1

        if _type == 2:
            return result
        elif _type == 0:
            return result + source_array[array[0]][1]
        else:
            return result + source_array[array[0]][0] + source_array[array[0]][1]

    def type_of(self, old_type: int, val: int):
        if old_type == 2:
            return 2

        if val == 0 or val == 1 or val == 8:
            return old_type

        if val == 2 or val == 5 or val == 6 or val == 9:
            return 1

        return 2

    def merge(self, cache: list, cache_index: int, head: list, head_index: int, _type: int):
        """
        _type = 0, result = head_0 * cache_1 + head_1 * (cache_0 + cache_1)
        _type = 1, result = (head_0 + head_1) * (cache_0 + cache_1)
        """
        head_0 = head[head_index][0]
        head_1 = head[head_index][1]
        cache_0 = cache[cache_index][0]
        cache_1 = cache[cache_index][1]
        if _type == 0:
            return head_0 * cache_1 + head_1 * (cache_0 + cache_1)
        return (head_0 + head_1) * (cache_0 + cache_1)


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
        self.assertEqual(0, solution.rotatedDigits(1))
        self.assertEqual(1, solution.rotatedDigits(2))
        self.assertEqual(2, solution.rotatedDigits(5))
        self.assertEqual(3, solution.rotatedDigits(6))
        self.assertEqual(4, solution.rotatedDigits(10))
        self.assertEqual(5, solution.rotatedDigits(12))
        self.assertEqual(6, solution.rotatedDigits(15))
        self.assertEqual(7, solution.rotatedDigits(16))
        self.assertEqual(8, solution.rotatedDigits(19))
        self.assertEqual(9, solution.rotatedDigits(20))

        self.assertEqual(132, solution.rotatedDigits(502))
        self.assertEqual(141, solution.rotatedDigits(516))
        self.assertEqual(247, solution.rotatedDigits(857))
        pass


"""
X is a good number if after rotating each digit individually by 180 degrees, 
we get a valid number that is different from X.  
Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 
0, 1, and 8 rotate to themselves; 
2 and 5 rotate to each other; 
6 and 9 rotate to each other, 
and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.

Note:
N  will be in range [1, 10000].

@author: yline
@time 2020/3/19 00:59
"""
