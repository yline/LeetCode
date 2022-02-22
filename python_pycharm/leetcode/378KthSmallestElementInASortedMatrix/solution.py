import unittest


class Solution:
    # List[List[int]]
    def kthSmallest(self, matrix: list, k: int) -> int:
        pass


class SolutionA(Solution):

    def kthSmallest(self, matrix: list, k: int) -> int:
        _n = matrix.__len__()
        source_list = []

        # 左下角，右上角
        for i in range(_n):
            for j in range(_n):
                source_list.append(matrix[i][j])

        source_list.sort()
        return source_list[k - 1]


class SolutionB(Solution):
    """
    这个的方法，相当于，把二维矩阵，的行当作一个一维数组。
    只是判断条件，变成了，小于某个数的个数总和
    """
    def kthSmallest(self, mat: list, k: int) -> int:
        # 排序模块
        import bisect

        n = len(mat)

        def helper(num):
            curr = 0
            for i in range(n):
                # 用入处理将会插入重复数值的情况，返回将会插入的位置
                curr += bisect.bisect_right(mat[i], num)
            return curr

        low = min(mat[i][0] for i in range(n))
        high = max(mat[i][-1] for i in range(n))
        while low < high:
            mid = (low + high) // 2
            if helper(mid) >= k:
                high = mid
            else:
                low = mid + 1
        return low


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
        matrix_a = [[1, 5, 9],
                    [10, 11, 13],
                    [12, 13, 15]]
        self.assertEqual(1, solution.kthSmallest(matrix_a, 1))
        self.assertEqual(5, solution.kthSmallest(matrix_a, 2))
        self.assertEqual(9, solution.kthSmallest(matrix_a, 3))
        self.assertEqual(10, solution.kthSmallest(matrix_a, 4))
        self.assertEqual(11, solution.kthSmallest(matrix_a, 5))
        self.assertEqual(12, solution.kthSmallest(matrix_a, 6))
        self.assertEqual(13, solution.kthSmallest(matrix_a, 7))
        self.assertEqual(13, solution.kthSmallest(matrix_a, 8))
        self.assertEqual(15, solution.kthSmallest(matrix_a, 9))
        pass


"""
Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, 
not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

思路1：
利用一个队列，每次移除1个最小的，然后插入最小的对应的两个值
注意点：每次需要校验两个值是否已经处理过。这里需要一个矩阵大小的内存
时间复杂度：n^2
空间复杂度：n^2 + (n^2)

思路2：
全部加入列表，全部排序一次，拿出来即可

@author: yline
@time 2020/3/26 16:17
"""
