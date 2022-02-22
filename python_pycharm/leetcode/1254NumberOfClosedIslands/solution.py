import unittest


class Solution:
    # List[List[int]]
    def closedIsland(self, grid: list) -> int:
        pass


class SolutionA(Solution):

    def closedIsland(self, grid: list) -> int:
        # 小于3，不可能存在
        if grid.__len__() < 3 or grid[0].__len__() < 3:
            return 0

        _row = grid.__len__()
        _column = grid[0].__len__()
        tag_matrix = [[False for i in range(_column)] for j in range(_row)]

        # 行列 处理
        for i in range(_row):
            self.spread(grid, tag_matrix, i, 0)
            self.spread(grid, tag_matrix, i, _column - 1)

        for j in range(1, _column - 1):
            self.spread(grid, tag_matrix, 0, j)
            self.spread(grid, tag_matrix, _row - 1, j)

        # 找出孤岛
        result = 0
        for i in range(1, _row - 1):
            for j in range(1, _column - 1):
                if grid[i][j] == 0 and not tag_matrix[i][j]:
                    self.spread(grid, tag_matrix, i, j)
                    result = result + 1

        return result

    def spread(self, grid: list, tag_matrix: list, i: int, j: int):
        # 1 或者 已经遍历过，就直接过掉
        if grid[i][j] == 1 or tag_matrix[i][j]:
            return

        tag_matrix[i][j] = True

        _row = grid.__len__()
        _column = grid[0].__len__()

        if j + 1 < _column:
            self.spread(grid, tag_matrix, i, j + 1)

        if j > 0:
            self.spread(grid, tag_matrix, i, j - 1)

        if i > 0:
            self.spread(grid, tag_matrix, i - 1, j)

        if i + 1 < _row:
            self.spread(grid, tag_matrix, i + 1, j)


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        grid_a = [[1, 1, 1, 1, 1, 1, 1, 0], [1, 0, 0, 0, 0, 1, 1, 0], [1, 0, 1, 0, 1, 1, 1, 0],
                  [1, 0, 0, 0, 0, 1, 0, 1], [1, 1, 1, 1, 1, 1, 1, 0]]
        self.assertEqual(2, solution.closedIsland(grid_a))

        grid_b = [[0, 0, 1, 0, 0], [0, 1, 0, 1, 0], [0, 1, 1, 1, 0]]
        self.assertEqual(1, solution.closedIsland(grid_b))

        grid_c = [[1, 1, 1, 1, 1, 1, 1],
                  [1, 0, 0, 0, 0, 0, 1],
                  [1, 0, 1, 1, 1, 0, 1],
                  [1, 0, 1, 0, 1, 0, 1],
                  [1, 0, 1, 1, 1, 0, 1],
                  [1, 0, 0, 0, 0, 0, 1],
                  [1, 1, 1, 1, 1, 1, 1]]
        self.assertEqual(2, solution.closedIsland(grid_c))

        # 实现具体的校验内容
        pass


"""
Given a 2D grid consists of 0s (land) and 1s (water).  
An island is a maximal 4-directionally connected group of 0s 
and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

1，边界为0，不算孤岛
2，有0-0的连接，算作同一个岛

1，遍历四个方向，将所有0以及连接的0，排除
2，找到下一个0，找到所有连接的0，则算作1个，不断的重复2的过程，直到所有点遍历完成

@author: yline
@time 2020/3/7 22:31
"""
