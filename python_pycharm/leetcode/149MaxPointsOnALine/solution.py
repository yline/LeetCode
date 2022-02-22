import unittest

import list_node
from list_node import ListNode


class Solution:
    # List[List[int]]
    def maxPoints(self, points: list) -> int:
        pass


class LineKey:

    def __init__(self, a, b, c) -> None:
        self.a = a
        self.b = b
        self.c = c

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, LineKey):
            return False
        return self.a == o.a and self.b == o.b and self.c == o.c

    def __hash__(self) -> int:
        return self.a.__hash__() + self.b.__hash__() + self.c.__hash__()


class Point:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, Point):
            return False
        return self.x == o.x and self.y == o.y

    def __hash__(self) -> int:
        return self.x.__hash__() + self.y.__hash__()


class SolutionA(Solution):

    def maxPoints(self, points: list) -> int:
        # 长度小于3，直接返回点的个数
        if points.__len__() < 3:
            return points.__len__()

        # 去重
        point_map = dict()
        for item in points:
            new_point = Point(item[0], item[1])
            if new_point in point_map:
                point_map[new_point] += 1
            else:
                point_map[new_point] = 1

        # 计算直线，遍历次数 n^2
        _max = 2
        checked_set = set()
        result_map = dict()

        for first in point_map:
            _max = max(_max, point_map[first])
            checked_set.add(first)

            for second in point_map:
                # 已经检查过了，或正在检查的项
                if second in checked_set:
                    continue

                key = self.get_line_sign(first, second)
                if key in result_map:
                    value = result_map[key] + point_map[second]
                    result_map[key] = value
                    _max = max(_max, value)
                else:
                    result_map[key] = point_map[first] + point_map[second]
                    _max = max(_max, result_map[key])
            result_map.clear()  # 清除数据
            pass

        return _max

    def get_line_sign(self, first: Point, second: Point) -> LineKey:
        """
        计算得到一条直线的表达式：ax + by = c
        由于，已经去重，因此不可能重复
        :return:
        """
        # x值相等
        if first.x == second.x:
            return LineKey(1, 0, first.x)

        # y值相等
        if first.y == second.y:
            return LineKey(0, 1, first.y)

        # x、y都不相等
        a = second.y - first.y
        b = first.x - second.x

        a, b = self.common_divisor(a, b)
        c = a * first.x + b * first.y
        return LineKey(a, b, c)

    def common_divisor(self, a: int, b: int):
        # 取正数，并且，确定符号
        if a > 0:
            _same = True
        else:
            a = -a
            _same = False

        if b > 0:
            _same = _same
        else:
            b = -b
            _same = not _same

        _common = self.common_divisor_inner(a, b)
        if _same:
            return a // _common, b // _common
        else:
            return -(a // _common), b // _common

    def common_divisor_inner(self, a: int, b: int):
        # 求值
        _min = min(a, b)
        _max = max(a, b)
        _value = _max % _min

        while _value != 0:
            _max = _min
            _min = _value
            _value = _max % _min

        return _min


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        result_a = solution.maxPoints([[1, 1], [2, 2], [3, 3]])
        self.assertEqual(3, result_a)

        result_b = solution.maxPoints([[1, 1], [3, 2], [5, 3], [4, 1], [2, 3], [1, 4]])
        self.assertEqual(4, result_b)

        result_c = solution.maxPoints([[1, 1], [2, 2], [1, 1]])
        self.assertEqual(3, result_c)

        result_d = solution.maxPoints([[1, 1], [1, 1], [1, 1]])
        self.assertEqual(3, result_d)

        # 实现具体的校验内容
        pass


"""
对于直线，可以表示为：ax + by = c
a和b为，最小公约数；如果符号不同，a为负数，b为正数

Given n points on a 2D plane, find the maximum number of points 
that lie on the same straight line.

Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4

Example 2:
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

NOTE: input types have been changed on April 15, 2019. 
Please reset to default code definition to get new method signature.

@author: yline
@time 2020/2/5 13:30
"""
