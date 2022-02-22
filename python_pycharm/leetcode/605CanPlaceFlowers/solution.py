import unittest


class Solution:
    def canPlaceFlowers(self, flowerbed: list, n: int) -> bool:
        pass


class SolutionA(Solution):
    # List[int]
    def canPlaceFlowers(self, flowerbed: list, n: int) -> bool:
        result = 0
        left = 0
        while left < flowerbed.__len__():
            num, left = self.move_to_next(flowerbed, left, flowerbed.__len__())
            result = result + num
            if result >= n:
                return True

        return False

    def move_to_next(self, flowerbed, left, right) -> (int, int):
        pos = left
        while pos < right:
            # 正常遍历
            if flowerbed[pos] == 1:
                _len = pos - left
                if left == 0:
                    return _len >> 1, pos + 1
                else:
                    return (_len - 1) >> 1, pos + 1
            pos = pos + 1

        # 已经到了边界
        _len = right - left
        if left == 0:
            return (_len + 1) >> 1, right
        else:
            return _len >> 1, right


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
        flow_a = [1, 0, 0, 0, 1]
        self.assertEqual(True, solution.canPlaceFlowers(flow_a, 1))

        flow_b = [0, 0, 1, 0]
        self.assertEqual(True, solution.canPlaceFlowers(flow_b, 1))

        flow_c = [0, 0, 1, 0, 0]
        self.assertEqual(True, solution.canPlaceFlowers(flow_c, 2))

        flow_d = [1, 0, 0, 0, 1]
        self.assertEqual(False, solution.canPlaceFlowers(flow_d, 2))

        flow_e = [1, 0, 0, 0, 0, 1]
        self.assertEqual(False, solution.canPlaceFlowers(flow_e, 2))

        flow_f = [0]
        self.assertEqual(True, solution.canPlaceFlowers(flow_f, 1))
        pass
