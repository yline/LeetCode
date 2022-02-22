import unittest


class Solution:
    # List[List[int]]
    def shortestBridge(self, A: list) -> int:
        pass


class Point:

    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y


class SolutionA(Solution):
    """
    超时了，原因是两个内容相互遍历，耗时太长
    采用SolutionB：从一个岛扩散出去，第一个抵达第二个岛的就是最短路径
    """

    def shortestBridge(self, A: list) -> int:
        """
        1，遍历找到两个岛【理论上，只能加入在岛边界的点】
        2，将两个岛进行遍历；时间复杂度：n * m
        :param A:
        :return:
        """
        row = A.__len__()
        column = A[0].__len__()
        visit_matrix = [[False for i in range(column)] for i in range(row)]

        # 找到两个岛屿
        island_a = []
        island_b = []
        size = 0
        for i in range(row):
            for j in range(column):
                # 已经遍历过了 或者 值为0
                if visit_matrix[i][j] or A[i][j] == 0:
                    continue

                if size == 0:
                    self.found_island_border(visit_matrix, A, island_a, i, j)
                    size = size + 1
                elif size == 1:
                    self.found_island_border(visit_matrix, A, island_b, i, j)

        # 开始遍历
        _min = row + column
        for i in range(island_a.__len__()):
            for j in range(island_b.__len__()):
                distance = abs(island_a[i].x - island_b[j].x) + abs(island_a[i].y - island_b[j].y)
                _min = min(_min, distance)

        return _min - 1

    def found_island_border(self, visit_matrix, A, island_a: list, i, j):
        if visit_matrix[i][j] or A[i][j] == 0:
            return
        visit_matrix[i][j] = True

        # 这里暂时不考虑边界问题了，增加了复杂度和遍历的量，不一定优化
        island_a.append(Point(i, j))
        if i > 0:
            self.found_island_border(visit_matrix, A, island_a, i - 1, j)

        if j > 0:
            self.found_island_border(visit_matrix, A, island_a, i, j - 1)

        if i < visit_matrix.__len__() - 1:
            self.found_island_border(visit_matrix, A, island_a, i + 1, j)

        if j < visit_matrix[0].__len__() - 1:
            self.found_island_border(visit_matrix, A, island_a, i, j + 1)


class PointB:

    def __init__(self, i, j, step, row) -> None:
        self.i = i
        self.j = j
        self.step = step
        self._hash = i + j * row

    def __hash__(self) -> int:
        return self._hash

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, PointB):
            return False
        return o.i == self.i and o.j == self.j


class SolutionB(Solution):
    import queue

    def shortestBridge(self, A: list) -> int:
        import queue

        """
        从一个岛出发，然后bfs计算
        :param A:
        :return:
        """
        row = A.__len__()
        column = A[0].__len__()
        visit_matrix = [[False for i in range(column)] for i in range(row)]

        # 找到两个岛屿
        i, j = self.found_first_point(A, row, column)

        # 这里理论上不会走
        if i == -1:
            return -1

        # 对队列赋值
        island_set = set()
        self.found_island_inner(visit_matrix, A, island_set, i, j)

        # bfs遍历开始
        island_queue = queue.Queue()
        for point in island_set:
            island_queue.put(point)

        temp_list = [None, None, None, None]
        while not island_queue.empty():
            start_point = island_queue.get()

            i = start_point.i
            j = start_point.j
            step = start_point.step

            visit_matrix[i][j] = True  # 表示已经访问过了

            # 上
            if i > 0:
                temp_list[0] = PointB(i - 1, j, step + 1, row)

            # 下
            if i < row - 1:
                temp_list[1] = PointB(i + 1, j, step + 1, row)

            # 左
            if j > 0:
                temp_list[2] = PointB(i, j - 1, step + 1, column)

            # 右
            if j < column - 1:
                temp_list[3] = PointB(i, j + 1, step + 1, column)

            # 判断逻辑
            for point in temp_list:
                if point is None:
                    continue
                if point in island_set:
                    continue
                if visit_matrix[point.i][point.j]:
                    continue
                visit_matrix[point.i][point.j] = True
                if A[point.i][point.j] == 1:
                    return step
                island_queue.put(point)

            # 重置
            for i in range(3):
                temp_list[i] = None
        return -1

    def found_first_point(self, A: list, row: int, column: int) -> (int, int):
        for i in range(row):
            for j in range(column):
                if A[i][j] == 1:
                    return i, j
        return -1, -1

    def found_island_inner(self, visit_matrix, A, island_set: set, i, j):
        if visit_matrix[i][j] or A[i][j] == 0:
            return
        visit_matrix[i][j] = True

        # 这里暂时不考虑边界问题了，增加了复杂度和遍历的量，不一定优化
        island_set.add(PointB(i, j, 0, A.__len__()))
        if i > 0:
            self.found_island_inner(visit_matrix, A, island_set, i - 1, j)

        if j > 0:
            self.found_island_inner(visit_matrix, A, island_set, i, j - 1)

        if i < visit_matrix.__len__() - 1:
            self.found_island_inner(visit_matrix, A, island_set, i + 1, j)

        if j < visit_matrix[0].__len__() - 1:
            self.found_island_inner(visit_matrix, A, island_set, i, j + 1)


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

        # 实现具体的校验内容
        matrix_a = [[0, 1],
                    [1, 0]]
        self.assertEqual(1, solution.shortestBridge(matrix_a))

        matrix_b = [[0, 1, 0],
                    [0, 0, 0],
                    [0, 0, 1]]
        self.assertEqual(2, solution.shortestBridge(matrix_b))

        matrix_c = [[1, 1, 1, 1, 1],
                    [1, 0, 0, 0, 1],
                    [1, 0, 1, 0, 1],
                    [1, 0, 0, 0, 1],
                    [1, 1, 1, 1, 1]]
        self.assertEqual(1, solution.shortestBridge(matrix_c))
        pass


"""
In a given 2D binary array A, there are two islands.  
(An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  
(It is guaranteed that the answer is at least 1.)


Example 1:
Input: [[0,1],
        [1,0]]
Output: 1

Example 2:
Input: [[0,1,0],
        [0,0,0],
        [0,0,1]]
Output: 2

Example 3:
Input: [[1,1,1,1,1],
        [1,0,0,0,1],
        [1,0,1,0,1],
        [1,0,0,0,1],
        [1,1,1,1,1]]
Output: 1

Note:
1 <= A.length = A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1

@author: yline
@time 2020/3/26 19:15
"""
