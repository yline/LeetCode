import unittest


class Solution:
    # List[List[int]
    def calculateMinimumHP(self, dungeon: list) -> int:
        pass


class Path:

    def __init__(self, _min, _current) -> None:
        """
        某条路径的要求
        :param _min: 该路径上的最小值
        :param _current: 该路径上的当前值
        """
        super().__init__()
        self.min = 0 if _min > 0 else _min  # 如果大于0，则对比没有意义
        self.current = _current

    def clone(self, val):
        """
        创建一个新的对象
        """
        _current = self.current + val
        _min = min(self.min, _current)
        return Path(_min, _current)


class SolutionA(Solution):

    def calculateMinimumHP(self, dungeon: list) -> int:
        if dungeon is None or dungeon.__len__() == 0:
            return 1

        _M = dungeon.__len__()
        _N = dungeon[0].__len__()

        # 初始化 二维矩阵
        matrix = [[None] * _N for i in range(_M)]

        _val = dungeon[0][0]
        matrix[0][0] = [Path(_val, _val)]

        # 第一行
        for i in range(1, _N):
            _val = dungeon[0][i]
            path_list = matrix[0][i - 1]

            new_list = []
            for path in path_list:
                new_list.append(path.clone(_val))
            matrix[0][i] = new_list

        # 第一列
        for i in range(1, _M):
            _val = dungeon[i][0]
            path_list = matrix[i - 1][0]

            new_list = []
            for path in path_list:
                new_list.append(path.clone(_val))
            matrix[i][0] = new_list

        # 行 + 列处理
        for i in range(1, _M):
            for j in range(1, _N):
                _val = dungeon[i][j]
                matrix[i][j] = self.merge(matrix[i - 1][j], matrix[i][j - 1], _val)

        result_list = matrix[_M - 1][_N - 1]
        _min = result_list[0].min
        for path in result_list:
            _min = max(_min, path.min)

        return 1 if _min > 0 else 1 - _min

    def merge(self, _left, _top, _val) -> list:
        """
        :param _left: 左边的路径信息
        :param _top: 右边的路径信息
        :param _val: 新的节点值
        :return: 当前节点的路径信息
        """
        temp_list = []
        for path in _left:
            temp_list.append(path.clone(_val))
        for path in _top:
            temp_list.append(path.clone(_val))

        # 按照 当前值进行降序排序
        temp_list.sort(key=lambda x: (x.current, x.min), reverse=True)

        result_list = []

        _min = temp_list[0].min
        result_list.append(temp_list[0])

        for index in range(1, temp_list.__len__()):
            if _min < temp_list[index].min:
                result_list.append(temp_list[index])
                _min = temp_list[index].min

        return result_list


class SolutionB(Solution):
    def calculateMinimumHP(self, dungeon: list) -> int:
        m = len(dungeon)
        n = len(dungeon[0])
        dp = [[0] * n for _ in range(m)]
        dp[-1][-1] = 1 if dungeon[-1][-1] >= 0 else 1 - dungeon[-1][-1]
        for k in range(m - 2, -1, -1):
            if dungeon[k][-1] >= 0:
                dp[k][-1] = max(1, dp[k + 1][-1] - dungeon[k][-1])
            else:
                dp[k][-1] = dp[k + 1][-1] - dungeon[k][-1]

        for k in range(n - 2, -1, -1):
            if dungeon[-1][k] >= 0:
                dp[-1][k] = max(1, dp[-1][k + 1] - dungeon[-1][k])
            else:
                dp[-1][k] = dp[-1][k + 1] - dungeon[-1][k]

        # print(dp[-1])
        for k in range(m - 2, -1, -1):
            for v in range(n - 2, -1, -1):
                if dungeon[k][v] >= 0:
                    dp[k][v] = max(1, min(dp[k + 1][v], dp[k][v + 1]) - dungeon[k][v])
                else:
                    dp[k][v] = min(dp[k + 1][v], dp[k][v + 1]) - dungeon[k][v]
            # print(dp[k])
        return dp[0][0]


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

        dungeon_a = [[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]
        self.assertEqual(7, solution.calculateMinimumHP(dungeon_a))

        # 实现具体的校验内容
        pass


"""
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
The dungeon consists of M x N rooms laid out in a 2D grid. 
Our valiant knight (K) was initially positioned in the top-left room 
and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. 
If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, 
so the knight loses health (negative integers) upon entering these rooms; 
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, 
the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health 
so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight 
must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

@author: yline
@time 2020/3/2 20:20
"""
